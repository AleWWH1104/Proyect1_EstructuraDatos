package com.example.Fase2;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa el entorno de evaluación para el intérprete Lisp.
 */
public class Environment implements Cloneable {
    private Map<String, Defun<?>> functionMap = new HashMap<>();
    private Map<String, Object> variableMap = new HashMap<>();

    //Método para obtener el mapa de funciones del entorno.
    public Map<String, Defun<?>> getFunctionMap() {
        return functionMap;
    }

    //Método para obtener el mapa de variables del entorno.
    public Map<String, Object> getVariableMap() {
        return variableMap;
    }

    //Método para agregar una función al mapa de funciones del entorno.
    public void addFunction(String name, Defun<?> defun) {
        functionMap.put(name, defun);
    }

    //Método para obtener una función del mapa de funciones del entorno
    public Defun<?> getFunction(String name) {
        return functionMap.get(name);
    }

    //Método para establecer una variable en el entorno.
    public void setVariable(String name, Object value) {
        variableMap.put(name, value);
    }

    //Método para obtener el valor de una variable del entorno.
    public Object getVariable(String name) {
        return variableMap.get(name);
    }

    //Método para clonar el entorno.
    @Override
    public Environment clone() {
        try {
            Environment clonedEnv = (Environment) super.clone();
            // Clonar functionMap
            clonedEnv.functionMap = new HashMap<>(this.functionMap);
            // Clonar variableMap
            clonedEnv.variableMap = new HashMap<>(this.variableMap);
            return clonedEnv;
        } catch (CloneNotSupportedException e) {
            // Manejar la excepción de clonación no soportada
            return null;
        }
    }
}
