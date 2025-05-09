package dutkercz.com.github.flash_freela.entities.empresa;

import dutkercz.com.github.flash_freela.entities.enums.Role;
import dutkercz.com.github.flash_freela.entities.enums.Status;
import dutkercz.com.github.flash_freela.entities.endereco.Endereco;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;

public interface EmpresaMapper {

    static Empresa toEntity(EmpresaCadastroDTO cadastroDTO, Usuario usuario) {
        return new Empresa(null, cadastroDTO.nome(), cadastroDTO.cnpj(), cadastroDTO.email(),
                cadastroDTO.telefone(), new Endereco(cadastroDTO.endereco()),
                Status.ATIVA, Role.EMPRESA, usuario);
    }
}
