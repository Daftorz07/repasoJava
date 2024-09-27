package serializacion;

public class Administrador extends Empleado{

    private static final long serialVersionUID = 1L;

    private double incentivo;

    public Administrador(String name, double salario, int year, int month, int day) {
        super(name, salario, year, month, day);
        this.incentivo = 0;
    }

    @Override
    public double getSalario() {
        double salarioBase = super.getSalario();
        return salarioBase + incentivo;
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    @Override
    public String toString() {
        return super.toString() +  " Administrador{ " + "incentivo = " + incentivo + "' }'";
    }
}
