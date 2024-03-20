import java.util.Stack;

public class Defun {
    private String functionName;
    private String[] parameters;
    private Stack<String> instructions;

    public Defun(String functionName, String[] parameters) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.instructions = new Stack<>();
    }

    public void addInstruction(String instruction) {
        instructions.push(instruction);
    }

    public void execute() {
        System.out.println("Executing function: " + functionName);
        System.out.println("Parameters:");
        for (String param : parameters) {
            System.out.println(param);
        }
        System.out.println("Instructions:");
        while (!instructions.isEmpty()) {
            String instruction = instructions.pop();
            System.out.println(instruction);

        }
        System.out.println("Function execution finished.");
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Defun defun = new Defun("myFunction", new String[] { "param1", "param2" });
        defun.addInstruction("(+ param1 param2)");
        defun.addInstruction("(println \"Hello, world!\")");
        defun.execute();
    }
}
