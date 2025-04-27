package dutkercz.com.github.flash_freela.repositories;

import dutkercz.com.github.flash_freela.entities.Status;
import dutkercz.com.github.flash_freela.entities.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findEmpresaByUsuarioIdAndStatus(Long id, Status status);
}
