package events.mouseListener.mouseListenerExample;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// DOC: https://docs.oracle.com/javase/8/docs/api/
public class PanelMouseListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseReleased 3");
        System.out.println("mouseClicked: Coordenada => X:" + e.getX() + " Y:" + e.getY());
        System.out.println("getClickCount => " + e.getClickCount());

        if(e.getButton() == 1){
            System.out.println("Click izquierdo");
        }else if(e.getButton() == 2){
            System.out.println("Rueda central");
        }else if(e.getButton() == 3){
            System.out.println("Click derecho");
        }

        System.out.println(e.getLocationOnScreen() + " getLocationOnScreen");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed: 1");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased 2");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered 1: Coordenada => X:" + e.getX() + " Y:" + e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited 2: Coordenada => X:" + e.getX() + " Y:" + e.getY());
    }
}

