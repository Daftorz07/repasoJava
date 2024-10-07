package swingIntroduccion.Java2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class VentanaPanel2D extends JPanel {

    public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);
        Graphics2D  grafico2D = (Graphics2D) grafico; // Convirtiendo grafico a grafico2D
        Rectangle2D rectangle2D = new Rectangle2D.Double(100,100,200,150);
        grafico2D.draw(rectangle2D);

        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangle2D);
        grafico2D.draw(elipse);

        grafico2D.draw(new Line2D.Double(300, 300, 300, 400));

        double CentroenX = rectangle2D.getCenterX();
        double CentroenY = rectangle2D.getCenterY();
        double radio = 150;

        Ellipse2D circulo   = new Ellipse2D.Double();
        circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX + radio, CentroenY + radio);
        grafico2D.draw(circulo);
    }

}

