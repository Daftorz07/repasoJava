package swingIntroduccion.colores;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class VentanaPanel2D extends JPanel {

    public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);
        Graphics2D  grafico2D = (Graphics2D) grafico; // Convirtiendo grafico a grafico2D
        Rectangle2D rectangle2D = new Rectangle2D.Double(100,100,200,150);

        grafico2D.setPaint(Color.BLACK);
        grafico2D.draw(rectangle2D);
        grafico2D.setPaint(Color.YELLOW);
        grafico2D.fill(rectangle2D);

        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangle2D);
        grafico2D.setPaint(Color.BLACK);
        grafico2D.draw(elipse);
        grafico2D.setPaint(new Color(120, 240, 90).brighter()); // darker() or brighter()
        grafico2D.fill(elipse);

    }
}

