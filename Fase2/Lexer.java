package Fase2;
import java.util.Stack;

public class Lexer<T> {
    Stack<String> stack = new Stack<>();
    FactoryEstructuras<T> stackFactory = new FactoryEstructuras<>();

    public void lexer(String expresion){
        String[] signos = {"+", "-", "*", "/"};
        String comparatorSignos = "^\\(\\s*(<|>)\\s+\\S+\\s+\\S+\\s*\\)$";
        boolean hasOperator = false;

        for (String opS : signos) {
            if (expresion.startsWith("(" + opS)) {
                hasOperator = true;
                break;
            }
        }
        if (hasOperator) {
            Iestructuras<T> stackI = stackFactory.createStack("calculadora");
            stackI.execute(expresion);
            return;
        }
    
        // Verifica si la expresión con signos comparator
        if (expresion.matches(comparatorSignos)) {
            Iestructuras<T> stackI = stackFactory.createStack("comparator");
            stackI.execute(expresion);
            return;
        }
    }


}
