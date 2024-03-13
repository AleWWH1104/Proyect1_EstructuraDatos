import java.util.HashMap;
import java.util.Map;

public class LispInterpreter {

    private static Map<String, Double> variables = new HashMap<>();

    public static double evaluate(String expression) {
        String[] tokens = expression.split("\\s+");

        if (tokens.length < 3 || !tokens[0].equals("SETQ")) {
            System.out.println("Expresión SETQ incorrecta.");
            return Double.MIN_VALUE;
        }

        String variableName = tokens[1];
        double value = calculate(tokens, 2);

        variables.put(variableName, value);
        return value;
    }

    private static double calculate(String[] tokens, int startIndex) {
        if (startIndex >= tokens.length) {
            System.out.println("Expresión incorrecta.");
            return Double.MIN_VALUE;
        }

        String token = tokens[startIndex];

        if (isNumeric(token)) {
            return Double.parseDouble(token);
        } else if (variables.containsKey(token)) {
            return variables.get(token);
        } else {
            System.out.println("Variable no definida: " + token);
            return Double.MIN_VALUE;
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String expression1 = "SETQ x 5";
        String expression2 = "SETQ y 10";
        String expression3 = "SETQ z (+ x y)";

        System.out.println("Resultado de la expresión 1: " + evaluate(expression1));
        System.out.println("Resultado de la expresión 2: " + evaluate(expression2));
        System.out.println("Resultado de la expresión 3: " + evaluate(expression3));
    }
}
