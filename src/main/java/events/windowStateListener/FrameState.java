package events.windowStateListener;

import javax.swing.*;


public class FrameState extends JFrame {

    public FrameState() {

        //Creacion del frame
        setTitle("Estados de ventana - windowStateListener");
        setSize(500,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        PanelState ventanaEstado = new PanelState();
        addWindowStateListener(ventanaEstado);

    }
}
