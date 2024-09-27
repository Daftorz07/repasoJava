package events.mouseListener.mouseMotionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

// DOC: https://docs.oracle.com/javase/8/docs/api/
public class PanelMouseMotionListener implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Arrastrando El Mouse, en la Coordenada: " + e.getX() + " " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Moviendo El Mouse, en la Coordenada: " + e.getX() + " " + e.getY());
    }
}

