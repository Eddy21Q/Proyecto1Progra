/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author josue
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo {
    // URL de la base de datos

    private static final String url = "jdbc:mysql://localhost:3306/proyecto1progra";
    // Usuario y contraseña de la base de datos
    private static final String dbUser = "root";
    private static final String dbPassword = "josueProgramacion2"; // Reemplaza con la contraseña real

    public boolean authenticateUser(String username, String password) {

        Connection connection = null;
        try {
            // Registrar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar a la base de datos
            connection = DriverManager.getConnection(url, dbUser, dbPassword);

            // Consulta SQL para autenticar al usuario
            String query = "SELECT * FROM autenticacionusuarios WHERE Usuario = ? AND Clave = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            // Si se encuentra el usuario, la autenticación es exitosa
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar la conexión si fue establecida
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void savePetData(String nombre, int edad, double peso, String color, boolean esterilizado) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "INSERT INTO tablamascotas (Nombre, edad, Peso, ColorPelo, Esterilizado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setInt(2, edad);
            statement.setDouble(3, peso);
            statement.setString(4, color);
            statement.setBoolean(5, esterilizado);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
