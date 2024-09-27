package collectionsII.iteradores;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentaUsuario {

    public static void main(String[] args) {

        //Creando los clientes
        Cliente clienteUno = new Cliente("David Torres", "0001", 1900000);
        Cliente clienteDos = new Cliente("Blanca Bayuelo", "0002", 900000);
        Cliente clienteTres = new Cliente("Messi", "0003", 90000000);
        Cliente clienteCuatro = new Cliente("Cristiano Ronaldo", "0004", 100000000);
        Cliente clienteCuatroCopy = new Cliente("Cristiano Ronaldo", "0004", 100000000);

        //Creando la colección - Una colección que los datos no se repita SET
        Set<Cliente> listaClientes = new HashSet<>();
        //Agregando los clientes a la colección
        listaClientes.add(clienteUno);
        listaClientes.add(clienteDos);
        listaClientes.add(clienteTres);
        listaClientes.add(clienteCuatro);
        listaClientes.add(clienteCuatroCopy);

        /*
        * Para evitar que se agreguen dos clientes con el mismo número de cuenta, como se vio en el ejemplo dos,
        * es necesario sobreescribir el metodo y especificar al momento de generar el Override, cúal es el criterio
        * por el cual se evaluara la comparación al momento de insertar el cliente en la colección.
        */

        //Recorrer la colección con bucle
        System.out.println("Recorriendo con un bucle FOR:");
        for(Cliente cliente : listaClientes){
            System.out.println("-> " + cliente.toString());
        }

        /*
        * iterator(): devuelve un objeto iterador de la colección
        */

        //Recorrer la colección con un Iterador
        Iterator<Cliente> itClientes = listaClientes.iterator();
        while (itClientes.hasNext()){
            String cliente = itClientes.next().getNombre();
            if (cliente.equals("Messi")){
                itClientes.remove();
            }
        }

        Iterator<Cliente> itClientes2 = listaClientes.iterator();
        System.out.println("\nRecorriendo con un Iterador:");
        while (itClientes2.hasNext()){
            String nombreCliente = itClientes2.next().getNombre();
            System.out.println("-> El nombre del cliente es: " + nombreCliente);
        }
    }
}
