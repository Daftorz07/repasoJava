package events.keyListener;

import javax.swing.*;


public class FrameKeyListener extends JFrame {

    public FrameKeyListener() {

        //Creacion del frame
        setTitle("Estados de ventana - windowStateListener");
        setSize(500,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        PanelKeyListener ventanaEstado = new PanelKeyListener();
        addKeyListener(ventanaEstado);

    }
}
