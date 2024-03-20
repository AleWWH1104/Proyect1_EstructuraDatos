package Fase2;

/**
 * Interfaz que define las operaciones básicas de una pila (stack).
 *
 * @param <T> Tipo de elementos almacenados en la pila.
 * @author Jonathan Díaz
 * @author Anggie Quezada
 */
public interface UVGstack<T> {

    /**
     * Agrega un elemento a la pila.
     *
     * @param x Elemento a agregar.
     */
    void push(T x);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return Elemento en la cima de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     */
    T pop();

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     *
     * @return Elemento en la cima de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     */
    T top();

    /**
     * Verifica si la pila está vacía.
     *
     * @return True si la pila está vacía, false en caso contrario.
     */
    boolean isEmpty();
}
