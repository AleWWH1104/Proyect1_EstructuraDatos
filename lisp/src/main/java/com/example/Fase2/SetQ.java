package com.example.Fase2;

import java.util.List;

/**
 * Clase SetQ que implementa la interfaz Iestructuras para asignar valores a
 * variables en un entorno.
 *
 * @param <T> Tipo genérico (no utilizado en esta implementación).
 */
public class SetQ<T> implements Iestructuras<T> {

    // Ejecuta la operación SetQ para asignar un valor a una variable en el entorno.
    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        if (tokens.size() != 3) {
            throw new IllegalArgumentException("SetQ incompleto.");
        }

        Object variableNameToken = tokens.get(1);
        Object valueToken = tokens.get(2);

        if (!(variableNameToken instanceof String)) {
            throw new IllegalArgumentException("Variable name should be a string.");
        }

        // Evaluar recursivamente el token de valor si es una lista
        Evaluador evaluador = new Evaluador(environment);
        if (valueToken instanceof List) {
            valueToken = evaluador.evaluarExpresion((List<Object>) valueToken);
        }
        // set la variable en el environment
        setVariable((String) variableNameToken, valueToken, environment);

        return valueToken;
    }

    private void setVariable(String variableName, Object value, Environment environment) {
        environment.setVariable(variableName, value.toString());
    }

}
