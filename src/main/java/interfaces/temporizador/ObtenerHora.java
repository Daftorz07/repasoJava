package interfaces.temporizador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ObtenerHora implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evento) {

        Date ahora = new Date();
        System.out.println("Cada segundo " + ahora);

        Toolkit.getDefaultToolkit().beep();

    }
}
