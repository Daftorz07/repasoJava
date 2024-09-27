package ciclos;

import javax.swing.*;

public class CompruebaEmail {

    public static void main(String[] args){

        //Metodos a Usar charAt() y length()
        int arroba = 0;
        boolean punto = false;

        String email = JOptionPane.showInputDialog("Digite el email:");

        for (int i = 0; i <email.length(); i++) {
            if (email.charAt(i) == '@') {
                arroba++;
            }
            if (email.charAt(i) == '.') {
                punto = true;
            }
        }

        if (arroba == 1 && punto) { // punto == true
            System.out.println("Email correcto: " + email);
        }else {
            System.out.println("Email NO correcto: " + email);
        }

    }
}
