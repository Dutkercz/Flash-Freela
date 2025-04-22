package dutkercz.com.github.flash_freela.services;

import dutkercz.com.github.flash_freela.entities.Trabalhador;
import dutkercz.com.github.flash_freela.entities.TrabalhadorCadastroDTO;
import dutkercz.com.github.flash_freela.repositories.TrabalhadorRepository;
import org.springframework.stereotype.Service;

@Service
public class TrabalhadorService {

    private final TrabalhadorRepository trabalhadorRepository;

    public TrabalhadorService(TrabalhadorRepository trabalhadorRepository) {
        this.trabalhadorRepository = trabalhadorRepository;
    }

    public Trabalhador cadastro(TrabalhadorCadastroDTO cadastroDTO) {
        return null;
    }
}
