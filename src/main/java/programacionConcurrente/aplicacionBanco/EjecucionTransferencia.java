package programacionConcurrente.aplicacionBanco;

public class EjecucionTransferencia implements Runnable {

    private Banco banco;
    private int cuentaOrigen;
    private double valorMaximo;

    public EjecucionTransferencia(Banco banco, int cuentaOrigen, double valorMaximo) {
        this.banco = banco;
        this.cuentaOrigen = cuentaOrigen;
        this.valorMaximo = valorMaximo;
    }

    @Override
    public void run() {

        try {
            while (true) {

                int cuentaDestino = (int) (100 * Math.random());
                double cantidadTransferir = valorMaximo * Math.random();

                Banco banco = new Banco();
                banco.transferir(cuentaOrigen, cuentaDestino, cantidadTransferir);

                Thread.sleep((int)(Math.random() * 10));
            }

        } catch (InterruptedException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }
}
