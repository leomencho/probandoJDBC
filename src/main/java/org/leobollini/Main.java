package org.leobollini;

import org.leobollini.util.ConexionBD;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


    try (Connection conn= ConexionBD.getInstance();
         Statement stmt = conn.createStatement();
         ResultSet resultado = stmt.executeQuery("SELECT * FROM algo")) {
        while (resultado.next()) {
            System.out.println(resultado.getString("nombre"));
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
    }
}