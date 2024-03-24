package com.example.Fase2;

import java.util.List;

public class SetQ<T> implements Iestructuras<T> {

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        if (tokens.size() != 3) {
            throw new IllegalArgumentException("SetQ incompleto.");
        }

        Object variableNameToken = tokens.get(1);
        Object valueToken = tokens.get(2);

        if (!(variableNameToken instanceof String)) {
            throw new IllegalArgumentException("Variable name should be a string.");
        }

        // Evaluate the value token recursively if it's a list
        Evaluador evaluador = new Evaluador(environment);
        if (valueToken instanceof List) {
            valueToken = evaluador.evaluarExpresion((List<Object>) valueToken);
        }
        //set la variable en el environment
        setVariable((String) variableNameToken, valueToken, environment);

        return valueToken; 
     }
 
    private void setVariable(String variableName, Object value, Environment environment) {
         environment.setVariable(variableName, value);
    }


}
