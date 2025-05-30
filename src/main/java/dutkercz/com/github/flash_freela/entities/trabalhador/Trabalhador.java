package dutkercz.com.github.flash_freela.entities.trabalhador;

import dutkercz.com.github.flash_freela.entities.enums.Role;
import dutkercz.com.github.flash_freela.entities.enums.Status;
import dutkercz.com.github.flash_freela.entities.endereco.Endereco;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table
public class Trabalhador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate nascimento;
    private Double avaliacao;
    private Integer totalDeTrabalhos;

    @Embedded
    private Endereco endereco;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public void setInativa() {
        this.status = Status.INATIVA;
    }

    public void update(@Valid TrabalhadorUpdateDTO cadastroDTO) {
        if (cadastroDTO.nome() != null &&!cadastroDTO.nome().isEmpty()){
            this.nome = cadastroDTO.nome();
        }
        if (cadastroDTO.email() != null && !cadastroDTO.email().isEmpty()){
            this.email = cadastroDTO.email();
        }
        if (cadastroDTO.endereco() != null){
            this.endereco.atualizarEndereco(cadastroDTO.endereco());
        }

    }
}
