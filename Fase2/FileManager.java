package Fase2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
<<<<<<< HEAD
    
    public String readFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Agregar la línea al contenido
                content.append(line.trim()).append("\n"); // Trim para eliminar espacios en blanco al inicio y al final
=======
    public String leerExpresion(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
>>>>>>> main
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD

        return content.toString();
=======
        return stringBuilder.toString().trim();
>>>>>>> main
    }
}
