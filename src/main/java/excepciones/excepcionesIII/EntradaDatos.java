package excepciones.excepcionesIII;

import java.util.Scanner;
import java.util.InputMismatchException;

public class EntradaDatos {

    public static void main(String[] args) {

        System.out.println("¿Que deseas haces?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner consola = new Scanner(System.in);
        int respuesta = consola.nextInt();

        if (respuesta == 1) {

            try {
                pedirDatos();
            } catch (InputMismatchException e) {
                System.err.println("\n Debe ingresar un numero");
                System.out.println("----------------");
                System.out.println("Hemos Terminado");
            }
        } else if (respuesta == 2) {
            System.out.println("Regresa pronto");
            System.exit(0);
        }
        consola.close();
    }

    static void pedirDatos() throws InputMismatchException {

        Scanner datosIn = new Scanner(System.in);

        System.out.println("Ingresa tu nombre completo: ");
        String nombre = datosIn.nextLine();

        System.out.println("Ingresa tu edad: ");
        int edad = datosIn.nextInt();

        System.out.println("----------------");
        System.out.println("Los datos ingresados son: \n Nombre: " + nombre + "\n Edad: " + edad);
        datosIn.close();
        System.out.println("----------------");
        System.out.println("Datos registrado, hasta luego!!");
    }
}
