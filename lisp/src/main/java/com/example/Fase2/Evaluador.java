package com.example.Fase2;

import java.util.List;

public class Evaluador {
    private final Environment environment;
    private final FactoryEstructuras factory;

    public Evaluador(Environment environment) {
        this.environment = environment;
        this.factory = new FactoryEstructuras();
    }

    public Object evaluarExpresion(List<Object> tokens) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Expresión vacía");
        }

        Object firstToken = tokens.get(0);
        if (firstToken instanceof List) {
            return evaluateList((List<Object>) firstToken);
        } else {
            return evaluateToken(firstToken, tokens);
        }
    }

    private Object evaluateList(List<Object> list) {
        Object firstToken = list.get(0);
        if (firstToken instanceof List) {
            return evaluarExpresion((List<Object>) firstToken);
        } else {
            return evaluateToken(firstToken, list);
        }
    }

    public Object evaluateToken(Object token, List<Object> tokens) {
        Iestructuras estructura = factory.crearImplementacion(token);
        if (estructura instanceof Defun<?>) {
            ((Defun<?>) estructura).setAttributes(tokens);
            return "";
        } else {
            // Si no es una clase Defun<T>, sigue con el comportamiento existente
            return estructura.execute(tokens, environment);
        }
    }
}
