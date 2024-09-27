package enums;

import java.util.Scanner;

public class TallasEnum {

    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese una talla: MINI, MEDIANO, GRANDE Y MUY_GRANDE");
        String entradaDatos = consola.next().toUpperCase();

        Talla talla = Talla.valueOf(Talla.class, entradaDatos);

        System.out.println("La talla ingresada es: " + talla + " que corresponde a " + talla.getTallaAbreviada());

    }
}
