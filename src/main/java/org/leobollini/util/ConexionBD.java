package org.leobollini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private  static String url = "jdbc:mysql://localhost:3306/java_prueba?serverTimezone=America/Argentina/Cordoba";
    private static String username="root";
    private static String password="vias";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null)
            connection= DriverManager.getConnection(url, username, password);
        return connection;
    }
}
