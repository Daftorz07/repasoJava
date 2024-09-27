package excepciones.excepcionesII;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagenesPanel2D extends JPanel {

    private Image imagen;

    public ImagenesPanel2D() {

        File rutaImagen = new File("src/img/motoUno.jpg");

        try {
            imagen = ImageIO.read(rutaImagen);
        } catch (IOException e) {
            System.err.println("La ruta de la imagen es errada, ruta: '" + rutaImagen + "'");
        }
    }

    public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);

        //Error no comprobado si la imagen es Null
        if (imagen == null) {
            grafico.drawString("Imagen no encontrada", 150, 100);
        } else {
            grafico.drawImage(imagen, 0, 0, null);
        }
    }
}

