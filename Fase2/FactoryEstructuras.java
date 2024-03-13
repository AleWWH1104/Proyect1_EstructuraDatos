package Fase2;



public class FactoryEstructuras<T> {
    
    //Construye una instancia de {Factory} inicializando las instancias de {SetQ} y {Defun}.
    public FactoryEstructuras(){
        
    }

    //Crea y devuelve una instancia de {InterfaceFactory} basada en la palabra reservada proporcionada.
    public Iestructuras<T> createStack(String implementacion) {
        switch (implementacion) {
            case "calculadora":
                return new Calculator<>();
            case "defun":
                return  new Defun<>();
            case "quote":
                return new Quote<>();
            case "setQ":
                return new Quote<>();
            case "list":
                return new Predicate<>().new Listas<T>();
            case "equal":
                return new Predicate<>().new EQUALS<T>();
            case "atom":
                return new Predicate<>().new Atom<T>();
            case "comparator":
                return new Predicate<>().new Ccomparator<T>();
            case "cond":
                return new Conditions<>();
            default:
                throw new IllegalArgumentException("Implementacion no válida/identificada: " + implementacion);
        }
    }
}
