package dutkercz.com.github.flash_freela.entities.empresa;

import dutkercz.com.github.flash_freela.entities.Status;
import dutkercz.com.github.flash_freela.entities.endereco.Endereco;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
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

    private String nome;

    private String cnpj;

    private String email;

    private String telefone;

    @Embedded
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @Enumerated(value = EnumType.STRING)
    private Status status;
}
