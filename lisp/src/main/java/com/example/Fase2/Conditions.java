package com.example.Fase2;
import java.util.List;

public class Conditions<T> implements Iestructuras<T> {

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
            Object a = evaluador.evaluarExpresion(condicion);
            Boolean evalueCondicion = (Boolean) evaluador.evaluarExpresion(condicion);
            if (evalueCondicion) {
                Object instruccion = expresion.get(1);
                if (instruccion instanceof List) {
                    System.err.println(instruccion);
                    return evaluador.evaluarExpresion((List<Object>) instruccion);
                } else {
                    System.err.println(instruccion);
                    return instruccion;
                }
            }
        }
        // If none of the conditions evaluate to true, return null
        return "";
    }
}
