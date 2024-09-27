package events.windowListener.adapterClass;

import javax.swing.*;


public class FrameEventos extends JFrame {

    public FrameEventos() {

        //Creacion del frame
        setTitle("Eventos de ventana - Ventana Listener");
        setSize(500,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        PanelEventos eventoWindow1 = new PanelEventos();
        addWindowListener(eventoWindow1);

    }
}
