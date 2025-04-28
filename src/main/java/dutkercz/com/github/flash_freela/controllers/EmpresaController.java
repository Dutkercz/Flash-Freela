package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.empresa.Empresa;
import dutkercz.com.github.flash_freela.entities.empresa.EmpresaCadastroDTO;
import dutkercz.com.github.flash_freela.entities.empresa.EmpresaDTO;
import dutkercz.com.github.flash_freela.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(usuario);
        Empresa empresa = empresaService.cadastro(cadastroDTO, usuario);
        URI uri = builder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmpresaDTO(empresa));
    }

    @DeleteMapping
    public ResponseEntity<?> deletarMeuCadastroEmpresa(){
        String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        empresaService.deleteMeuCadastro(usuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Page<EmpresaDTO>> listarEmpresas(Pageable pageable){
        Page<EmpresaDTO> empresaDTOS = empresaService.findAllAtivo(pageable).map(EmpresaDTO::new);
        return ResponseEntity.ok(empresaDTOS);
    }
}
