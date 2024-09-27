package sockets.socketsI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//Clase principal
public class Cliente {

    public static void main(String[] args) {

        MarcoCliente miMarco = new MarcoCliente();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//Marco del Cliente
class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(600, 300, 280, 350);
        setTitle("Cliente");
        LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
        add(miLamina);
        setVisible(true);
    }
}

//Panel / Informacion del Cliente
class LaminaMarcoCliente extends JPanel {

    private JTextField campoTexto;
    private JButton btnEnviar;

    public LaminaMarcoCliente() {

        JLabel texto = new JLabel("Cliente:");
        add(texto);

        campoTexto = new JTextField(20);
        add(campoTexto);

        btnEnviar = new JButton("Enviar");
        EnviarTexto eventoEnviar = new EnviarTexto();
        btnEnviar.addActionListener(eventoEnviar);
        add(btnEnviar);
    }

    //Clase Interna encargada de gestionar los eventos del boton
    private class EnviarTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String datosIngresado = campoTexto.getText();
            System.out.println("Datos ingresados: " + datosIngresado);

            //Creacion del Socket
            try {
                // 192.168.1.51 IP Address PC
                Socket socket = new Socket("192.168.1.51", 9999);

                //Iniciando el flujo de datos y pasando como referencia la ruta por donde circularan los datos
                DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());

                //En el flujo de datos circulará el contenido del campo de texto
                flujoSalida.writeUTF(campoTexto.getText());

                //Cerrar el flujo de datos para que se puedan enviar
                flujoSalida.close();

            } catch (IOException e) {
                System.out.println("Se genero un error de tipo: " + e.getClass().getName());
                System.out.println("Motivo: " + e.getMessage());
                System.out.println("--------------------------------");
                throw new RuntimeException(e);
            }
        }
    }
}