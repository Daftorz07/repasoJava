package events.focusListener.ejemplo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PanelFocusListener extends JPanel {

    // Variables Object parecidas a String
    JTextField cuadroTexto1;
    JTextField cuadroTexto2;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        super.paintComponent(g);
        //Inactivar el Layout, se inhabilita la colocación predeterminada
        setLayout(null);

        cuadroTexto1 = new JTextField();
        cuadroTexto2 = new JTextField();

        cuadroTexto1.setBounds(150, 50, 150, 25);
        cuadroTexto2.setBounds(150, 100, 150, 25);

        cuadroTexto1.setName("Cuadro 1");

        add(cuadroTexto1);
        add(cuadroTexto2);

        ManejadorFocus manejador = new ManejadorFocus();
        cuadroTexto1.addFocusListener(manejador);

    }

    private class ManejadorFocus implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("Tienes el foco " + cuadroTexto1.getName());
        }

        @Override
        public void focusLost(FocusEvent e) {

            //System.out.println("Perdiste el foco " + cuadroTexto1.getText());

            String email = cuadroTexto1.getText();
            boolean isEmail = false;

            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    isEmail = true;
                }
            }
            if(isEmail){
                System.out.println("Email " + email + " es correcto");
            } else {
                System.out.println("Email " + email + " es incorrecto");
            }

        }
    }
}

