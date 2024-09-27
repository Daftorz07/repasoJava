package collectionsI.maps;

import java.util.HashMap;
import java.util.Map;

public class RepasoHashMap {

    public static void main(String[] args){

        //Definición de la collection
        Map<Integer, String> mapaEmpleado = new HashMap<>();

        //Agregando datos al map
        mapaEmpleado.put(1052, "David Torres");
        mapaEmpleado.put(1053, "Blanca Bayuelo");

        //Verifica que el valor este dentro del mapa
        boolean contieneValor = mapaEmpleado.containsValue("David Torres");
        System.out.println(contieneValor);

        //Verifica que la clave este dentro del mapa
        boolean contieneClave = mapaEmpleado.containsKey(1052);
        System.out.println(contieneClave);

        //Valores del mapa
        System.out.println(mapaEmpleado.values());

        //Claves del mapa
        System.out.println(mapaEmpleado.keySet());

        //Valor del mapa a partir de la clave
        String valorMapa = mapaEmpleado.get(1053);
        System.out.println("El empleado es: " + valorMapa);

        //Eliminar un valor del mapa
        mapaEmpleado.put(1054, "Elemento de prueba");
        System.out.println("Valor eliminado: " + mapaEmpleado.remove(1054));
        System.out.println(mapaEmpleado.values());




    }
}
