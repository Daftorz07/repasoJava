package events.multiplesEventos.multipleEventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrameAcciones extends JFrame {

    public void iniciar() {

        setTitle("Ventana 1 - Multiples Eventos");

        setSize(800, 400);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        PanelAcciones panelAcciones = new PanelAcciones();
        add(panelAcciones);
    }
}

class PanelAcciones extends JPanel {

    public PanelAcciones() {

        String srcAmarillo = "src/img/amarillo.png";
        String srcAzul = "src/img/azul.png";
        String srcRojo = "src/img/rojo.png";

        AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon(srcAmarillo), Color.YELLOW);
        AccionColor accionAzul = new AccionColor("Azul", new ImageIcon(srcAzul), Color.BLUE);
        AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon(srcRojo), Color.RED);

        JButton buttonAmarillo = new JButton(accionAmarillo);
        JButton buttonAzul = new JButton(accionAzul);
        JButton buttonRojo = new JButton(accionRojo);

        add(buttonAmarillo);
        add(buttonAzul);
        add(buttonRojo);

        //1- Crear el mapa de entrada - El objeto del foco se encuentra dentro del Panel
        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        //2- Crear la combination de teclas
        KeyStroke comAmarillo = KeyStroke.getKeyStroke("ctrl Y");
        KeyStroke comAzul = KeyStroke.getKeyStroke("ctrl B");
        KeyStroke comRojo = KeyStroke.getKeyStroke("ctrl R");

        //3- Asignar combination de teclas al objeto
        mapaEntrada.put(comAmarillo, "fondoAmarillo");
        mapaEntrada.put(comAzul, "fondoAzul");
        mapaEntrada.put(comRojo, "fondoRojo");

        //4- Asignar objeto a la accion
        ActionMap mapaAccion = getActionMap();
        mapaAccion.put("fondoAmarillo", accionAmarillo);
        mapaAccion.put("fondoAzul", accionAzul);
        mapaAccion.put("fondoRojo", accionRojo);

    }

    //Clase Interna de PanelAcciones
    private class AccionColor extends AbstractAction {

        public AccionColor(String nombre, Icon icono, Color colorBoton) {

            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Colocar lamina de color " + nombre);
            putValue("colorFondo", colorBoton);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Color color = (Color) getValue("colorFondo");
            setBackground(color);

            System.out.println( "Nombre: " + getValue(Action.NAME));


        }
    }

}
