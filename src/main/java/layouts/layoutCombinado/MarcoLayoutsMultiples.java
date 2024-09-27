package layouts.layoutCombinado;

import layouts.borderLayout.PanelLayout;

import javax.swing.*;
import java.awt.*;

public class MarcoLayoutsMultiples extends JFrame {

    public MarcoLayoutsMultiples() {

        setSize(700, 700);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Marco - Layouts Multiples");

        PanelUno panelUno = new PanelUno();
        PanelDos panelDos = new PanelDos();

        add(panelUno, BorderLayout.NORTH);
        add(panelDos, BorderLayout.SOUTH);

    }
}
