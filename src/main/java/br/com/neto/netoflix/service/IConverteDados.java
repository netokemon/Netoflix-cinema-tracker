package br.com.neto.netoflix.service;


public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
