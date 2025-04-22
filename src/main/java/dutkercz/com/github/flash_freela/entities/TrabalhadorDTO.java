package dutkercz.com.github.flash_freela.entities;

import dutkercz.com.github.flash_freela.entities.endereco.EnderecoDTO;

public record TrabalhadorDTO(
        String nome,
        String telefone,
        EnderecoDTO enderecoDTO) {
    public TrabalhadorDTO(Trabalhador trabalhador) {
        this(trabalhador.getNome(), trabalhador.getTelefone(),
                new EnderecoDTO(trabalhador.getEndereco()));
    }
}
