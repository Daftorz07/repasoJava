package layouts.borderLayout;

import javax.swing.*;
import java.awt.BorderLayout;

public class PanelLayout extends JPanel {

    public PanelLayout() {

        // 1 - Definiendo el layout
        BorderLayout layout = new BorderLayout(5,5);
        // 2 - Estableciendo el layout
        setLayout(layout);

        add(new JButton("Amarillo"), BorderLayout.NORTH);
        add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Rojo"), BorderLayout.SOUTH);
        add(new JButton("Negro"), BorderLayout.CENTER);
        add(new JButton("Blanco"), BorderLayout.EAST);

    }
}
