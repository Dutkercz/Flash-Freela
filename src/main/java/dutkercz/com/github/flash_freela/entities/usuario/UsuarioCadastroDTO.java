package dutkercz.com.github.flash_freela.entities.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioCadastroDTO(
        @NotBlank(message = "O campo USERNAME não pode estar em branco")
        String username,

        @NotBlank(message = "O campo PASSWORD não pode estar em branco")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,}$",
                message = "A Senha deve ter pelo menos 6 caracteres de LETRAS e NÚMEROS e pelo menos uma LETRA MAIÚSCULA")
        String password
) {
}
