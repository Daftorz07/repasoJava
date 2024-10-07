package swingIntroduccion.imagenes;

import javax.swing.*;

public class ImagenesFrame2D extends JFrame {

    public ImagenesFrame2D() {

        //Creacion del frame
        setTitle("Incluyendo Imagenes 2D");
        setSize(1000,1000);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        ImagenesPanel2D panel2D = new ImagenesPanel2D();
        add(panel2D);

    }
}
