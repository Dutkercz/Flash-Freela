package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.contrato.Contrato;
import dutkercz.com.github.flash_freela.entities.contrato.ContratoCadastroDTO;
import dutkercz.com.github.flash_freela.entities.contrato.ContratoDTO;
import dutkercz.com.github.flash_freela.repositories.ContratoRepository;
import dutkercz.com.github.flash_freela.services.ContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity<ContratoDTO> novoContrato(@RequestBody ContratoCadastroDTO cadastroDTO,
                                                    UriComponentsBuilder builder){
        String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        Contrato contrato = contratoService.novoContrato(cadastroDTO, usuario);
        URI uri = builder.path("contrato/{id}").buildAndExpand(contrato.getId()).toUri();

        return ResponseEntity.created(uri).body(new ContratoDTO(contrato));

    }
}
