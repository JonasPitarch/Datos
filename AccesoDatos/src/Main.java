import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String linea;
        HashMap<String, Integer> palabraConteo = new HashMap<>();
        int totalPalabras = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("Documentos/frases.txt"));

            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+");

                for (String palabra : palabras) {
                    palabra = palabra.toLowerCase();
                    palabraConteo.put(palabra, palabraConteo.getOrDefault(palabra, 0) + 1);
                }

                totalPalabras += palabras.length;
            }
            br.close();

            System.out.println("Total de palabras en todas las líneas: " + totalPalabras);


            System.out.println("Frecuencia de palabras en el archivo:");
            for (Map.Entry<String, Integer> entry : palabraConteo.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Fichero no encontrado: " + e.getMessage());
        }
    }
}




