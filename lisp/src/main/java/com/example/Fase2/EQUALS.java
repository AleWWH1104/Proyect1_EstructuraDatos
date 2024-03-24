package com.example.Fase2;
import java.util.List;

/* Compara la igualdad de dos operandos y devuelve "T" si son iguales, o "NIL" si son diferentes.*/
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
        if (leftOperand instanceof Double) {
            leftOperand = Double.toString((Double) leftOperand);
        }
        if (rightOperand instanceof Double) {
            rightOperand = Double.toString((Double) rightOperand);
        }

       // Verificar si los operandos son iguales y devolver T o NIL
       return leftOperand.equals(rightOperand) ? "T" : "NIL";
    }
}
