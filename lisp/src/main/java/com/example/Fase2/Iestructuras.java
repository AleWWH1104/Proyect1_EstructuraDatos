package com.example.Fase2;
import java.util.List;

/**
 * Interfaz que define la estructura de las operaciones en el intérprete Lisp.
 *
 * @param <T> Tipo genérico (no utilizado en esta interfaz).
 */
public interface Iestructuras<T>  {
    //Método para ejecutar una operación en el intérprete Lisp.
    public Object execute(List<Object> tokens, Environment environment);
}
