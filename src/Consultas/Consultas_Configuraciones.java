/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Configuracion;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Configuraciones extends Conexion {

    public boolean registrar(Configuracion configuraciones) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
       
        
        
        String sql = "INSERT INTO configuracion (idconfiguracion,directorio,prefijo) VALUES(?,?,?) ";
        
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, configuraciones.getIdconfiguracion());
            ps.setString(2, configuraciones.getDirectorio());
            ps.setString(3, configuraciones.getPrefijo());
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

    public boolean cargar(Configuracion configuraciones) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM configuracion WHERE idconfiguracion=1";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                configuraciones.setDirectorio(rs.getString("directorio"));
                configuraciones.setPrefijo(rs.getString("prefijo"));
                return true;
            }
            return false;
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
    

    public boolean modificar(Configuracion configuraciones) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  configuracion SET directorio=?, prefijo=? WHERE idconfiguracion=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, configuraciones.getDirectorio());
            ps.setString(2, configuraciones.getPrefijo());
            ps.setInt(3, configuraciones.getIdconfiguracion());
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
}
