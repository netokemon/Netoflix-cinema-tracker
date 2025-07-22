package br.com.neto.netoflix.principal;

import br.com.neto.netoflix.model.DadosSerie;
import br.com.neto.netoflix.model.DadosTemporada;
import br.com.neto.netoflix.service.ConsumoAPI;
import br.com.neto.netoflix.service.ConverteDados;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final String INICIO_ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=&";

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private Scanner scanner = new Scanner(System.in);

    public void exibeMenu(){
        System.out.println("Digite a série que quer buscar:");
        var nomeBusca = scanner.nextLine();
        var nomeCodificado = URLEncoder.encode(nomeBusca, StandardCharsets.UTF_8);
        var json = consumoAPI.obterDados(INICIO_ENDERECO + nomeCodificado + API_KEY);

        DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for(int i = 1; i <= dadosSerie.totalDeTemporadas(); i++){
            json = consumoAPI.obterDados(INICIO_ENDERECO + nomeCodificado + "&season=" + i + API_KEY);
            DadosTemporada temporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(temporada);
        }

        temporadas.forEach(System.out::println);


    }
}
