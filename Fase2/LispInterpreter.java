package Fase2;

import java.util.List;

public class LispInterpreter {
    
    public Object evaluarExpresionAritmetica(List<Object> expresion) {
        OperacionAritmetica operacion = new OperacionAritmetica(expresion);
        return operacion.evaluar();
    }

    public Object evaluarExpresion(List<Object> tokens, Environment environment) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Lista de tokens vacía");
        }

        Object firstToken = tokens.get(0);
        if (!(firstToken instanceof String)) {
            throw new IllegalArgumentException("El primer token debe ser una cadena de texto");
        }

        String command = (String) firstToken;
        switch (command) {
            case "SETQ":
                // Obtenemos el nombre de la variable y el valor asociado de la lista de tokens
                String variableName = (String) tokens.get(1);
                Object value = tokens.get(2);
                // Creamos una instancia de SetQ con el nombre de variable y el valor asociado
                return new SetQ<Object>(variableName, value).execute(tokens.subList(1, tokens.size()), environment);
            // Aquí puedes agregar casos para otros comandos Lisp que necesites evaluar
            default:
                throw new IllegalArgumentException("Comando Lisp no reconocido: " + command);
        }
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String filePath = "/Users/alejandraayala/Desktop/EstructuraDatos/LISP/Proyect1_EstructuraDatos/Fase2/prueba.txt"; // Reemplaza "ruta/del/archivo.txt" por la ubicación real de tu archivo
        String expresion = fileManager.leerExpresion(filePath);
        Parser parsear = new Parser();
        List<Object> tokens = parsear.parse(expresion);
        System.out.println(tokens);
        Evaluador evaluador = new Evaluador(new Environment());
        Object result = evaluador.evaluarExpresion(tokens);
        System.out.println("Resultado: " + result);
    }
}
