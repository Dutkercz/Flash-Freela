package dutkercz.com.github.flash_freela.entities.contrato;

import dutkercz.com.github.flash_freela.entities.empresa.Empresa;
import dutkercz.com.github.flash_freela.entities.enums.StatusContrato;
import dutkercz.com.github.flash_freela.entities.trabalhador.Trabalhador;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Trabalhador trabalhador;

    private String descricao;

    private Double valor;

    @Enumerated(value = EnumType.STRING)
    private StatusContrato status;

    private LocalDate dataInicio;
    private LocalDate dataFim;
}
