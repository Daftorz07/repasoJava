package programacionConcurrente.rebotePelotaIII;

import java.awt.*;

public class PelotaHilos implements Runnable {

    private Pelota pelota;
    private Component componente;

    public PelotaHilos(Pelota pelota, Component componente) {
        this.componente = componente;
        this.pelota = pelota;
    }

    @Override
    public void run() {

        System.out.println("Estado del hilo al iniciar: " + Thread.currentThread().isInterrupted());

        //Hilo bloqueado por el metodo Sleep
        for (int i = 1; i <= 3000; i++) {
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Estado del hilo al finalizar: " + Thread.currentThread().isInterrupted());
    }
}
