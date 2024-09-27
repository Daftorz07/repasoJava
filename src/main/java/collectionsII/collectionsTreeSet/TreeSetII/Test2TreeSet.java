package collectionsII.collectionsTreeSet.TreeSetII;

import java.util.TreeSet;

public class Test2TreeSet {

    public static void main(String[] args) {

        //Creando colección de tipo TreeSet
        TreeSet<String> ordenPersonas = new TreeSet<>();

        ordenPersonas.add("Dairo Torres");
        ordenPersonas.add("Carmen Benitez");
        ordenPersonas.add("David Torres Benitez");

        System.out.println("Nombres ordenados: (Tipo String) - Metodo compareTo, implementado por la clase String");
        for (String persona : ordenPersonas) {
            System.out.println("-> " + persona);
        }

        //Ordenando objetos construidos
        Articulo articulo1 = new Articulo("Balones de futbol", 10);
        Articulo articulo2 = new Articulo("Uniformes Real Madrid", 3);
        Articulo articulo3 = new Articulo("Trofeo de la Champions", 15);

        TreeSet<Articulo> ordenArticulosNum = new TreeSet<>();
        ordenArticulosNum.add(articulo1);
        ordenArticulosNum.add(articulo2);
        ordenArticulosNum.add(articulo3);

        System.out.println("\nArticulos ordenados: (Tipo Articulo) - Metodo compareTo");
        for (Articulo articulo : ordenArticulosNum){
            System.out.println("-> " + articulo.getDescription() + ": " + articulo.getNumeroArticulo());
        }

        System.out.println("\nArticulos ordenados: (Tipo Articulo) - Metodo compare");

        Articulo comparadorArticulo = new Articulo();
        /*
        * Al TreeSet, al momento de construirlo, se le pasa la clase que implementa la interfaz Comparator,
        * lo que hace que internamente, vaya a la clase y verifique los criterios de ordenamiento en el metodo compare
        */
        TreeSet<Articulo> ordenArticulosString = new TreeSet<Articulo>(comparadorArticulo);

        ordenArticulosString.add(articulo1);
        ordenArticulosString.add(articulo2);
        ordenArticulosString.add(articulo3);

        for (Articulo articulo : ordenArticulosString){
            System.out.println("-> " + articulo.getDescription() + ": " + articulo.getNumeroArticulo());
        }
    }
}