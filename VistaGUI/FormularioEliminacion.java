package VistaGUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.Controlador;
public class FormularioEliminacion extends JPanel {
 private JTextField nombreField;
    private JButton eliminarButton;
    private JButton limpiarButton;
    private JButton salirButton;

    public FormularioEliminacion(Controlador controlador) {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(102, 255, 102)); // Verde claro para el fondo principal

        JLabel formTitleLabel = new JLabel("Eliminar Datos de Mascota");
        formTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        formTitleLabel.setForeground(new Color(255, 51, 51)); // Rojo para el título
        formTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(formTitleLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 153, 0)), // Verde oscuro para el borde del panel
                "Datos de Mascota",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 16), // Fuente para el título del borde
                new Color(0, 153, 0) // Color para el título del borde
        ));
        formPanel.setBackground(new Color(102, 255, 255)); // Cian claro para el fondo del panel de formulario

        nombreField = createInputField("Nombre:", formPanel);

        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        limpiarButton = createStyledButton("Limpiar", buttonPanel);
        eliminarButton = createStyledButton("Eliminar", buttonPanel);
        salirButton = createStyledButton("Salir", buttonPanel);

        formPanel.add(buttonPanel);
        mainPanel.add(formPanel);

        add(mainPanel, BorderLayout.CENTER);

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                controlador.eliminarDatosMascota(nombre);
                JOptionPane.showMessageDialog(FormularioEliminacion.this, "Datos de la mascota eliminados");
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreField.setText("");
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.abrirMenuPrincipal();
            }
        });
    }

    private JTextField createInputField(String label, JPanel panel) {
        JPanel fieldPanel = new JPanel(new BorderLayout(10, 10));
        fieldPanel.setOpaque(false);
        JLabel fieldLabel = new JLabel(label);
        fieldLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        fieldLabel.setForeground(new Color(0, 153, 0)); // Verde oscuro para las etiquetas
        JTextField textField = new JTextField();
        textField.setBorder(new LineBorder(new Color(0, 153, 0), 1, true)); // Verde oscuro para el borde del campo
        fieldPanel.add(fieldLabel, BorderLayout.WEST);
        fieldPanel.add(textField, BorderLayout.CENTER);
        panel.add(fieldPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        return textField;
    }

    private JButton createStyledButton(String text, JPanel panel) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(0, 123, 255)); // Azul para el fondo del botón
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        return button;
    }
}
