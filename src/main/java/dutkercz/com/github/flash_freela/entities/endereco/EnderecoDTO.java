package dutkercz.com.github.flash_freela.entities.endereco;

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
        @Pattern(regexp = "\\d{8}", message = "Digite um CEP válido.")
        String cep,

        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "O campo UF deve conter 2 letras MAIÚSCULAS")
        String uf,

        @NotBlank
        String pais
) {
        public EnderecoDTO(Endereco endereco) {
                this(endereco.getRua(), endereco.getNumero(), endereco.getBairro(),
                        endereco.getCidade(), endereco.getCep(), endereco.getUf(),
                        endereco.getPais());
        }
}
