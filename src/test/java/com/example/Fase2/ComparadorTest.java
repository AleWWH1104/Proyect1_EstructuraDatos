package com.example.Fase2;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ComparadorTest {
    @Test
    public void Comparadorrtest() {
        Parser parsear = new Parser();
        String expresion = "(< 3 4)";
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
        assertEquals("true", results.get(0));

    }

}
