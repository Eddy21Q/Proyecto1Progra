/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author josue
 */
public class GUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public GUI() {
        setTitle("Veterinaria CR");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel de fondo
        BackgroundPanel backgroundPanel = new BackgroundPanel("Vista\\Images\\image.png");
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Panel para el título
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setOpaque(false); // Hacer el panel transparente
        JLabel titleLabel = new JLabel("Login to Veterinaria CR");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK); // Cambiar el color del texto a negro
        titlePanel.add(Box.createRigidArea(new Dimension(100, 0))); // Espacio adicional a la izquierda
        titlePanel.add(titleLabel);

        // Crear y configurar el panel del campo de usuario
        JPanel userPanel = new JPanel(new BorderLayout(10, 10));
        userPanel.setOpaque(false); // Hacer el panel transparente
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userLabel.setForeground(Color.BLACK); // Cambiar el color del texto a negro
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 40));
        userPanel.add(userLabel, BorderLayout.WEST);
        userPanel.add(usernameField, BorderLayout.CENTER);

        // Crear y configurar el panel del campo de contraseña
        JPanel passPanel = new JPanel(new BorderLayout(10, 10));
        passPanel.setOpaque(false); // Hacer el panel transparente
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passLabel.setForeground(Color.BLACK); // Cambiar el color del texto a negro
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 40));
        passPanel.add(passLabel, BorderLayout.WEST);
        passPanel.add(passwordField, BorderLayout.CENTER);

        // Crear y configurar el panel del botón de login
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Hacer el panel transparente
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setPreferredSize(new Dimension(150, 40));
        buttonPanel.add(loginButton);

        // Añadir los paneles al panel principal
        backgroundPanel.add(titlePanel);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre el título y el campo de usuario
        backgroundPanel.add(userPanel);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre los campos
        backgroundPanel.add(passPanel);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espacio antes del botón
        backgroundPanel.add(buttonPanel);

        add(backgroundPanel);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }
}
