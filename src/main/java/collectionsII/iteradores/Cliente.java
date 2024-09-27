package collectionsII.iteradores;

import java.util.Objects;

public class Cliente {

    private String nombre;
    private String cuenta;
    private double saldoCuenta;

    public Cliente(String nombre, String cuenta, double saldoCuenta) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.saldoCuenta = saldoCuenta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{ ");
        sb.append("cuenta='").append(cuenta).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", saldoCuenta=").append(saldoCuenta);
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cuenta, cliente.cuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cuenta);
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }
}
