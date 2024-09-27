package inheritance.clasesAbstractas;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado extends Persona{

    private int idEmpleado;
    private int salario;

    private int year;
    private int month;
    private int day;
    private Date altaContrato;

    private static int contadorEmpleado;

    public Empleado(String nombrePersona, int salario, int year, int month, int day) {

        super(nombrePersona);

        this.salario = salario;
        this.year = year;
        this.month = month;
        this.day = day;

        GregorianCalendar calendario = new GregorianCalendar(year, month-1, day);
        this.altaContrato = calendario.getTime();

        generarId();
    }

    public void generarId(){
        Empleado.contadorEmpleado++;
        this.idEmpleado = Empleado.contadorEmpleado;
    }

    //Redefiniendo el metodo de la clase abstracta Persona
    @Override
    public String descripcionPersona() {
        return getNombrePersona() + ", Este empleado tiene un Id = " + idEmpleado + " con un salario de " + salario +
                " y trabaja en la empresa desde " + altaContrato;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empleado{");
        sb.append("altaContrato=").append(altaContrato);
        sb.append(", idEmpleado=").append(idEmpleado);
        sb.append(", salario=").append(salario);
        sb.append(", year=").append(year);
        sb.append(", month=").append(month);
        sb.append(", day=").append(day);
        sb.append('}');
        return sb.toString();
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date getAltaContrato() {
        return altaContrato;
    }

    public void setAltaContrato(Date altaContrato) {
        this.altaContrato = altaContrato;
    }
}
