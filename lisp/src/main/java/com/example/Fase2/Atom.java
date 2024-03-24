package com.example.Fase2;
import java.util.List;

public class Atom<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("No hay atomo");
        }
        System.out.println(tokens);
        Evaluador evaluador = new Evaluador(environment);
        Object token = null;

        if (tokens.get(1) instanceof List) {
            token = evaluador.evaluarExpresion((List<Object>) tokens.get(1));
        }

        if (token instanceof List) {
            return false;
        } else {
            return true;
        }
    }
}
