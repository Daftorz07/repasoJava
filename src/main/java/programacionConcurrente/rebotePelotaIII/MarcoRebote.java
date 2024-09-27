package programacionConcurrente.rebotePelotaIII;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Marco con lámina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame {

    private LaminaPelota lamina;
    private Thread thread1, thread2, thread3;
    private JButton iniciar1, iniciar2, iniciar3, detener1, detener2, detener3;

    public MarcoRebote() {

        setBounds(600, 300, 800, 500);
        setTitle("Rebotes");

        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones = new JPanel();

        //Creando los Botones
        iniciar1 = new JButton("Hilo 1");
        iniciar2 = new JButton("Hilo 2");
        iniciar3 = new JButton("Hilo 3");
        detener1 = new JButton("Detener H1");
        detener2 = new JButton("Detener H2");
        detener3 = new JButton("Detener H3");

        //Colocando a la Escucha los botones
        iniciar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });

        iniciar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });

        iniciar3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comienza_el_juego(e);
            }
        });

        detener1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detenerPelota(e);
            }
        });

        detener2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detenerPelota(e);
            }
        });

        detener3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detenerPelota(e);
            }
        });

        //Agregando los Botones a la lámina
        laminaBotones.add(iniciar1);
        laminaBotones.add(iniciar2);
        laminaBotones.add(iniciar3);
        laminaBotones.add(detener1);
        laminaBotones.add(detener2);
        laminaBotones.add(detener3);

        add(laminaBotones, BorderLayout.SOUTH);
    }

    //Añade pelota y la bota 1000 veces
    public void comienza_el_juego(ActionEvent event) {

        Pelota pelota = new Pelota();
        lamina.add(pelota);

        Runnable pelotaHilos = new PelotaHilos(pelota, lamina);

        if (event.getSource().equals(iniciar1)){
            thread1 = new Thread(pelotaHilos);
            thread1.start();
        }

        if (event.getSource().equals(iniciar2)){
            thread2 = new Thread(pelotaHilos);
            thread2.start();
        }

        if (event.getSource().equals(iniciar3)){
            thread3 = new Thread(pelotaHilos);
            thread3.start();
        }
    }

    public void detenerPelota(ActionEvent event){

        if (event.getSource().equals(detener1)){
            thread1.interrupt();
            System.out.println("Hilo 1 detenido");
        }

        if (event.getSource().equals(detener2)){
            thread2.interrupt();
            System.out.println("Hilo 2 detenido");
        }

        if (event.getSource().equals(detener3)){
            thread3.interrupt();
            System.out.println("Hilo 3 detenido");
        }
    }
}