package programacionConcurrente.rebotePelotaIV;

public class SincronizandoHilos {

    public static void main(String[] args) {

        Thread hiloUno =  new MultiplesHilosI();
        Thread hiloDos = new MultiplesHilosII(hiloUno);

        hiloUno.start();
        hiloDos.start();

        System.out.println("Fin del Programa");
    }
}
