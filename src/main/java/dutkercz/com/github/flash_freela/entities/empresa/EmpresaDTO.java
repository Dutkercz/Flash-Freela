package dutkercz.com.github.flash_freela.entities.empresa;

import dutkercz.com.github.flash_freela.entities.endereco.Endereco;

public record EmpresaDTO(String nome,
                         String telefone,
                         String email,
                         Endereco endereco) {

    public EmpresaDTO(Empresa empresa) {
        this(empresa.getNome(), empresa.getTelefone(), empresa.getEmail(), empresa.getEndereco());
    }
}
