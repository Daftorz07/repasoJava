package jdbc.Introduccion;

import java.sql.*;

public class TestInsertUpdateDelete {

    public static void main(String[] args) {

        //Datos para la conexión
        String url = "jdbc:mysql://localhost:3306/usuarios";
        String username = "root";
        String password = "root";

        try {
            //1-Crear la conexión a la base de datos
            Connection newConnection = DriverManager.getConnection(url, username, password);

            //2-Crear objeto Statement para preparar la consulta a ejecutar
            Statement newStatement = newConnection.createStatement();

            //3-Ejecutar la instruccion SQL
            String sqlInsert = "INSERT INTO PERSONAS (NOMBRE, APELLIDO, EMAIL, TELEFONO) VALUES ('David 2', 'Torres', 'dftorres@sprc.com.co', '301-457-4364')";
            String sqlUpdate = "UPDATE PERSONAS SET NOMBRE = 'Ing David' WHERE ID_PERSONA = 25";
            String sqlDelete = "DELETE FROM PERSONAS WHERE ID_PERSONA = 18";

            newStatement.executeUpdate(sqlDelete);
            System.out.println("Transaction completed successfully");

        } catch (SQLException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }
}
