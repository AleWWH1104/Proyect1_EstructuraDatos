package Fase2;

public class Quote<T> implements Iestructuras<T> {

    @Override
    public void execute(String expresion) {
        System.out.println("Procesando quote: " + expresion);
    }

    
    // public T execute(String expresion) {
    //      // Elimina los paréntesis y divide la expresión por espacios para obtener los elementos
    //      String[] elementos = expresion.replaceAll("[()]", "").split("\\s+");
        
    //      if (elementos.length > 0) {
    //          // Devuelve el primer elemento de la lista (en este caso, "a")
    //          return (T) elementos[0];
    //      } else {
    //          throw new IllegalArgumentException("Expresión vacía para la operación quote.");
    //      }
    // }
}