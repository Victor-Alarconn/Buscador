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
import modelo.Mac;

/**
 *
 * @author yonat
 */
public class Consultas_Mac extends Conexion {

    public boolean registrar(Mac mac) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO macs (macs) VALUES(?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, mac.getMacs());
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
    
    public ArrayList<String> llenar() {
        ArrayList lista = new ArrayList();
        com.mysql.jdbc.PreparedStatement ps = null;
        ResultSet rs = null;
        com.mysql.jdbc.Connection con = getConexion();
        String sql = " SELECT * FROM macs";

        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("macs"));
            }
            return lista;
        } catch (SQLException e) {
            System.err.println(e);
//            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
    }
    
    // consultala mac existente
    public boolean buscar(Mac mac) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM macs  WHERE macs.macs=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, mac.getMacs());
            rs = ps.executeQuery();
            if (rs.next()) {
                mac.setIdmacs(rs.getInt("idmacs"));
                mac.setMacs(rs.getString("macs"));
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
}
