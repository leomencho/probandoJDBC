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
            //con este try anidados implementamos un auto close.
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearPrueba(rs);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void guardar(Prueba prueba) {
        String sql;
        if(prueba.getId()!=null && prueba.getId()>0){
            sql="UPDATE  algo SET nombre=?, otro=? WHERE id=?";
        }
        else {
            sql="INSERT INTO algo (nombre, otro) VALUES(?,?)";
        }
        try(PreparedStatement stmp= getConnection().prepareStatement(sql)){
            stmp.setString(1, prueba.getNombre());
            stmp.setString(2,prueba.getOtro());

            if (prueba.getId()!=null && prueba.getId()>0){
                stmp.setLong(3, prueba.getId());
            }
            stmp.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement stmt= getConnection().prepareStatement("DELETE FROM algo WHERE id=?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static Prueba crearPrueba(ResultSet rs) throws SQLException {
        Prueba p = new Prueba();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setOtro(rs.getString("otro"));
        return p;
    }
}
