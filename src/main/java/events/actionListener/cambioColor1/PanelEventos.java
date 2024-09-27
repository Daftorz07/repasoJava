package events.actionListener.cambioColor1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEventos extends JPanel implements ActionListener {

    JButton button1 = new JButton("Amarillo");
    JButton button2 = new JButton("Azul");
    JButton button3 = new JButton("Rojo");

    //Objeto Evento - Clic = addActionListener
    //Objeto Fuente - Boton = Quien ejecuta el evento
    //Objeto Listener - This = Quien recibe el evento

    public PanelEventos() {

        add(button1);
        add(button2);
        add(button3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object botonPulsado = e.getSource();

        System.out.println( botonPulsado.toString());

        if (botonPulsado == button1) {
            setBackground(Color.YELLOW);
        } else if (botonPulsado == button2){
            setBackground(Color.BLUE);
        }else if (botonPulsado == button3){
            setBackground(Color.RED);
        }
    }
}

