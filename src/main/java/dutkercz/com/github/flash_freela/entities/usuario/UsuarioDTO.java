package dutkercz.com.github.flash_freela.entities.usuario;

import dutkercz.com.github.flash_freela.entities.enums.Role;

public record UsuarioDTO(String username, Role role) {
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getUsername(), usuario.getRole());
    }
}
