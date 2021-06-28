/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Modulo;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Modulos extends Conexion {
    
    public boolean registrar(Modulo modulo) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO modulos (modulo,usuarios_idusuario) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, modulo.getModulo());
            ps.setInt(2, modulo.getUsuarios_idusuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    //consulta para eliminar
    public boolean eliminar(Modulo modulo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM modulos  WHERE idmodulo=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, modulo.getIdmodulo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    //consulta para cargar los modulos en la vista
    public ArrayList<Modulo> llenar() {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM modulos";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Modulo modulo = new Modulo();
                modulo.setIdmodulo(rs.getInt("idmodulo"));
                modulo.setModulo(rs.getString("modulo"));
                modulo.setUsuarios_idusuario(rs.getInt("usuarios_idusuario"));
                lista.add(modulo);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
            //return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
    }
    
}
