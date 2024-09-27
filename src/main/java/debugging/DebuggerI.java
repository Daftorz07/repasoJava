package debugging;

import javax.swing.*;

public class DebuggerI {

    public static void main(String[] args) {

        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño de la matriz"));
        int[] numAleatorios = new int[elementos];

        for(int i = 0; i < numAleatorios.length; i++) {
            numAleatorios[i] = (int) (Math.random() * 100);
        }

        for (int numero: numAleatorios) {
            System.out.println("Numero: " + numero);
        }
    }
}
