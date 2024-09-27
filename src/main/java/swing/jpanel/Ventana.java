package swing.jpanel;

import javax.swing.*;

public class Ventana extends JFrame {

    public Ventana() {

        setSize(800, 800);
        setLocationRelativeTo(this);
        setVisible(true); //Debe ir después de la localización
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Al cerrar la ventana se cierra el programa

        //Agregando el panel al Frame para ser mostrado en la Ventana
        Panel panel = new Panel(400, 400);
        add(panel);


    }
}
