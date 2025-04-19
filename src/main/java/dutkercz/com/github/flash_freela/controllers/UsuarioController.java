package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import dutkercz.com.github.flash_freela.entities.usuario.UsuarioCadastroDTO;
import dutkercz.com.github.flash_freela.entities.usuario.UsuarioDTO;
import dutkercz.com.github.flash_freela.entities.usuario.UsuarioLogin;
import dutkercz.com.github.flash_freela.services.JWTService;
import dutkercz.com.github.flash_freela.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public UsuarioController(UsuarioService usuarioService, JWTService jwtService, AuthenticationManager authenticationManager) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioCadastroDTO cadastro,
                                                       UriComponentsBuilder builder) {
        Usuario usuario = usuarioService.cadastrarNovoUsuario(cadastro);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioLogin login){
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(login.username(), login.password());
        var authentication = authenticationManager.authenticate(token);
        String tokenJWT = jwtService.createJWT((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(tokenJWT);
    }
}
