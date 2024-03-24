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

        // Convertir a String si son Double
        if (leftOperand instanceof Integer) {
            leftOperand = Double.toString((Double) leftOperand);
        }
        if (rightOperand instanceof Integer) {
            rightOperand = Double.toString((Double) rightOperand);
        }
        System.out.println(leftOperand.getClass().getSimpleName());
        System.out.println(rightOperand.getClass().getSimpleName());
        System.out.println(leftOperand);
        System.out.println(rightOperand);
        
        // Verificar si los operandos son iguales
        return leftOperand.equals(rightOperand);
    }
}
