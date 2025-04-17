package dutkercz.com.github.flash_freela.repositories;

import dutkercz.com.github.flash_freela.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
