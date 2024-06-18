package VistaGUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;  //Importaciones de la interfaz grafica y la clase controlador
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.Controlador;

public class FormularioActualizacion extends JPanel{
    //Creacion de las variables para los botones y textfields
private JTextField nombreActualField;
    private JTextField nuevoNombreField;
    private JTextField edadField;
    private JTextField pesoField;
    private JTextField colorField;
    private JCheckBox esterilizadoCheckBox;
    private JButton actualizarButton;
    private JButton limpiarButton;
    private JButton salirButton;

    public FormularioActualizacion(Controlador controlador) {//Interfaz grafica del panel de actualizacion
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(102, 255, 102)); // color del fondo

        JLabel formTitleLabel = new JLabel("Actualizar Datos de Mascota");
        formTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        formTitleLabel.setForeground(new Color(255, 51, 51)); // Color del título
        formTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(formTitleLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 153, 0)), // color del borde del panel
                "Datos de Mascota",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 16), // Fuente para el título del borde
                new Color(0, 153, 0) // Color para el título del borde
        ));
        formPanel.setBackground(new Color(102, 255, 255)); // color para fondo del panel de formulario

        nombreActualField = createInputField("Nombre Actual:", formPanel);//creacion de los espacios para ingresar los datos
        nuevoNombreField = createInputField("Nuevo Nombre:", formPanel);
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        limpiarButton = createStyledButton("Limpiar", buttonPanel);
        actualizarButton = createStyledButton("Actualizar", buttonPanel);
        salirButton = createStyledButton("Salir", buttonPanel);

        formPanel.add(buttonPanel);
        mainPanel.add(formPanel);

        add(mainPanel, BorderLayout.CENTER);

        actualizarButton.addActionListener(new ActionListener() {//boton de actualizar los datos
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreActual = nombreActualField.getText();
                String nuevoNombre = nuevoNombreField.getText();
                int edad = Integer.parseInt(edadField.getText());
                double peso = Double.parseDouble(pesoField.getText());
                String color = colorField.getText();
                boolean esterilizado = esterilizadoCheckBox.isSelected();

                controlador.actualizarDatosMascota(nombreActual, nuevoNombre, edad, peso, color, esterilizado);
                JOptionPane.showMessageDialog(FormularioActualizacion.this, "Datos de la mascota actualizados");
            }
        });

        limpiarButton.addActionListener(new ActionListener() {//boton para limipiar los espacios donde se ingresaron los datos
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreActualField.setText("");
                nuevoNombreField.setText("");
                edadField.setText("");
                pesoField.setText("");
                colorField.setText("");
                esterilizadoCheckBox.setSelected(false);
            }
        });

        salirButton.addActionListener(new ActionListener() {//boton para regresar al menu
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.abrirMenuPrincipal();
            }
        });
    }

    private JTextField createInputField(String label, JPanel panel) {//Metodo para crear los espacios 
        JPanel fieldPanel = new JPanel(new BorderLayout(10, 10));
        fieldPanel.setOpaque(false);
        JLabel fieldLabel = new JLabel(label);
        fieldLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        fieldLabel.setForeground(new Color(0, 153, 0)); // color para las etiquetas
        JTextField textField = new JTextField();
        textField.setBorder(new LineBorder(new Color(0, 153, 0), 1, true)); //colorpara el borde del campo
        fieldPanel.add(fieldLabel, BorderLayout.WEST);
        fieldPanel.add(textField, BorderLayout.CENTER);
        panel.add(fieldPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        return textField;
    }

    private JButton createStyledButton(String text, JPanel panel) {//metodo para la creacion de los botones
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(0, 123, 255)); // color para el fondo del botón
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        return button;
    }
}
