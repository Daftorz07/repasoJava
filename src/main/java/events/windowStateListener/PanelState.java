package events.windowStateListener;

import javax.swing.*;
import java.awt.event.*;

public class PanelState implements WindowStateListener {

    @Override
    public void windowStateChanged(WindowEvent e) {

        // DOC: https://docs.oracle.com/javase/7/docs/api/java/awt/Frame.html

        //System.out.println("La Ventana ha cambiado de estado");

        if(e.getNewState() == JFrame.MAXIMIZED_BOTH){ // 6
            System.out.println("La ventana ha sido maximizada");
        }else if(e.getNewState() == JFrame.NORMAL){ //0
            System.out.println("La ventana ha sido restaurada");
        }else if(e.getNewState() == JFrame.ICONIFIED){ // 1
            System.out.println("La ventana ha sido minimizada");
        }
    }
}

