package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.trabalhador.Trabalhador;
import dutkercz.com.github.flash_freela.entities.trabalhador.TrabalhadorCadastroDTO;
import dutkercz.com.github.flash_freela.entities.trabalhador.TrabalhadorDTO;
import dutkercz.com.github.flash_freela.services.TrabalhadorService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;

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

    @DeleteMapping
    public ResponseEntity<?> deletarMeuCadastroTrabalhador(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        trabalhadorService.deleteMeuCadastro(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Page<TrabalhadorDTO>> listarTrabalhadores(Pageable pageable){
        Page<TrabalhadorDTO> trabalhadorDTOS = trabalhadorService.findAllAtivo(pageable)
                .map(TrabalhadorDTO::new);
        return ResponseEntity.ok(trabalhadorDTOS);
    }


}
