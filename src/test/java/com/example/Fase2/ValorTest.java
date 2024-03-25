package com.example.Fase2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValorTest {
    @Test
    public void valortest() {
        Parser parsear = new Parser();
        String expresion ="(5)";
        List<Object> tokens = (List<Object>) parsear.parse(expresion);
        List<String> results = new ArrayList<>();
        Evaluador evaluador = new Evaluador(new Environment());
        for (Object lista : tokens) {
            Object result = evaluador.evaluarExpresion((List<Object>) lista);
            ;
            if (result.toString() != "") {
                results.add(result.toString());
            }
        }
        assertEquals("5", results.get(0));

    }

}