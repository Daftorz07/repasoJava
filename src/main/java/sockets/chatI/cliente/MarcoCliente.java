package sockets.chatI.cliente;

import javax.swing.*;

public class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(600, 300, 280, 350);
        setTitle("Cliente");
        LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
        add(miLamina);
        setVisible(true);
    }
}
