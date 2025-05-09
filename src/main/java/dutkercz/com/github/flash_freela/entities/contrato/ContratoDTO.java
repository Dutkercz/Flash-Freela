package dutkercz.com.github.flash_freela.entities.contrato;

import java.time.LocalDate;

public record ContratoDTO(String descricao,
                          Double valor,
                          LocalDate dataInicio,
                          LocalDate dataFim) {

    public ContratoDTO(Contrato contrato) {
        this(contrato.getDescricao(), contrato.getValor(), contrato.getDataInicio(), contrato.getDataFim());
    }
}
