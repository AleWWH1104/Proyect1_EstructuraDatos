package Fase2;

public class Defun<T> implements Iestructuras<T> {

    @Override
    public void execute(String expresion) {
        System.out.println("Definiendo función: " + expresion);
    }
    
}
