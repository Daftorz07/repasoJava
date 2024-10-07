package streamsIntroduccion.buffersCaracteres;

import java.io.*;

public class EscribirFichero {

    public void escribir(String nombreArchivo) {

        try (FileReader archivoLeer = new FileReader("src/archivos/buffers/poo.txt");
             BufferedReader reader = new BufferedReader(archivoLeer);

             FileWriter archivoEscribir = new FileWriter("src/archivos/buffers/" + nombreArchivo);
             BufferedWriter write = new BufferedWriter(archivoEscribir)) {

            String linea = "";

            System.out.println("Desde la clase " + getClass().getName() + "\n");
            while ((linea = reader.readLine()) != null) {
                write.write(linea);
                write.newLine();
                System.out.println(linea);
            }

            System.out.println("\n Escritura en archivo completada.");

        } catch (IOException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
