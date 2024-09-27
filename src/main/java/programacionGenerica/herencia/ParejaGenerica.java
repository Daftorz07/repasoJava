package programacionGenerica.herencia;

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

    /*
     * El metodo se encarga de imprimir datos del objeto generico tipo empleado,
     * pero también todos los objetos que extiendan da la clase Empleado.
     * Es decir, de todas las subclases de empleado
     */

    public static void imprimirTrabajador(ParejaGenerica<? extends Empleado> objetoGenerico) {
        Empleado datoEmpleado = objetoGenerico.getDatoGenerico();
        System.out.println(datoEmpleado);
    }
}
