package com.example.Fase2;
import java.util.List;

public class Atom<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        // Verificar que la lista de tokens tenga al menos un elemento
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("No hay Atom/ estructura vacia");
        }
        
        // Obtener el primer elemento de la lista de tokens
        Object atom = tokens.get(0);
        
        // Devolver el átomo sin evaluar
        return atom;    
    }
    
}
