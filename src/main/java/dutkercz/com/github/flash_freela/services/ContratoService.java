package dutkercz.com.github.flash_freela.services;

import dutkercz.com.github.flash_freela.repositories.ContratoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

}
