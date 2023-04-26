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
        System.out.println("=============listar======================");
        repositorio.listar().forEach(p -> System.out.println(p));
        System.out.println("=============ver por id======================");
        System.out.println(repositorio.porId(2L));
        /*System.out.println("============= crear/ insertar ======================");
        Prueba producto = new Prueba();
        producto.setNombre("chuchu");
        producto.setOtro("alfa de la casa");
        repositorio.guardar(producto);
        System.out.println("producto guardado con exito");

        System.out.println("============= modificar ======================");
        Prueba producto = new Prueba();
        producto.setId(1L);
        producto.setNombre("vika");
        producto.setOtro("bollini");
        repositorio.guardar(producto);
        System.out.println("producto editador con exito");*/

        System.out.println("========= eliminar =================");
        repositorio.eliminar(3L);
        System.out.println("Eliminado con exito");

        repositorio.listar().forEach(System.out::println);

    } catch (SQLException e){
        e.printStackTrace();
    }
    }
}