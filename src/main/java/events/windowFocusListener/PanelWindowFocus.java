package events.windowFocusListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class PanelWindowFocus implements WindowFocusListener {

    @Override
    public void windowGainedFocus(WindowEvent e) {
        System.out.println("Tiene el foco");
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        System.out.println("Foco perdido");
    }
}

