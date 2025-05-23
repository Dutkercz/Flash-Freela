package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.contrato.Contrato;
import dutkercz.com.github.flash_freela.entities.contrato.ContratoCadastroDTO;
import dutkercz.com.github.flash_freela.entities.contrato.ContratoDTO;
import dutkercz.com.github.flash_freela.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/contratos")
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

    @GetMapping("/all")
    public ResponseEntity<Page<ContratoDTO>> verContratosDisponiveis(Pageable pageable){
        Page<ContratoDTO> contratosDTO = contratoService.findByStatus(pageable)
                .map(ContratoDTO::new);

        return ResponseEntity.ok(contratosDTO);
    }

}
