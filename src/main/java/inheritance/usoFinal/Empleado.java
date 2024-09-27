package inheritance.usoFinal;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado {

    private int idEmpleado;
    private String nombreEmpleado;
    private int salario;

    private int year;
    private int month;
    private int day;
    private Date altaContrato;

    private static int contadorEmpleado;

    public Empleado(String nombreEmpleado, int salario) {
        this.nombreEmpleado = nombreEmpleado;
        this.salario = salario;
        this.year = 2022;
        this.month = 4;
        this.day = 1;

        GregorianCalendar calendario = new GregorianCalendar(year, month-1, day);
        this.altaContrato = calendario.getTime();

        generarId();
    }

    public Empleado(String nombreEmpleado, int salario, int year, int month, int day) {
        this.nombreEmpleado = nombreEmpleado;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" { ");
        sb.append("idEmpleado = ").append(idEmpleado);
        sb.append(", nombreEmpleado = '").append(nombreEmpleado).append('\'');
        sb.append(", salario = ").append(salario);
        sb.append(", altaContrato = ").append(altaContrato);
        sb.append(" }");
        return sb.toString();
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
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
