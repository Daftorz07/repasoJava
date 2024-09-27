package events.focusListener.ejemplo2;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class FocusVentana extends JFrame implements WindowFocusListener {

    FocusVentana ventana1;
    FocusVentana ventana2;

    public void iniciar() {

        ventana1 = new FocusVentana();
        ventana1.setTitle("Ventana 1");
        ventana1.setVisible(true);
        ventana1.setBounds(300, 100, 600, 350);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana2 = new FocusVentana();
        ventana2.setTitle("Ventana 2");
        ventana2.setVisible(true);
        ventana2.setBounds(1200, 100, 600, 350);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana1.addWindowFocusListener(this);
        ventana2.addWindowFocusListener(this);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        //Quien ese el origen del evento
        if (e.getSource() == ventana1) {
            ventana1.setTitle("Ventana 1 - Tiene el Foco");
        } else if (e.getSource() == ventana2) {
            ventana2.setTitle("Ventana 2 - Tiene el Foco");
        }
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        if (e.getSource() == ventana1) {
            ventana1.setTitle("Ventana 1");
        } else if (e.getSource() == ventana2) {
            ventana2.setTitle("Ventana 2");
        }
    }
}
