package dutkercz.com.github.flash_freela.entities;

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
//    private Usuario usuario;
    @Enumerated(value = EnumType.STRING)
    private Status status;

}
