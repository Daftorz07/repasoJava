package sockets.chatII.cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class LaminaMarcoCliente extends JPanel implements Runnable {

    private JTextField mensaje;
    private JButton btnEnviar;

    private JTextArea campoChat;
    private JLabel nick;
    private JComboBox ips;

    public LaminaMarcoCliente() {

        //Componente del nombre del Usuario
        String nickUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario: ");
        JLabel texto = new JLabel("Nick: ");
        nick = new JLabel();
        nick.setText(nickUsuario);
        add(texto);
        add(nick);

        //IP del Receptor del Mensaje
        JLabel ipl = new JLabel("- IP: ");

        ips = new JComboBox();
        //ips.addItem("192.168.1.51");

        add(ipl);
        add(ips);

        //Campo de historial de Chat
        campoChat = new JTextArea(12, 20);
        add(campoChat);

        //Mensaje a enviar
        mensaje = new JTextField(20);
        add(mensaje);

        //Configuración del boton enviar
        btnEnviar = new JButton("Enviar");
        EnviarTexto eventoEnviar = new EnviarTexto();
        btnEnviar.addActionListener(eventoEnviar);
        add(btnEnviar);

        //Se coloca en funcionamiento el hilo donde se configuró el ServerSocket
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {
            /*
             * --------------------------------------------------------------------------------
             * * ServerSocket configurado dentro de un hilo para que siempre este a la escucha
             * --------------------------------------------------------------------------------
             */

            //Creando el ServerSocket por donde se recibirá la información desde el cliente
            ServerSocket serverSocket = new ServerSocket(9090); //Escuchando por el puerto

            //Creando el Socket para la comunicación con el cliente2
            Socket cliente;
            DatosMensaje datosRecibidos;

            while (true) {
                /*
                 * ----------------------------------------------------------------
                 * * Socket configurado para recibir la información del cliente
                 * ----------------------------------------------------------------
                 */

                //Aceptar las conexiones del cliente (9090)
                cliente = serverSocket.accept();

                //Crear el flujo de datos de entrada para recibir los datos que vienen del cliente por el serverSocket
                ObjectInputStream datosEntrada = new ObjectInputStream(cliente.getInputStream());

                //Datos recibidos
                datosRecibidos = (DatosMensaje) datosEntrada.readObject();
                String nick = datosRecibidos.getNick();
                String ip = datosRecibidos.getIpAddress();
                String message = datosRecibidos.getMessage();

                //Escribimos el texto
                if (!datosRecibidos.getMessage().equals(" online")) {
                    campoChat.append("\n" + nick + ": " + message + " para: " + ip);
                } else {

                    //campoChat.append("\n" + datosRecibidos.getIps());

                    //Crear lista que contendrá de manera dinámica las IPS de los clientes que se van conectando
                    ArrayList<String> ipsMenu = new ArrayList<String>();
                    ipsMenu = datosRecibidos.getIps();

                    //Antes de agregar las nuevas IPS, se limpia primero el array
                    ips.removeAllItems();

                    for (String ipIten : ipsMenu){
                        //Agregando las IPS de los clientes conectados
                        ips.addItem(ipIten);
                    }
                }

                //Cerramos el flujo de datos recibidos
                datosEntrada.close();
            }

        } catch (Exception e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }

    //Clase Interna encargada de gestionar los eventos del boton
    private class EnviarTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String datosIngresado = mensaje.getText();
            //System.out.println("Datos ingresados: " + datosIngresado);

            campoChat.append("\n" + mensaje.getText());

            try {

                /* Primero = para el envío de los datos
                 * ----------------------------------------------------------------
                 * * Socket configurado para envíar la información del servidor
                 * ----------------------------------------------------------------
                 */

                //Creacion del Socket - IP y puerto por donde está a la escucha el servidor
                Socket socket = new Socket("192.168.1.51", 9999);

                //Creacion del objeto que contiene todas las partes del mensaje
                DatosMensaje mensajeCliente = new DatosMensaje();
                mensajeCliente.setNick(nick.getText());
                mensajeCliente.setIpAddress(ips.getSelectedItem().toString());
                mensajeCliente.setMessage(mensaje.getText());

                //Iniciando el flujo de datos y pasando como referencia la ruta por donde circularan los datos
                ObjectOutputStream datosSalida = new ObjectOutputStream(socket.getOutputStream());

                //En el flujo de datos circulará el contenido del campo de texto
                datosSalida.writeObject(mensajeCliente);

                //Cerrar el flujo de datos para que se puedan enviar
                datosSalida.close();

            } catch (IOException e) {
                System.out.println("Se genero un error de tipo: " + e.getClass().getName());
                System.out.println("Motivo: " + e.getMessage());
                System.out.println("--------------------------------");
                throw new RuntimeException(e);
            }
        }
    }
}
