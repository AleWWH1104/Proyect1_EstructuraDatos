package Fase2;
public class FactoryEstructuras<T extends Number> {

    // Crea y devuelve una instancia de {InterfaceFactory} basada en la palabra reservada proporcionada.
    public Iestructuras<T> crearImplementacion(Object tipo) {
        if (tipo instanceof String) {
            String tokenStr = (String) tipo;
            switch (tokenStr) {
                case "defun":
                    return new Defun<>();
                case "quote":
                    return new Quote<>();
                case "cond":
                    return new Conditions<>();
                case "=":
                    return new EQUALS<>();
                case "+":
                case "-":
                case "*":
                case "/":
                    return new Calculator<>();
                default:
                    return null;   
            }
        }else {
            throw new IllegalArgumentException("Invalid token type");
        }
    }
}
    
