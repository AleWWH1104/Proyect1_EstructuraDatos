package com.example.Fase2;
import java.util.List;

/**
 * Clase Quote que implementa la interfaz Iestructuras para la operación de cita ('quote').
 */
public class Quote<T> implements Iestructuras<T> {
    List<String> listQuote;
    //Ejecuta la operación de cita ('quote') para devolver el token siguiente al 'quote'.
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