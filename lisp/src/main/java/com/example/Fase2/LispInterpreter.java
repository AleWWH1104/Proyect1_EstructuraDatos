package com.example.Fase2;

import java.util.ArrayList;
import java.util.List;

public class LispInterpreter {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String filePath = "src\\main\\java\\com\\example\\Fase2\\prueba.txt";
        String expresion = fileManager.leerExpresion(filePath);
        Parser parsear = new Parser();
        List<Object> tokens = parsear.parse(expresion);
        System.out.println(tokens);
        List<String> results = new ArrayList<>();
        Evaluador evaluador = new Evaluador(new Environment());
        for (Object lista : tokens) {
            Object result = evaluador.evaluarExpresion((List<Object>) lista);
            if (result.toString() != "") {
                results.add(result.toString());
            }
        }
        for (String r : results) {
            System.out.println(r);
        }
    }
}
