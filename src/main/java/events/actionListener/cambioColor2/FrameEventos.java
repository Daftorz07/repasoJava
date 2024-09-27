package events.actionListener.cambioColor2;

import javax.swing.*;

public class FrameEventos extends JFrame {

    public FrameEventos() {

        //Creacion del frame
        setTitle("Eventos");
        setSize(800,800);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        PanelEventos panelEventos = new PanelEventos();
        add(panelEventos);

    }
}
