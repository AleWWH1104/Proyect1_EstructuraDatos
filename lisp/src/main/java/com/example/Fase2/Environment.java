package com.example.Fase2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Environment {
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

    public Set<String> getAllFunctionNames() {
        return functionMap.keySet();
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
}