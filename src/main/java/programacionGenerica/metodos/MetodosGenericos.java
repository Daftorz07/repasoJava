package programacionGenerica.metodos;

public class MetodosGenericos {

    public static <T> String numElementos(T[] arrayGenerico) {
        return "El numero de elementos del Array es: " + arrayGenerico.length;
    }

    public static <T extends Comparable> T getMenor(T[] arrayGenerico) {

        if (arrayGenerico == null || arrayGenerico.length == 0) {
            return null;
        }

        T elementoMenor = arrayGenerico[0];

        for (int i = 1; i < arrayGenerico.length; i++) {

            if (elementoMenor.compareTo(arrayGenerico[i]) > 0) {
                elementoMenor = arrayGenerico[i];
            }
        }
        return elementoMenor;
    }
}