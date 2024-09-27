package swing.fuentes;

import javax.swing.*;
import java.awt.*;

public class VentanaPanel2D extends JPanel {

    public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);
        Graphics2D  grafico2D = (Graphics2D) grafico; // Convirtiendo grafico a grafico2D

        Font nuevaFont1 = new Font("Showcard Gothic", Font.BOLD, 29);
        grafico2D.setFont(nuevaFont1);
        //grafico2D.setColor(Color.YELLOW);
        grafico2D.drawString("Colombia", 100, 100);

        Font nuevaFont2 = new Font("Lucida Console", Font.ITALIC, 29);
        grafico2D.setFont(nuevaFont2);
        grafico2D.setColor(Color.YELLOW);
        grafico2D.drawString("Cartagena", 150, 150);

        Font nuevaFont3 = new Font("Bahnschrift", Font.BOLD, 29);
        grafico2D.setFont(nuevaFont3);
        grafico2D.setColor(Color.RED);
        grafico2D.drawString("Sociedad Portuaria", 200, 200);

    }
}

