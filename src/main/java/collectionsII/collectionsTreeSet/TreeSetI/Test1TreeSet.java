package collectionsII.collectionsTreeSet.TreeSetI;

import java.util.TreeSet;

public class Test1TreeSet {

    public static void main(String[] args) {

        //Creando colección de tipo TreeSet
        TreeSet<String> ordenPersonas = new TreeSet<>();

        ordenPersonas.add("Dairo Torres");
        ordenPersonas.add("Carmen Benitez");
        ordenPersonas.add("David Torres Benitez");

        System.out.println("Nombres ordenados: (Tipo String)");
        for (String persona : ordenPersonas) {
            System.out.println("-> " + persona);
        }

        //Ordenando objetos construidos
        Articulo articulo1 = new Articulo("Balones de futbol", 10);
        Articulo articulo2 = new Articulo("Uniformes Real Madrid", 3);
        Articulo articulo3 = new Articulo("Trofeo de la Champions", 15);

        TreeSet<Articulo> ordenArticulos = new TreeSet<>();
        ordenArticulos.add(articulo1);
        ordenArticulos.add(articulo2);
        ordenArticulos.add(articulo3);

        System.out.println("\nArticulos ordenados: (Tipo Articulo)");
        for (Articulo articulo : ordenArticulos){
            System.out.println("-> " + articulo.getDescription() + ": " + articulo.getNumeroArticulo());
        }



    }
}
