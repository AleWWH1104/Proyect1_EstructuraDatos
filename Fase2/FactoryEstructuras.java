package Fase2;

public class FactoryEstructuras<T> {

    // Crea y devuelve una instancia de {InterfaceFactory} basada en la palabra
    // reservada proporcionada.
    public Iestructuras<T> createStack(String expresion) {
        if (expresion.contains("(")) {
            int indexParenthesis = expresion.indexOf("(");
            String expressionAfterParenthesis = expresion.substring(indexParenthesis + 1);
            if (expressionAfterParenthesis.startsWith("+") || expressionAfterParenthesis.startsWith("-") ||
                    expressionAfterParenthesis.startsWith("*") || expressionAfterParenthesis.startsWith("/")) {
                System.err.println("es op");
                return new Calculator<>();
            }
        } else if (expresion.contains("(") && expresion.contains("defun")) {
            System.err.println("es defun");
            return new Defun<>();
        } else if (expresion.contains("(") && expresion.contains("quote")) {
            System.err.println("es quote");
            return new Quote<>();
        } else if (expresion.contains("(") && expresion.contains("cond")) {
            System.err.println("es cond");
            return new Conditions<>();
        } else if (expresion.startsWith("(")) {
            System.err.println("es lista");
            return new Predicate<>().new Listas<T>();
        } else {
            System.err.println("es atom");
            return new Predicate<>().new Atom<T>();
        }
        return null;
    }
}
