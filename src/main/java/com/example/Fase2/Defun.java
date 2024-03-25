package com.example.Fase2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase representa la definición de una función en un entorno específico.
 * Implementa la interfaz Iestructuras y es clonable.
 *
 * @param <T> Tipo genérico para la definición de funciones.
 */
public class Defun<T> implements Iestructuras<T>, Cloneable {

    /** Entorno local para la función. */
    public Environment localEnvironment;

    /** Nombre de la función. */
    public String name;

    /** Instrucciones que componen la función. */
    public List<Object> instructions;

    /** Parámetros de la función. */
    public Map<String, Object> params = new HashMap<>();

    /** Resultado de la función. */
    public Object result;

    /**
     * Constructor por defecto de la clase Defun.
     */
    public Defun() {
    }

    /**
     * Método para establecer funciones en el entorno local.
     *
     * @param name    Nombre de la función.
     * @param funcion Definición de la función.
     */
    public void setFuncios(String name, Defun<?> funcion) {
        localEnvironment.addFunction(name, funcion);
    }

    /**
     * Método para establecer los atributos de la función.
     *
     * @param instructions Instrucciones que componen la función.
     */
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

    /**
     * Método para establecer los parámetros de la función.
     *
     * @param valueParams Parámetros de la función.
     * @param environment Entorno de ejecución.
     */
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

    /**
     * Método para verificar si un objeto es una lista.
     *
     * @param object Objeto a verificar.
     * @return Lista si el objeto es una lista, de lo contrario, una lista que
     *         contiene el objeto.
     */
    private List<Object> isList(Object object) {
        if (object instanceof List) {
            return (List<Object>) object;
        } else {
            List<Object> list = new ArrayList<>();
            list.add(object);
            return list;
        }
    }

    /**
     * Método para ejecutar las instrucciones de la función.
     *
     * @param tokens      Tokens de la función.
     * @param environment Entorno de ejecución.
     * @return Resultado de la ejecución de las instrucciones de la función.
     */
    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        tokens.remove(0);
        Map<String, Object> variables = localEnvironment.getVariableMap();
        variables.putAll(environment.getVariableMap());
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

    /**
     * Método para clonar la definición de la función.
     *
     * @return Clon de la definición de la función.
     */
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
