package com.example.Fase2;
import java.util.List;

/**
 * Clase que implementa la interfaz Iestructuras para obtener el valor del primer elemento de una lista de tokens.
 *
 * @param <T> Tipo genérico que representa el tipo de dato de los tokens.
 */
public class Valor<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        Object token = tokens.get(0);
        if (token instanceof List) {
            return token; // Devolver el primer elemento si es una lista
        } else {
            return tokens.get(0); // Devolver el primer elemento de tokens
        }
    }
}
