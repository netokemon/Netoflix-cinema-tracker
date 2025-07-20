package br.com.neto.netoflix.service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class DesserializaAno extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String valor = jsonParser.getText();
        if(valor.contains("–")){
            return Integer.parseInt(valor.split("–")[0]);
        }
        return Integer.parseInt(valor);
    }
}
