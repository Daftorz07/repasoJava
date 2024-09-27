package JDBC.practicaGuiadaPI;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class MarcoAplicacion extends JFrame {

    public MarcoAplicacion() throws HeadlessException {

        //Configuring the framework of the application.
        setSize(500, 400);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Consulta BBDD");

        //Panel for the table of Contents
        JPanel menus = new PanelAplicacion();
        add(menus);

        //Conexion to database
        Connection newConnection = Conexion.getConnection();

        if (newConnection != null) {
            System.out.println("Connection successfully");
        }else {
            System.out.println("Connection error");
        }



    }
}
