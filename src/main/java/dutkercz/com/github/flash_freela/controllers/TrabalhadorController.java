package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.trabalhador.Trabalhador;
import dutkercz.com.github.flash_freela.entities.trabalhador.TrabalhadorCadastroDTO;
import dutkercz.com.github.flash_freela.entities.trabalhador.TrabalhadorDTO;
import dutkercz.com.github.flash_freela.services.TrabalhadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/trabalhador")
public class TrabalhadorController {

    private final TrabalhadorService trabalhadorService;

    public TrabalhadorController(TrabalhadorService trabalhadorService) {
        this.trabalhadorService = trabalhadorService;
    }

    @PostMapping
    public ResponseEntity<TrabalhadorDTO> cadastrarTrabalhador(@RequestBody TrabalhadorCadastroDTO cadastroDTO,
                                                               UriComponentsBuilder builder){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Trabalhador trabalhador = trabalhadorService.cadastro(cadastroDTO, username);
        URI uri = builder.path("/trabalhador/{id}").buildAndExpand(trabalhador.getId()).toUri();
        return ResponseEntity.created(uri).body(new TrabalhadorDTO(trabalhador));
    }
}
