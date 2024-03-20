package Fase2;

public class FactoryEstructuras<T> {

    public FactoryEstructuras() {

    }

    public Iestructuras<T> createStack(String implementacion) {
        switch (implementacion) {
            case "calculadora":
                return new Calculator<>();
            case "defun":
                return new Defun<T>();
            case "quote":
                return new Quote<>();
            case "setQ":
                return new SetQ<>();
            case "list":
                return new Predicate<>().new Listas<T>();
            case "equal":
                return new Predicate<>().new EQUALS<T>();
            case "atom":
                return new Predicate<>().new Atom<T>();
            case "cond":
                return new Conditions<>();
            default:
                throw new IllegalArgumentException("Implementacion no válida/identificada: " + implementacion);
        }
    }
}
