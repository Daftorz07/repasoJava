package collectionsII.collectionsMaps;

import java.util.HashMap;
import java.util.Map;

public class UsoMaps {

    public static void main(String[] args) {

        //Instancia de objetos de tipo Empleado
        Empleado empleado1 = new Empleado("David Torres", 4800);
        Empleado empleado2 = new Empleado("Blanca Bayuelo", 2800);
        Empleado empleado3 = new Empleado("Eliminar", 0);

        //Creando la colección Map de tipo HashMap
        HashMap<String, Empleado> mapaEmpleados = new HashMap<String, Empleado>();

        //Agregando los datos al mapa
        mapaEmpleados.put("1051", empleado1);
        mapaEmpleados.put("1052", empleado2);
        mapaEmpleados.put("1053", empleado3);

        //Recorriendo el mapa a partir de las claves
        System.out.println("Listado de elementos en el mapa:");
        for (String key : mapaEmpleados.keySet()) {
            System.out.println("-> Clave: " + key + " - Valor: " + mapaEmpleados.get(key));
        }

        //Eliminar elemento del mapa
        mapaEmpleados.remove("1053");

        System.out.println("\nElementos posterior a la eliminación:");
        for (String key : mapaEmpleados.keySet()) {
            System.out.println("-> Clave: " + key + " - Valor: " + mapaEmpleados.get(key));
        }

        /*
         * Cuando se usa el metodos entrySet(), lo que realmente ocurre es que el valor que retorna Map.Entry<K,V>
         * guarda los dos datos en una misma variable, y con los metodos disponibles podemos extraer la información
         * que se requiere.
         */

        //Recorrer usando las entradas (clave-valor)
        System.out.println("\nInformación Clave: Valor / entrySet()");
        for (Map.Entry<String, Empleado> entrada : mapaEmpleados.entrySet()) {
            System.out.println("-> Clave: " + entrada.getKey() + " - Valor: " + entrada.getValue());
        }
    }
}
