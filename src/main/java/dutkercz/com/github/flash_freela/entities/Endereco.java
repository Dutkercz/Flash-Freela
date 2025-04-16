package dutkercz.com.github.flash_freela.entities;

import jakarta.persistence.Embeddable;
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
}
