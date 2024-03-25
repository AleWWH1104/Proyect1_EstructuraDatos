package com.example.Fase2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Quotetest {
    @Test
    public void quotetest() {
        Parser parsear = new Parser();
        String expresion = "(quote hola)";
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
        assertEquals("hola", results.get(0));

    }

}