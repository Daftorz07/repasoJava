package directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PruebaRutasII {

    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);

        //Configuración de la ruta
        System.out.print("Ingresa el nombre de la ruta: ");
        String nuevaRuta = consola.nextLine();
        String rutaPrincipal = "src" + File.separator + "archivos" + File.separator + "directorios" + File.separator + nuevaRuta;

        //Instancia de la ruta + Creando la ruta
        File rutaDirectorio = new File(rutaPrincipal);
        rutaDirectorio.mkdir();
        System.out.println("Nueva ruta creada: " + rutaDirectorio.getAbsolutePath() + "\n");

        //Creando archivo
        System.out.print("Ingrese el nombre del archivo a crear: ");
        String nombreArchivoNuevo = consola.nextLine();
        String rutaDestino = rutaDirectorio.getAbsolutePath() + File.separator + nombreArchivoNuevo;

        File newDestino = new File(rutaDestino);

        try {
            newDestino.createNewFile();
            System.out.println("Archivo creado en la ruta: " + rutaDestino + "\n");

        } catch (IOException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            throw new RuntimeException(e);
        }

        //Escribir en el archivo creado
        EscribirArchivo escribiendo = new EscribirArchivo();

        System.out.print("Ingresa la fresa que quiere escribir en el archivo " + nombreArchivoNuevo + ": ");
        String fraseEscribir = consola.nextLine();

        escribiendo.escribir(rutaDestino, fraseEscribir);

        //Eliminar Archivo
        System.out.print("Ingresa nombre de la carpeta donde se encuentra el archivo a eliminar: ");
        String carpetaArchivo = consola.nextLine();

        System.out.print("Ingresa nombre del archivo a eliminar: ");
        String eliminarArchivo = consola.nextLine();

        EliminarArchivo eliminar = new EliminarArchivo();
        eliminar.eliminarArchivo(carpetaArchivo, eliminarArchivo);

    }
}

class EscribirArchivo {

    public void escribir(String rutaArchivo, String fraseEscribir) {

        try {
            FileWriter escribirArchivo = new FileWriter(rutaArchivo);

            for (int i = 0; i < fraseEscribir.length(); i++) {
                escribirArchivo.write(fraseEscribir.charAt(i));
            }
            escribirArchivo.close();
            System.out.println("Escritura realizada \n");

        } catch (IOException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            throw new RuntimeException(e);
        }
    }
}

class EliminarArchivo {

    public void eliminarArchivo(String rutaArchivo, String nombreArchivo) {

        String rutaArchivoEliminar = "src" + File.separator + "archivos" + File.separator + "directorios" + File.separator + rutaArchivo + File.separator + nombreArchivo;
        File archivoEliminar = new File(rutaArchivoEliminar);

        if (archivoEliminar.delete()){
            System.out.println("✅: Archivo Eliminado");
        }else{
            System.out.println("❌: No se pudo eliminar el archivo " + nombreArchivo);
        }
    }
}