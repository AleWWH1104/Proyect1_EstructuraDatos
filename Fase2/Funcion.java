package Fase2;

import java.util.List;
import java.util.Map;

public class Funcion {
    private List<String> arguments;
    private String instruction;

    public Funcion(List<String> arguments, String instruction) {
        this.arguments = arguments;
        this.instruction = instruction;
    }

    public List<String> getArguments() {
        return this.arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String execute(Map<String, Integer> argumentsHash) {
        for (Map.Entry<String, Integer> entry : argumentsHash.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            int index = arguments.indexOf(key);
            instruction = instruction.replace(key, String.valueOf(value));
            arguments.set(index, String.valueOf(value));
        }
        return instruction;
    }

}