package excepciones.excepcionesVII;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcularArea {

    static int opcion;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Elige un opción: \n1. Cuadrado \n2. Rectángulo \n3. Triángulo \n4. Círculo");
            opcion = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Solo se pueden ingresar numero para la operacion");
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");

        } finally {
            scanner.close();
        }

        switch (opcion) {
            case 1:
                int lado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un lado del cuadrado:"));
                System.out.println("El area del cuadrado es: " + Math.pow(lado, 2));
                break;

            case 2:
                int base = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la base del Rectángulo:"));
                int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la altura del Rectángulo:"));
                System.out.println("El area del rectángulo es: " + (base * altura));
                break;

            case 3:
                int baseTriangulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la base del Triángulo:"));
                int alturaTriangulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la altura del Rectángulo:"));
                System.out.println("El area del triángulo es: " + (baseTriangulo * alturaTriangulo) / 2);

            case 4:
                int radio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el radio del Círculo:"));
                System.out.println("El area del círculo es: " + (Math.PI * Math.pow(radio, 2)));
                break;

            default:
                System.out.println("Opción no es correcta");
        }

        int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu altura en cm:"));
        System.out.println("Si eres hombre tu peso ideal es: " + (altura - 110) + " kg");
        System.out.println("Si eres mujer tu peso ideal es: " + (altura - 120) + " kg");
    }
}
