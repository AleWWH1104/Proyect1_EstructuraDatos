package Fase2;
import java.util.ArrayList;
import java.util.List;

public class Operacionlogica {
    private String operador;
    private List<Object> expresiones;
    private List<Object> valores;

    public Operacionlogica(List<Object> expresiones) {
        this.operador = (String) expresiones.get(0);
        this.expresiones = expresiones.subList(1, expresiones.size());
        this.valores = new ArrayList<>();
        evaluar();
    }

    private void evaluar() {
        for (Object expresion : expresiones) {
            valores.add(obtenerValor(expresion));
        }
    }

    private Object obtenerValor(Object expresion) {
        if (expresion instanceof Boolean || expresion instanceof Integer || expresion instanceof Double) {
            return expresion;
        } else if (expresion instanceof Operacionlogica) {
            return ((Operacionlogica) expresion).execute();
        } else {
            throw new IllegalArgumentException("Expresión no válida: " + expresion);
        }
    }

    public boolean execute() {
        switch (operador.toUpperCase()) {
            case "AND":
                return valores.stream().allMatch(b -> obtenerBooleano(b));
            case "OR":
                return valores.stream().anyMatch(b -> obtenerBooleano(b));
            case "NOT":
                if (valores.size() != 1) {
                    throw new IllegalArgumentException("Operador NOT solo acepta una expresión.");
                }
                return !obtenerBooleano(valores.get(0));
            default:
                throw new IllegalArgumentException("Operador lógico no válido: " + operador);
        }
    }

    private boolean obtenerBooleano(Object valor) {
        if (valor instanceof Boolean) {
            return (boolean) valor;
        } else if (valor instanceof Integer) {
            return (int) valor != 0;
        } else if (valor instanceof Double) {
            return (double) valor != 0.0;
        } else {
            throw new IllegalArgumentException("Tipo de valor no válido: " + valor.getClass().getSimpleName());
        }
    }
}
