package componentes.textos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextPanel extends JPanel {

    private JTextField lineaTexto;
    private JLabel resultadoValidacion;

    public TextPanel() {

        setLayout(new BorderLayout());

        JPanel formulario = new JPanel();
        formulario.setLayout(new FlowLayout());

        JLabel lblTexto = new JLabel("Email:");
        formulario.add(lblTexto);

        resultadoValidacion = new JLabel("", JLabel.CENTER);

        lineaTexto = new JTextField("dftorres@sprc.com.co", 15);
        formulario.add(lineaTexto);

        JButton btnEnviar = new JButton("Validar email");
        EnviarNombre enviarNombre = new EnviarNombre();
        btnEnviar.addActionListener(enviarNombre);
        formulario.add(btnEnviar);

        add(resultadoValidacion, BorderLayout.CENTER);
        add(formulario, BorderLayout.NORTH);
    }

    private class EnviarNombre implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String email = lineaTexto.getText();
            boolean isEmail = false;

            isEmail = validateEmail(email);

            if (isEmail) {
                System.out.println("Email " + email + " es correcto");
                resultadoValidacion.setText("Email correcto");
            } else {
                System.out.println("Email " + email + " es incorrecto");
                resultadoValidacion.setText("Email incorrecto");
            }
        }

        public boolean validateEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
    }
}


