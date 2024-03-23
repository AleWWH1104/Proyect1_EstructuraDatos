package Fase2;
import java.util.List;

public class Predicate<T> {
    public List<Object> expresion;

    public class EQUALS<T> implements Iestructuras<T>{
        
        @Override
        public Object execute(List<Object> expresion, Environment environment) {
            if (expresion.size() != 3) {
                throw new IllegalArgumentException("Para EQUAL solo se compara con 2 operandos, verifique cantidad de elementos.");
            }

            Object valor1 = expresion.get(1);
            Object valor2 = expresion.get(2);

            if (valor1 == null || valor2 == null) {
                return false;
            }

            if (valor1 instanceof List && valor2 instanceof List) {
                List<Object> lista1 = (List<Object>) valor1;
                List<Object> lista2 = (List<Object>) valor2;
                return lista1.equals(lista2);
            }else{
                // Al menos una de las subexpresiones no es lista, utilizar FactoryEstructuras
                Evaluador evaluador = new Evaluador(environment);
                Object resultado1 = evaluador.evaluarExpresion((List<Object>) valor1);
                Object resultado2 = evaluador.evaluarExpresion((List<Object>) valor2);
                return resultado1.equals(resultado2);
            }
        }
    }

    public class ATOM<T> implements Iestructuras<T>{
        private T value;

        public ATOM(T value) {
            this.value = value;
        }

        @Override
        public Object execute(List<Object> expresion, Environment environment) {
            return value;
        }

    }

}
