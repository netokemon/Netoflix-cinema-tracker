package br.com.neto.netoflix;

import br.com.neto.netoflix.model.DadosSerie;
import br.com.neto.netoflix.service.ConsumoAPI;
import br.com.neto.netoflix.service.ConverteDados;
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
		var consumoAPI = new ConsumoAPI();
		ConverteDados conversor = new ConverteDados();
		String json = consumoAPI.obterDados("http://www.omdbapi.com/?t=teen+wolf&apikey=&");
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
