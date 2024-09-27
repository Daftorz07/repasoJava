package programacionConcurrente.rebotePelotaII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame {

    private LaminaPelota lamina;
    private Thread thread;

    public MarcoRebote() {

        setBounds(600, 300, 500, 500);
        setTitle("Rebotes");

        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();

        ponerBoton(laminaBotones, "Lanzar Pelota!", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }
        });

        ponerBoton(laminaBotones, "Detener Pelota", new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                detenerPelota();
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

        Runnable pelotaHilos = new PelotaHilos(pelota, lamina);
        thread = new Thread(pelotaHilos);
        thread.start();
    }

    public void detenerPelota(){

        //Se toma la instancia del hilo en ejecución y se detiene
        //thread.stop(); //Deprecated
        thread.interrupt();
    }
}