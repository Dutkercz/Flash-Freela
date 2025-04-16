package dutkercz.com.github.flash_freela.repositories;

import dutkercz.com.github.flash_freela.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
