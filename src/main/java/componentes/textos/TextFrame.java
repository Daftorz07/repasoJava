package componentes.textos;

import javax.swing.*;
import java.awt.*;

public class TextFrame extends JFrame {

    public TextFrame() throws HeadlessException {

        setTitle("Marco de Texto");
        setSize(650, 350);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        TextPanel panel = new TextPanel();
        add(panel);
    }
}
