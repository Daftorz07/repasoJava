package JDBC.practicaGM.zonaFit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion() {

        Connection newConnection = null;
        String database = "zonaFitDB";
        String url = "jdbc:mysql://localhost:3306/" + database;
        String username = "root";
        String password = "root";

        try {
            //Cargando la clase en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Estableciendo la conexion a la base de datos
            newConnection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }

        return newConnection;
    }

    public static void main(String[] args) {

        Connection comm = Conexion.getConexion();

        if (comm != null){
            System.out.println("Connection successfully");
        }else {
            System.out.println("Connection failed");
        }
    }

}
