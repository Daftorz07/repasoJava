package events.multiplesEventos.multiplesOyentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaminaPrincipal extends JPanel {

    JButton cerrarLaminas;

    public LaminaPrincipal() {

        JButton nuevaLamina = new JButton("Nueva Lamina");
        add(nuevaLamina);

        cerrarLaminas = new JButton("Cerrar Laminas");
        add(cerrarLaminas);

        ClaseOyenteNew miOyente = new ClaseOyenteNew();
        nuevaLamina.addActionListener(miOyente);
    }

    // Clase interna Oyente
    private class ClaseOyenteNew implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoEmergente nuevoMarco = new MarcoEmergente(cerrarLaminas);
        }
    }
}

class MarcoEmergente extends JFrame {

    private static int contadorMarcos = 0;

    public MarcoEmergente(JButton btnCerrar) {

        contadorMarcos++;
        setTitle("Ventana Emergente N°" + contadorMarcos);
        setBounds(60 * contadorMarcos, 60 * contadorMarcos, 350, 250);
        setVisible(true);

        //Por parametro se pasa la referencia del boton cerrar y se ejecuta desde MarcoEmergente
        CerrarLaminas cerrarTodo = new CerrarLaminas();
        btnCerrar.addActionListener(cerrarTodo);
    }

    //Clare interna
    private class CerrarLaminas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Metodo heredado de por JFrame desde la clase Window, cierra todas las ventanas, libera recursos
            dispose();
            contadorMarcos = 0;
        }
    }
}
