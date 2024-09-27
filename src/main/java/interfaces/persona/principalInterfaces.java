package interfaces.persona;

import java.util.Arrays;

public class principalInterfaces {

    public static void main(String[] args) {

        //Arregla de personas
        Empleado[] listadoPersonas = new Empleado[5];

        Empleado empleado1 = new Empleado("David Torres", 3800000, 2022, 4, 1);
        Empleado empleado2 = new Empleado("Jose Torres", 6800000, 2023, 2, 1);
        Empleado empleado3 = new Empleado("Lia Torres", 5800000, 2021, 5, 1);
        Empleado empleado4 = new Empleado("Dairo Torres", 9000000, 1998, 1, 1);
        Empleado empleado5 = new Empleado("Carmen Benitez", 2500000, 2000, 6, 1);

        listadoPersonas[0] = empleado1;
        listadoPersonas[1] = empleado2;
        listadoPersonas[2] = empleado3;
        listadoPersonas[3] = empleado4;
        listadoPersonas[4] = empleado5;

        //Ordenado el array de objetos - para poder aplicar el metodo sort, es necesario que se implemente la interfaz comparable
        Arrays.sort(listadoPersonas);

        for (Persona p : listadoPersonas) {
            System.out.println(p.descripcionPersona());
        }

        System.out.println("--------------------------------");

        Empleado coordinadorSistemas = new Jefe("Yeixel Yemail", 25000000, 1994, 1, 1);

        System.out.println("Bono Jefe,  " + coordinadorSistemas.getNombrePersona() + " es de:" +
                " " + coordinadorSistemas.estable_bonus(5000000));

        System.out.println("Bono Empleado,  " + empleado1.getNombrePersona() + " es de: "
                + empleado1.estable_bonus(2000000));

        System.out.println("--------------------------------");


        Comparable ejemplo = coordinadorSistemas;

        if (coordinadorSistemas instanceof Empleado) {
            System.out.println("Es de tipo Jefe");
        }

        if (ejemplo instanceof Comparable) {
            System.out.println("Implementa la interfaz comparable");
        }

        System.out.println("--------------------------------");

        //Aplicando mi propia interfaz
        Jefe directoSistemas = new Jefe("Eduardo Bustamente", 25000000, 1994, 1, 1);
        System.out.println(directoSistemas.tomarDecision("Subir el salario de todos los que tienen 2 años en la empresa"));


    }
}
