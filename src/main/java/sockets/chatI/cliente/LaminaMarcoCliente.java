package sockets.chatI.cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LaminaMarcoCliente extends JPanel implements Runnable {

    private JTextField mensaje;
    private JButton btnEnviar;

    private JTextArea campoChat;
    private JTextField nick, ip;

    public LaminaMarcoCliente() {

        JLabel texto = new JLabel("Cliente: ");
        nick = new JTextField(5);
        add(texto);
        add(nick);

        JLabel ipl = new JLabel("IP: ");
        ip = new JTextField(7);
        add(ipl);
        add(ip);

        campoChat = new JTextArea(12, 20);
        add(campoChat);

        mensaje = new JTextField(20);
        add(mensaje);

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
                campoChat.append("\n" + nick + ": " + message + " para: " + ip);

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
            System.out.println("Datos ingresados: " + datosIngresado);

            campoChat.append("\n" + mensaje.getText());

            try {

                /* Primero = para el envío de los datos
                 * ----------------------------------------------------------------
                 * * Socket configurado para envíar la información del servidor
                 * ----------------------------------------------------------------
                 */

                //Creacion del Socket
                Socket socket = new Socket("192.168.1.51", 9999);

                //Creacion del objeto que contiene todas las partes del mensaje
                DatosMensaje mensajeCliente = new DatosMensaje();
                mensajeCliente.setNick(nick.getText());
                mensajeCliente.setIpAddress(ip.getText());
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
