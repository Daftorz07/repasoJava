package programacionConcurrente.rebotePelotaI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame {

    private LaminaPelota lamina;

    public MarcoRebote() {

        setBounds(600, 300, 400, 350);
        setTitle("Rebotes");

        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();

        ponerBoton(laminaBotones, "Dale!", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }
        });

        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });

        add(laminaBotones, BorderLayout.SOUTH);
    }

    //Ponemos botones
    public void ponerBoton(Container c, String titulo, ActionListener oyente) {

        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);
    }

    //Añade pelota y la bota 1000 veces
    public void comienza_el_juego() {

        Pelota pelota = new Pelota();
        lamina.add(pelota);

        for (int i = 1; i <= 3000; i++) {
            pelota.mueve_pelota(lamina.getBounds());
            lamina.paint(lamina.getGraphics());
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                System.out.println("Se genero un error de tipo: " + e.getClass().getName());
                System.out.println("Motivo: " + e.getMessage());
                System.out.println("--------------------------------");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}