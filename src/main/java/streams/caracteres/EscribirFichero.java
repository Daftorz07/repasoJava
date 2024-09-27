package streams.caracteres;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {

    public void escribir(String frase) {

        //String frase = "Frase de prueba";

        try {
            FileWriter escribiendo = new FileWriter("src/archivos/streamsCaracteresEscritos.txt");

            for (int i = 0; i < frase.length(); i++) {
                escribiendo.write(frase.charAt(i));
            }

            escribiendo.close();

        } catch (IOException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
