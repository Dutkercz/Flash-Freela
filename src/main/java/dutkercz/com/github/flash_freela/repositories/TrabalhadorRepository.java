package dutkercz.com.github.flash_freela.repositories;

import dutkercz.com.github.flash_freela.entities.enums.Status;
import dutkercz.com.github.flash_freela.entities.trabalhador.Trabalhador;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long> {

    Optional<Trabalhador> findTrabalhadorByUsuarioIdAndStatus(Long id, Status status);

    Page<Trabalhador> findAllByStatus(Status status, Pageable pageable);
}
