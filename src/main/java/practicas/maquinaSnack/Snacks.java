package practicas.maquinaSnack;

import java.util.ArrayList;
import java.util.List;

public class Snacks {

    private static final List<Snack> listaSnacks;

    //Bloque Static inicializados - Para inicializar los datos de la clase
    static {
        listaSnacks = new ArrayList<>();
        listaSnacks.add(new Snack("Papas", 70.5));
        listaSnacks.add(new Snack("Refresco", 50.8));
        listaSnacks.add(new Snack("Sandwich", 120.4));
    }

    public static void agregarSnack(Snack snack){
        listaSnacks.add(snack);
    }

    public static void mostrarSnack(){
        String mostrarSnack = "";
        for(Snack snack : listaSnacks){
            mostrarSnack += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el Inventario ---");
        System.out.println(mostrarSnack);
    }

    public static List<Snack> getSnackList(){
        return listaSnacks;
    }
}
