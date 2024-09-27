package events.windowListener.ejemplo1;

import javax.swing.*;
import java.awt.event.*;

public class PanelEventos extends JPanel implements WindowListener{



    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated: Ventana Activa - La que tiene el Foco");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpened: Ventana Abierta");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("windowClosing: Ventana Cerrada");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed: Ventana Listener Cerrada");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified: Ventana Minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified: Ventana Maximizada");

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated: Ventana Desactivada - Cuando pierde el Foco");
    }
}

