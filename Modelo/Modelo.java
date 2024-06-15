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
    private String dbUser = "root";
    private String dbPassword = "josueProgramacion2";

    public boolean authenticateUser(String username, String password) {
        System.out.println("Inicio de authenticateUser");
        System.out.println("Conectando a la base de datos con URL: " + jdbcUrl);
        System.out.println("Usuario de la base de datos: " + dbUser);

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            System.out.println("Conexión exitosa");

            String sql = "SELECT * FROM autenticacionusuarios WHERE Usuario = ? AND Clave = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            System.out.println("Ejecutando consulta: " + sql);
            System.out.println("Parámetros: " + username + ", " + password);

            ResultSet resultSet = statement.executeQuery();
            boolean result = resultSet.next();
            System.out.println("Resultado de la consulta: " + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}