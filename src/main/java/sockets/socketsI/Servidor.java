package sockets.socketsI;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        MarcoServidor miMarco = new MarcoServidor();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoServidor extends JFrame implements Runnable {

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

            //El bucle infinito no tiene un efecto negativo, porque se está ejecutándose en un subproceso
            while (true) {
                //Aceptar las conexiones del cliente
                Socket socket = serverSocket.accept();
                //Crear el flujo de datos de entrada para recibir los datos que vienen del cliente por el serverSocket
                DataInputStream flujoEntrada = new DataInputStream(socket.getInputStream());
                //Datos recibidos
                String textoRecibido = flujoEntrada.readUTF();
                //Escribimos el texto
                areaTexto.append("\n" + textoRecibido);
                //Cerramos el flujo de datos
                flujoEntrada.close();
            }

        } catch (IOException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }
}
