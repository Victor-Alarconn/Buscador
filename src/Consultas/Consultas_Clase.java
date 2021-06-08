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
import modelo.Clases;

/**
 *
 * @author yonathan
 */
public class Consultas_Clase  extends Conexion {
    //consulta para registrar
    public boolean registrar(Clases clases) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO clases (clase) VALUES(?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, clases.getClase());
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
    public boolean eliminar(Clases clases) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM clases  WHERE clase=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, clases.getClase());
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

    //consulta para llenar los los combobox
    public ArrayList<String> llenar() {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM clases";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("clase"));
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
