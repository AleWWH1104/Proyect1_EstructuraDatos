package Fase2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    
    public List<String> readInstructionsFromFile(String filePath) {
        List<String> instructions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Agregar la línea a la lista de instrucciones
                instructions.add(line.trim()); // Trim para eliminar espacios en blanco al inicio y al final
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return instructions;
    }

}
