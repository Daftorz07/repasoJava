package practicas.aplicacionDialogos;

import componentes.textos.TextPanel;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Date;

public class MarcoDialogo extends JFrame {

    //Variables para cada díalogo
    private PanelBotones panelTipos, panelTiposMensajes, panelMensaje, panelConfirmar, panelOpcion, panelEntrada;

    private String cadenaMensaje = "Mensaje";
    private Icon iconoMensaje = new ImageIcon("src/img/azul.png");
    private Object objMensaje = new Date();
    private Component componentMensaje = new panelComponent();

    public MarcoDialogo() {

        //Configuración del Fame
        setTitle("Prueba de Dialogos");
        setSize(600, 450);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Panel que contendrá los díalogos
        JPanel panelCuadricula = new JPanel();
        panelCuadricula.setLayout(new GridLayout(2, 3));

        //Arreglo de díalogos
        String[] tipos = {"Mensaje", "Confirmar", "Opción", "Entrada"};
        String[] tiposMensajes = {"ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"};
        String[] mensaje = {"Cadena", "Icono", "Componente", "Otros", "Object[]"};
        String[] confirmar = {"DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"};
        String[] opcion = {"String[]", "Icon[]", "Object[]"};
        String[] entrada = {"Campo de texto", "Combo"};

        //Agregando los díalogos
        panelTipos = new PanelBotones("Tipos", tipos);
        panelTiposMensajes = new PanelBotones("Tipo de Mensaje", tiposMensajes);
        panelMensaje = new PanelBotones("Mensaje", mensaje);
        panelConfirmar = new PanelBotones("Confirmar", confirmar);
        panelOpcion = new PanelBotones("Opción", opcion);
        panelEntrada = new PanelBotones("Entrada", entrada);

        //Dialogos a la cuadrícula
        panelCuadricula.add(panelTipos);
        panelCuadricula.add(panelTiposMensajes);
        panelCuadricula.add(panelMensaje);
        panelCuadricula.add(panelConfirmar);
        panelCuadricula.add(panelOpcion);
        panelCuadricula.add(panelEntrada);

        //Panel inferior
        JPanel panelMostrar = new JPanel();
        JButton buttonMostrar = new JButton("Mostrar");
        buttonMostrar.addActionListener(new AccionMostrar());
        panelMostrar.add(buttonMostrar);


        //Agregando al panel
        add(panelCuadricula, BorderLayout.CENTER);
        add(panelMostrar, BorderLayout.SOUTH);
    }

    //------------------- Metodo que proporciona los mensajes -------------------
    public Object informacionMensaje() {

        String mensaje = panelMensaje.datosSeleccionados();

        if (mensaje.equals("Cadena")) {
            return cadenaMensaje;
        } else if (mensaje.equals("Icono")) {
            return iconoMensaje;
        } else if (mensaje.equals("Componente")) {
            return componentMensaje;
        } else if (mensaje.equals("Otros")) {
            return objMensaje;
        } else if (mensaje.equals("Object[]")) {
            return new Object[]{cadenaMensaje, iconoMensaje, componentMensaje, objMensaje};
        } else {
            return null;
        }
    }
    //---------------------------------------------------------------------------

    //------------------- Metodo que proporciona los tipos de Iconos ------------
    public int tipoIcono() {

        String icono = panelTiposMensajes.datosSeleccionados();

        if (icono.equals("ERROR_MESSAGE")) {
            return 0;
        } else if (icono.equals("INFORMATION_MESSAGE")) {
            return 1;
        } else if (icono.equals("WARNING_MESSAGE")) {
            return 2;
        } else if (icono.equals("QUESTION_MESSAGE")) {
            return 3;
        } else if (icono.equals("PLAIN_MESSAGE")) {
            return -1;
        } else {
            return 0;
        }
    }
    //---------------------------------------------------------------------------

    //------------------- Metodo que proporciona los tipos de confirmación ------
    public int tipoConfirm() {

        String confirm = panelConfirmar.datosSeleccionados();

        if (confirm.equals("DEFAULT_OPTION")) {
            return -1;
        } else if (confirm.equals("YES_NO_OPTION")) {
            return 0;
        } else if (confirm.equals("YES_NO_CANCEL_OPTION")) {
            return 1;
        } else if (confirm.equals("OK_CANCEL_OPTION")) {
            return 2;
        } else {
            return 0;
        }
    }
    //---------------------------------------------------------------------------

    //------------------- Metodo que proporciona los tipos de Opciones ----------
    public Object[] tipoOpciones(PanelBotones panelBotones) {

        String panelSeleccionado = panelBotones.datosSeleccionados();

        //String[] opcion = {"String[]", "Icon[]", "Object[]"};
        if (panelSeleccionado.equals("String[]")) {
            return new String[]{"Amarillo", "Azul", "Rojo"};
        } else if (panelSeleccionado.equals("Icon[]")) {
            return new Icon[]{new ImageIcon("src/img/amarillo.png"), new ImageIcon("src/img/azul.png"), new ImageIcon("src/img/rojo.png")};
        } else if (panelSeleccionado.equals("Object[]")) {
            return new Object[]{cadenaMensaje, iconoMensaje, objMensaje, componentMensaje};
        } else {
            return null;
        }
    }
    //---------------------------------------------------------------------------

    private class AccionMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (panelTipos.datosSeleccionados().equals("Mensaje")) {
                JOptionPane.showMessageDialog(MarcoDialogo.this, informacionMensaje(), "Mensaje", tipoIcono());

            } else if (panelTipos.datosSeleccionados().equals("Confirmar")) {
                JOptionPane.showConfirmDialog(MarcoDialogo.this, informacionMensaje(), "Confirmar", tipoConfirm(), tipoIcono());

            } else if (panelTipos.datosSeleccionados().equals("Entrada")) {
                if (panelEntrada.datosSeleccionados().equals("Campo de texto")) {
                    JOptionPane.showInputDialog(MarcoDialogo.this, informacionMensaje(), "Entrada", tipoIcono());
                } else {
                    JOptionPane.showInputDialog(MarcoDialogo.this, informacionMensaje(), "Entrada", tipoIcono(), null, new String[] {"Amarillo", "Azul", "Rojo"}, "Azul");
                }

            } else if (panelTipos.datosSeleccionados().equals("Opción")) {
                JOptionPane.showOptionDialog(MarcoDialogo.this, informacionMensaje(), "Opción", JOptionPane.YES_NO_OPTION, tipoIcono(), null, tipoOpciones(panelOpcion), null);
            }
        }
    }
}

class panelComponent extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle2D = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        g2d.setPaint(Color.YELLOW);
        g2d.fill(rectangle2D);
    }
}
