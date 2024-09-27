package practicas.maquinaSnackArchivos.presentacion;

import practicas.maquinaSnackArchivos.dominio.Snack;
import practicas.maquinaSnackArchivos.servicio.IservicioSnacks;
import practicas.maquinaSnackArchivos.servicio.ServicioSnacksArchivos;
import practicas.maquinaSnackArchivos.servicio.ServicioSnacksLista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {

    public static void main(String[] args) {

        maquinaSnacks();
    }

    private static void maquinaSnacks() {

        boolean salir = false;
        Scanner consola = new Scanner(System.in);

        //Instancia de la Clase que implemente IServicioSnacks

        //IservicioSnacks servicioSnacks = new ServicioSnacksLista();
        IservicioSnacks servicioSnacks = new ServicioSnacksArchivos();

        //Listado de productos
        List<Snack> productos = new ArrayList<>();
        System.out.println("\n *** Maquina de Snacks ***");
        servicioSnacks.mostrarSnack();

        while (!salir) {
            try {

                int opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos, servicioSnacks);

            } catch (Exception e) {
                System.err.println("Error capturado + " + e.getMessage());

            } finally {
                System.out.println();
            }
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                Menu:
                1. Comprar Snack
                2. Mostrar Ticket
                3. Agregar Nuevo Snack
                4. Inventario de Snack
                5. Salir
                \nElige una opcion: \s""");
        // Leemos y retornamos la opcion seleccionada
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos, IservicioSnacks servicioSnacks) {

        boolean salir = false;

        switch (opcion) {
            case 1 -> comprarSnack(consola, productos, servicioSnacks);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola, servicioSnacks);
            case 4 -> inventarioSnacks(consola, servicioSnacks);
            case 5 -> {
                System.out.println("\nHasta Pronto!!!");
                salir = true;
            }
            default -> {
                System.err.println("\nLa opcion ingresada no es valida: " + opcion + "\n");
            }
        }

        return salir;
    }

    private static void inventarioSnacks(Scanner consola, IservicioSnacks servicioSnacks) {
        servicioSnacks.mostrarSnack();
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos, IservicioSnacks servicioSnacks) {

        System.out.print("\nIndica el id del Snack a comprar: ");
        int idSnack = Integer.parseInt(consola.nextLine());

        //Validar que el id del snack exista
        boolean snackEncontrado = false;
        for (Snack snack : servicioSnacks.getSnackList()) {
            if (idSnack == snack.getIdSnack()) {
                //Se agrega el snack encontrado a la lista de productos
                productos.add(snack);
                System.out.println("Snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if (!snackEncontrado) {
            System.out.println("Id Snack no encontrado: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos) {

        String ticket = "\n*** Ticket de Venta ***";
        double total = 0.0;

        for (Snack producto : productos) {
            ticket += "\n\t -> " + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }

        ticket += "\n\t -> total $" + total;
        System.out.println(ticket);

    }

    private static void agregarSnack(Scanner consola, IservicioSnacks servicioSnacks) {

        System.out.print("\nIngrese el nombre del nuevo Snack: ");
        String nombre = consola.nextLine();
        System.out.print("Ingrese el precio del nuevo Snack: ");
        double precio = Double.parseDouble(consola.nextLine());

        servicioSnacks.agregarSnack(new Snack(nombre, precio));

        System.out.println("Snack creado!\n");
        servicioSnacks.mostrarSnack();
    }
}
