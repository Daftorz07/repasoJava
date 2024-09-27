package ciclos;

import javax.swing.*;

public class NumeroFactorial {

    public static void main(String[] args) {

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero:"));
        int factorial = 1;

        for (int i = numero; i > 0; i--) {
            factorial = factorial * i;
        }

        System.out.println("El factorial de " + numero + " es " + factorial);

    }
}
