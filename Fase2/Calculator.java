package Fase2;
import java.util.List;
import java.util.ArrayList;

public class Calculator<T> implements Iestructuras<T> {
    @Override
    public Double execute(List<Object> tokens, Environment environment) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Expresión vacía.");
        }

        Object operador = tokens.get(0);
        if (operador instanceof String) {
            String operadorStr = (String) operador;
            List<Object> subTokens = tokens.subList(1, tokens.size());
            List<Double> operands = new ArrayList<>();
            for (Object subToken : subTokens) {
                if (subToken instanceof String) {
                    if (esOperador((String) subToken)) {
                        continue;
                    }
                    operands.add(Double.parseDouble((String) subToken));
                }
            }

            switch (operadorStr) {
                case "+":
                    return sumar(operands);
                case "-":
                    return restar(operands);
                case "*":
                    return multiplicar(operands);
                case "/":
                    return dividir(operands);
                default:
                    throw new IllegalArgumentException("Operador no válido: " + operadorStr);
            }
        } else {
            throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }

    private double sumar(List<Double> operands) {
        double resultado = 0;
        for (Double operand : operands) {
            resultado += operand;
        }
        return resultado;
    }

    private double restar(List<Double> operands) {
        if (operands.size() != 2) {
            throw new IllegalArgumentException("La resta requiere exactamente dos operandos.");
        }
        double operando1 = operands.get(0);
        double operando2 = operands.get(1);
        return operando1 - operando2;
    }

    private double multiplicar(List<Double> operands) {
        double resultado = 1;
        for (Double operand : operands) {
            resultado *= operand;
        }
        return resultado;
    }

    private double dividir(List<Double> operands) {
        if (operands.size() != 2) {
            throw new IllegalArgumentException("La división requiere exactamente dos operandos.");
        }
        double operando1 = operands.get(0);
        double operando2 = operands.get(1);
        if (operando2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return operando1 / operando2;
    }

    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
