package Fase2;

import java.util.List;

public class SetQ<T> implements Iestructuras<T> {
    private String variableName;
    private T value;

    public SetQ(String variableName, T value) {
        this.variableName = variableName;
        this.value = value;
    }

    public String getVariableName() {
        return variableName;
    }

    public T getValue() {
        return value;
    }

    @Override
    public T execute(List<Object> tokens, Environment environment) {
        // Verifica si se proporciona el nombre de la variable y un valor asociado
        if (tokens.size() != 2) {
            throw new IllegalArgumentException("El comando SETQ requiere un nombre de variable y un valor asociado.");
        }
        
        // Obtiene el nombre de la variable y el valor asociado de la lista de tokens
        String variableName = (String) tokens.get(0);
        T value = (T) tokens.get(1);
        
        // Almacena el valor asociado con el nombre de la variable en el entorno
        environment.setVariable(variableName, value);
        
        // Devuelve el valor asociado como confirmación de la ejecución del comando SETQ
        return value;
    }
}
