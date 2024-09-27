package poo;

public class UsoCoche {

    public static void main(String[] args){

        //Instancia de la clase coche
        Coche Renault = new Coche();

        Renault.setColor("Azul");

        System.out.println("Cantidad de ruedas del coche: " + Renault.getRueda() + " ruedas");
        System.out.println("El color del carro es: " + Renault.getColor());



    }
}
