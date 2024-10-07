package jdbc.consultasPreparadas;

import java.sql.*;

public class consultasPreparadasI {

    public static void main(String[] args) {

        //Datos para la conexión
        String url = "jdbc:mysql://localhost:3306/usuarios";
        String username = "root";
        String password = "root";

        try {
            //1-Crear la conexión a la base de datos
            Connection newConnection = DriverManager.getConnection(url, username, password);

            //2-Preparamos la consulta SQL
            String sqlPreparada = "SELECT * FROM PERSONAS WHERE APELLIDO = ? OR ID_PERSONA = ? ";
            PreparedStatement newPreparedStatement = newConnection.prepareStatement(sqlPreparada);

            //2.1-Seteamos los parametros
            //El metodo de seteo debe ser acorde al tipo de datos de la columna en la base de datos
            newPreparedStatement.setString(1, "Torres");
            newPreparedStatement.setInt(2, 22);

            //3-Ejecutar la instruccion SQL
            ResultSet newResultSet = newPreparedStatement.executeQuery();

            //3.1-Recorremos los datos obtenido
            System.out.println("\nPrimera consulta: \n");
            while (newResultSet.next()) { //Mientras exista un siguiente registro
                //Se puede pasar el nombre del campo a la ubicación de la columna siendo la primera la 1
                System.out.println("-> " + newResultSet.getInt("id_persona") + " - "
                        + newResultSet.getString("nombre") + " - "
                        + newResultSet.getString("apellido") + " - "
                        + newResultSet.getString("email") + " - "
                        + newResultSet.getString(5) + " - "//Campo telefono
                        + newResultSet.getDate("fecha_creacion"));
            }

            //4-Cerrando el ResultSet
            newResultSet.close();

            /*
            * ------------------------------------------------
            * Reutilizando la consulta
            * ------------------------------------------------
            */

            System.out.println("\nReutilizando la consulta: \n");

            newPreparedStatement.setString(1, "Ronaldo");
            newPreparedStatement.setInt(2, 23);

            newResultSet = newPreparedStatement.executeQuery();

            while (newResultSet.next()) { //Mientras exista un siguiente registro
                //Se puede pasar el nombre del campo a la ubicación de la columna siendo la primera la 1
                System.out.println("-> " + newResultSet.getInt("id_persona") + " - "
                        + newResultSet.getString("nombre") + " - "
                        + newResultSet.getString("apellido") + " - "
                        + newResultSet.getString("email") + " - "
                        + newResultSet.getString(5) + " - "//Campo telefono
                        + newResultSet.getDate("fecha_creacion"));
            }

            newResultSet.close();


        } catch (SQLException e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }
}
