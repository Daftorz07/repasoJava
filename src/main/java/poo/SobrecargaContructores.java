package poo;

public class SobrecargaContructores {

    public static void main(String[] args) {

        Empleado[] empleados = new Empleado[2];

        empleados[0] = new Empleado("David Torres");
        empleados[1] = new Empleado("Blanca Bayuelo", "Atencion al cliente", "Pacaribe");

        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }
}

class Empleado {

    String nombreEmpleado;
    String cargoEmpleado;
    String nombreEmpresa;

    //Constructor con argumentos
    Empleado(String nombreEmpleado, String cargoEmpleado, String nombreEmpresa) {
        this.nombreEmpleado = nombreEmpleado;
        this.cargoEmpleado = cargoEmpleado;
        this.nombreEmpresa = nombreEmpresa;
    }

    //Constructor con valores predeterminados
    Empleado(String nombreEmpleado) {
        // Se referencia al otro constructor por medio del this
        this(nombreEmpleado, "Soporte", "SPRC");
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", cargoEmpleado='" + cargoEmpleado + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                '}';
    }
}
