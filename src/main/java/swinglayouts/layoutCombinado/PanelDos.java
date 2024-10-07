package swinglayouts.layoutCombinado;

import javax.swing.*;
import java.awt.*;

public class PanelDos extends JPanel {

    public PanelDos() {

        // 1 - Definiendo el layout
        FlowLayout layout = new FlowLayout();
        // 2 - Estableciendo el layout
        setLayout(layout);

        add(new JButton("Amarillo"));
        add(new JButton("Azul"));

    }
}
