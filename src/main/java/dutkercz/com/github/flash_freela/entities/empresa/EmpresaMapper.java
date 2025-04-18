package dutkercz.com.github.flash_freela.entities.empresa;

import dutkercz.com.github.flash_freela.entities.endereco.EnderecoMapper;

public interface EmpresaMapper {

    static Empresa toEntity(EmpresaCadastroDTO cadastroDTO){
        Empresa empresa = new Empresa();

        empresa.setNome(cadastroDTO.nome());
        empresa.setCnpj(cadastroDTO.cnpj());
        empresa.setEmail(cadastroDTO.email());
        empresa.setTelefone(cadastroDTO.telefone());
        empresa.setEndereco(EnderecoMapper.toEntity(cadastroDTO.endereco()));

        return empresa;
    }
}
