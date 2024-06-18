package VistaGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;//importaciones de los componentes graficos y la clase controlador
import Controlador.Controlador;
import java.awt.*;

public class PanelInformacion extends JPanel{

    public PanelInformacion(Controlador controlador, String informacion) {//constructor
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(new Color(102, 255, 102)); // Fondo gris claro

        // Crear título
        JLabel titleLabel = new JLabel("Información Importante");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(new Color(34, 34, 34)); // Color de texto 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Crear panel central con imagen y texto
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(245, 245, 245)); // Color de Fondo gris

        // Añadir imagen
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("VistaGUI/Images/adoption.png"); //ruta para la imagen
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(imageLabel, BorderLayout.NORTH);

        // Crear área de texto con la información
        JTextArea infoTextArea = new JTextArea(informacion);
        infoTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setEditable(false);
        infoTextArea.setBackground(new Color(245, 245, 245)); // Fondo gris claro
        infoTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Crear panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245)); // color del fondo

        JButton salirButton = new JButton("Salir");//darle estilo al boton
        salirButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        salirButton.setBackground(new Color(0, 123, 255));
        salirButton.setForeground(Color.WHITE);
        salirButton.setFocusPainted(false);
        salirButton.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 1, true));
        salirButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salirButton.addActionListener(e -> controlador.abrirMenuPrincipal());

        buttonPanel.add(salirButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
