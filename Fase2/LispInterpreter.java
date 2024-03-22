package Fase2;
import java.util.List;
public class LispInterpreter {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String filePath = "/Users/alejandraayala/Desktop/EstructuraDatos/LISP/Proyect1_EstructuraDatos/Fase2/prueba.txt"; // Reemplaza "ruta/del/archivo.txt" por la ubicación real de tu archivo
        String expresion = fileManager.leerExpresion(filePath);
        Parser parsear = new Parser();
        List<Object> tokens = parsear.parse(expresion);
        System.out.println(tokens);
        FactoryEstructuras factory = new FactoryEstructuras<>();    
        Iestructuras implementacion = factory.crearImplementacion(tokens);
        Environment environment = new Environment();
        Object resultado = implementacion.execute(environment);
        System.err.println("Resultado: " + resultado);

    }
}
