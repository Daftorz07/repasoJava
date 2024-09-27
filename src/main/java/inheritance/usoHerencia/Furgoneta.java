package inheritance.usoHerencia;

public class Furgoneta extends Coche {

    private int capacidadCarga;
    private int numeroSillas;

    public Furgoneta(int capacidadCarga, int numeroSillas) {
        super(); //Llama al constructor de la clase padre

        this.numeroSillas = numeroSillas;
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Furgoneta{");
        sb.append("Datos del padre=").append(super.toString());
        sb.append("\n").append(" ");
        sb.append("capacidadCarga=").append(capacidadCarga);
        sb.append(", numeroSillas=").append(numeroSillas);
        sb.append('}');
        return sb.toString();
    }

    public String soloDatosFurgoneta() {
        StringBuilder sb = new StringBuilder("Furgoneta{");
        sb.append("capacidadCarga=").append(capacidadCarga);
        sb.append(", numeroSillas=").append(numeroSillas);
        sb.append('}');
        return sb.toString();
    }


}
