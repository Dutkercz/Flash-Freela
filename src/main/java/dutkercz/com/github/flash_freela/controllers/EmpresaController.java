package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.empresa.Empresa;
import dutkercz.com.github.flash_freela.entities.empresa.EmpresaCadastroDTO;
import dutkercz.com.github.flash_freela.entities.empresa.EmpresaDTO;
import dutkercz.com.github.flash_freela.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    public final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id) {
        EmpresaDTO empresaDTO = new EmpresaDTO(empresaService.findById(id));
        return ResponseEntity.ok().body(empresaDTO);
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> cadastrarEmpresa(@RequestBody @Valid EmpresaCadastroDTO cadastroDTO,
                                                       UriComponentsBuilder builder) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(user);
        Empresa empresa = empresaService.cadastro(cadastroDTO, user);
        URI uri = builder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmpresaDTO(empresa));
    }



}
