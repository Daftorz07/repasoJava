package swingIntroduccion.jframe;

import javax.swing.*;

public class Ventana1 extends JFrame {

    public Ventana1() {

        //Tamaño de la ventana
        setSize(800,500);
        //Posicion relativa a la resolución de la pantalla
        setLocationRelativeTo(this); //setBounds() - setIconImage();
        //Titulo del frame
        setTitle("Ventana Principal");
        //Visible el frame
        setVisible(true);
        //Operación por defecto al cerrar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setExtendedState(Frame.MAXIMIZED_BOTH); //Pantalla completa
        //Redimensionar ventana
        setResizable(false);



    }
}
