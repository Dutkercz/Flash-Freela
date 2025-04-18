package dutkercz.com.github.flash_freela.services;

import dutkercz.com.github.flash_freela.entities.empresa.Empresa;
import dutkercz.com.github.flash_freela.entities.empresa.EmpresaCadastroDTO;
import dutkercz.com.github.flash_freela.entities.empresa.EmpresaMapper;
import dutkercz.com.github.flash_freela.repositories.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa findById(Long id){
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    }

    @Transactional
    public Empresa cadastro(@Valid EmpresaCadastroDTO cadastroDTO) {
        Empresa empresa = EmpresaMapper.toEntity(cadastroDTO);
        return empresaRepository.save(empresa);
    }
}
