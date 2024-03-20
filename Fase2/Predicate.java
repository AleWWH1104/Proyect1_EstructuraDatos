package Fase2;
import java.util.ArrayList;
import java.util.List;

public class Predicate<T> {

    @SuppressWarnings("hiding")
    public class Listas<T> implements Iestructuras<T>{
        @Override
        public void execute(String expresion) {
            List<T> list = listConversion(expresion);
            System.out.println(list);    
        }

        public List<T> listConversion(String expresion) {
            String[] tokens = expresion.substring(0, expresion.length() - 1).split("\\s+");
            List<T> result = new ArrayList<>();
    
            for (int i = 1; i < tokens.length; i++) {
                try {
                    @SuppressWarnings("unchecked")
                    T value = (T) tokens[i];
                    result.add(value);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            return result;
        }
    }

    @SuppressWarnings("hiding")
    public class Atom<T> implements Iestructuras<T>{
        @Override
        public void execute(String expresion) {
        
        }
    }

    @SuppressWarnings("hiding")
    public class EQUALS<T> implements Iestructuras<T>{
        @Override
        public void execute(String expresion) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }
    }

    @SuppressWarnings("hiding")
    public class Comparator<T> implements Iestructuras<T>{
        @Override
        public void execute(String expresion) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'execute'");
        }
    }

    
    
    
}
