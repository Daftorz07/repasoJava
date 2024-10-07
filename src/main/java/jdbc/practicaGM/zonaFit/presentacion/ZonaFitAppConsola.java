package jdbc.practicaGM.zonaFit.presentacion;

import jdbc.practicaGM.zonaFit.datos.ClienteDAO;
import jdbc.practicaGM.zonaFit.datos.IClienteDAO;
import jdbc.practicaGM.zonaFit.dominio.Cliente;

import java.util.List;
import java.util.Scanner;

public class ZonaFitAppConsola {

    public static void main(String[] args) {
        zonaFitAppConsola();
    }

    private static void zonaFitAppConsola() {

        boolean salirApp = false;
        Scanner consola = new Scanner(System.in);
        IClienteDAO cliente = new ClienteDAO();

        while (!salirApp) {
            try {

                int opcion = mostrarMenu(consola);
                salirApp = ejecutarOpciones(consola, cliente, opcion);

            } catch (Exception e) {
                System.out.println("Error al intentar ejecutar la opción: " + e.getClass().getName());
                System.out.println("Motivo: " + e.getMessage());
                System.out.println("--------------------------------");
                throw new RuntimeException(e);
            }
            System.out.println("\n");
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                *** Zona Fit (GYM)
                1. Listar Clientes
                2. Buscar Clientes
                3. Agregar Clientes
                4. Actualizar Clientes
                5. Eliminar Clientes
                6. Salir App
                
                Elige una opcion: \s""");

        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola, IClienteDAO clienteDAO, int opcion) {

        boolean salirApp = false;

        switch (opcion) {
            case 1 -> {
                //Listar Clientes
                System.out.println("--- Listado de Clientes ---");
                List<Cliente> listaClientes = clienteDAO.listarCliente();
                listaClientes.forEach(System.out::println);
            }
            case 2 -> {
                //Buscar Cliente por ID
                System.out.print("Ingrese el ID del Cliente a buscar: ");

                int idCliente = Integer.parseInt(consola.nextLine());
                Cliente newCliente = new Cliente(idCliente);
                boolean findCliente = clienteDAO.buscarClienteID(newCliente);

                if (findCliente){
                    System.out.println("\nCliente encontrado: " + newCliente);
                }else {
                    System.out.println("\nCliente no encontrado: " + newCliente);
                }
            }
            case 3 -> {
                //Agregar Cliente
                System.out.println("--- Agregar Cliente ---");

                //Solicitando los datos del clienteDAO
                System.out.print("Ingrese el nombre de Cliente: ");
                String userNameCliente = consola.nextLine();

                System.out.print("Ingrese el apellido de Cliente: ");
                String lastNameCliente = consola.nextLine();

                System.out.print("Ingrese la membresía del Cliente: ");
                int membershipCliente = Integer.parseInt(consola.nextLine());

                //Objeto Cliente
                Cliente insertCliente = new Cliente(userNameCliente, lastNameCliente, membershipCliente);

                //Agregando el Cliente
                boolean agregado = clienteDAO.agregarCliente(insertCliente);

                if (agregado){
                    System.out.println("Cliente agregado: " + insertCliente);
                }else {
                    System.out.println("Cliente no agregado: " + insertCliente);
                }
            }
            case 4 ->{
                //Actualizar Clientes
                System.out.println("--- Actualizar Clientes ---");

                //Solicitando los datos del clienteDAO
                System.out.print("Ingrese el ID del cliente a actualizar: ");
                int userIdCliente = Integer.parseInt(consola.nextLine());

                //Solicitando los datos del clienteDAO
                System.out.print("Ingrese el nombre de Cliente actualizado: ");
                String userNameUpdate = consola.nextLine();

                System.out.print("Ingrese el apellido de Cliente actualizado: ");
                String userLastNameUpdate = consola.nextLine();

                System.out.print("Ingrese la membresía del Cliente actualizado: ");
                int userMembershipUpdate = Integer.parseInt(consola.nextLine());

                Cliente clienteActualizado = new Cliente(userIdCliente, userNameUpdate, userLastNameUpdate, userMembershipUpdate);
                boolean actualizado = clienteDAO.modificarCliente(clienteActualizado);

                if (actualizado){
                    System.out.println("El Cliente fue modificado: " + clienteActualizado);
                }else {
                    System.out.println("No es posible actualizar el Cliente: " + clienteActualizado);
                }
            }
            case 5 -> {
               //Eliminar Clientes
                System.out.println("--- Eliminar Clientes ---");

                //Solicitando los datos del clienteDAO
                System.out.print("Ingrese el ID del cliente a eliminar: ");
                int userIdCliente = Integer.parseInt(consola.nextLine());

                Cliente clienteDelete = new Cliente(userIdCliente);
                boolean eliminado = clienteDAO.eliminarCliente(clienteDelete);

                if (eliminado){
                    System.out.println("El Cliente fue eliminado: " + clienteDelete);
                }else {
                    System.out.println("No es posible eliminar el Cliente: " + clienteDelete);
                }
            }
            case 6 -> {
                System.out.println("Regresa Pronto!!!");
                salirApp = true;
            }
            default -> {
                System.out.println("La opcion ingresada no es correcta: " + opcion);
            }
        }
        return salirApp;
        //Pendiente la creación de la aplicacion usando Spring Boot
    }
}