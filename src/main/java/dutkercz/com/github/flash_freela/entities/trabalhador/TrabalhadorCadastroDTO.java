package dutkercz.com.github.flash_freela.entities.trabalhador;

import com.fasterxml.jackson.annotation.JsonFormat;
import dutkercz.com.github.flash_freela.entities.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record TrabalhadorCadastroDTO(
        @NotBlank(message = "O campo NOME não pode estar em branco.")
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "Use somente digitos")
        String cpf,

        @NotBlank(message = "O campo EMAIL não pode estar em branco.")
        @Email(message = "Digite um email válido.")
        String email,

        @NotBlank(message = "O campo TELEFONE não pode estar em branco.")
        String telefone,

        @NotNull(message = "O campo NASCIMENTO não pode estar em branco.")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate nascimento,

        @NotNull(message = "Vefifique os dados do endereço.")
        @Valid
        EnderecoDTO endereco
) {
}
