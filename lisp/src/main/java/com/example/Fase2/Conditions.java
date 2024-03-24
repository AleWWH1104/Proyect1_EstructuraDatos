package com.example.Fase2;

import java.util.List;

/**
 * Esta clase representa la estructura de condiciones utilizada para evaluar
 * diferentes opciones y ejecutar la correspondiente.
 *
 * @param <T> Tipo genérico para la estructura de condiciones.
 */
public class Conditions<T> implements Iestructuras<T> {

    /**
     * Método para ejecutar las condiciones y devolver el resultado de la primera
     * condición que se cumpla.
     *
     * @param tokens      Lista de tokens que representan las condiciones y las
     *                    instrucciones asociadas.
     * @param environment Entorno de ejecución.
     * @return Resultado de la ejecución de la primera condición que se cumple, o
     *         una cadena vacía si ninguna condición se cumple.
     * @throws IllegalArgumentException si la lista de tokens está vacía.
     */
    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Lista de tokens vacía.");
        }
        tokens.remove(0);
        Evaluador evaluador = new Evaluador(environment);

        for (Object token : tokens) {
            List<Object> expresion = (List<Object>) token;
            List<Object> condicion = (List<Object>) expresion.get(0);
            Boolean evalueCondicion = (Boolean) evaluador.evaluarExpresion(condicion);
            if (evalueCondicion) {
                Object instruccion = expresion.get(1);
                if (instruccion instanceof List) {
                    return evaluador.evaluarExpresion((List<Object>) instruccion);
                } else {
                    return instruccion;
                }
            }
        }
        // Si ninguna de las condiciones se evalúa como verdadera, devuelve una cadena
        // vacía
        return "";
    }
}
