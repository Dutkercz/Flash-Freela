package dutkercz.com.github.flash_freela.entities;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface UsuarioMapper {
    static Usuario toEntity(UsuarioCadastroDTO cadastroDTO, PasswordEncoder encoder){
        String passwordHash = encoder.encode(cadastroDTO.password());
        return new Usuario(null,
                cadastroDTO.username(),
                passwordHash,
                cadastroDTO.role());
    }
}
