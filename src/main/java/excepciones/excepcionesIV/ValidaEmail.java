package excepciones.excepcionesIV;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.IllegalArgumentException;

public class ValidaEmail {

    public static void main(String[] args) {

        String email = JOptionPane.showInputDialog("Ingresa el email a validar");

        try {
            validarEmail(email);
        }catch (IllegalArgumentException e) {
            System.err.println("Email no puede ser menor o igual a 6 caracteres");
        }
    }

    static void validarEmail(String email) throws IllegalArgumentException {

        if (email.length() <= 6) {

            throw new IllegalArgumentException();

        } else {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            boolean resultado = matcher.matches();

            if (resultado) {
                System.out.println("El email ingresado " + email + " es correcto");
            } else {
                System.out.println("El email ingresado " + email + " es incorrecto");
            }
        }


    }
}
