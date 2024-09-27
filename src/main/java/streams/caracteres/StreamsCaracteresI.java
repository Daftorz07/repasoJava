package streams.caracteres;

public class StreamsCaracteresI {

    public static void main(String[] args) {

        LeerFichero leerFichero = new LeerFichero();
        String fraseRecuperada = leerFichero.leer("streamsCaracteresEscritos.txt");

        String nuevaFrase = fraseRecuperada + " y no agrego nada nuevo";

        EscribirFichero escribirFichero = new EscribirFichero();
        escribirFichero.escribir(nuevaFrase);
        //escribirFichero.escribir(" ");
    }
}
