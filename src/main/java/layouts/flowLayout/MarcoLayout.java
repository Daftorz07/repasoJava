package layouts.flowLayout;

import javax.swing.*;
import java.awt.FlowLayout;

public class MarcoLayout extends JFrame {

    public MarcoLayout() {

        setSize(600, 500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Marco Layout Principal");

        PanelLayout panelLayout = new PanelLayout();
        add(panelLayout);
    }
}
