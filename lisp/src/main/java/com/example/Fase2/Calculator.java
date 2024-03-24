package com.example.Fase2;
import java.util.List;
import java.util.Stack;

//Ejecuta la expresión matemática en notación prefija representada por una lista de tokens.
public class Calculator<T> implements Iestructuras<T> {
    @Override
    public Double execute(List<Object> tokens, Environment environment) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Expresión vacía.");
        }

        Stack<Double> stack = new Stack<>();
        for (int i = tokens.size() - 1; i >= 0; i--) {
            Object token = tokens.get(i);
            if (token instanceof String) {
                String operator = (String) token;
                if (isOperator(operator)) {
                    double operand1 = stack.pop();
                    double operand2 = stack.pop();
                    double result = applyOperator(operator, operand1, operand2);
                    stack.push(result);
                } else {
                    stack.push(Double.parseDouble(operator));
                }
            } else if (token instanceof List<?>) {
                double result = execute((List<Object>) token, environment);
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión inválida.");
        }

        return stack.pop();
    }

    //Verifica si un token es un operador matemático válido (+, -, *, /).
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    //Aplica un operador matemático a dos operandos.
    private double applyOperator(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("División por cero.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operator);
        }
    }
}
