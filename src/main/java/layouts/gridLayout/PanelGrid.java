package layouts.gridLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelGrid extends JPanel {

    private final JPanel botones;
    private JButton pantalla;
    private boolean numeroInicial;
    private double resultado;
    private String ultimaOperacion;

    public PanelGrid() {

        numeroInicial = true;

        setLayout(new BorderLayout(5, 5));

        pantalla = new JButton("0");
        pantalla.setEnabled(false);
        pantalla.setBackground(new Color(224, 218, 218));
        add(pantalla, BorderLayout.NORTH);

        //Panel (Interno) que contiene los botones creado con el metodo crearBoton
        botones = new JPanel();
        botones.setLayout(new GridLayout(4, 4, 5, 5));

        ActionListener escribirNumero = new EscribirNumero();
        ActionListener accionOperacion = new AccionOperacion();

        crearBoton("7", escribirNumero);
        crearBoton("8", escribirNumero);
        crearBoton("9", escribirNumero);
        crearBoton("/", accionOperacion);
        crearBoton("4", escribirNumero);
        crearBoton("5", escribirNumero);
        crearBoton("6", escribirNumero);
        crearBoton("*", accionOperacion);
        crearBoton("1", escribirNumero);
        crearBoton("2", escribirNumero);
        crearBoton("3", escribirNumero);
        crearBoton("-", accionOperacion);
        crearBoton("0", escribirNumero);
        crearBoton(".", escribirNumero);
        crearBoton("=", accionOperacion);
        crearBoton("+", accionOperacion);

        add(botones, BorderLayout.CENTER);

        ultimaOperacion = "=";
    }

    private void crearBoton(String name, ActionListener oyente) {

        JButton boton = new JButton(name);
        boton.addActionListener(oyente);
        botones.add(boton);
    }


    private class EscribirNumero implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String entrada = e.getActionCommand();

            if (numeroInicial) {
                pantalla.setText("");
                numeroInicial = false;
            }

            pantalla.setText(pantalla.getText() + entrada);
        }
    }

    private class AccionOperacion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String tipoOperacion = e.getActionCommand();
            calcular(Double.parseDouble(pantalla.getText()));
            ultimaOperacion = tipoOperacion;
            numeroInicial = true;
        }

        public void calcular(double valorPantalla) {

            if (ultimaOperacion.equals("+")) {

                resultado += valorPantalla;
                System.out.println(resultado);

            } else if (ultimaOperacion.equals("-")) {

                resultado -= valorPantalla;
                System.out.println(resultado);

            } else if (ultimaOperacion.equals("*")) {

                resultado *= valorPantalla;
                System.out.println(resultado);

            } else if (ultimaOperacion.equals("/")) {

                resultado /= valorPantalla;
                System.out.println(resultado);

            } else if (ultimaOperacion.equals("=")) {
                resultado = valorPantalla;

            }

            pantalla.setText("" + resultado);
        }
    }
}
