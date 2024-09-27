package events.windowListener.ejemplo1;

import javax.swing.*;

public class MainEventos extends JFrame{

    public static void main(String[] args)  {

        FrameEventos frame1 = new FrameEventos();

        //Ventana 2
        FrameEventos frame2 = new FrameEventos();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Eventos de ventana - Ventana 2");
        frame2.setBounds(100,100,500,500);


    }
}
