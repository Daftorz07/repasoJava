package events.keyListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// TODO: DOC => https://docs.oracle.com/javase/8/docs/api/

public class PanelKeyListener implements KeyListener {


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed: getKeyCode => " + e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped: getKeyChar => " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased: " + e.getKeyChar() + "-" + e.getKeyCode());
    }

}

