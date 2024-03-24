package com.example.Fase2;

import java.util.List;

public class LispInterpreter {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String filePath = "src\\main\\java\\com\\example\\Fase2\\prueba.txt";
        String expresion = fileManager.leerExpresion(filePath);
        Parser parsear = new Parser();
        List<Object> tokens = parsear.parse(expresion);
        System.out.println(tokens);
        for (Object lista : tokens) {
            Evaluador evaluador = new Evaluador(new Environment());
            Object result = evaluador.evaluarExpresion((List<Object>) lista);
            System.out.println("Resultado: " + result);
        }
    }
}
