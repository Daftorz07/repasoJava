package events.windowFocusListener;

import javax.swing.*;


public class FrameWindowFocus extends JFrame {

    public FrameWindowFocus() {

        //Creacion del frame
        setTitle("FocusListener - Ventana 1");
        setSize(500,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // No termina la aplicación
        setVisible(true);

        PanelWindowFocus windowFocusListener = new PanelWindowFocus();
        addWindowFocusListener(windowFocusListener);

    }
}
