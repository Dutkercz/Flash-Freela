package dutkercz.com.github.flash_freela.repositories;

import dutkercz.com.github.flash_freela.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByUsername(String username);
}
