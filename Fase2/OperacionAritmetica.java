package Fase2;

import java.util.List;

public class OperacionAritmetica {
    private String operador;
    private Object operando1;
    private Object operando2;

    public OperacionAritmetica(List<Object> expresion) {
        if (expresion == null || expresion.size() != 3) {
            throw new IllegalArgumentException("Expresión aritmética no válida");
        }

        this.operador = (String) expresion.get(0);
        this.operando1 = expresion.get(1);
        this.operando2 = expresion.get(2);
    }

    public Object evaluar() {
        Object valorOperando1 = evaluarOperando(operando1);
        Object valorOperando2 = evaluarOperando(operando2);

        // Realizar la evaluación de acuerdo al operador
        switch (operador) {
            case "+":
                return (int)valorOperando1 + (int)valorOperando2;
            case "-":
                return (int)valorOperando1 - (int)valorOperando2;
            case "*":
                return (int)valorOperando1 * (int)valorOperando2;
            case "/":
                if ((int)valorOperando2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return (int)valorOperando1 / (int)valorOperando2;
            default:
                throw new IllegalArgumentException("Operador aritmético no válido: " + operador);
        }
    }

    private Object evaluarOperando(Object operando) {
        if (operando instanceof Integer) {
            return operando; // El operando es un número
        } else if (operando instanceof List) {
            return new LispInterpreter().evaluarExpresionAritmetica((List<Object>) operando);
        } else {
            throw new IllegalArgumentException("Valor no válido en la expresión aritmética: " + operando);
        }
    }
}
