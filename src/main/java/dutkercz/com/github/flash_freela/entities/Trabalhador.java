package dutkercz.com.github.flash_freela.entities;

import dutkercz.com.github.flash_freela.entities.endereco.Endereco;
import jakarta.persistence.*;
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
    private Endereco endereco;
    private Role role;
}
