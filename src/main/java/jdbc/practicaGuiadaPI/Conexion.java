package jdbc.practicaGuiadaPI;

import java.sql.*;

public class Conexion {

    public static Connection getConnection() {

        //Datos para la conexión
        String url = "jdbc:mysql://localhost:3306/usuarios";
        String username = "root";
        String password = "root";

        Connection newConnection = null;

        try {
            //1-Crear la conexión a la base de datos
            newConnection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }

        return newConnection;
    }
}
