package programacionConcurrente.aplicacionBanco;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {

    private final double[] cuentasCorrientes;

    //Manejo de concurrencia
    private Lock cierreBanco = new ReentrantLock();

    private Condition saldoSuficiente;

    public Banco() {
        this.cuentasCorrientes = new double[100];

        //El método fill() de la clase Arrays en Java permite llenar (o inicializar) un arreglo con un valor específico. Igual que un for y recorrer el arreglo
        Arrays.fill(cuentasCorrientes, 2000000);

        //Estableciendo que cierreBanco debe darse bajo una condición
        saldoSuficiente = cierreBanco.newCondition();
    }

    public void transferir(int cuentaOrigen, int cuentaDestino, double cantidadDinero) throws InterruptedException {

        cierreBanco.lock();

        try {
            //Controlar que la cantidad a transferir, no sea mayor al saldo
            while (cuentasCorrientes[cuentaOrigen] < cantidadDinero) {
                    saldoSuficiente.await();
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

            saldoSuficiente.signalAll();

        } finally {

            cierreBanco.unlock();
        }
    }

    public double getSaldo() {

        double sumaCuentas = 0;

        for (double cuenta : cuentasCorrientes) {
            sumaCuentas += cuenta;
        }
        return sumaCuentas;
    }
}
        