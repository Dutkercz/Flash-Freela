package dutkercz.com.github.flash_freela;

import dutkercz.com.github.flash_freela.entities.*;
import dutkercz.com.github.flash_freela.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FlashFreelaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlashFreelaApplication.class, args);
	}

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void run(String... args) throws Exception {
		Endereco endereco = new Endereco("RUA", "NUM", "BAIRRO", "CIDADE", "CEP", "UF", "PAIS");
		Empresa empresa = new Empresa(null, "Nome", "CNPJ", "EMAIL", "TELEFONE", endereco, /*new Usuario(null, "user", "pass", Role.ADMIN),*/ Status.ATIVA);

		System.out.println(empresaRepository.findAll());
	}
}
