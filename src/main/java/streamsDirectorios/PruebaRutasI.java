package streamsDirectorios;

import java.io.File;

public class PruebaRutasI {

    public static void main(String[] args) {

        /*
         * File.separator: Garantiza la compatibilidad del separador de ruta en los distintos
         * sistemas operativos
         */

        String ruta1 = "src" + File.separator + "archivos" + File.separator + "streamsDirectorios" + File.separator + "archivoPrueba.txt";
        String ruta2 = "archivoPrueba.txt";

        File rutaArchivo = new File(ruta1);

        System.out.println("Ruta del archivo: " + rutaArchivo.getAbsolutePath());

        if (rutaArchivo.exists()) {
            System.out.println("El archivo Existe");
        } else {
            System.out.println("El archivo no Existe");
        }

        System.out.println("------------------------------------------------");

        String ruta3 = "src" + File.separator + "archivos";
        File rutaArchivos = new File(ruta3);
        String[] archivos = rutaArchivos.list();

        for (String archivo : archivos) {

            File rutasInternas = new File(ruta3, archivo);

            if (rutasInternas.isDirectory()) {

                String[] archivosInternos = rutasInternas.list();
                System.out.println("Archivos internos de " + archivo);

                for (String aInterno : archivosInternos) {
                    System.out.println(" -> " + aInterno);
                }

                System.out.println();

            } else {
                System.out.println(archivo);
            }
        }
    }
}
