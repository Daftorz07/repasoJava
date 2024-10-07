package swingIntroduccion.dibujo;

import javax.swing.*;
import java.awt.*;

public class VentanaPanel extends JPanel {

    public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);
        grafico.drawRect(100,100,200,200);
        grafico.drawLine(125,125, 125, 225);
        grafico.drawArc(140,140,200,100,200,200);
    }
}
