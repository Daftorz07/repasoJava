package programacionGenerica.herencia;

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.edad = edad;
        this.nombre = nombre;
        this.salario = salario;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empleado{");
        sb.append("edad=").append(edad);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", salario=").append(salario);
        sb.append('}');
        return sb.toString();
    }

}