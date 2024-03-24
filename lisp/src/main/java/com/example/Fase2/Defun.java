package com.example.Fase2;

import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Defun<T> implements Iestructuras<T> {
    Environment environment = new Environment();
    String name;
    List<Object> instructions;
    Map<String, Object> params;
    Object value;

    public void setInstructions(List<Object> instructions) {
        this.instructions = instructions;
    }

    public Defun(String name, List<String> params) {
        this.name = name;
        this.params = new HashMap<>();
        for (String param : params) {
            this.params.put(param, null);
        }
    }

    public Defun() {
    }

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}

    public Object execute(List<Object> tokens, Environment environment) {
        value = evaluar(environment, tokens);
        return value;

    }

}