package com.example.Fase2;

/**
 * Clase FactoryEstructuras que crea instancias de implementaciones de la interfaz Iestructuras
 * basándose en la palabra reservada proporcionada.
 *
 * @param <T> Tipo genérico que extiende Number y representa el tipo de dato de las implementaciones de Iestructuras.
 */
public class FactoryEstructuras<T extends Number> {

    public Iestructuras<T> crearImplementacion(Object tipo) {
        if (tipo instanceof String) {
            String tokenStr = (String) tipo;
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
}
