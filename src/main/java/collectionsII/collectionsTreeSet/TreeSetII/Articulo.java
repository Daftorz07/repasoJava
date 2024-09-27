package collectionsII.collectionsTreeSet.TreeSetII;

import java.util.Comparator;

public class Articulo implements Comparable<Articulo>, Comparator<Articulo> {

    private int numeroArticulo;
    private String description;

    public Articulo() {

    }

    public Articulo(String description, int numeroArticulo) {
        this.description = description;
        this.numeroArticulo = numeroArticulo;
    }

    // Orden los artículos en función del número de artículos
    @Override
    public int compareTo(Articulo objArticulo) {
        return numeroArticulo - objArticulo.numeroArticulo;
    }

    /*
     * Metodo de la interfaz Comparator, el cual recibe dos objetos del mismo tipo y los compara por el criterio
     * que se le especifique, como el criterio es un string, la clase String implementa Comparable, por lo que podemos
     * internamente utilizar el metodo compareTo para realizar la validacion.
     */
    @Override
    public int compare(Articulo art1, Articulo art2) {
        String descriptionArt1 = art1.getDescription();
        String descriptionArt2 = art2.getDescription();
        return descriptionArt1.compareTo(descriptionArt2);
    }

    public String getDescription() {
        return description;
    }

    public int getNumeroArticulo() {
        return numeroArticulo;
    }
}
