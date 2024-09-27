package programacionConcurrente.aplicacionBanco;

import java.util.Arrays;

public class BancoSynchronized {

    private final double[] cuentasCorrientes;

    public BancoSynchronized() {
        this.cuentasCorrientes = new double[100];

        //El método fill() de la clase Arrays en Java permite llenar (o inicializar) un arreglo con un valor específico. Igual que un for y recorrer el arreglo
        Arrays.fill(cuentasCorrientes, 2000000);

    }

    public synchronized void transferir(int cuentaOrigen, int cuentaDestino, double cantidadDinero) throws InterruptedException {

        //Controlar que la cantidad a transferir, no sea mayor al saldo
        while (cuentasCorrientes[cuentaOrigen] < cantidadDinero) {
            wait();
        }

        System.out.println("\nHilo que realiza la transferencia: " + Thread.currentThread().getName());

        //Restando la cantidad a transferir de la cuenta origen
        cuentasCorrientes[cuentaOrigen] -= cantidadDinero;

        //Información de la transferencia
        System.out.printf("Transferencia de: $%10.2f Desde la cuenta N°%d hacia la cuenta N°%d", cantidadDinero, cuentaOrigen, cuentaDestino);

        //Sumando la cantidad a transferir de la cuenta destino
        cuentasCorrientes[cuentaDestino] += cantidadDinero;
        System.out.printf("\nCuenta Origen " + cuentaOrigen + ", Saldo después de la la transferencia: $%10.2f", cuentasCorrientes[cuentaOrigen]);

        System.out.printf("\nSaldo total en cuentas: $%10.2f%n", getSaldo());

        notifyAll();
    }

    public double getSaldo() {

        double sumaCuentas = 0;

        for (double cuenta : cuentasCorrientes) {
            sumaCuentas += cuenta;
        }
        return sumaCuentas;
    }
}
        