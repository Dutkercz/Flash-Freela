package dutkercz.com.github.flash_freela.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequest(
        @NotBlank
        @Email
        String para,

        @NotBlank
        String assunto,

        @NotBlank
        String corpo) {
}
