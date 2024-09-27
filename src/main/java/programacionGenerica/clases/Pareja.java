package programacionGenerica.clases;

public class Pareja {

    public static void main(String[] args) {

        ParejaGenerica<String> genericoString = new ParejaGenerica<String>();
        genericoString.setDatoGenerico("David Torres");
        System.out.println("Generico Tipo String: " + genericoString.getDatoGenerico());

        ParejaGenerica<Integer> genericoInt = new ParejaGenerica<Integer>();
        genericoInt.setDatoGenerico(29);
        System.out.println("Generico Tipo Int: " + genericoInt.getDatoGenerico());

        ParejaGenerica<Persona> genericoPersona = new ParejaGenerica<Persona>();
        Persona persona = new Persona("David Torres");
        genericoPersona.setDatoGenerico(persona);
        System.out.println("Generico Tipo Persona: " + genericoPersona.getDatoGenerico());
    }
}
