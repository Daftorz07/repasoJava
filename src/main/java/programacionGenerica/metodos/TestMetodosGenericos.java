package programacionGenerica.metodos;

import java.util.GregorianCalendar;

public class TestMetodosGenericos {

    public static void main(String[] args) {

        String[] nombres = {"David", "Fernando", "Torres", "Benitez"};
        System.out.println(MetodosGenericos.numElementos(nombres));

        Empleado[] empleados = new Empleado[2];
        empleados[0] = new Empleado(29, "David Torres", 3800000);
        empleados[1] = new Empleado(30, "Blanqui Bayuelo", 1800000);
        System.out.println(MetodosGenericos.numElementos(empleados));

        System.out.println("Elemento menor del array nombre: " + MetodosGenericos.getMenor(nombres));
        //System.out.println("Elemento menor del array empleados: " + MetodosGenericos.getMenor(empleados));

        GregorianCalendar[] fechas = {
                new GregorianCalendar(1994,8,7),
                new GregorianCalendar(1994,7,29)
        };

        System.out.println("La fecha menor es: " + MetodosGenericos.getMenor(fechas));

    }
}
