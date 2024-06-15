/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistaGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Controlador.Controlador;

public class MenuPrincipal extends JPanel {

    private BufferedImage backgroundImage;

    public MenuPrincipal(Controlador controlador) {
        // Cargar la imagen de fondo
        try {
            backgroundImage = ImageIO.read(new File("VistaGUI\\Images\\animalitos.jpg")); // Reemplaza con la ruta correcta
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setOpaque(false); // Hacer que el JPanel sea transparente para mostrar la imagen de fondo

        JLabel menuLabel = new JLabel("Fundacion Entre Colitas");
        menuLabel.setFont(new Font("Segoe UI", Font.BOLD, 32)); // Fuente moderna y grande
        menuLabel.setForeground(Color.BLACK); // Color de texto oscuro
        menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(menuLabel);

        add(Box.createRigidArea(new Dimension(0, 40))); // Espacio debajo del título

        // Añadir botones con estilo
        add(createStyledButton("INSERTAR", "icon/insert.png", e -> controlador.abrirFormularioMascota()));
        add(createStyledButton("ACTUALIZAR", "icon/update.png", null));
        add(createStyledButton("ELIMINAR", "icon/delete.png", null));
        add(createStyledButton("CONSULTAR REGISTROS", "icon/search.png", null));
    }

    private JButton createStyledButton(String text, String iconPath, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button.setBackground(new Color(255, 255, 255)); // Fondo blanco
        button.setForeground(new Color(0, 123, 255)); // Texto azul
        button.setFocusPainted(false); // Eliminar el borde de enfoque
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor al pasar sobre el botón
        button.setMaximumSize(new Dimension(250, 60)); // Tamaño del botón
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar botón

        // Añadir icono al botón
        if (iconPath != null) {
            ImageIcon icon = new ImageIcon(iconPath);
            button.setIcon(icon);
        }

        // Añadir bordes redondeados y sombra
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 123, 255), 1, true), // Borde azul
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Espaciado interior
        ));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 123, 255));
                button.setForeground(Color.WHITE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(0, 123, 255));
            }
        });

        // Añadir ActionListener si no es nulo
        if (actionListener != null) {
            button.addActionListener(actionListener);
        }

        add(Box.createRigidArea(new Dimension(0, 15))); // Espacio entre botones
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
