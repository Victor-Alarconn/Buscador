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
import modelo.Subcarpeta;

/**
 *
 * @author yonathan
 */
public class Consultas_SubCarpetas extends Conexion{
    
    public  boolean registrar(Subcarpeta subcarpeta){
        
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO subcarpetas (subcarpeta, directorios_iddirectorios, usuarios_idusuario) VALUES(?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, subcarpeta.getSubcarpeta());
            ps.setInt(2, subcarpeta.getDirectorios_iddirectorios());
            ps.setInt(3, subcarpeta.getUsuario_idusurio());
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
    public boolean eliminar(Subcarpeta subcarpeta) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM subcarpetas  WHERE subcarpeta=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, subcarpeta.getSubcarpeta());
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
    public ArrayList<String> llenar(Subcarpeta subcarpeta) {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM subcarpetas WHERE directorios_iddirectorios=?";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, subcarpeta.getDirectorios_iddirectorios());
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("subcarpeta"));
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
    
    //consulta para traer todas las subcarpetas
    public ArrayList<Subcarpeta>allsubcategorias(){
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM subcarpetas";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Subcarpeta msubscarpeta = new Subcarpeta();
                msubscarpeta.setDirectorios_iddirectorios(rs.getInt("directorios_iddirectorios"));
                msubscarpeta.setSubcarpeta(rs.getString("subcarpeta"));
                lista.add(msubscarpeta);
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
