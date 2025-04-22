package dutkercz.com.github.flash_freela.entities.empresa;

import dutkercz.com.github.flash_freela.entities.endereco.Endereco;
import dutkercz.com.github.flash_freela.entities.endereco.EnderecoDTO;

public record EmpresaDTO(String nome,
                         String telefone,
                         String email,
                         EnderecoDTO endereco) {

    public EmpresaDTO(Empresa empresa) {
        this(empresa.getNome(), empresa.getTelefone(), empresa.getEmail(),
                new EnderecoDTO(empresa.getEndereco()));
    }
}
