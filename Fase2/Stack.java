package Fase2;
import java.util.LinkedList;

/**
 * Implementación de una pila (stack) utilizando una lista enlazada.
 * Esta clase implementa la interfaz UVGStack.
 *
 * @param <T> Tipo de elementos almacenados en la pila.
 * @author Jonathan Díaz
 * @author Anggie Quezada
 */
public class Stack<T> implements UVGstack<T> {
    private LinkedList<T> stackList;

    /**
     * Constructor de la pila que utiliza una lista enlazada.
     */
    public Stack() {
        stackList = new LinkedList<>();
    }

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param x Elemento a agregar.
     */
    @Override
    public void push(T x) {
        stackList.addLast(x);
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return Elemento en la cima de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackList.removeLast();
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     *
     * @return Elemento en la cima de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     */
    @Override
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackList.getLast();
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return True si la pila está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
}
