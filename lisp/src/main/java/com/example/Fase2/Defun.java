package com.example.Fase2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Defun<T> implements Iestructuras<T>, Cloneable {
    public Environment localEnvironment;
    public String name;
    public List<Object> instructions;
    public Map<String, Object> params = new HashMap<>();
    public Object result;

    public Defun() {
    }

    public void setAtributes(List<Object> instructions) throws CloneNotSupportedException {
        localEnvironment = new Environment();
        instructions.remove(0);
        this.name = instructions.get(0).toString();
        List<Object> p = (List<Object>) instructions.get(1);
        if (p.size() > 0) {
            List<String> params = (List<String>) instructions.get(1);
            instructions.remove(1);
            instructions.remove(2);
            for (String param : params) {
                this.params.put(param, null);
            }
        }
        this.instructions = instructions;
    }

    public void setParams(List<Object> valueParams) {
        Set<String> claves = params.keySet();
        List<String> listaClaves = new ArrayList<>(claves);
        for (int index = 0; index < valueParams.size(); index++) {
            String key = listaClaves.get(index);
            List<Object> result = isList(valueParams.get(index));
            Object value = execute(result, localEnvironment);
            params.put(key, value);
        }
        Map<String, Object> variables = localEnvironment.getVariableMap();
        variables.putAll(params);
    }

    private List<Object> isList(Object object) {
        if (object instanceof List) {
            return (List<Object>) object;
        } else {
            List<Object> lista = new ArrayList<>();
            lista.add(object);
            return lista;
        }
    }

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        Evaluador evaluador = new Evaluador(environment);
        result = evaluador.evaluarExpresion(tokens);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Defun<T> clone = (Defun<T>) super.clone();
        clone.instructions = new ArrayList<>(this.instructions);
        clone.params = new HashMap<>(this.params);
        clone.localEnvironment = new Environment();
        for (Map.Entry<String, Object> entry : this.localEnvironment.getVariableMap().entrySet()) {
            clone.localEnvironment.setVariable(entry.getKey(), entry.getValue());
        }
        return clone;
    }
}
