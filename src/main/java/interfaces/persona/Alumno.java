package interfaces.persona;

public class Alumno extends Persona {

    private String carrera;

    public Alumno(String nombrePersona, String carrera) {
        super(nombrePersona);

        this.carrera = carrera;
    }

    @Override
    public String descripcionPersona() {
        return "El alumno " + getNombrePersona() + " esta cursando la carrera " + carrera;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Alumno{");
        sb.append("carrera='").append(carrera).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}


