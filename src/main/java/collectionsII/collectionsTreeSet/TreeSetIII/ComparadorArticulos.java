package collectionsII.collectionsTreeSet.TreeSetIII;

import java.util.Comparator;

public class ComparadorArticulos implements Comparator<Articulo>{

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
}
