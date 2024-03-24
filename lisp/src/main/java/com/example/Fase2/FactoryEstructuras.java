package com.example.Fase2;

public class FactoryEstructuras<T extends Number> {

    // Crea y devuelve una instancia de {InterfaceFactory} basada en la palabra
    // reservada proporcionada.
    @SuppressWarnings("unchecked")
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
                //case "equal":
                case "=":
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
                case "setq":
                    return new SetQ<>();
                // case "list":
                //     return new Listas<>();
                default:
                    return new Valor<>();
                    //return new Valor<>();
            }
        } else {
            throw new IllegalArgumentException("Invalid token type");
        }
    }
}
