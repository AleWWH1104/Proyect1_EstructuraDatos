package com.example.Fase2;
import java.util.List;

/**
 * Clase Calculator que implementa la interfaz Iestructuras para ejecutar operaciones matemáticas en notación prefija.
 */

//Ejecuta la expresión matemática en notación prefija representada por una lista de tokens.
public class Calculator<T> implements Iestructuras<T> {
    @SuppressWarnings("unchecked")
    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        // Verificar que la lista de tokens tenga al menos tres elementos
        if (tokens.size() < 3) {
            throw new IllegalArgumentException("Comparador operation requires at least two operands and an operator.");
        }

        // Obtener el operador y los operandos de la lista de tokens
        Object operador = tokens.get(0);
        Object operando1 = tokens.get(1);
        Object operando2 = tokens.get(2);

        // Evaluar los operandos recursivamente si son listas
        Evaluador evaluador = new Evaluador(environment);
        if (operando1 instanceof List) {
            operando1 = evaluador.evaluarExpresion((List<Object>) operando1);
        }
        if (operando2 instanceof List) {
            operando2 = evaluador.evaluarExpresion((List<Object>) operando2);
        }

        // Realizar la operación aritmética según el operador
        if ("+".equals(operador)) {
            return Double.parseDouble(operando1.toString()) + Double.parseDouble(operando2.toString());
        } else if ("-".equals(operador)) {
            return Double.parseDouble(operando1.toString()) - Double.parseDouble(operando2.toString());
        } else if ("*".equals(operador)) {
            return Double.parseDouble(operando1.toString()) * Double.parseDouble(operando2.toString());
        } else if ("/".equals(operador)) {
            return Double.parseDouble(operando1.toString()) / Double.parseDouble(operando2.toString());
        } else {
            throw new IllegalArgumentException("Operador de aritmética no válido: " + operador);
        }
    }
}
