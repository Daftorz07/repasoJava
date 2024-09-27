package collectionsII.collectionsTreeSet.TreeSetIII;

public class Articulo {

    private final int numeroArticulo;
    private final String description;

    public Articulo(String description, int numeroArticulo) {
        this.description = description;
        this.numeroArticulo = numeroArticulo;
    }

    public String getDescription() {
        return description;
    }

    public int getNumeroArticulo() {
        return numeroArticulo;
    }
}
