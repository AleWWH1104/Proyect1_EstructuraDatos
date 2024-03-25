package com.example.Fase2;

import java.util.List;

/**
 * Verifica si el token es un átomo en Lisp.
 *
 * @param tokens      Lista de tokens que contiene el token a verificar.
 * @param environment Entorno de ejecución (no utilizado en este método).
 * @return "T" si el token es un átomo, "NIL" si el token es una lista vacía, o
 *         "NIL" si el token es una lista no vacía.
 * @throws IllegalArgumentException Si la lista de tokens no contiene
 *                                  exactamente un argumento.
 */

public class Atom<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        if (tokens.size() != 2) {
            throw new IllegalArgumentException("La operación atom requiere exactamente un argumento.");
        }

        Object token = tokens.get(1);

        if (token instanceof List) {
            // Verificar si la lista está vacía
            if (((List<Object>) token).isEmpty()) {
                return false; // Devolver NIL si la lista está vacía
            } else {
                return false; // Devolver NIL si el token es una lista no vacía
            }
        } else {
            return true; // Devolver T si el token es un átomo
        }
    }
}
