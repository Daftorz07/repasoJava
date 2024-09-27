package inheritance.clasesAbstractas;

public class principalAbstract {

    public static void main(String[] args){

        //Arregla de personas
        Persona [] listadoPersonas = new Persona[2];

        Empleado empleado = new Empleado("David Torres", 3800000, 2022, 4, 1);
        Alumno alumno = new Alumno("David Torres Benitez", "Especialista en Ingeniería de Software");

        listadoPersonas[0] = empleado;
        listadoPersonas[1] = alumno;

        for (Persona p : listadoPersonas){
            System.out.println(p.descripcionPersona());
        }



    }
}
