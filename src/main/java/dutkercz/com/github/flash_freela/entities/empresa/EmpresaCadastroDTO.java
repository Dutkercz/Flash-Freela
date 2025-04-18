package dutkercz.com.github.flash_freela.entities.empresa;

import dutkercz.com.github.flash_freela.entities.Endereco;
import dutkercz.com.github.flash_freela.entities.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EmpresaCadastroDTO(
        @NotBlank(message = "O Campo nome não pode estar em branco.")
        String nome,

        @NotBlank(message = "O Campo CNPJ não pode estar em branco.")
        @Pattern(regexp = "/d{14}", message = "Digite apenas os 14 digitos do CNPJ.")
        String cnpj,

        @NotBlank(message = "O campo E-MAIL não pode estar em branco.")
        @Email(message = "Digite um email válido.")
        String email,

        @NotBlank(message = "O campo TELEFONE não pode estar em branco.")
        String telefone,

        @NotNull @Valid
        EnderecoDTO endereco
) {
}
