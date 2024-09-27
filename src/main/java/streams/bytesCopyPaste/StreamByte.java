package streams.bytesCopyPaste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamByte {

    public static void main(String[] args) {

        int contadorByte = 0;
        int[] datosByteEntrada = new int[98176];

        try {
            //Referenciando la imagen a leer
            FileInputStream rutaImagen = new FileInputStream("src/archivos/copiaByte/motoUno.jpg");

            boolean archivoFinal = false;

            while (!archivoFinal) {
                int bytesRead = rutaImagen.read();

                //Validando que no sea el último byte del archivo
                if (bytesRead != -1) {
                    datosByteEntrada[contadorByte] = bytesRead;
                } else {
                    archivoFinal = true;
                }

                /*System.out.println(bytesRead);*/
                System.out.print(datosByteEntrada[contadorByte] + " ");
                contadorByte++;
            }
            System.out.println("Numero de Bytes: " + contadorByte);
            System.out.println("Tamaño del Array de Bytes " + datosByteEntrada.length);
            rutaImagen.close();

        } catch (FileNotFoundException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        crearArchivoByte(datosByteEntrada);
    }

    static void crearArchivoByte(int[] datosNuevoArchivo){

        try {
            FileOutputStream archivoSalida = new FileOutputStream("src/archivos/copiaByte/motoDos.jpg");

            for (int datoByte : datosNuevoArchivo) {
                archivoSalida.write(datoByte);
            }

            /*
            for (int i = 0; i < datosNuevoArchivo.length; i++) {
                archivoSalida.write(datosNuevoArchivo[i]);
            }
            * */

            System.out.println("Copia de datos realizada");
            archivoSalida.close();

        }  catch (IOException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            throw new RuntimeException(e);
        }


    }
}

