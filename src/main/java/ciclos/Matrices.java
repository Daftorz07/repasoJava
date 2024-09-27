package ciclos;

import javax.swing.*;

public class Matrices {

    public static void main(String[] args){

        //Declaracion de una matriz
        int[] numerosEnteros = new int[5]; //int numerosEnteros[] = new int[5];
        numerosEnteros[0] = 29;
        numerosEnteros[1] = 15;
        numerosEnteros[2] = -8;
        numerosEnteros[3] = 17;
        numerosEnteros[4] = 7;

        //For tradicional
        for (int i = 0; i < numerosEnteros.length; i++){
            System.out.println("Numero " + numerosEnteros[i] + " En la posicion " + i);
        }

        String[] nombres = new String[2];
        nombres[0] = "David Torres";
        nombres[1] = "Blanca Bayuelo";

        //For each
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        //Definiendo el tamaño de la matriz
        int tamano = Integer.parseInt(JOptionPane.showInputDialog("Ingrese en tamaño de la matriz"));
        String[] paises = new String[tamano];

        for (int i = 0; i < tamano; i++) {
            paises[i] = JOptionPane.showInputDialog("Ingrese el nombre del pais");
        }

        //Mostrando resultados
        for (String nombre : paises) {
            System.out.println("El nombre del pais es: " + nombre);
        }


    }
}
