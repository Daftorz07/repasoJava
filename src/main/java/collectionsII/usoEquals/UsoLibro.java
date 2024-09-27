package collectionsII.usoEquals;

public class UsoLibro {

    public static void main(String[] args) {

        /*
        * Manejo del metodo equals
        * Utilizando equals definido en la clase Libro
        */

        Libro libroUno = new Libro("Gabriel Garcia Marquez", "100 años de Soledad", 196707);
        Libro libroDos = new Libro("Gabriel Garcia Marquez", "El coronel no tiene quien le escriba", 196708);

        //libroUno = libroDos;

        if (libroUno.equals(libroDos)) {
            System.out.println("Es el mismo libro");
            System.out.println("libroTres: hashCode " + libroUno.hashCode());
            System.out.println("libroTresCopia: hashCode " + libroDos.hashCode());
        } else {
            System.out.println("Son libres diferentes");
            System.out.println("libroTres: hashCode " + libroUno.hashCode());
            System.out.println("libroTresCopia: hashCode " + libroDos.hashCode());
        }
    }
}
