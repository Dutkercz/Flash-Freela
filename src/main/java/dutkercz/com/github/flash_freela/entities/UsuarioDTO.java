package dutkercz.com.github.flash_freela.entities;

public record UsuarioDTO (String username, String password, Role role){
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getUsername(), usuario.getPassword().replaceAll(".","*" ).substring(0, 6),
                usuario.getRole());
    }
}
