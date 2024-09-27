package programacionConcurrente.rebotePelotaIV;

public class MultiplesHilosI extends Thread{

    public void run(){

        for (int i = 0; i < 10; i++) {
            System.out.println("Ejecutando Hilo: " + Thread.currentThread().getName());
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
