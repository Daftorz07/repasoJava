package componentes.documentos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class EjemploUno {

    public static void main(String[] args) {

        Frame marco = new Frame();
    }
}

class Frame extends JFrame {

    public Frame() {

        setTitle("Ejemplo Uno");
        setSize(650, 350);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Panel panel = new Panel();
        add(panel);

    }
}

class Panel extends JPanel {

    public Panel() {

        JTextField campoTexto = new JTextField(30);
        AccionDocumento accionDocumento = new AccionDocumento();

        //Se extrae la información del documento
        Document miDocumento = campoTexto.getDocument();
        miDocumento.addDocumentListener(accionDocumento);

        add(campoTexto);
    }

    private class AccionDocumento implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {

        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("Insert update");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("Remove update");
        }
    }
}





