package com.example.Fase2;

import java.util.ArrayList;
import java.util.List;

public class Listas<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("No hay tokens para evaluar");
        }
        tokens.remove(0);
        List<Object> lista = new ArrayList<>();

        Evaluador evaluador = new Evaluador(environment);
        for (Object token : tokens) {

            if (token instanceof List) {
                Object value = evaluador.evaluarExpresion((List<Object>) token);
                lista.add(value);
            }

            else {
                List<Object> temp = new ArrayList<>();
                temp.add(token);
                Object value = evaluador.evaluarExpresion((List<Object>) temp);
                lista.add(value);

            }
        }

        return lista;

    }
}