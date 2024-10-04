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

    // -----------------------------------------------------------------------------------
    // listar Clientes -------------------------------------------------------------------
    // -----------------------------------------------------------------------------------
    @Override
    public List<Cliente> listarCliente() {

        //Flujo de datos SQL
        PreparedStatement newPreparedStatement;
        ResultSet newResultSet;
        Connection connection;

        //Obtenemos la conexion
        connection = Conexion.getConexion();

        //Lista clientes
        List<Cliente> clientes = new ArrayList<>();

        //SQL a ejecutar
        String sql = "SELECT * FROM CLIENTES ORDER BY ID_CLIENTE";

        try {
            //Preparamos y ejecutamos la sentencia SQL
            newPreparedStatement = connection.prepareStatement(sql);
            newResultSet = newPreparedStatement.executeQuery();

            //Recorriendo el ResultSet
            while (newResultSet.next()) {

                //Objeto de tipo cliente
                Cliente cliente = new Cliente();

                //Seteando los datos del cliente
                cliente.setId(newResultSet.getInt("id_cliente"));
                cliente.setUserName(newResultSet.getString("userName"));
                cliente.setLastName(newResultSet.getString("lastName"));
                cliente.setMembership(newResultSet.getInt("membership"));

                //Agregando el cliente a la lista de clientes
                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Se genero un error al intentar listar los clientes: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);

        } finally {
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

    // -----------------------------------------------------------------------------------
    // Buscar Clientes -------------------------------------------------------------------
    // -----------------------------------------------------------------------------------
    @Override
    public boolean buscarClienteID(Cliente cliente) {

        //Flujo de datos SQL
        PreparedStatement newPreparedStatement;
        ResultSet newResultSet;
        Connection connection;

        connection = Conexion.getConexion();
        String sql = "SELECT * FROM CLIENTES WHERE ID_CLIENTE = ?";

        try {

            newPreparedStatement = connection.prepareStatement(sql);
            newPreparedStatement.setInt(1, cliente.getId());

            newResultSet = newPreparedStatement.executeQuery();

            if (newResultSet.next()) {
                cliente.setUserName(newResultSet.getString("userName"));
                cliente.setLastName(newResultSet.getString("lastName"));
                cliente.setMembership(newResultSet.getInt("membership"));
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar cliente por id: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);

        } finally {
            try {
                //El cierre de la conexion puede generar una exception
                connection.close();
            } catch (SQLException e) {
                System.out.println("Se genero un error el intentar cerrar la conexion: " + e.getClass().getName());
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    // -----------------------------------------------------------------------------------
    // Agregar Clientes ------------------------------------------------------------------
    // -----------------------------------------------------------------------------------
    @Override
    public boolean agregarCliente(Cliente cliente) {

        //Flujo de datos SQL
        PreparedStatement newPreparedStatement;
        Connection connection;
        connection = Conexion.getConexion();

        // Parametros Posicionales
        String sqlInsert = "INSERT INTO CLIENTES(userName, lastName, membership) VALUES (?,?,?)";

        try {
            //Se carga la consulta SQL
            newPreparedStatement = connection.prepareStatement(sqlInsert);

            //Seteando los datos SQL
            newPreparedStatement.setString(1, cliente.getUserName());
            newPreparedStatement.setString(2, cliente.getLastName());
            newPreparedStatement.setInt(3, cliente.getMembership());

            //Ejecutando la consulta
            newPreparedStatement.execute();

            return true;

        }catch (Exception e) {
            System.out.println("Error al intentar realizar insert del cliente: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);

        } finally {
            try {
                //El cierre de la conexion puede generar una exception
                connection.close();
            } catch (SQLException e) {
                System.out.println("Se genero un error el intentar cerrar la conexion: " + e.getClass().getName());
                throw new RuntimeException(e);
            }
        }
        //return false;
    }

    // -----------------------------------------------------------------------------------
    // Actualizar Clientes ---------------------------------------------------------------
    // -----------------------------------------------------------------------------------
    @Override
    public boolean modificarCliente(Cliente cliente) {

        //Flujo de datos SQL
        PreparedStatement newPreparedStatement;
        Connection connection;
        connection = Conexion.getConexion();

        // Parametros Posicionales
        String sqlUpdate = "UPDATE CLIENTES SET userName = ?, lastName = ?, membership = ? WHERE id_cliente = ?";

        try {
            //Se carga la consulta SQL
            newPreparedStatement = connection.prepareStatement(sqlUpdate);

            //Seteando los datos SQL
            newPreparedStatement.setString(1, cliente.getUserName());
            newPreparedStatement.setString(2, cliente.getLastName());
            newPreparedStatement.setInt(3, cliente.getMembership());
            newPreparedStatement.setInt(4, cliente.getId());

            //Ejecutando la consulta
            newPreparedStatement.execute();

            return true;

        }catch (Exception e) {
            System.out.println("Error al intentar actualizar cliente: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);

        } finally {
            try {
                //El cierre de la conexion puede generar una exception
                connection.close();
            } catch (SQLException e) {
                System.out.println("Se genero un error el intentar cerrar la conexion: " + e.getClass().getName());
                throw new RuntimeException(e);
            }
        }
    }

    // -----------------------------------------------------------------------------------
    // Eliminar Clientes -----------------------------------------------------------------
    // -----------------------------------------------------------------------------------
    @Override
    public boolean eliminarCliente(Cliente cliente) {

        //Flujo de datos SQL
        PreparedStatement newPreparedStatement;
        Connection connection;
        connection = Conexion.getConexion();

        // Parametros Posicionales
        String sqlDelete = "DELETE FROM CLIENTES WHERE id_cliente = ?";

        try {
            //Se carga la consulta SQL
            newPreparedStatement = connection.prepareStatement(sqlDelete);

            //Seteando los datos SQL
            newPreparedStatement.setInt(1, cliente.getId());

            //Ejecutando la consulta
            newPreparedStatement.execute();

            return true;

        }catch (Exception e) {
            System.out.println("Error al intentar eliminar cliente: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);

        } finally {
            try {
                //El cierre de la conexion puede generar una exception
                connection.close();
            } catch (SQLException e) {
                System.out.println("Se genero un error el intentar cerrar la conexion: " + e.getClass().getName());
                throw new RuntimeException(e);
            }
        }
    }
}
