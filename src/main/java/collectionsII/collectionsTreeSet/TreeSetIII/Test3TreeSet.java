package collectionsII.collectionsTreeSet.TreeSetIII;

import java.util.TreeSet;

public class Test3TreeSet {

    public static void main(String[] args) {

        /*
         * Al TreeSet, al momento de construirlo, se le pasa la clase que implementa la interfaz Comparator,
         * lo que hace que internamente, vaya a la clase y verifique los criterios de ordenamiento en el metodo compare
         * Pero en este caso la clase que implemente la interfaz, no es la misma que crea los objetos, con lo cual
         * esta nueva clase solo se usa para ordenar los elementos de la lista implementando Comparator con su metodo
         * compare
         */

        //Ordenando objetos construidos
        Articulo articulo1 = new Articulo("Balones de futbol", 10);
        Articulo articulo2 = new Articulo("Uniformes Real Madrid", 3);
        Articulo articulo3 = new Articulo("Trofeo de la Champions", 15);

        System.out.println("\nArticulos ordenados: (Tipo Articulo) - Metodo compare desde la clase ComparadorArticulos");

        //Instancia de la clase que implemente Comparator
        ComparadorArticulos comparadorArticulos = new ComparadorArticulos();
        //Se pasa como parametro en el constructor del TreeSet la instancia de la clase anterior
        TreeSet<Articulo> articulosTreeSet = new TreeSet<Articulo>(comparadorArticulos);

        articulosTreeSet.add(articulo1);
        articulosTreeSet.add(articulo2);
        articulosTreeSet.add(articulo3);

        for (Articulo articulo : articulosTreeSet){
            System.out.println("-> " + articulo.getDescription() + ": " + articulo.getNumeroArticulo());
        }
    }
}