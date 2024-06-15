package VistaGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;

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
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con layout GridLayout para dividir en dos secciones
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Panel izquierdo (imagen)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(0, 123, 255)); // Color de fondo azul
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Crear el panel de imagen adaptada
        JLabel imageLabel = new JLabel();
        ImageIcon originalIcon = new ImageIcon("VistaGUI\\Images\\image.png");
        Image image = originalIcon.getImage();
        Image scaledImage = image.getScaledInstance(10, 10, Image.SCALE_SMOOTH); // Inicialmente no se escala
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);

        // Añadir la imagen al panel izquierdo
        leftPanel.add(imageLabel, BorderLayout.CENTER);
        mainPanel.add(leftPanel);

        // Panel derecho (formulario de inicio de sesión)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel loginTitleLabel = new JLabel("Digite sus datos");
        loginTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loginTitleLabel.setForeground(new Color(0, 123, 255));
        loginTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(loginTitleLabel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel userPanel = new JPanel(new BorderLayout(10, 10));
        userPanel.setOpaque(false);
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userLabel.setForeground(new Color(0, 123, 255));
        usernameField = new JTextField();
        usernameField.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        userPanel.add(userLabel, BorderLayout.WEST);
        userPanel.add(usernameField, BorderLayout.CENTER);
        rightPanel.add(userPanel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel passPanel = new JPanel(new BorderLayout(10, 10));
        passPanel.setOpaque(false);
        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passLabel.setForeground(new Color(0, 123, 255));
        passwordField = new JPasswordField();
        passwordField.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        passPanel.add(passLabel, BorderLayout.WEST);
        passPanel.add(passwordField, BorderLayout.CENTER);
        rightPanel.add(passPanel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setPreferredSize(new Dimension(150, 40));
        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(loginButton);

        mainPanel.add(rightPanel);

        add(mainPanel);

        // Adaptar el tamaño de la imagen al panel izquierdo
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int width = leftPanel.getWidth();
                int height = leftPanel.getHeight();
                Image newScaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(newScaledImage));
            }
        });
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
        });
    }
}
