package br.com.neto.netoflix;

import br.com.neto.netoflix.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetoflixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NetoflixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
