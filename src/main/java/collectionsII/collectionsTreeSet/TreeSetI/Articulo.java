package collectionsII.collectionsTreeSet.TreeSetI;

public class Articulo implements Comparable<Articulo> {

    private int numeroArticulo;
    private String description;

    public Articulo(String description, int numeroArticulo) {
        this.description = description;
        this.numeroArticulo = numeroArticulo;
    }

    // Orden los artículos en función del número de artículos
    @Override
    public int compareTo(Articulo objArticulo) {
        return numeroArticulo - objArticulo.numeroArticulo;
    }

    public String getDescription() {
        return description;
    }

    public int getNumeroArticulo() {
        return numeroArticulo;
    }
}
