package events.actionListener.cambioColor2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEventos extends JPanel {

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

        ColorFondo colorDeFondo1 = new ColorFondo(Color.YELLOW);
        ColorFondo colorDeFondo2 = new ColorFondo(Color.BLUE);
        ColorFondo colorDeFondo3 = new ColorFondo(Color.RED);

        button1.addActionListener(colorDeFondo1);
        button2.addActionListener(colorDeFondo2);
        button3.addActionListener(colorDeFondo3);
    }

    //Clase interna - clase listener porque implemente la interfaz ActionListener
    private class ColorFondo implements ActionListener {

        private Color colorDeFondo;

        public ColorFondo(Color color) {
            this.colorDeFondo = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(colorDeFondo);
        }
    }
}



