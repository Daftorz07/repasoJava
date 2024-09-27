package programacionGenerica.clases;

public class ParejaGenerica<T> {

    private T datoGenerico;

    public ParejaGenerica() {
        this.datoGenerico = null;
    }

    public void setDatoGenerico(T datoGenerico) {
        this.datoGenerico = datoGenerico;
    }

    public T getDatoGenerico() {
        return datoGenerico;
    }
}
