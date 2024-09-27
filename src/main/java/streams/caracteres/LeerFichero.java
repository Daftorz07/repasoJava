package streams.caracteres;

import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

    public String leer(String nombreArchivo) {

        /*
        * FileReader: Exception => FileNotFoundException
        * read: IOException
        */

        try {
            FileReader archivo = new FileReader("src/archivos/" + nombreArchivo);
            int caracter = archivo.read();

            StringBuilder frase = new StringBuilder();

            while (caracter != -1) {

                caracter = archivo.read();
                char letra = (char) caracter;
                System.out.print(letra);

                frase.append((char) letra);
            }
            archivo.close();
            return frase.toString();

        } catch (IOException e) {

            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }
}