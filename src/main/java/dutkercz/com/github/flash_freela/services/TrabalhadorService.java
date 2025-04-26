package dutkercz.com.github.flash_freela.services;

import dutkercz.com.github.flash_freela.entities.trabalhador.Trabalhador;
import dutkercz.com.github.flash_freela.entities.trabalhador.TrabalhadorCadastroDTO;
import dutkercz.com.github.flash_freela.entities.trabalhador.TrabalhadorMapper;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import dutkercz.com.github.flash_freela.repositories.TrabalhadorRepository;
import dutkercz.com.github.flash_freela.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TrabalhadorService {

    private final TrabalhadorRepository trabalhadorRepository;
    private final UsuarioRepository usuarioRepository;

    public TrabalhadorService(TrabalhadorRepository trabalhadorRepository, UsuarioRepository usuarioRepository) {
        this.trabalhadorRepository = trabalhadorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Trabalhador cadastro(TrabalhadorCadastroDTO cadastroDTO, String username) {
        Usuario usuario = (Usuario) usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return TrabalhadorMapper.toEntity(cadastroDTO, usuario);
    }

    public Trabalhador deleteMyAccount(String username) {
        Usuario usuario =(Usuario) usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado."));
        if (usuario != null){
        }
        return null;
    }
}
