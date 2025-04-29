package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.contrato.ContratoCadastroDTO;
import dutkercz.com.github.flash_freela.entities.contrato.ContratoDTO;
import dutkercz.com.github.flash_freela.repositories.ContratoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ContratoController {

    private final ContratoRepository contratoRepository;

    public ContratoController(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    @PostMapping
    public ResponseEntity<ContratoDTO> novoContrato(@RequestBody ContratoCadastroDTO cadastroDTO){

    }
}
