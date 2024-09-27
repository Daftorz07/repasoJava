package interfaces.clasesInternas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Temporizador {

    public static void main(String[] args){

        Reloj relojUno = new Reloj(2000, true);
        relojUno.IniciarReloj();

        JOptionPane.showMessageDialog(null, "Detener el reloj");
        System.exit(0);
    }
}

class Reloj {

    private int intervalo;
    private boolean sonido;

    public Reloj(int intervalo, boolean sonido) {
        this.intervalo = intervalo;
        this.sonido = sonido;
    }

    public void IniciarReloj(){
        ActionListener evento = new ObtenerHoraActual();
        Timer temporizador = new Timer(this.intervalo, evento);
        temporizador.start();
    }

    //Clase interna ObtenerHoraActual
    private class ObtenerHoraActual implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            //La clase interna ObtenerHoraActual puede acceder a las propiedades de Reloj sin necesidad de los metodos de acceso
            Date horaActual = new Date();
            System.out.println("La hora cada " + intervalo/1000 + " segundo " + horaActual);

            if(sonido){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
