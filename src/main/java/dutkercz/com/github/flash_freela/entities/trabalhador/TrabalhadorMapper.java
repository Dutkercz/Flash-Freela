package dutkercz.com.github.flash_freela.entities.trabalhador;

import dutkercz.com.github.flash_freela.entities.Role;
import dutkercz.com.github.flash_freela.entities.Status;
import dutkercz.com.github.flash_freela.entities.endereco.Endereco;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;

public interface TrabalhadorMapper {

    static Trabalhador toEntity(TrabalhadorCadastroDTO cadastroDTO, Usuario usuario){
        return new Trabalhador(null, cadastroDTO.nome(), cadastroDTO.cpf(), cadastroDTO.email(),
                cadastroDTO.telefone(), cadastroDTO.nascimento(),null, null,
                new Endereco(cadastroDTO.endereco()), Status.ATIVA,  Role.PROFISSIONAL, usuario);
    }
}
