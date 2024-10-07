package swingIntroduccion.colores;

import javax.swing.*;
import java.awt.*;

public class VentanaFrame2D extends JFrame {

    public VentanaFrame2D() {

        //Creacion del frame
        setTitle("Ventana de Dibujos 2D");
        setSize(700,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        VentanaPanel2D panel2D = new VentanaPanel2D();
        add(panel2D);

        //panel2D.setBackground(Color.RED);
        panel2D.setBackground(SystemColor.window); //Color por defecto del sistema operativo


    }
}
