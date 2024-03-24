package com.example.Fase2;

public class FactoryEstructuras<T extends Number> {

    // Crea y devuelve una instancia de {InterfaceFactory} basada en la palabra
    // reservada proporcionada.
    public Iestructuras<T> crearImplementacion(Object tipo, Environment environment) {
        if (tipo instanceof String) {
            String tokenStr = (String) tipo;
            if (environment.getFunctionMap().containsKey(tokenStr)) {
                return obtenerCopiaDesdeEnvironment(tokenStr, environment);
            }
            switch (tokenStr) {
                case "defun":
                    return new Defun<>();
                case "quote":
                case "'":
                    return new Quote<>();
                case "cond":
                    return new Conditions<>();
                case "equal":
                    return new EQUALS<>();
                case "+":
                case "-":
                case "*":
                case "/":
                    return new Calculator<>();
                case ">":
                case "<":
                case "<=":
                case ">=":
                    return new Comparador<>();
                case "atom":
                    return new Atom<>();
                case "setq":
                    return new SetQ<>();
                default:
                    return new Valor<>();
            }
        } else {
            throw new IllegalArgumentException("Invalid token type");
        }
    }

    // Método para obtener una copia del objeto desde el Environment si el token es
    // una función definida
    @SuppressWarnings("unchecked")
    private Iestructuras<T> obtenerCopiaDesdeEnvironment(String token, Environment environment) {
        Defun<?> function = environment.getFunctionMap().get(token);
        if (function != null) {
            Defun<?> fooCopy = function.clone();
            function.setFuncios(function.name, fooCopy);
            return (Iestructuras<T>) function;
        } else {
            // Si no se encuentra la función en el Environment, devolvemos null
        }
        return null;
    }
}
