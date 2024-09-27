package programacionConcurrente.aplicacionBanco;

public class BancoSinSincronizar {

    public static void main(String[] args) {

        Banco banco = new Banco();

        for (int cuenta = 0; cuenta < 100; cuenta++) {
            EjecucionTransferencia bancoTransferencia = new EjecucionTransferencia(banco, cuenta, 2000000);

            Thread thread = new Thread(bancoTransferencia);
            thread.start();
        }

        /* BancoSynchronized banco = new BancoSynchronized();

        for (int cuenta = 0; cuenta < 100; cuenta++) {
            EjecucionTransferencia bancoTransferencia = new EjecucionTransferencia(banco, cuenta, 2000000);

            Thread thread = new Thread(bancoTransferencia);
            thread.start();
        }*/

    }
}
