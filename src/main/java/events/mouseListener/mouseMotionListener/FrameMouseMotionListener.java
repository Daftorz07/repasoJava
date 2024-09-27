package events.mouseListener.mouseMotionListener;

import javax.swing.*;


public class FrameMouseMotionListener extends JFrame {

    public FrameMouseMotionListener() {

        //Creacion del frame
        setTitle("mouseMotionListener");
        setSize(500,500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        PanelMouseMotionListener ventanaMouseMotion = new PanelMouseMotionListener();
        addMouseMotionListener(ventanaMouseMotion);

    }
}
