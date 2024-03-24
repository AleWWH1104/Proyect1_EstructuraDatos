package com.example.Fase2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase LispInterpreter que contiene el método main para ejecutar el intérprete
 * de Lisp.
 */
public class LispInterpreter {
    public static void main(String[] args) {
        // Crear un objeto FileManager para leer la expresión desde un archivo
        FileManager fileManager = new FileManager();
        String filePath = "/Users/alejandraayala/Desktop/EstructuraDatos/LISP/Proyect1_EstructuraDatos/lisp/src/main/java/com/example/Fase2/prueba.txt";
        String expresion = fileManager.leerExpresion(filePath);
        // Crear un objeto Parser para parsear la expresión en tokens
        Parser parsear = new Parser();
        List<Object> tokens = parsear.parse(expresion);
        System.out.println(tokens);
        // Lista para almacenar los resultados de evaluar las expresiones
        List<String> results = new ArrayList<>();
        Evaluador evaluador = new Evaluador(new Environment());
        // Iterar sobre cada lista de tokens y evaluarlas utilizando el Evaluador
        for (Object lista : tokens) {
            Object result = evaluador.evaluarExpresion((List<Object>) lista);
            if (result.toString() != "") {
                results.add(result.toString());
            }
        }
        // Imprimir los resultados
        for (String r : results) {
            System.out.println(r);
        }
    }
}
