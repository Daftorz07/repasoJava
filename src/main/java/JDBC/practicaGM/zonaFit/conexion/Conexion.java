package JDBC.practicaGM.zonaFit.conexion;

import JDBC.practicaGM.zonaFit.datos.ClienteDAO;
import JDBC.practicaGM.zonaFit.datos.IClienteDAO;
import JDBC.practicaGM.zonaFit.dominio.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

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
        IClienteDAO clienteDAO = new ClienteDAO();

        if (comm != null){
            System.out.println("Connection successfully");
        }else {
            System.out.println("Connection failed");
        }

        //Test listar Clientes
        System.out.println("*** Listar Clientes ***");
        List<Cliente> clientes = clienteDAO.listarCliente();
        //clientes.forEach(System.out::println);

        //Test Buscar Cliente por ID
        Cliente cliente = new Cliente(2); //Sobrecarga de constructores
        System.out.println("Cliente antes de la búsqueda: " + cliente);
        boolean clienteEncontrado = clienteDAO.buscarCliente(cliente);
        if (clienteEncontrado){
            System.out.println("Cliente encontrado: " + cliente);
        }else {
            System.out.println("Cliente no existe: " + cliente.getId());
        }
    }

}
