package excepciones.excepcionesI;

import javax.swing.*;

public class Fallos {

    public static void main(String[] args) {

        int [] numeros = new int[5];

        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;
        numeros[3] = 4;
        numeros[4] = 5;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posicion: " + i + " = " + numeros[i]);
        }

        //Solicitando datos Personales
        String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu edad"));

        System.out.println("Tu nombre es " + nombre + " y tu edad es " + edad);

    }
}
