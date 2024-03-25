package com.example.Fase2;

import java.util.List;

/**
 * Esta clase representa una estructura que compara la igualdad de dos
 * operandos.
 * Devuelve "T" si son iguales, o "NIL" si son diferentes.
 *
 * @param <T> Tipo genérico para la estructura EQUALS.
 */
public class EQUALS<T> implements Iestructuras<T> {

    @SuppressWarnings("unchecked")
    @Override
    public Object execute(List<Object> expresion, Environment environment) {
        if (expresion.size() != 3) {
            throw new IllegalArgumentException("La operación EQUALS requiere exactamente dos operandos.");
        }

        Object leftOperand = expresion.get(1);
        Object rightOperand = expresion.get(2);

        // Evaluar los operandos recursivamente si son listas
        Evaluador evaluador = new Evaluador(environment);
        if (leftOperand instanceof List) {
            leftOperand = evaluador.evaluarExpresion((List<Object>) leftOperand).toString();
        }
        if (rightOperand instanceof List) {
            rightOperand = evaluador.evaluarExpresion((List<Object>) rightOperand).toString();
        }
        // Comparar los resultados
        return leftOperand.equals(rightOperand);
    }

}
