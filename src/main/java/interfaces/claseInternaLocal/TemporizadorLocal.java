package interfaces.claseInternaLocal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TemporizadorLocal {

    public static void main(String[] args){

        Reloj relojUno = new Reloj();
        relojUno.IniciarReloj(3000, true);

        JOptionPane.showMessageDialog(null, "Detener el reloj");
        System.exit(0);
    }
}

class Reloj {

    //Los parametros del metodo son propiedades de la clase interna local
    public void IniciarReloj(final int intervalo, final boolean sonido) {

        //Clase interna Local ObtenerHoraActual
        class ObtenerHoraActual implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                Date horaActual = new Date();
                System.out.println("Interna Local: La hora cada " + intervalo/1000 + " segundo " + horaActual);

                if(sonido){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener evento = new ObtenerHoraActual();
        Timer temporizador = new Timer(intervalo, evento);
        temporizador.start();
    }

}
