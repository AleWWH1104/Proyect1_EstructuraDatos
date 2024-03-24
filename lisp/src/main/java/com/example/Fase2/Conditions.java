package com.example.Fase2;

import java.util.Arrays;
import java.util.List;

public class Conditions<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Lista de tokens vacía.");
        }

        // Obtener la condición y las cláusulas de acción
        List<Object> condicion = (List<Object>) tokens.get(0);
        List<Object> acciones = (List<Object>) tokens.subList(1, tokens.size());

        // Evaluar la condición y ejecutar la acción correspondiente
        Evaluador evaluador = new Evaluador(environment);
        for (Object accion : acciones) {
            List<Object> accionList = (List<Object>) accion;
            if (evaluarCondicion((List<Object>) condicion.get(0), environment)) {
                return evaluador.evaluarExpresion(accionList);
            }
        }

        throw new IllegalArgumentException("Ninguna cláusula de acción se ejecutó.");
    }

    private boolean evaluarCondicion(List<Object> condicion, Environment environment) {
        if (condicion.isEmpty()) {
            throw new IllegalArgumentException("Condición vacía.");
        }

        // Obtener el operador y los operandos de la condición
        String operador = (String) condicion.get(0);
        Object operando1 = condicion.get(1);
        Object operando2 = condicion.get(2);

        // Evaluar los operandos recursivamente si son listas
        Evaluador evaluador = new Evaluador(environment);
        if (operando1 instanceof List) {
            operando1 = evaluador.evaluarExpresion((List<Object>) operando1);
        }
        if (operando2 instanceof List) {
            operando2 = evaluador.evaluarExpresion((List<Object>) operando2);
        }

        // Realizar la comparación utilizando la clase Comparador
        Comparador<T> comparador = new Comparador<>();
        List<Object> comparacion = Arrays.asList((Object) operador, operando1, operando2);
        return (boolean) comparador.execute(comparacion, environment); }
}
