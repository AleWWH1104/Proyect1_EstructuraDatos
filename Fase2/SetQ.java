package Fase2;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class SetQ {
    private String variableName;
    private Object value;
    private List<String> instructions;
=======
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetQ<T> implements Iestructuras<T>{
>>>>>>> main

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

    @Override
    public Object execute(List<Object> tokens, Environment environment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
}
