package com.example.Fase2;

/**
 * Clase FactoryEstructuras que crea instancias de implementaciones de la interfaz Iestructuras
 * basándose en la palabra reservada proporcionada.
 *
 * @param <T> Tipo genérico que extiende Number y representa el tipo de dato de las implementaciones de Iestructuras.
 */
public class FactoryEstructuras<T extends Number> {

    // Crea y devuelve una instancia de {InterfaceFactory} basada en la palabra
    // reservada proporcionada.
    public Iestructuras<T> crearImplementacion(Object tipo, Environment environment) {
        if (tipo instanceof String) {
            String tokenStr = (String) tipo;
            if (environment.getFunctionMap().containsKey(tokenStr)) {
                System.out.println("lol");
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
                case "=":
                case "/=":
                    return new Comparador<>();
                case "setq":
                    return new SetQ<>();
                case "list":
                    return new Listas<>();
                case "atom":
                    return new Atom<>();
                default:
                    return new Valor<>();
            }
        } else {
            throw new IllegalArgumentException("Token invalido");
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
            System.out.println(fooCopy);
            // return (Iestructuras<T>) function;
        } else {
            System.out.println("xd");
            // Si no se encuentra la función en el Environment, devolvemos null
        }
        return null;
    }
}
