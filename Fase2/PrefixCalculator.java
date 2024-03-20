import java.util.Stack;

public class PrefixCalculator {

    public static int calculatePrefix(String[] expression) throws IllegalArgumentException {
        if (expression == null || expression.length == 0) {
            throw new IllegalArgumentException("Expresión inválida");
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = expression.length - 1; i >= 0; i--) {
            String token = expression[i];

            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand1, operand2;
                try {
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                } catch (Exception e) {
                    throw new IllegalArgumentException("Expresión inválida");
                }

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        if (operand1 == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        stack.push(operand2 / operand1); // Cambio de orden para mantener el orden correcto
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no reconocido: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión inválida");
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] expression = {"+", "3", "*", "4", "2"}; // + 3 * 4 2

        try {
            int result = calculatePrefix(expression);
            System.out.println("Resultado de la calculadora prefix: " + result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
