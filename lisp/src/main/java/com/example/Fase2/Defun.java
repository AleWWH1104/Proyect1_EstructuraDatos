package com.example.Fase2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Defun<T> implements Iestructuras<T>, Cloneable {
    public Environment localEnvironment;
    public String name;
    public List<Object> instructions;
    public Map<String, Object> params = new HashMap<>();
    public Object result;

    public Defun() {
    }

    public void setFuncios(String name, Defun<?> funcion) {
        localEnvironment.addFunction(name, funcion);
    }

    public void setAttributes(List<Object> instructions) {
        localEnvironment = new Environment();
        this.name = instructions.get(1).toString();
        List<String> params = (List<String>) instructions.get(2);
        if (params.size() > 0) {
            for (String param : params) {
                this.params.put(param, null);
            }
        }
        instructions.remove(0);
        instructions.remove(0);
        instructions.remove(0);
        this.instructions = instructions;
    }

    public void setParams(List<Object> valueParams, Environment environment) {
        Set<String> keys = params.keySet();
        List<String> keyList = new ArrayList<>(keys);
        for (int index = 0; index < valueParams.size(); index++) {
            String key = keyList.get(index);
            List<Object> p = isList(valueParams.get(index));
            Evaluador evaluator = new Evaluador(localEnvironment);
            Object value = evaluator.evaluarExpresion(p);
            params.put(key, value.toString());
        }
        Map<String, Object> variables = localEnvironment.getVariableMap();
        variables.putAll(params);

    }

    private List<Object> isList(Object object) {
        if (object instanceof List) {
            return (List<Object>) object;
        } else {
            List<Object> list = new ArrayList<>();
            list.add(object);
            return list;
        }
    }

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        tokens.remove(0);
        setParams(tokens, environment);
        List<Object> results = new ArrayList<>();
        Evaluador evaluator = new Evaluador(localEnvironment);
        for (Object instruction : instructions) {
            if (instructions.size() != 0) {
                result = evaluator.evaluarExpresion((List<Object>) instruction);
                if (result != "") {
                    results.add(result);
                }
            } else {
                results.add("");
            }
        }
        StringBuilder resultsStrings = new StringBuilder();
        for (int i = 0; i < results.size(); i++) {
            resultsStrings.append(results.get(i).toString());
            if (i != results.size() - 1) { // Si no es el último elemento
                resultsStrings.append("\n");
            }
        }
        return resultsStrings.toString();

    }

    @Override
    public Defun<T> clone() {
        try {
            Defun<T> clonedDefun = (Defun<T>) super.clone();
            clonedDefun.localEnvironment = this.localEnvironment.clone(); // Clonar el entorno
            clonedDefun.instructions = new ArrayList<>(this.instructions);
            clonedDefun.params = new HashMap<>(this.params);
            return clonedDefun;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
