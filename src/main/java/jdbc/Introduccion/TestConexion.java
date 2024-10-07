package jdbc.Introduccion;

import java.sql.*;

public class TestConexion {

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
            String sql = "SELECT * FROM PERSONAS";
            ResultSet newResultSet = newStatement.executeQuery(sql);

            //4-Leer el ResultSet
            while (newResultSet.next()) { //Mientras exista un siguiente registro
                //Se puede pasar el nombre del campo a la ubicación de la columna siendo la primera la 1
                System.out.println( newResultSet.getInt("id_persona") + " - "
                        + newResultSet.getString("nombre") + " - "
                        + newResultSet.getString("apellido") + " - "
                        + newResultSet.getString("email") + " - "
                        + newResultSet.getString(5) + " - "//Campo telefono
                        + newResultSet.getDate("fecha_creacion")); //Campo telefono
            }

        } catch (SQLException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }
}
