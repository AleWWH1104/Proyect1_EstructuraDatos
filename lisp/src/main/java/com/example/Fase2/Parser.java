package lisp.src.main.java.com.example.Fase2;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    public List<Object> parse(String input) {
        List<Object> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, " ()", true);
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                if (token.equals("(")) {
                    // No agregues una lista al parsear una lista, simplemente continúa con el proceso
                    parseList(tokenizer, tokens);
                } else {
                    tokens.add(token);
                }
            }
        }
        
        return tokens;
    }
    
    private void parseList(StringTokenizer tokenizer, List<Object> list) {
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                if (token.equals("(")) {
                    // Al encontrar una nueva lista, inicia el proceso de parseo recursivamente
                    List<Object> sublist = new ArrayList<>();
                    parseList(tokenizer, sublist);
                    list.add(sublist);  // Agrega la sublist directamente a la lista principal
                } else if (token.equals(")")) {
                    break;
                } else {
                    list.add(token);
                }
            }
        }
    }   
}
