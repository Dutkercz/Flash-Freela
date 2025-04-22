package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.Trabalhador;
import dutkercz.com.github.flash_freela.entities.TrabalhadorCadastroDTO;
import dutkercz.com.github.flash_freela.entities.TrabalhadorDTO;
import dutkercz.com.github.flash_freela.services.TrabalhadorService;
import org.springframework.http.ResponseEntity;
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
        Trabalhador trabalhador = trabalhadorService.cadastro(cadastroDTO);
        URI uri = builder.path("/trabalhador/{id}").buildAndExpand()
    }
}
