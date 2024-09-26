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
        int totalLineas = 0;
        String palabraMasRepetida = null;
        int maxRepeticiones = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("Documentos/frases.txt"));

            while ((linea = br.readLine()) != null) {
                totalLineas++;

                String[] palabras = linea.split("\\s+");

                for (String palabra : palabras) {
                    palabra = palabra.toLowerCase();
                    palabraConteo.put(palabra, palabraConteo.getOrDefault(palabra, 0) + 1);

                    // Actualiza la palabra más repetida
                    if (palabraConteo.get(palabra) > maxRepeticiones) {
                        maxRepeticiones = palabraConteo.get(palabra);
                        palabraMasRepetida = palabra;
                    }
                }

                totalPalabras += palabras.length;
            }
            br.close();

            System.out.println("Total de líneas en el archivo: " + totalLineas);
            System.out.println("Total de palabras en todas las líneas: " + totalPalabras);

            System.out.println("Frecuencia de palabras en el archivo:");
            for (Map.Entry<String, Integer> entry : palabraConteo.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            
            System.out.println("La palabra que más se repite es: '" + palabraMasRepetida + "' con " + maxRepeticiones + " repeticiones.");

        } catch (IOException e) {
            System.out.println("Fichero no encontrado: " + e.getMessage());
        }
    }
}






