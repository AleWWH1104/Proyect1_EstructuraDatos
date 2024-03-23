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
        Object valor1 = obtenerValor(operando1);
        Object valor2 = obtenerValor(operando2);

        switch (operador) {
            case "+":
                return (int) valor1 + (int) valor2;
            case "-":
                return (int) valor1 - (int) valor2;
            case "*":
                return (int) valor1 * (int) valor2;
            case "/":
                if ((int) valor2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return (int) valor1 / (int) valor2;
            default:
                throw new IllegalArgumentException("Operador aritmético no válido: " + operador);
        }
    }

    private Object obtenerValor(Object operando) {
        if (operando instanceof Integer) {
            return operando;
        } else if (operando instanceof List) {
            return new LispInterpreter().evaluarExpresionAritmetica((List<Object>) operando);
        } else {
            throw new IllegalArgumentException("Valor no válido en la expresión aritmética: " + operando);
        }
    }
}
