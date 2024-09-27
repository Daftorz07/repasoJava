package JDBC.practicaGuiadaPI;

import javax.swing.*;
import java.awt.*;

public class MarcoAplicacion extends JFrame {

    public MarcoAplicacion() throws HeadlessException {

        //Properties
        JComboBox selector;
        JComboBox edades;
        JTextArea resultado;

        //Configuring the framework of the application.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Consulta BBDD");
        setBounds(500, 300, 400, 400);
        setLayout(new BorderLayout());

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

        resultado = new JTextArea();
        resultado.setEditable(false);
        add(resultado);

        JButton btnConsultar = new JButton("Consultar");

        add(menus, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);
        add(btnConsultar, BorderLayout.SOUTH);
    }
}
