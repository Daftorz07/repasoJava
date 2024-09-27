package swing.imagenes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagenesPanel2D extends JPanel {

    private Image imagen;

    //Al instanciar el panel cargamos en memoria la imagen y solo hasta qye se ejecuta el drawImage es pintada la imagen
    /*public ImagenesPanel2D() {

        try {
            imagen = ImageIO.read(new File("src/img/motoUno.jpg"));
        } catch (IOException e) {
            System.err.println("Ruta de la imagen errada");
        }
    }*/

    public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);

       File rutaImagen = new File("src/img/motoUno.jpg");

        try {
            imagen = ImageIO.read(rutaImagen);
        } catch (IOException e) {
            System.err.println("Ruta de la imagen errada");
        }

        int widthImagen = imagen.getWidth(this);
        int heightImagen = imagen.getHeight(this);

        System.out.println("Las dimensiones de la imagen: " + widthImagen + " x " + heightImagen);

        grafico.drawImage(imagen, 0, 0, null);

    }
}

