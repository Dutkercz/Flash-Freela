package dutkercz.com.github.flash_freela.entities.empresa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dutkercz.com.github.flash_freela.entities.endereco.Endereco;
import dutkercz.com.github.flash_freela.entities.Status;
import dutkercz.com.github.flash_freela.entities.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String nome;
    @Setter
    private String cnpj;
    @Setter
    private String email;
    @Setter
    private String telefone;

    @Embedded
    @Setter
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @PrePersist
    public void prePersist(){
        this.status = Status.ATIVA;
    }
}
