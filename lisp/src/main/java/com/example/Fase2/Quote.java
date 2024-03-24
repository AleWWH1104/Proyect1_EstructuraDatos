package com.example.Fase2;

import java.util.List;

public class Quote<T> implements Iestructuras<T> {
    List<String> listQuote;
    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        
        // Obtenemos el token que sigue a 'quote' (o ').
        if (tokens.size() < 2) {
            throw new IllegalArgumentException("Falta el token a citar después de 'quote'");
        }
        Object quote = tokens.get(1);

        // Devolver lo que sigue del quote
        return quote;    
    }
    
}