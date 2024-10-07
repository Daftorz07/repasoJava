package swingIntroduccion.jframe;

import java.awt.*;
import javax.swing.*;


public class Ventana2 extends JFrame {

    public Ventana2() {

        Toolkit miVentana = Toolkit.getDefaultToolkit();
        Dimension resolucion  = miVentana.getScreenSize();
        System.out.println(resolucion);

        int anchoResolucion = resolucion.width;
        int altoResolucion = resolucion.height;

        setSize(anchoResolucion/2, altoResolucion/2);
        setLocation(anchoResolucion/4, altoResolucion/4);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventana numero dos - Centrada");

        Image icono = miVentana.getImage("src/main/java/swing/jframe/icono.png");
        setIconImage(icono);
    }
}
