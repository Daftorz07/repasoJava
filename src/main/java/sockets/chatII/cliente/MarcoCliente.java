package sockets.chatII.cliente;

import javax.swing.*;

public class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(600, 300, 280, 350);
        setTitle("Cliente");
        LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
        add(miLamina);
        setVisible(true);

        /*
         * --------------------------------------------------------------------------
         * * Envio de señal Online hacia el servidor para que este la distribuya en
         * * todos los clientes disponibles en la red
         * --------------------------------------------------------------------------
         */

        addWindowFocusListener(new EnvioOnline());
    }
}
