package com.example.Fase2;

import java.util.ArrayList;
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
        Iestructuras estructura = factory.crearImplementacion(token, environment);
        Boolean flagFuncionCreate = environment.getFunctionMap().containsKey(token.toString());
        if (estructura instanceof Defun<?> && !flagFuncionCreate) {
            Defun<?> funcion = (Defun<?>) estructura;
            funcion.setAttributes(tokens);
            environment.addFunction(funcion.name, funcion);
            return "";
        } else {
            // Si no es una clase Defun<T>, sigue con el comportamiento existente
            List<Object> replacedTokens = replaceValues(tokens);
            return estructura.execute(replacedTokens, environment);
        }
    }

    private List<Object> replaceValues(List<Object> tokens) {
        List<Object> replacedTokens = new ArrayList<>();
        for (Object token : tokens) {
            if (token instanceof String) {
                String word = (String) token;
                if (environment.getVariableMap().containsKey(word)) {
                    Object value = environment.getVariable(word);
                    replacedTokens.add(value);
                } else {
                    replacedTokens.add(token);
                }
            } else {
                replacedTokens.add(token);
            }
        }
        return replacedTokens;
    }

}
