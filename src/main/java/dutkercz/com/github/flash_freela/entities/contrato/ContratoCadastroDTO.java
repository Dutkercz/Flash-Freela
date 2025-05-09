package dutkercz.com.github.flash_freela.entities.contrato;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ContratoCadastroDTO(
        @NotBlank(message = "Insira um descrição do contrato")
        String descricao,

        @NotNull(message = "Insira o valor total do contrato")
        Double valor,

        @NotNull(message = "Insira a data inicial do contrato")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataInicio,

        @NotNull(message = "Insira a data final do contrato")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataFim
) {
}
