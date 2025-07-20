package br.com.neto.netoflix.model;

import br.com.neto.netoflix.service.DesserializaAno;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String nome,
                         @JsonAlias("Year") @JsonDeserialize(using = DesserializaAno.class) Integer anoDeLancamento,
                         @JsonAlias("totalSeasons") Integer totalDeTemporadas) {
}
