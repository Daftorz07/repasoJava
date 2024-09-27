package ciclos;

import javax.swing.*;

public class Bucles {

    public static void main(String[] args){

        String clave = "david";
        String claveDigitada = "";

        //claveDigitada.equals(clave) == false
        while(!clave.equals(claveDigitada)){
            claveDigitada = JOptionPane.showInputDialog("Ingresa la clave");
            if (!claveDigitada.equals(clave)){
                System.out.println("Clave incorrecta");
            }
        }
        System.out.println("Contraseña digitada conrrectamente");
    }

}
