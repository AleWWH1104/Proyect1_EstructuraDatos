
package com.example.Fase2;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testDefunClass {
    @Test
    public void testDefun() {
        Parser parsear = new Parser();
        String expresion = "(     defun factorial (num)         (cond          ((= num 0) 1)         ((> num 0) (* num (factorial (- num 1))))         ) )(factorial 5)";
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
        assertEquals("120.0", results.get(0));

    }

}
