
import Modelo.Modelo;
import VistaGUI.GUI;

import javax.swing.SwingUtilities;

import Controlador.Controlador;

public class Main {

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(modelo);
            gui.setVisible(true);
        });
    }
}
