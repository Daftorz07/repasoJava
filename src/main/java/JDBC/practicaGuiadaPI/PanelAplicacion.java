package JDBC.practicaGuiadaPI;

import javax.swing.*;
import java.awt.*;

public class PanelAplicacion extends JPanel{

    //Properties
    JComboBox selector;
    JComboBox edades;
    JTextArea resultado;

    public PanelAplicacion() {

        //Properties
        JComboBox selector;
        JComboBox edades;
        JTextArea resultado;

        //Panel for the table of Contents
        JPanel menus = new JPanel();
        menus.setLayout(new FlowLayout());

        selector = new JComboBox();
        selector.setEditable(false);
        selector.addItem("Todos");
        menus.add(selector);

        edades = new JComboBox();
        edades.setEditable(false);
        edades.addItem("Todos");
        menus.add(edades);

        resultado = new JTextArea(17,50);
        resultado.setEditable(false);
        add(resultado);

        JButton btnConsultar = new JButton("Consultar");

        add(menus, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);
        add(btnConsultar, BorderLayout.SOUTH);
    }
}
