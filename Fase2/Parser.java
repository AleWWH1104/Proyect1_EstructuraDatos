package Fase2;
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
                    tokens.add(parseList(tokenizer));
                } else {
                    tokens.add(token);
                }
            }
        }
        
        if (tokens.size() > 0 && tokens.get(0).equals("(")) {
            tokens.remove(0);
            tokens.remove(tokens.size() - 1);
        }
        
        return tokens;
    }
    
    private List<Object> parseList(StringTokenizer tokenizer) {
        List<Object> list = new ArrayList<>();
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                if (token.equals("(")) {
                    list.add(parseList(tokenizer));
                } else if (token.equals(")")) {
                    break;
                } else {
                    list.add(token);
                }
            }
        }
        return list;
    }   
}
