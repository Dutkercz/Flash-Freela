package dutkercz.com.github.flash_freela.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(

        @NotBlank
        String rua,

        @NotBlank
        String numero,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        @Pattern(regexp = "/d{8}", message = "Digite um CEP válido.")
        String cep,

        @NotBlank
        @Pattern(regexp = "^{2}$")
        String uf,

        @NotBlank
        String pais
) {
}
