package dutkercz.com.github.flash_freela.entities.contrato;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ContratoCadastroDTO(
        @NotBlank(message = "Insira um descrição do contrato")
        String descricao,

        @NotNull(message = "Insira o valor total do contrato")
        Double valor,

        @NotNull(message = "Insira a data inicial do contrato")
        LocalDate dataInicio,

        @NotNull(message = "Insira a data final do contrato")
        LocalDate dataFim
) {
}
