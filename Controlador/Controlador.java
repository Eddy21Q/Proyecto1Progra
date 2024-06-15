package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import VistaGUI.GUI;
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
            } else {
                vista.showMessage("Login failed!");
            }
        }
    }
}
