package com.example.Fase2;

import java.util.List;

public class Quote<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        // Obtenemos el token que sigue a 'quote' (o ').
        if (tokens.size() < 2) {
            throw new IllegalArgumentException("Falta el token a citar después de 'quote'");
        }
        // Devolver la sublista que sigue al quote
        return tokens.subList(1, tokens.size());    
    }

    
}