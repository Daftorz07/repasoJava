package inheritance.usoHerencia;

public class PruebaHerencia {

    public static void main(String[] args){

        //Coche
        Coche cocheUno  = new Coche();
        //System.out.println(cocheUno);

        //Furgoneta
        Furgoneta furgoneta = new Furgoneta(1500, 8);
        furgoneta.setColor("Rojo");
        furgoneta.setPeso_total(furgoneta.getPeso_Plataforma() + 1500);
        System.out.println(furgoneta.toString());


    }
}
