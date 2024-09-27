package swing.jpanel;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private int xOffset, yOffset;

    public Panel(int x, int y) {
        this.xOffset = x;
        this.yOffset = y;
    }

    public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);
        grafico.drawString("Java Swing", xOffset, yOffset);

    }
}
