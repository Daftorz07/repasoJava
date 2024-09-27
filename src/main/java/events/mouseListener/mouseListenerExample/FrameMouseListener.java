package events.mouseListener.mouseListenerExample;

import javax.swing.*;


public class FrameMouseListener extends JFrame {

    public FrameMouseListener() {

        //Creacion del frame
        setTitle("Estados de ventana - windowStateListener");
        setSize(500,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        PanelMouseListener ventanaMouseListener = new PanelMouseListener();
        addMouseListener(ventanaMouseListener);

    }
}
