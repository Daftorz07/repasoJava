package collectionsI.arrayList;

import java.util.ArrayList;
import java.util.List;

public class RepesoArrayList {

    public static void main(String[] args) {

        List<String> listaMetas = new ArrayList<>();

        listaMetas.add("Comprar una casa");
        listaMetas.add("Tener un vehiculo");

        System.out.println("El numero de metas son: " + listaMetas.size());
        System.out.println("La meta es: " + listaMetas.get(1));

        System.out.println("Recorrido de metas: ");
        for (String meta : listaMetas) {
            System.out.println(meta);
        }

        List<Persona> listaPersonas = new ArrayList<>();

        Persona personaUno = new Persona("David Torres", 29);
        Persona personaDos = new Persona("Blanca Bayuelo", 29);

        listaPersonas.add(personaUno);
        listaPersonas.add(personaDos);

        System.out.println("Listado de personas: ");
        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }


    }
}
