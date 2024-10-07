package jdbc.practicaGuiadaPI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MarcoAplicacion extends JFrame {

    //Properties
    private JComboBox selector;
    private JTextArea resultado;
    private Connection newConnection;

    public MarcoAplicacion() {

        /*
         * ----------------------------------------------------------------
         * * Configuring the framework of the application.
         * ----------------------------------------------------------------
         */
        setSize(500, 400);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Consulta BBDD");

        /*
         * ----------------------------------------------------------------
         * * Panel for the table of Contents
         * ----------------------------------------------------------------
         */
        //Panel for the table of Contents
        JPanel menus = new JPanel();
        menus.setLayout(new FlowLayout());

        JLabel label = new JLabel("Selecciona la edad");
        selector = new JComboBox();
        selector.setEditable(false);
        selector.addItem("Edades");
        menus.add(label);
        menus.add(selector);

        resultado = new JTextArea(17, 50);
        resultado.setEditable(false);
        add(resultado);

        JButton btnConsultar = new JButton("Consultar");
        //Colocando a la escucha el boton
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarConsulta();
            }
        });

        add(menus, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);
        add(btnConsultar, BorderLayout.SOUTH);

        /*
         * ----------------------------------------------------------------
         * * Connection to database
         * ----------------------------------------------------------------
         */
        try {
            //1-Conexion to database
            newConnection = Conexion.getConnection();

            //2-Crear objeto Statement para preparar la consulta a ejecutar
            Statement newStatement = newConnection.createStatement();

            //3-Ejecutar la instruccion SQL
            String sql = "SELECT DISTINCT EDAD FROM PERSONAS ORDER BY EDAD";
            ResultSet newResultSet = newStatement.executeQuery(sql);

            //4-Leer el ResultSet
            while (newResultSet.next()) { //Mientras exista un siguiente registro

                selector.addItem(newResultSet.getString("EDAD"));
            }
        } catch (SQLException e) {

            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }

    private void ejecutarConsulta() {

        ResultSet newResultSet = null;

        try {
            //Reseteamos la información dentro del resultado (TextArea)
            resultado.setText("");

            String edadSeleccionada = (String) selector.getSelectedItem();

            //2-Preparamos la consulta SQL
            String sqlPreparada = "SELECT * FROM PERSONAS WHERE EDAD = ?";
            PreparedStatement newPreparedStatement = newConnection.prepareStatement(sqlPreparada);

            //2.1-Seteamos los parametros
            //El metodo de seteo debe ser acorde al tipo de datos de la columna en la base de datos
            newPreparedStatement.setString(1, edadSeleccionada);

            //3-Ejecutar la instruccion SQL
            newResultSet = newPreparedStatement.executeQuery();

            //3.1-Recorremos los datos obtenidos
            resultado.append("\n Personas con edad de " + edadSeleccionada + " años");

            while (newResultSet.next()) {
                resultado.append("\n -- ");
                resultado.append(newResultSet.getString("nombre"));
                resultado.append(" ");
                resultado.append(newResultSet.getString("apellido"));
                resultado.append(" tiene una edad de: ");
                resultado.append(newResultSet.getString("edad"));
            }
        } catch (SQLException e) {

            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("--------------------------------");
            throw new RuntimeException(e);
        }
    }
}
