package interfaces.persona;

public class Jefe extends Empleado implements Jefes {

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

    //Metodo de la interfaz Jefes
    @Override
    public String tomarDecision(String decision) {
        return "Un miembro de la direccion a tomado la decision de: " + decision;
    }

    //Metodo de la interfaz Trabajadores que hereda la interfaz Jefes
    @Override
    public double estable_bonus(double gratificacion) {

        double prima = 2000000;
        return Trabajadores.BONUS_BASE + prima + gratificacion;
    }

    @Override
    public int getSalario() {
        int sueldoJefe = super.getSalario();
        return sueldoJefe + this.incentivo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        sb.append('\n' + "Datos del padre: ").append(super.toString());
        sb.append('\n');
        sb.append("Datos del Hijo: { ");
        sb.append("incentivo = ").append(incentivo);
        sb.append(" }");
        return sb.toString();
    }
}
