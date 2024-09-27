package programacionGenerica.arrayList;

import java.util.ArrayList;

public class ArrayListI {

    public static void main(String[] args) {

        Empleado[] empleados = new Empleado[3];

        empleados[0] = new Empleado(30, "Blanqui", 2000000);
        empleados[1] = new Empleado(29, "David", 4000000);
        empleados[2] = new Empleado(50, "Carmen", 1000000);

        System.out.println("Contenido Array inicial:");
        for (Empleado empleado : empleados) {
            System.out.println(" -> Arreglo: " + empleado);
        }

        System.out.println("\n--------------------------------");

        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        listaEmpleados.ensureCapacity(3);

        listaEmpleados.add(new Empleado(30, "Blanqui", 2000000));
        listaEmpleados.add(new Empleado(29, "David", 4000000));
        listaEmpleados.add(new Empleado(50, "Carmen", 1000000));

        //Metodos de los Arrays List
        System.out.println("\nTamaño de la lista: " + listaEmpleados.size());
        listaEmpleados.trimToSize();

        listaEmpleados.set(0, new Empleado(28, "Jose Set", 7000000));
        System.out.println("Ultimo elemento de la lista es: " + listaEmpleados.get(2).toString() + "\n");

        //Contenido de la lista
        System.out.println("Contenido de la lista:");
        for (Empleado empleado : listaEmpleados) {
            System.out.println(" -> " + empleado);
        }

        //Copiar una lista a un Array
        System.out.println("\n--------------------------------\n");

        Empleado[] copiaListaArray = new Empleado[listaEmpleados.size()];
        listaEmpleados.toArray(copiaListaArray);

        System.out.println("Elementos copiados de la lista a un array:");
        for(Empleado empleado : copiaListaArray){
            System.out.println(" -> Empleado copia " + empleado);
        }

    }
}
