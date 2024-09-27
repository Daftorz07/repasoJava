package inheritance.clasesAbstractas;

public abstract class Persona {

    private String nombrePersona = "";

    public Persona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    //Method abstract
    public abstract String descripcionPersona();

    public String getNombrePersona() {
        return nombrePersona;
    }

}
