package dutkercz.com.github.flash_freela.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCadastro(
        @NotNull
        String username,

        @NotNull
        String password,

        @NotBlank
        Role role
        ) {
}
