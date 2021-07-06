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
import java.util.ArrayList;
import modelo.Configuracion;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Configuraciones extends Conexion {

    //consulta para registrar 
    public boolean registrar(Configuracion configuraciones) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO configuracion (directorio,usuarios_idusuario,modulos_idmodulo,macs_idmacs) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, configuraciones.getDirectorio());
            ps.setInt(2, configuraciones.getUsuarios_idusuario());
            ps.setInt(3, configuraciones.getModulos_idmodulos());
            ps.setInt(4, configuraciones.getMacs_idmacs());
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

    //consulta para cargar las configuraciones en la vista
    public ArrayList<Configuracion> cargar(int mac) {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT idconfiguracion,directorio,modulo FROM configuracion inner join modulos"
                + " on modulos_idmodulo=modulos.idmodulo WHERE configuracion.macs_idmacs="+mac;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                Configuracion configuraciones = new Configuracion();
                configuraciones.setDirectorio(rs.getString("directorio"));
                configuraciones.setIdconfiguracion(rs.getInt("idconfiguracion"));
                configuraciones.setModulo(rs.getString("modulo"));
                lista.add(configuraciones);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
          
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    //consulta para modificar las configuraciones
    public boolean modificar(Configuracion configuraciones) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  configuracion SET directorio=?, modulos_idmodulo=?, usuarios_idusuario=? WHERE idconfiguracion=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, configuraciones.getDirectorio());
            ps.setInt(2, configuraciones.getModulos_idmodulos());
            ps.setInt(3, configuraciones.getUsuarios_idusuario());
            ps.setInt(4, configuraciones.getIdconfiguracion());
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
    public boolean eliminar(Configuracion configuraciones) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM configuracion  WHERE idconfiguracion=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, configuraciones.getIdconfiguracion());
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
