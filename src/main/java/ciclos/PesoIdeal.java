package ciclos;
import javax.swing.*;

public class PesoIdeal {

    public static void main(String[] args) {

        String genero;

        do{
            genero = JOptionPane.showInputDialog("Ingrese tu genero: \n(M)Masculino \n(F)Femenino");
        }while(!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F")); // genero.equalsIgnoreCase("H")==false

        int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu altura"));
        int pesoIdeal = 0;

        if (genero.equalsIgnoreCase("M")){
            pesoIdeal = altura - 110;
        }else if (genero.equalsIgnoreCase("F")){
            pesoIdeal = altura - 120;
        }

        System.out.println("Tu peso ideal es: " + pesoIdeal);
    }
}
