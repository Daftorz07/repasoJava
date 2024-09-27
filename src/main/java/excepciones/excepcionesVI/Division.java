package excepciones.excepcionesVI;

import javax.swing.*;

public class Division {

    public static void main(String[] args) {

        try{
            dividir();
        }catch (ArithmeticException e){
            System.out.println("No puedes Dividir entre cero");
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");

            e.printStackTrace();

        }catch (NumberFormatException e){
            System.out.println("Solo se pueden ingresar numero para la operacion");
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");

            e.printStackTrace();

        }
    }

    static void dividir() {

        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el dividendo:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el divisor:"));
        //double resultado = (double) num1 / num2;

        System.out.println("El resultado de la division de " + num1 + " entre el " + num2 + " es: " + (num1 / num2));
    }
}

/*
 * java.lang.RuntimeException
 * ArithmeticException: Division por cero
 * NumberFormatException: Argumentos inválidos, datos distintos de un número
 *
 * Cuando se capturan los errores, es común que se comparta el mensaje de error y el nombre de la clase
 * e.getMessage() y e.getClass().getName()
 */


