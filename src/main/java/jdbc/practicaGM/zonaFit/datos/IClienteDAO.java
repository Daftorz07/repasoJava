package jdbc.practicaGM.zonaFit.datos;



import jdbc.practicaGM.zonaFit.dominio.Cliente;

import java.util.List;

public interface IClienteDAO {

    List<Cliente> listarCliente();
    boolean buscarClienteID(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
}
