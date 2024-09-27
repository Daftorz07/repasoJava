package sockets.chatII.cliente;

import sockets.chatI.cliente.DatosMensaje;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class EnvioOnline extends WindowAdapter {

    public void windowOpened(WindowEvent ev) {

        /*
         * --------------------------------------------------------------------------
         * * Envio de señal Online hacia el servidor para que este la distribuya en
         * * todos los clientes disponibles en la red
         * * Instancia en la clase: MarcoCliente
         * --------------------------------------------------------------------------
         */

        try {
            //Configurando el socket
            String ipServer = "192.168.1.51";
            Socket newSocket = new Socket(ipServer, 9999);

            //Configurando el objeto a enviar
            DatosMensaje datosConexion = new DatosMensaje();
            datosConexion.setMessage(" online");

            //Creando el Flujo de datos hacia el servidor
            ObjectOutputStream datosSalidaOnline = new ObjectOutputStream(newSocket.getOutputStream());

            //Escribiendo en el flujo el paquete a enviar
            datosSalidaOnline.writeObject(datosConexion);

            //Cerrando el socket
            newSocket.close();

        } catch (Exception e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }
}
