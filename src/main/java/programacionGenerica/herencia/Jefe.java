package programacionGenerica.herencia;

public class Jefe extends Empleado {

    public Jefe(String nombre, int edad, double salario) {
        super(nombre, edad, salario);
    }

    public double incentivo(double incentivo) {
        return incentivo;
    }
}
