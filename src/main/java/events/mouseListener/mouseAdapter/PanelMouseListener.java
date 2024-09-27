package events.mouseListener.mouseAdapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// DOC: https://docs.oracle.com/javase/8/docs/api/
public class PanelMouseListener extends MouseAdapter {


    @Override
    public void mouseClicked(MouseEvent e) {
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
    public void mousePressed(MouseEvent e){

        System.out.println("\n"+ e.getModifiersEx()+"\n");

        if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK){
            System.out.println("Click izquierdo");
        }else if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK){
            System.out.println("Rueda central");
        }else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK){
            System.out.println("Click derecho");
        }
    }



}

