package layouts.borderLayout;

import javax.swing.*;

public class MarcoLayout extends JFrame {

    public MarcoLayout() {

        setSize(600, 500);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Marco Border Layout Principal");

        PanelLayout panelLayout = new PanelLayout();
        add(panelLayout);
    }
}
