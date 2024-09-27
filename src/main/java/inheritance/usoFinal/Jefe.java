package inheritance.usoFinal;

public class Jefe extends Empleado {

    //Atributos de la clase
    private int incentivo = 1200000;

    public Jefe(String nombreEmpleado, int salario, int year, int month, int day) {
        super(nombreEmpleado, salario, year, month, day);
    }

    public int getIncentivo() {
        return incentivo;
    }

    public void setIncentivo(int incentivo) {
        this.incentivo = incentivo;
    }

    @Override
    public int getSalario() {
        int sueldoJefe = super.getSalario();
        return sueldoJefe + this.incentivo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        sb.append('\n' + "Datos clase padre: ").append(super.toString());
        sb.append('\n');
        sb.append("Datos clase Hijo: { ");
        sb.append("incentivo = ").append(incentivo);
        sb.append(" }");
        return sb.toString();
    }
}
