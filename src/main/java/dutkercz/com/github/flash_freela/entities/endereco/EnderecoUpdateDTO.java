package dutkercz.com.github.flash_freela.entities.endereco;

import jakarta.validation.constraints.Pattern;

public record EnderecoUpdateDTO(
        String rua,
        String numero,
        String bairro,
        String cidade,

        @Pattern(regexp = "\\d{8}", message = "Digite um CEP válido.")
        String cep,

        @Pattern(regexp = "^[A-Z]{2}$", message = "O campo UF deve conter 2 letras MAIÚSCULAS")
        String uf,

        String pais

) {
}
