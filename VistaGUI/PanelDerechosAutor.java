package VistaGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;//importaciones de los componentes graficos y la clase controlador
import java.awt.*;
import Controlador.Controlador;

public class PanelDerechosAutor extends JPanel{ 

    public PanelDerechosAutor(Controlador controlador, String informacion) {//constructor
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(new Color(102, 255, 102)); // Fondo gris claro

        // Crear título
        JLabel titleLabel = new JLabel("Derechos de Autor");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(new Color(34, 34, 34)); // Color de texto 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Crear panel central con imagen y texto
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(245, 245, 245)); // Fondo gris

        // Crear area de texto con la información
        JTextArea infoTextArea = new JTextArea(informacion);
        infoTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setEditable(false);
        infoTextArea.setBackground(new Color(245, 245, 245)); // Fondo
        infoTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Crear panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));

        JButton salirButton = new JButton("Salir"); //estilar el bton de salir
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
