package Fase2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String fileContent = fileManager.readFile("expresiones.txt");
        SetQ setq = null;
        String variableName = null;
        int value = 0;

        String[] lines = fileContent.split("\\r?\\n"); // Dividir el contenido en líneas
        
        for (String line : lines) {
            String[] tokens = line.split("\\s+");
            if (tokens.length > 0) {
                String command = tokens[0];
                switch (command) {
                    case "SetQ":
                        if (tokens.length == 3) {
                            variableName = tokens[1];
                            value = Integer.parseInt(tokens[2]);
                            setq = new SetQ(variableName, value);
                        } else {
                            System.out.println("Error: Comando SetQ malformado");
                        }
                        break;
                    case "Execute":
                        if (tokens.length == 2 && setq != null) {
                            String input = tokens[1];
                            String result = setq.execute(input);
                            System.out.println(result);
                        } else {
                            System.out.println("Error: Comando Execute malformado o variable no definida");
                        }
                        break;
                    default:
                        // Si el comando no es reconocido, se asume que es una instrucción para SetQ
                        if (setq != null) {
                            setq.addInstruction(line);
                        }
                        break;
                }
            }  
        }
    }
}
