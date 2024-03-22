package Fase2;
import java.util.List;

public class Predicate<T> {
    public List<Object> expresion;

    public class EQUALS<T> implements Iestructuras<T>{
        public EQUALS(List<Object> expresion) {
            Predicate.this.expresion = expresion;
        }
        @Override
        public Object execute(Environment environment) {
            if (expresion.size() != 3) {
                throw new IllegalArgumentException("Para EQUAL solo se compara con 2 operandos, verifique cantidad de elementos.");
            }

            Object valor1 = environment.getVariable(expresion.get(0).toString());
            Object valor2 = environment.getVariable(expresion.get(1).toString());

            if (valor1 == null || valor2 == null) {
                return false;
            }

            if (valor1 instanceof List && valor2 instanceof List) {
                List<Object> lista1 = (List<Object>) valor1;
                List<Object> lista2 = (List<Object>) valor2;
                return lista1.equals(lista2);
            }

            return valor1.equals(valor2);
        }
    }

}
