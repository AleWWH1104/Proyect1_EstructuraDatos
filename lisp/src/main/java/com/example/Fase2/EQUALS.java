package com.example.Fase2;
import java.util.List;

public class EQUALS<T> implements Iestructuras<T> {

    @SuppressWarnings("unchecked")
    @Override
    public Object execute(List<Object> expresion, Environment environment) {
        if (expresion.size() != 3) {
            throw new IllegalArgumentException("EQUALS operation requires exactly two operands.");
        }

        Object leftOperand = expresion.get(1);
        Object rightOperand = expresion.get(2);

        // Evaluar los operandos recursivamente si son listas
        Evaluador evaluador = new Evaluador(environment);
        if (leftOperand instanceof List) {
            leftOperand = evaluador.evaluarExpresion((List<Object>) leftOperand);
        }
        if (rightOperand instanceof List) {
            rightOperand = evaluador.evaluarExpresion((List<Object>) rightOperand);
        }

        // Comparar los resultados
        return leftOperand.equals(rightOperand);
    }
}
