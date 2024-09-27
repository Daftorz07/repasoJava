package events.multiplesEventos.multiplesOyentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MarcoPrincipal extends JFrame {

    public void iniciar() {

        setTitle("Ventana Principal - Multiples Oyentes");

        setSize(500, 200);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        LaminaPrincipal lamina = new LaminaPrincipal();
        add(lamina);
    }
}

