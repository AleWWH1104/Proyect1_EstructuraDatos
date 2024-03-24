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
<<<<<<< HEAD
                case "setq":
                    return new SetQ<>();
=======
                case "atom":
                    return new Atom<>();
>>>>>>> main
                default:
                    return new Valor<>();
            }
        } else {
            throw new IllegalArgumentException("Invalid token type");
        }
    }
}
