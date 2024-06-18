
import Modelo.Modelo;//Importaciones de las clases controlador, modelo y vistaGui
import VistaGUI.GUI;
import javax.swing.SwingUtilities;
import Modelo.Modelo;
import Controlador.Controlador;

public class Main {
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        GUI gui = new GUI();
        Controlador controlador = new Controlador(gui, modelo);//se crea la clase controlador
        gui.setSize(850,400);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);

    }
}