package com.example.Fase2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Defun<T> implements Iestructuras<T> {
    Environment environment = new Environment();
    String name;
    List<Object> instructions;
    Map<String, Object> params;
    Object value;

    public void setInstructions(List<Object> instructions) {
        this.instructions = instructions;
    }

    // public Defun(String name, List<String> params) {
    //     this.name = name;
    //     this.params = new HashMap<>();
    //     for (String param : params) {
    //         this.params.put(param, null);
    //     }
    // }

    // @Override
    // public Object execute(List<Object> expression) {
    //     Evaluator evaluador = new Evaluator(environment);
    //     value = evaluador.evaluar(environment, expression);
    //     return value;

    // }

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
