package com.example.Fase2;

import java.util.List;

public class Valor<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        return tokens.get(0);

    }
}
