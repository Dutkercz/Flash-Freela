package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.UsuarioCadastro;
import dutkercz.com.github.flash_freela.entities.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid UsuarioCadastro cadastro,
                                                    UriComponentsBuilder builder){
        return null;
    }
}
