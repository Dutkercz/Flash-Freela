package dutkercz.com.github.flash_freela.services;

import dutkercz.com.github.flash_freela.entities.enums.Status;
import dutkercz.com.github.flash_freela.entities.empresa.Empresa;
import dutkercz.com.github.flash_freela.entities.empresa.EmpresaCadastroDTO;
import dutkercz.com.github.flash_freela.entities.empresa.EmpresaMapper;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import dutkercz.com.github.flash_freela.repositories.EmpresaRepository;
import dutkercz.com.github.flash_freela.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final UsuarioRepository usuarioRepository;

    public EmpresaService(EmpresaRepository empresaRepository, UsuarioRepository usuarioRepository) {
        this.empresaRepository = empresaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Empresa findById(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    }

    @Transactional
    public Empresa cadastro(@Valid EmpresaCadastroDTO cadastroDTO, String username) {
        Usuario usuario = (Usuario) usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return empresaRepository.save(EmpresaMapper.toEntity(cadastroDTO, usuario));
    }

    @Transactional
    public void deleteMeuCadastro(String username){
        Usuario usuario =(Usuario) usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado."));
        Empresa empresa = empresaRepository.findEmpresaByUsuarioIdAndStatus(usuario.getId(), Status.ATIVA)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada!"));
        empresa.setInativa();
    }

    public Page<Empresa> findAllAtivo(Pageable pageable) {
        return empresaRepository.findAllByStatus(Status.ATIVA, pageable);
    }
}
