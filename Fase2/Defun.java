package Fase2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Defun<T> implements Iestructuras<T> {
    Environment environment = new Environment();
    String name;
    List<String> instructions;
    Map<String, Object> params;
    Object finalValue;

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public Object getFinalValue() {
        return finalValue;
    }

    public Defun(String name, List<String> params) {
        this.name = name;
        this.params = new HashMap<>();
        for (String param : params) {
            this.params.put(param, "none");
        }
    }

    public Defun() {
    }

    @Override
    public void execute(List<String> expression) {

    }

}
