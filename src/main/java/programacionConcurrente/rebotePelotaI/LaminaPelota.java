package programacionConcurrente.rebotePelotaI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Lámina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel {

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

    //Añadimos pelota a la lámina
    public void add(Pelota b) {
        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Pelota b : pelotas) {
            g2.fill(b.getShape());
        }
    }
}