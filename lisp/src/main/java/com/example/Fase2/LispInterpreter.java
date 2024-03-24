package com.example.Fase2;
import java.util.List;
public class LispInterpreter {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String filePath = "/Users/alejandraayala/Desktop/EstructuraDatos/LISP/Proyect1_EstructuraDatos/lisp/src/main/java/com/example/Fase2/prueba.txt"; // Reemplaza "ruta/del/archivo.txt" por la ubicación real de tu archivo
        String expresion = fileManager.leerExpresion(filePath);
        Parser parsear = new Parser();
        List<Object> tokens = parsear.parse(expresion);
        System.out.println(tokens);
        Evaluador evaluador = new Evaluador(new Environment());
        Object result = evaluador.evaluarExpresion(tokens);
        System.out.println("Resultado: " + result);
    }
}