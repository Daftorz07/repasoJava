package swinglayouts.flowLayout;

import javax.swing.*;
import java.awt.FlowLayout;

public class PanelLayout extends JPanel {

    public PanelLayout() {

        // 1 - Definiendo el layout
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER,15,150);
        // 2 - Estableciendo el layout
        setLayout(layout);

        add(new JButton("Amarillo"));
        add(new JButton("Azul"));
        add(new JButton("Rojo"));

    }
}
