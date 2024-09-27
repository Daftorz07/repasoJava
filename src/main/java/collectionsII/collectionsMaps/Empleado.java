package collectionsII.collectionsMaps;

public class Empleado {

    private String nombreEmpleado;
    private double salario;

    public Empleado(String nombreEmpleado, double salario) {
        this.nombreEmpleado = nombreEmpleado;
        this.salario = salario;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empleado { ");
        sb.append("nombreEmpleado = '").append(nombreEmpleado).append('\'');
        sb.append(", salario = ").append(salario);
        sb.append(" }");
        return sb.toString();
    }
}
