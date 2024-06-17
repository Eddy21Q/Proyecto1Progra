package VistaGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelConsulta extends JPanel {

    public PanelConsulta(List<String[]> mascotas, Controlador controlador) {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(new Color(102, 255, 102)); // Fondo azul claro

        // Crear título
        JLabel titleLabel = new JLabel("Consulta de Registros");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(34, 34, 34)); // Color de texto oscuro
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // Hacer transparente para mostrar el fondo
        titlePanel.add(titleLabel);

        add(titlePanel, BorderLayout.NORTH);

        String[] columnNames = {"Nombre", "Edad", "Peso", "Color de Pelo", "Esterilizado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String[] mascota : mascotas) {
            model.addRow(mascota);
        }

        JTable table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
        table.getTableHeader().setBackground(new Color(0, 123, 255)); // Fondo azul para el encabezado de la tabla
        table.getTableHeader().setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Crear panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setOpaque(false); // Hacer transparente para mostrar el fondo
        buttonPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JButton salirButton = createStyledButton("Salir");
        salirButton.addActionListener(e -> controlador.abrirMenuPrincipal());

        buttonPanel.add(Box.createHorizontalGlue()); // Para centrar el botón
        buttonPanel.add(salirButton);
        buttonPanel.add(Box.createHorizontalGlue()); // Para centrar el botón

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(new Color(0, 123, 255)); // Azul para el fondo del botón
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        button.setFocusPainted(false); // Eliminar el borde de enfoque
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor al pasar sobre el botón
        button.setMaximumSize(new Dimension(150, 40)); // Tamaño del botón
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}
