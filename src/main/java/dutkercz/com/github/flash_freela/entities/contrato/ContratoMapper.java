package dutkercz.com.github.flash_freela.entities.contrato;

import dutkercz.com.github.flash_freela.entities.empresa.Empresa;
import dutkercz.com.github.flash_freela.entities.enums.StatusContrato;

public interface ContratoMapper {
    static Contrato toEntity(ContratoCadastroDTO cadastroDTO, Empresa empresa) {
        return new Contrato(null, empresa, null, cadastroDTO.descricao(), cadastroDTO.valor(), StatusContrato.DISPONIVEL,
                cadastroDTO.dataInicio(), cadastroDTO.dataFim());
    }
}
