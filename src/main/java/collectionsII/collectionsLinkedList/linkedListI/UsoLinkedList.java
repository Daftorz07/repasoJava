package collectionsII.collectionsLinkedList.linkedListI;

import java.util.LinkedList;
import java.util.ListIterator;

public class UsoLinkedList {

    public static void main(String[] args) {

        /*
         * Este tipo de Colecciones, se pueden crear, creando la colección y después especificando el tipo de colección
         * Pero también se puede crear la colección del tipo a usar directamente
         *
         * List<Persona> personas = new LinkedList<Persona>();
         * LinkedList<Persona> listaPersonas = new LinkedList<Persona>();
         */

        //Creando la lista enlazada
        LinkedList<Persona> listaPersonas = new LinkedList<Persona>();

        Persona personaUno = new Persona("David Torres", 30);
        Persona personaDos = new Persona("José Torres", 27);
        Persona personaTres = new Persona("Lia Torres", 24);
        Persona personaCuatro = new Persona("Dairo Torres", 55);
        Persona personaCinco = new Persona("Carmen Benitez", 50);

        listaPersonas.add(personaUno);
        listaPersonas.add(personaDos);
        listaPersonas.add(personaTres);
        listaPersonas.add(personaCuatro);
        listaPersonas.add(personaCinco);

        System.out.println("Tamaño de la lista: " + listaPersonas.size());

        System.out.println("\nNombre de las personas de la lista: For-each");
        for (Persona persona : listaPersonas) {
            System.out.println("-> " + persona.getName());
        }

        //Creando el iterador de la lista
        ListIterator<Persona> iterator = listaPersonas.listIterator();
        Persona personaSeis = new Persona("Blanqui Bayuelo", 30);

        //Nos movemos en el iterador, y en la posición actual se agrega una nueva persona
        iterator.next();
        iterator.add(personaSeis);

        System.out.println("\nListado de personas después de agregar una mas:");
        for (Persona persona : listaPersonas) {
            System.out.println("-> " + persona.getName());
        }
    }
}
