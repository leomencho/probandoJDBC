package org.leobollini;

import org.leobollini.modelo.Prueba;
import org.leobollini.repositorio.ProductoRepositorioImpl;
import org.leobollini.repositorio.Repositorio;
import org.leobollini.util.ConexionBD;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


    try (Connection conn= ConexionBD.getInstance()) {
        Repositorio<Prueba> repositorio = new ProductoRepositorioImpl();
        repositorio.listar().forEach(p -> System.out.println(p.getNombre()));
    } catch (SQLException e){
        e.printStackTrace();
    }
    }
}