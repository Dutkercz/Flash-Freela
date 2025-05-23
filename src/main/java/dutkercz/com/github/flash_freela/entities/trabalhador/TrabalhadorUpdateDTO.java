package dutkercz.com.github.flash_freela.entities.trabalhador;

import dutkercz.com.github.flash_freela.entities.endereco.EnderecoUpdateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

public record TrabalhadorUpdateDTO(
        String nome,

        @Email(message = "Digite um email válido.")
        String email,

        String telefone,

        @Valid
        EnderecoUpdateDTO endereco
) {
}
