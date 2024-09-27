package layouts.layoutCombinado;

import javax.swing.*;
import java.awt.*;

public class PanelUno extends JPanel {

    public PanelUno() {

        // 1 - Definiendo el layout
        BorderLayout layout = new BorderLayout(5,5);
        // 2 - Estableciendo el layout
        setLayout(layout);

        add(new JButton("Amarillo"), BorderLayout.EAST);
        add(new JButton("Azul"), BorderLayout.CENTER);
        add(new JButton("Rojo"), BorderLayout.WEST);
    }
}
