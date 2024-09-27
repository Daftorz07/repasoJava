package programacionGenerica.arrayList;

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public Empleado(int edad, String nombre, double salario) {
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