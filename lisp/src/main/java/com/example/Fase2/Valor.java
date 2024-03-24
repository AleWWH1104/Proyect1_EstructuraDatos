package com.example.Fase2;

import java.util.List;

public class Valor<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        Object token = tokens.get(0);
        if (token.getClass().getSimpleName().equals("Integer")) {
            Double doubleToken = Double.parseDouble(token.toString());
            String stringToken = doubleToken.toString();
            return stringToken;
        } else {
            return token;
        }
    }
}