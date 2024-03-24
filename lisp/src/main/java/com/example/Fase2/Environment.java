package com.example.Fase2;

import java.util.HashMap;
import java.util.Map;

public class Environment implements Cloneable {
    private Map<String, Defun<?>> functionMap = new HashMap<>();
    private Map<String, Object> variableMap = new HashMap<>();

    public Map<String, Defun<?>> getFunctionMap() {
        return functionMap;
    }

    public Map<String, Object> getVariableMap() {
        return variableMap;
    }

    public void addFunction(String name, Defun<?> defun) {
        functionMap.put(name, defun);
    }

    public Defun<?> getFunction(String name) {
        return functionMap.get(name);
    }

    public void setVariable(String name, Object value) {
        variableMap.put(name, value);
    }

    public Object getVariable(String name) {
        return variableMap.get(name);
    }

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
