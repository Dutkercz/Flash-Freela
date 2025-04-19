package dutkercz.com.github.flash_freela.repositories;

import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<UserDetails> findByUsername(String username);
}
