package swingIntroduccion.Java2D;

import javax.swing.*;

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
    }
}
