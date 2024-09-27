package practicas.maquinaSnack;

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

        //Listado de productos
        List<Snack> productos = new ArrayList<>();
        System.out.println("\n *** Maquina de Snacks ***");
        Snacks.mostrarSnack();

        while (!salir) {
            try {

                int opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos);

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
                4. Salir
                \nElige una opcion: \s""");
        // Leemos y retornamos la opcion seleccionada
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos) {

        boolean salir = false;

        switch (opcion) {
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("\nHasta Pronto!!!");
                salir = true;
            }default -> {
                System.err.println("\nLa opcion ingresada no es valida: " + opcion + "\n");
            }
        }

        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos) {

        System.out.print("\nIndica el id del Snack a comprar: ");
        int idSnack = Integer.parseInt(consola.nextLine());

        //Validar que el id del snack exista
        boolean snackEncontrado = false;
        for (Snack snack : Snacks.getSnackList()) {
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

    private static void agregarSnack(Scanner consola) {

        System.out.print("\nIngrese el nombre del nuevo Snack: ");
        String nombre = consola.nextLine();
        System.out.print("Ingrese el precio del nuevo Snack: ");
        double precio = Double.parseDouble(consola.nextLine());

        Snacks.agregarSnack(new Snack(nombre, precio));

        System.out.println("Snack creado!\n");
        Snacks.mostrarSnack();
    }
}
