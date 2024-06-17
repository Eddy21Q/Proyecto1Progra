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
        try {
            backgroundImage = ImageIO.read(new File("VistaGUI/Images/animalitos.jpg")); // Reemplaza con la ruta correcta
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, 20, 0, 20));
        setOpaque(false); // Hacer que el JPanel sea transparente para mostrar la imagen de fondo
        setPreferredSize(new Dimension(1400, 3500)); // Ajustar tamaño del panel

        JLabel menuLabel = new JLabel("Fundacion Entre Colitas");
        menuLabel.setFont(new Font("Segoe UI", Font.BOLD, 32)); // Fuente moderna y grande
        menuLabel.setForeground(Color.BLACK); // Color de texto oscuro
        menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(menuLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(18, 1, 15, 5)); // Usar GridLayout con 8 filas y 1 columna y más espacio entre los botones
        buttonPanel.setOpaque(false);

        // Añadir botones con estilo
        buttonPanel.add(createStyledButton("INSERTAR", "VistaGUI/Images/insert.png", e -> controlador.abrirFormularioMascota()));
        buttonPanel.add(createStyledButton("ACTUALIZAR", "VistaGUI/Images/update.png", e -> controlador.abrirFormularioActualizacion()));
        buttonPanel.add(createStyledButton("ELIMINAR", "VistaGUI/Images/delete.png", e -> controlador.abrirFormularioEliminacion()));
        buttonPanel.add(createStyledButton("CONSULTAR REGISTROS", "VistaGUI/Images/search.png", e -> controlador.abrirPanelConsulta()));
        buttonPanel.add(createStyledButton("INFORMACION IMPORTANTE", "VistaGUI/Images/info.png", e -> controlador.abrirPanelInformacionImportante()));
        buttonPanel.add(createStyledButton("DERECHOS DE AUTOR", "VistaGUI/Images/copyright.png", e -> controlador.abrirPanelDerechosAutor()));
        buttonPanel.add(createStyledButton("SALIR", "VistaGUI/Images/exit.png", e -> salirDelSistema())); // Salir del sistema
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.add(buttonPanel);
        add(centerPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, String iconPath, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alinear contenido del botón a la izquierda
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setBackground(new Color(255, 255, 255)); // Fondo blanco
        button.setForeground(new Color(0, 123, 255)); // Texto azul
        button.setFocusPainted(false); // Eliminar el borde de enfoque
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor al pasar sobre el botón
        button.setPreferredSize(new Dimension(350, 40)); // Tamaño del botón
        button.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinear el botón a la izquierda

        // Añadir icono al botón y redimensionarlo
        if (iconPath != null) {
            ImageIcon originalIcon = new ImageIcon(iconPath);
            Image img = originalIcon.getImage();
            Image scaledImage = img.getScaledInstance(40, 35, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            button.setIcon(scaledIcon);
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

        return button;
    }
    private void salirDelSistema() {
        JOptionPane.showMessageDialog(this, "Has salido del sistema.");
        System.exit(0);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}