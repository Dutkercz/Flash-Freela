package dutkercz.com.github.flash_freela.entities.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String pais;

    public Endereco(@NotNull @Valid EnderecoDTO enderecoDTO) {
        this.rua = enderecoDTO.rua();
        this.numero = enderecoDTO.numero();
        this.bairro = enderecoDTO.bairro();
        this.cidade = enderecoDTO.cidade();
        this.cep = enderecoDTO.cep();
        this.uf = enderecoDTO.uf();
        this.pais = enderecoDTO.pais();
    }

    public void atualizarEndereco(@Valid EnderecoUpdateDTO endereco) {
        if (endereco.rua() != null && !endereco.rua().isEmpty()){
            this.rua = endereco.rua();
        }
        if (endereco.numero() != null && !endereco.numero().isEmpty()){
            this.numero = endereco.numero();
        }
        if (endereco.bairro() != null && !endereco.bairro().isEmpty()){
            this.bairro = endereco.bairro();
        }
        if (endereco.cidade() != null && !endereco.cidade().isEmpty()){
            this.cidade = endereco.cidade();
        }
        if (endereco.cep() != null && !endereco.cep().isEmpty()){
            this.cep = endereco.cep();
        }
        if (endereco.uf() != null && !endereco.uf().isEmpty()){
            this.uf = endereco.uf();
        }
        if (endereco.pais() != null && !endereco.pais().isEmpty()){
            this.pais = endereco.pais();
        }

    }
}
