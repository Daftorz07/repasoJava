package serializacion;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private double salario;
    private Date fechaContrato;

    public Empleado(String name, double salario, int year, int month, int day) {
        this.name = name;
        this.salario = salario;

        GregorianCalendar calendario = new GregorianCalendar(year, month - 1, day);
        this.fechaContrato = calendario.getTime();
    }

    public double getSalario() {
        return salario;
    }

    public String getName() {
        return name;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void subirSalario(double porcentaje) {
        double aumento = salario * porcentaje / 100;
        salario += aumento;
    }

    @Override
    public String toString() {
        return "Empleado { " + "fecha Contrato = " + fechaContrato +
                ", name = " + name +
                ", salario = " + salario +
                "' }'";
    }
}
