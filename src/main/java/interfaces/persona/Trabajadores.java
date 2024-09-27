package interfaces.persona;

public interface Trabajadores {

    //public static final: por defecto las constantes se define asi, no es necesario colocarlo en la definición
    double BONUS_BASE = 1500000;

    //public abstract: por convención no se colocan los en la definición de metodos de las interfaces
    double estable_bonus(double gratificacion);
}
