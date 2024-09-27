package collectionsII.collectionsLinkedList.linkedListII;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListaEnlazada {

    public static void main(String[] args) {

        LinkedList<String> paises = new LinkedList<String>();
        paises.add("España");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Peru");

        LinkedList<String> capitales = new LinkedList<String>();
        capitales.add("Madrid");
        capitales.add("Bogota");
        capitales.add("Ciudad de Mexico");
        capitales.add("Lima");

        System.out.println("Lista de Países: " + paises);
        System.out.println("Lista de Capitales: " + capitales);

        ListIterator<String> iPaises = paises.listIterator();
        ListIterator<String> iCapitales = capitales.listIterator();

        while (iCapitales.hasNext()) {
            if (iPaises.hasNext()) {
                iPaises.next();
            }
            iPaises.add(iCapitales.next());
        }

        System.out.println("Listas combinados: " + paises);

        //Reiniciar al iterador
        iCapitales = capitales.listIterator();

        while (iCapitales.hasNext()) {
            iCapitales.next();
            if (iCapitales.hasNext()) {
                iCapitales.next();
                iCapitales.remove();
            }
        }
        System.out.println("Datos pares eliminados en la lista capitales: " + capitales);

        paises.removeAll(capitales);
        System.out.println("Capitales eliminadas: " + paises);
    }
}
