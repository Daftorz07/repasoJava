package programacionGenerica.arrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListII {

    public static void main(String[] args) {

        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        listaEmpleados.add(new Empleado(30, "Blanqui", 2000000));
        listaEmpleados.add(new Empleado(29, "David", 4000000));
        listaEmpleados.add(new Empleado(50, "Carmen", 1000000));

        System.out.println("Contenido de la lista:");
        for (Empleado empleado : listaEmpleados) {
            System.out.println(" -> " + empleado);
        }

        System.out.println("\n--------------------------------\n");

        //Creando el Iterador
        Iterator <Empleado> iteradorEmpleados = listaEmpleados.iterator();

        System.out.println("Elementos de la lista con Iterador:");
        while (iteradorEmpleados.hasNext()) {
            System.out.println(" -> Iterador: " + iteradorEmpleados.next());
        }
    }
}
