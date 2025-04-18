package dutkercz.com.github.flash_freela.entities.endereco;

public interface EnderecoMapper {

    static Endereco toEntity(EnderecoDTO enderecoDTO){
        return new Endereco(
                enderecoDTO.rua(), enderecoDTO.numero(),
                enderecoDTO.bairro(), enderecoDTO.cidade(),
                enderecoDTO.cep(), enderecoDTO.uf(), enderecoDTO.pais()
        );
    }
}
