package programacionConcurrente.rebotePelotaII;

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
        /*for (int i = 1; i <= 3000; i++) {
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                System.out.println("Se genero un error de tipo: " + e.getClass().getName());
                System.out.println("Motivo: " + e.getMessage());
                System.out.println("--------------------------------");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }*/

        // ----------------------------------------------------------------
        //Con el metodo Interrupted
        /*while (!Thread.interrupted()) {
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());
        }*/

        // ----------------------------------------------------------------
        // Usando los metodos currentThread y isInterrupted
        while (!Thread.currentThread().isInterrupted()) {
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());
        }

        System.out.println("Estado del hilo al finalizar: " + Thread.currentThread().isInterrupted());

    }
}
