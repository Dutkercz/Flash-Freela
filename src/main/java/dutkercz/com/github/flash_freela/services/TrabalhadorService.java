package dutkercz.com.github.flash_freela.services;

import dutkercz.com.github.flash_freela.entities.Status;
import dutkercz.com.github.flash_freela.entities.trabalhador.Trabalhador;
import dutkercz.com.github.flash_freela.entities.trabalhador.TrabalhadorCadastroDTO;
import dutkercz.com.github.flash_freela.entities.trabalhador.TrabalhadorMapper;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import dutkercz.com.github.flash_freela.repositories.TrabalhadorRepository;
import dutkercz.com.github.flash_freela.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Trabalhador cadastro(TrabalhadorCadastroDTO cadastroDTO, String username) {
        Usuario usuario = (Usuario) usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return trabalhadorRepository.save(TrabalhadorMapper.toEntity(cadastroDTO, usuario));
    }

    @Transactional
    public void deleteMeuCadastro(String username) {
        Usuario usuario =(Usuario) usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado."));

        Trabalhador trabalhador = trabalhadorRepository.findTrabalhadorByUsuarioIdAndStatus(usuario.getId(), Status.ATIVA)
                .orElseThrow(() -> new EntityNotFoundException("Cadastro não encontrado, ou está inativo."));

        trabalhador.setInativa();
    }
}
