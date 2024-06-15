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

public class Modelo {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/proyecto1progra";
    private String dbUser = "eddy.gonzalez";
    private String dbPassword = "123";

    public boolean authenticateUser(String username, String password) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String sql = "SELECT * FROM autenticacionusuarios WHERE Usuario = ? AND Clave = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
