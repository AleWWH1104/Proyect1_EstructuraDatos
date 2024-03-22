package Fase2;
import java.util.List;
public class FactoryEstructuras<T> {

    // Crea y devuelve una instancia de {InterfaceFactory} basada en la palabra reservada proporcionada.
    public Iestructuras<T> crearImplementacion(List<List<Object>> listFunctions) {
        if (listFunctions.isEmpty()) {
            throw new IllegalArgumentException("La expresion esta vacia.");
        }

        Object primerElemento = listFunctions.get(0).get(0);

        if (primerElemento instanceof String) {
            String tipo = (String) primerElemento;
            switch (tipo) {
                case "defun":
                    return new Defun<>();
                case "quote":
                    System.err.println("es quote");
                    return new Quote<>();
                case "cond":
                    return new Conditions<>();
                case "=":
                    Predicate<T> predicate = new Predicate<>();
                    return predicate.new EQUALS<T>(listFunctions.get(0));
                case "+":
                    return new Calculator<>();
                //case "atom":
                    //return new Atom<>();
                default:
                    throw new IllegalArgumentException("Implementacion desconocida: " + tipo);

            }
        }else {
            throw new IllegalArgumentException("No es string.");
        }
    }
}
