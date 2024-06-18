package VistaGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;   //Importaciones de la interfaz grafica y la clase controlador
import javax.swing.border.LineBorder;
import Controlador.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JTextField usernameField; //Inicializacion de las variables de los botones, labels e imagenes
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel contentPanel;
    private JLabel imageLabel;
    private Image image;

    public GUI() {//constructor
        setTitle("Veterinaria CR");     //componentes graficos de la ventana de loggin
        setSize(1200, 1900); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contentPanel = new JPanel(new CardLayout());
        setContentPane(contentPanel);

        JPanel loginPanel = createLoginPanel();
        contentPanel.add(loginPanel, "loginPanel");

        addComponentListener(new java.awt.event.ComponentAdapter() {//metodo para darle forma a la ventana
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int width = loginPanel.getWidth();
                int height = loginPanel.getHeight();
                Image newScaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(newScaledImage));
            }
        });
    }

    private JPanel createLoginPanel() {//metodo para la creacion de los componentes graficos de la ventana de loggin
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(0, 123, 255)); // Color de fondo azul
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        imageLabel = new JLabel();
        ImageIcon originalIcon = new ImageIcon("VistaGUI/Images/image.png");
        image = originalIcon.getImage();
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);                    //iconos
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(imageLabel, BorderLayout.CENTER);

        JLabel welcomeLabel = new JLabel("Bienvenido a Veterinaria CR");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(welcomeLabel, BorderLayout.SOUTH);

        mainPanel.add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new EmptyBorder(20, 40, 20, 40)); // Márgenes 

        JLabel loginTitleLabel = new JLabel("Iniciar Sesión");
        loginTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        loginTitleLabel.setForeground(new Color(0, 123, 255));
        loginTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(loginTitleLabel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espacio debajo del título

        JPanel userPanel = new JPanel(new BorderLayout(10, 10));
        userPanel.setOpaque(false);
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        userLabel.setForeground(new Color(0, 123, 255));
        usernameField = new JTextField();
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        usernameField.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        userPanel.add(userLabel, BorderLayout.WEST);
        userPanel.add(usernameField, BorderLayout.CENTER);
        rightPanel.add(userPanel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre campos

        JPanel passPanel = new JPanel(new BorderLayout(10, 10));
        passPanel.setOpaque(false);
        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        passLabel.setForeground(new Color(0, 123, 255));
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordField.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        passPanel.add(passLabel, BorderLayout.WEST);
        passPanel.add(passwordField, BorderLayout.CENTER);
        rightPanel.add(passPanel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espacio debajo del campo de contraseña

        loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 18));// creacion de los Botones
        loginButton.setPreferredSize(new Dimension(200, 50));
        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(new LineBorder(new Color(0, 123, 255), 1, true));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(loginButton);

        mainPanel.add(rightPanel);

        return mainPanel;
    }

    public void addLoginListener(ActionListener listener) {//metoodo para boton de loggin
        loginButton.addActionListener(listener);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void showMessage(String message) {//metodo para advertencias de excepciones
        JOptionPane.showMessageDialog(this, message);
    }

    public void mostrarPanel(JPanel panel) {//metodo para abrir mostrar el panel
        contentPanel.add(panel, "newPanel");
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "newPanel");
    }
   
}
