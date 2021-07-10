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
import modelo.Modalidad;

/**
 *
 * @author yonat
 */
public class Consultas_Modalidad extends Conexion{
    
     public boolean registrar(Modalidad modalidad) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO modalidad (modalidad,usuarios_idusuario) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, modalidad.getModalidad());
            ps.setInt(2, modalidad.getUsuarios_idusuario());
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
    public boolean eliminar(Modalidad modalidad) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM modalidad  WHERE idmodalidad=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, modalidad.getIdmodalidad());
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
    
    //consulta para llenar tablas y combobox
    public ArrayList<Modalidad> llenar() {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM modalidad";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Modalidad modalidad = new Modalidad();
                modalidad.setIdmodalidad(rs.getInt("idmodalidad"));
                modalidad.setModalidad(rs.getString("modalidad"));
                lista.add(modalidad);
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
