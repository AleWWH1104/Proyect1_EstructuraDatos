package com.example.Fase2;

import java.util.List;

public class Valor<T> implements Iestructuras {

    @Override
    public Object execute(List tokens, Environment environment) {
        return tokens.get(0);
    }
}
