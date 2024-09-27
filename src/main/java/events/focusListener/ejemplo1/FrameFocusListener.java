package events.focusListener.ejemplo1;

import javax.swing.*;


public class FrameFocusListener extends JFrame {

    public FrameFocusListener() {

        //Creacion del frame
        setTitle("FocusListener - Ventana 1");
        setSize(500,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        PanelFocusListener focusListener = new PanelFocusListener();
        add(focusListener);

    }
}
