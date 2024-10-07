package swingIntroduccion.dibujo;

import javax.swing.*;

public class VentanaFrame extends JFrame {

    public VentanaFrame(){

        //Creacion del frame
        setTitle("Ventana de Dibujos");
        setSize(700,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Agregando el panel al frame
        VentanaPanel panel = new VentanaPanel();
        add(panel);
    }
}
