package streamsIntroduccion.buffersCaracteres;

public class Buffers {

    public static void main(String[] args) {

        /*
        * Archivos de prueba: escribiendoBuffer y poo
        */

        LeerFichero leerFichero = new LeerFichero();
        leerFichero.leer("poo.txt");

        EscribirFichero escribirFichero = new EscribirFichero();
        //escribirFichero.escribir("escribiendoBuffer.txt");

    }
}
