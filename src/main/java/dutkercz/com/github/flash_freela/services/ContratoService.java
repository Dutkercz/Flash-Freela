package dutkercz.com.github.flash_freela.services;

import dutkercz.com.github.flash_freela.entities.contrato.Contrato;
import dutkercz.com.github.flash_freela.entities.contrato.ContratoCadastroDTO;
import dutkercz.com.github.flash_freela.entities.contrato.ContratoMapper;
import dutkercz.com.github.flash_freela.entities.empresa.Empresa;
import dutkercz.com.github.flash_freela.entities.enums.Status;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import dutkercz.com.github.flash_freela.repositories.ContratoRepository;
import dutkercz.com.github.flash_freela.repositories.EmpresaRepository;
import dutkercz.com.github.flash_freela.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;

    public ContratoService(ContratoRepository contratoRepository, UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository) {
        this.contratoRepository = contratoRepository;
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public Contrato novoContrato(ContratoCadastroDTO cadastroDTO, String username) {
        Usuario usuario = (Usuario) usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado."));

        Empresa empresa = empresaRepository.findEmpresaByUsuarioIdAndStatus(usuario.getId(), Status.ATIVA)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada!"));

        return contratoRepository.save(ContratoMapper.toEntity(cadastroDTO, empresa));
    }
}
