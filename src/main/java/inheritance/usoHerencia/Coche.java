package inheritance.usoHerencia;

public class Coche {

    private int rueda;
    private int largo;
    private int ancho;
    private int motor;
    private int peso_Plataforma;

    private String color;
    private int peso_total;
    private boolean tipoAsiento, climatizacion;

    //Metodo constructor, se encarga de dar un estado inicial al objeto
    public Coche() {
        rueda = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        peso_Plataforma = 500;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "rueda=" + rueda +
                ", largo=" + largo +
                ", ancho=" + ancho +
                ", motor=" + motor +
                ", peso_Plataforma=" + peso_Plataforma +
                ", color='" + color + '\'' +
                ", peso_total=" + peso_total +
                ", tipoAsiento=" + tipoAsiento +
                ", climatizacion=" + climatizacion +
                '}';
    }

    public int getRueda() {
        return rueda;
    }

    public void setRueda(int rueda) {
        this.rueda = rueda;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public int getPeso_Plataforma() {
        return peso_Plataforma;
    }

    public void setPeso_Plataforma(int peso_Plataforma) {
        this.peso_Plataforma = peso_Plataforma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPeso_total() {
        return peso_total;
    }

    public void setPeso_total(int peso_total) {
        this.peso_total = peso_total;
    }

    public boolean isTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(boolean tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public boolean isClimatizacion() {
        return climatizacion;
    }

    public void setClimatizacion(boolean climatizacion) {
        this.climatizacion = climatizacion;
    }
}
