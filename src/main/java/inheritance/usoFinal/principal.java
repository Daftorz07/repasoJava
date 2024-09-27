package inheritance.usoFinal;

public class principal {

    public static void main(String[] args){

        Empleado[] arregloEmpleados = new Empleado[2];

        //Objeto de tipo empleado
        Empleado empleado = new Empleado("David Torres", 3800000);

        //Objeto de tipo jefe extiende de empleado
        Jefe jefe = new Jefe("David", 5800000, 2020, 12, 7);
        jefe.setIncentivo(1200000);

        //Cargando los objetos en el arreglo
        arregloEmpleados[0] = empleado;
        arregloEmpleados[1] = jefe;

        //Recorriendo listado de objetos
        for (Empleado elemento : arregloEmpleados){
            System.out.println("Información del Objeto: " + elemento);

            if (elemento.getClass() == Jefe.class){
                System.out.println("EL empleado es un jefe, por lo que tiene un incentivo de: " + ((Jefe) elemento).getIncentivo());
                System.out.println("Salario del la jefe: " + elemento.getSalario());
            }

            System.out.println(" ");
        }

        //Objeto Final Director
        Director director = new Director("Dairo Torres", 12000000, 1992, 1, 7);
        System.out.println(director.toString());
        System.out.println(director.getSalario());
    }
}
