package org.leobollini.repositorio;

import org.leobollini.modelo.Prueba;
import org.leobollini.util.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements  Repositorio<Prueba>{

    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();

    }
    @Override
    public List<Prueba> listar() {
        List<Prueba> prueba = new ArrayList<>();

        try (Statement stmt= getConnection().createStatement();
        ResultSet rs= stmt.executeQuery("SELECT * FROM algo")){
            while (rs.next()){
                Prueba p = new Prueba();
                p.setId(rs.getLong("id"));
                p.setNombre(rs.getString("nombre"));
                p.setOtro(rs.getString("otro"));
                prueba.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return prueba;
    }

    @Override
    public Prueba porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Prueba prueba) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
