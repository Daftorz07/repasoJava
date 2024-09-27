package events.windowFocusListener;

import javax.swing.*;

public class MainWindowFocus extends JFrame{

    public static void main(String[] args)  {

        //Ventana numero 1
        FrameWindowFocus focusListenerV1 = new FrameWindowFocus();

        //Ventana numero 2
        FrameWindowFocus focusListenerV2 = new FrameWindowFocus();
        focusListenerV2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        focusListenerV2.setTitle("FocusListener - Ventana 2");
        focusListenerV2.setBounds(100,100,500,500);


    }
}
