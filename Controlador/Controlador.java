package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import VistaGUI.GUI;
import VistaGUI.MenuPrincipal;
import VistaGUI.FormularioMascota;
import Modelo.Modelo;

public class Controlador {

    private GUI vista;
    private Modelo modelo;

    public Controlador(GUI vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addLoginListener(new LoginListener());
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = vista.getUsername();
            String password = vista.getPassword();
            if (modelo.authenticateUser(username, password)) {
                vista.showMessage("Login successful!");
                abrirMenuPrincipal();
            } else {
                vista.showMessage("Login failed!");
            }
        }
    }

    public void abrirMenuPrincipal() {
        MenuPrincipal menuPrincipal = new MenuPrincipal(this);
        
        vista.mostrarPanel(menuPrincipal);
    }

    public void abrirFormularioMascota() {
        FormularioMascota formulario = new FormularioMascota(this);
        vista.mostrarPanel(formulario);
    }

    public void guardarDatosMascota(String nombre, int edad, double peso, String color, boolean esterilizado) {
        modelo.savePetData(nombre, edad, peso, color, esterilizado);
    }
}
