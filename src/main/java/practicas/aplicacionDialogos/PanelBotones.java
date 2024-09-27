package practicas.aplicacionDialogos;

import javax.swing.*;

public class PanelBotones extends JPanel {

    ButtonGroup buttonGroup;

    public PanelBotones(String titulo, String[] opciones) {

        //Creando el borde
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        // 1-Contenedor padre - 2-Despocision de los elementos
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        buttonGroup = new ButtonGroup();

        for (int i = 0; i < opciones.length; i++) {
            JRadioButton radioButton = new JRadioButton(opciones[i]);

            //Agregando acciones a los radio buttons
            radioButton.setActionCommand(opciones[i]);

            add(radioButton);
            buttonGroup.add(radioButton);
            radioButton.setSelected(i == 0);
        }
    }

    public String datosSeleccionados() {

        ButtonModel buttonModel = buttonGroup.getSelection();
        String datos = buttonModel.getActionCommand();
        return datos;
    }
}
