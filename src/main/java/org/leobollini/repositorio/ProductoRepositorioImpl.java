package org.leobollini.repositorio;

import org.leobollini.modelo.Prueba;
import org.leobollini.util.ConexionBD;

import java.sql.*;
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
                Prueba p = crearPrueba(rs);
                prueba.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return prueba;
    }

    @Override
    public Prueba porId(Long id) {
        Prueba producto = null;

        try(PreparedStatement stmt= getConnection().prepareStatement("SELECT * FROM algo WHERE id=?")){
            stmt.setLong(1,id);
            ResultSet rs= stmt.executeQuery();
            if (rs.next()){
                producto= crearPrueba(rs);
            }
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void guardar(Prueba prueba) {

    }

    @Override
    public void eliminar(Long id) {

    }

    private static Prueba crearPrueba(ResultSet rs) throws SQLException {
        Prueba p = new Prueba();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setOtro(rs.getString("otro"));
        return p;
    }
}
