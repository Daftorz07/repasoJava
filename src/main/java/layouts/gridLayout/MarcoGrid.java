package layouts.gridLayout;

import javax.swing.*;

public class MarcoGrid extends JFrame{

    public MarcoGrid() {

        setSize(250, 250);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Calculadora");

        PanelGrid panel = new PanelGrid();
        add(panel);

        /*
         * Hace que el contenedor se adapte a los elementos que contiene de forma predeterminada
         * si se usa este metodo, no se puede utilizar ningún metodo que defina tamañas al marco
         */
        //pack();
    }
}
