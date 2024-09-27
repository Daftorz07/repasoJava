package programacionGenerica.herencia;

import programacionGenerica.clases.Pareja;

public class HerenciaGenerica {

    public static void main(String[] args) {

        //Herencia de clases convencional
        Empleado empleado = new Empleado("David Torres", 29, 3800);
        Jefe jefe = new Jefe("Blanqui", 30, 1800);
        Empleado empleadoJefe = jefe;

        //Herencia con clases Genericas
        ParejaGenerica <Empleado> empleadoGenerico = new ParejaGenerica<Empleado>();
        ParejaGenerica <Jefe> jefeGenerico = new ParejaGenerica<Jefe>();
        /*
        * ParejaGenerica <Empleado> empleadoJefeGenerico = jefeGenerico;
        * No es permitido porque, las clases genericas no pueden convertir tipos de datos
        */

        ParejaGenerica.imprimirTrabajador(jefeGenerico);





    }
}
