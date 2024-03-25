package com.example.Fase2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SetQTest {
    @Test
    public void setQtest() {
        Parser parser = new Parser();
        String expression = "(setq x 5)";
        List<Object> tokens = (List<Object>) parser.parse(expression);
        List<String> results = new ArrayList<>();
        Environment environment = new Environment(); // Crear un nuevo entorno
        Evaluador evaluator = new Evaluador(environment);
        for (Object lista : tokens) {
            Object result = evaluator.evaluarExpresion((List<Object>) lista);
            if (result.toString() != "") {
                results.add(result.toString());
            }
        }

        assertEquals("5", environment.getVariable("x"));

    }

}
