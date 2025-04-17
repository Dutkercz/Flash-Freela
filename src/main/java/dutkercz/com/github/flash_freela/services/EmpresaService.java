package dutkercz.com.github.flash_freela.services;

import dutkercz.com.github.flash_freela.entities.Empresa;
import dutkercz.com.github.flash_freela.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public void saveNewEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
    }

    public Empresa findById(Long id){
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
    }
}
