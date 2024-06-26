package VistaGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;   //Importaciones de los componentes de la interfaz grafica y el controlador
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 public class FormularioMascota extends JPanel {

    private JTextField nombreField;  //creacion de las variables de los botones y los espacios
    private JTextField edadField;
    private JTextField pesoField;
    private JTextField colorField;
    private JCheckBox esterilizadoCheckBox;
    private JButton ingresarButton;
    private JButton limpiarButton;
    private JButton salirButton;

    public FormularioMascota(Controlador controlador) {//constructor
        setLayout(new BorderLayout());
                                                       //creacion de los componentes de la interfaz grafica
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(102, 255, 102)); // color del fondo principal

        JLabel formTitleLabel = new JLabel("Registro de Mascotas");
        formTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        formTitleLabel.setForeground(new Color(255, 51, 51)); // color del título
        formTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(formTitleLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 153, 0)), // 
                "Datos Generales",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 16), 
                new Color(0, 153, 0) // Color para el título del borde
        ));
        formPanel.setBackground(new Color(102, 255, 255)); 

        nombreField = createInputField("Nombre:", formPanel);
        edadField = createInputField("Edad:", formPanel);
        pesoField = createInputField("Peso:", formPanel);
        colorField = createInputField("Color:", formPanel);

        JPanel esterilizadoPanel = new JPanel(new BorderLayout(10, 10));
        esterilizadoPanel.setOpaque(false);
        JLabel esterilizadoLabel = new JLabel("Esterilizado:");
        esterilizadoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        esterilizadoLabel.setForeground(new Color(0, 153, 0));
        esterilizadoCheckBox = new JCheckBox();
        esterilizadoCheckBox.setBackground(new Color(102, 255, 255)); 
        esterilizadoPanel.add(esterilizadoLabel, BorderLayout.WEST);
        esterilizadoPanel.add(esterilizadoCheckBox, BorderLayout.CENTER);
        formPanel.add(esterilizadoPanel);

        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel buttonPanel = new JPanel();  //creacion de los botones
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        limpiarButton = createStyledButton("Limpiar", buttonPanel);
        ingresarButton = createStyledButton("Ingresar", buttonPanel);
        salirButton = createStyledButton("Salir", buttonPanel);

        formPanel.add(buttonPanel);
        mainPanel.add(formPanel);

        add(mainPanel, BorderLayout.CENTER);

        ingresarButton.addActionListener(new ActionListener() {//metodo para ingresar los datos de las mascotas
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                int edad = Integer.parseInt(edadField.getText());
                double peso = Double.parseDouble(pesoField.getText());
                String color = colorField.getText();
                boolean esterilizado = esterilizadoCheckBox.isSelected();

                controlador.guardarDatosMascota(nombre, edad, peso, color, esterilizado);
                JOptionPane.showMessageDialog(FormularioMascota.this, "Datos de la mascota guardados");
            }
        });

        limpiarButton.addActionListener(new ActionListener() {//metodo para limpiar los espacios donde se ingresaron los datos
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreField.setText("");
                edadField.setText("");
                pesoField.setText("");
                colorField.setText("");
                esterilizadoCheckBox.setSelected(false);
            }
        });

        salirButton.addActionListener(new ActionListener() {//metodo del boton para regresar al menu
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.abrirMenuPrincipal();
            }
        });
    }

    private JTextField createInputField(String label, JPanel panel) {//metodo para la creacion de los espacios
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

    private JButton createStyledButton(String text, JPanel panel) {//metodo para darle estilo a los botones
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