package streams.buffersCaracteres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

    public void leer(String nombreArchivo) {

        try {
            FileReader archivo = new FileReader("src/archivos/buffers/" + nombreArchivo);
            //Creando la memoria - Buffer
            BufferedReader buffer = new BufferedReader(archivo);

            String linea = "";
            while (linea != null) {

                linea = buffer.readLine();
                if (linea != null) System.out.println(linea + "\n");
            }
            archivo.close();

        } catch (IOException e) {

            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}