package practicas.maquinaSnackArchivos.servicio;

import practicas.maquinaSnackArchivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements IservicioSnacks {

    private final String nombreArchivo = "src/archivos/snack/snacks.txt";
    private List<Snack> listaSnacks = new ArrayList<>();

    public ServicioSnacksArchivos() {
        File archivo = new File(nombreArchivo);
        boolean exist = false;

        try {

            exist = archivo.exists();
            if (exist) {
                this.listaSnacks = obtenerSnacks();
            } else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Archivo Creado");
            }

        } catch (Exception e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }

        if (!exist) {
            cargarSnackIniciales();
        }
    }

    private void cargarSnackIniciales() {
        this.agregarSnack(new Snack("Papas", 3500));
        this.agregarSnack(new Snack("Gaseosa", 2500));
        this.agregarSnack(new Snack("Galletas", 1500));
    }

    private List<Snack> obtenerSnacks() {

        List<Snack> snacks = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));

            for(String line : lineas) {

                String[] lineasSnack = line.split(",");
                //String IdSnack = lineasSnack[0];
                String nombre = lineasSnack[1];
                double precio = Double.parseDouble(lineasSnack[2]);

                Snack newSnack = new Snack(nombre, precio);
                snacks.add(newSnack);
            }
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            e.printStackTrace();
        }

        return snacks;
    }

    private void agregarSnackArchivo(Snack snack) {
        boolean anexar = false;
        File archivo = new File(nombreArchivo);

        try {
            anexar = archivo.exists();
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack());
            salida.close();

        } catch (Exception e) {
            System.out.println("Error al agregar el snack: " + e.getMessage());
        }
    }

    @Override
    public void agregarSnack(Snack snack) {
        //1. Agregar el Snack a la lista en memoria
        this.listaSnacks.add(snack);
        //2. Agregar Snack en el archivo
        this.agregarSnackArchivo(snack);
    }

    @Override
    public void mostrarSnack() {
        System.out.println(" --- Snacks en el Inventario --- ");
        String inventario = "";
        for(Snack snack : this.listaSnacks) {
            inventario += snack.toString() + "\n";
        }
        System.out.println(inventario);
    }

    @Override
    public List<Snack> getSnackList() {
        return this.listaSnacks;
    }
}
