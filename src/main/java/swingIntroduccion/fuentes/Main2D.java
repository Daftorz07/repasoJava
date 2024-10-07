package swingIntroduccion.fuentes;

import java.awt.*;

public class Main2D {

    public static void main(String[] args) {

        VentanaFrame2D frame = new VentanaFrame2D();

        String [] tiposFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String fuente : tiposFuentes){
            System.out.println("Fuente : " + fuente);
        }

        /*String fuenteDigitada = JOptionPane.showInputDialog("Digite la fuente");
        boolean estaFuente = false;

        String [] tiposFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String fuente : tiposFuentes){
            System.out.println("Fuente: " + fuente);
            if (fuenteDigitada.equals(fuente)){
                estaFuente = true;
            }
        }

        if (estaFuente){
            System.out.println("La fuente SI esta instalada");
        } else {
            System.out.println("La fuente NO esta instalada");
        }*/


    }
}
