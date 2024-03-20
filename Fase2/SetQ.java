package Fase2;

import java.util.ArrayList;
import java.util.List;

public class SetQ {
    private String variableName;
    private Object value;
    private List<String> instructions;

    public SetQ(String variableName, Object value) {
        this.variableName = variableName;
        this.value = value;
        this.instructions = new ArrayList<>();
    }

    public String getVariableName() {
        return variableName;
    }

    public Object getValue() {
        return value;
    }

    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }

    public String execute(String input) {
   
        return "Instrucciones ejecutadas para la variable '" + variableName + "'";
    }
}
