package sockets.chatI.servidor;

import sockets.chatI.cliente.DatosMensaje;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MarcoServidor extends JFrame implements Runnable {

    JTextArea areaTexto;

    public MarcoServidor() {

        setBounds(1200, 300, 280, 350);
        setTitle("Servidor");
        JPanel miLamina = new JPanel();
        miLamina.setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        miLamina.add(areaTexto, BorderLayout.CENTER);

        add(miLamina);
        setVisible(true);

        //Crear Hilo
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {
            //Creando el ServerSocket por donde se recibirá la información desde el cliente
            ServerSocket serverSocket = new ServerSocket(9999); //Escuchando por el puerto

            //Variable del tipo de con el que se crea el objeto que envía la información del cliente
            DatosMensaje datosRecibidos;

            String nick;
            String ip;
            String message;


            //El bucle infinito no tiene un efecto negativo, porque se está ejecutándose en un subproceso
            while (true) {

                /* Primero = Para recibir los datos desde el cliente
                * ----------------------------------------------------------------
                * * Socket configurado para recibir la información del cliente
                * ----------------------------------------------------------------
                */

                //Aceptar las conexiones del cliente
                Socket socket = serverSocket.accept();

                //Crear el flujo de datos de entrada para recibir los datos que vienen del cliente por el serverSocket
                ObjectInputStream datosEntrada = new ObjectInputStream(socket.getInputStream());

                //Datos recibidos
                datosRecibidos = (DatosMensaje) datosEntrada.readObject();
                nick = datosRecibidos.getNick();
                ip = datosRecibidos.getIpAddress();
                message = datosRecibidos.getMessage();

                //Escribimos el texto
                areaTexto.append("\n" + nick + ": " + message + " para: " + ip);

                /* Segundo = Para envíar los datos desde el servidor al destinatario
                 * --------------------------------------------------------------------------
                 * * Socket configurado para enviar la información recibida desde el cliente
                 * --------------------------------------------------------------------------
                 */

                //Creando el Socket que envía la información al destinatario
                Socket socketDestino = new Socket(ip, 9090);

                //Creando flujo de salida hacia el receptor
                ObjectOutputStream datosSalida = new ObjectOutputStream(socketDestino.getOutputStream());

                //Escribimos los datos que recibimos del cliente en el flujo de salida
                datosSalida.writeObject(datosRecibidos);

                //Cerramos el flujo de datos
                datosSalida.close();
                datosEntrada.close();
                socket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }
}
