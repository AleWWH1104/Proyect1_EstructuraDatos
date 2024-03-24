package com.example.Fase2;

import java.util.ArrayList;
import java.util.List;

/** Procesa una lista de tokens y evalúa sus elementos.*/
public class Listas<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("No hay tokens para evaluar");
        }
        // Remover el primer elemento que es el nombre de la operación
        tokens.remove(0);
        List<Object> lista = new ArrayList<>();

        Evaluador evaluador = new Evaluador(environment);
        for (Object token : tokens) {

            if (token instanceof List) {
                 // Evaluar el token si es una lista y agregar el resultado a la lista
                Object value = evaluador.evaluarExpresion((List<Object>) token);
                lista.add(value);
            }

            else {
                // Crear una lista temporal con el token y evaluarla, luego agregar el resultado a la lista
                List<Object> temp = new ArrayList<>();
                temp.add(token);
                Object value = evaluador.evaluarExpresion((List<Object>) temp);
                lista.add(value);

            }
        }
        return lista;
    }
}