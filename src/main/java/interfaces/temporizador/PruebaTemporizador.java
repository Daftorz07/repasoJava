package interfaces.temporizador;

import javax.swing.*;

public class PruebaTemporizador {

    public static void main(String[] args){

        ObtenerHora obtenerHora = new ObtenerHora();
        Timer miTimer = new Timer(1000, obtenerHora);

        //Inicializa el timer
        miTimer.start();

        //Evita que finalice le programa para poder ver la ejecucion en consola
        JOptionPane.showMessageDialog(null, "Timer Ejecutando");
        System.exit(0);

    }
}
