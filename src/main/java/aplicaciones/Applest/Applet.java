package aplicaciones.Applest;

import javax.swing.*;

public class Applet extends JApplet {

    @Override
    public void init() {
        super.init();

        JLabel titulo = new JLabel("Hola Mundo");
        add(titulo);
    }
}
