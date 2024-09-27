package events.windowListener.adapterClass;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelEventos extends WindowAdapter {

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated: Ventana Activa");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified: Ventana Minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified: Ventana Maximizada");
    }
}

