package ciclos;
import java.util.Scanner;

public class AdivinaNumero {

    public static void main(String[] args) {

        //Adivina el numero
        int numeroAdivinar = (int) (Math.random() * 100);
        //System.out.println(numeroAdivinar);

        Scanner entrada = new Scanner(System.in);
        int numeroDigitado = 0;
        int numeroIntentos = 0;

        while (numeroDigitado != numeroAdivinar) {
            System.out.println("Introduce un numero:");
            numeroDigitado = entrada.nextInt();

            if (numeroAdivinar < numeroDigitado) {
                System.out.println("Numero a hallar es más bajo ↓");
            } else if (numeroAdivinar > numeroDigitado) {
                System.out.println("Numero a hallar es más alto ↑");
            }
            numeroIntentos++;
        }
        System.out.println("Correcto numero adivinado: " + numeroAdivinar + " en " + numeroIntentos + " intentos.");
    }
}
