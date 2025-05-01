package dutkercz.com.github.flash_freela.repositories;

import dutkercz.com.github.flash_freela.entities.contrato.Contrato;
import dutkercz.com.github.flash_freela.entities.enums.StatusContrato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    Page<Contrato> findAllByStatusContrato(StatusContrato statusContrato, Pageable pageable);
}
