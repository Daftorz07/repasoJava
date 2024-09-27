package programacionConcurrente.rebotePelotaIV;

public class MultiplesHilosII extends Thread {

    private final Thread mThread;

    public MultiplesHilosII(Thread hilo) {
        this.mThread = hilo;
    }

    public void run() {

        try {
            mThread.join();
        } catch (InterruptedException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 7; i++) {
            System.out.println("Ejecutando Hilo: " + Thread.currentThread().getName());
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
