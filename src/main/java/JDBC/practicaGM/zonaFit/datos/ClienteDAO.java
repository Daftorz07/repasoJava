package JDBC.practicaGM.zonaFit.datos;


import JDBC.practicaGM.zonaFit.conexion.Conexion;
import JDBC.practicaGM.zonaFit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    //Flujo de datos SQL
    PreparedStatement newPreparedStatement;
    ResultSet newResultSet;
    Connection connection;

    @Override
    public List<Cliente> listarCliente() {

        //Obtenemos la conexion
        connection = Conexion.getConexion();

        //Lista clientes
        List<Cliente> clientes = new ArrayList<>();

        //SQL a ejecutar
        String sql = "SELECT * FROM CLIENTES ORDER BY ID";

        try {
            //Preparamos y ejecutamos la sentencia SQL
            newPreparedStatement = connection.prepareStatement(sql);
            newResultSet = newPreparedStatement.executeQuery();

            //Recorriendo el ResultSet
            while (newResultSet.next()) {

                //Objeto de tipo cliente
                Cliente cliente = new Cliente();

                //Seteando los datos del cliente
                cliente.setId(newResultSet.getInt("id"));
                cliente.setUserName(newResultSet.getString("userName"));
                cliente.setLastName(newResultSet.getString("lastName"));
                cliente.setMembership(newResultSet.getInt("membership"));

                //Agregando el cliente a la lista de clientes
                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);

        }finally {
            try {
                //El cierre de la conexion puede generar una exception
                connection.close();
            } catch (SQLException e) {
                System.out.println("Se genero un error de tipo: " + e.getClass().getName());
                throw new RuntimeException(e);
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;
    }
}
