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
import modelo.Directorio;

/**
 *
 * @author yonathan
 */
public class Consultas_Directorio extends Conexion {

    //consulta para registrar
    public boolean registrar(Directorio directorio) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO directorios (carpeta, usuarios_idusuario) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, directorio.getCarpeta());
            ps.setInt(2, directorio.getUsuarios_idusuarios());
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
    
    //consulta para cargar los directorios en la vista
    public ArrayList<Directorio> llenar() {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM directorios";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Directorio mdirectorio = new Directorio();
                mdirectorio.setCarpeta(rs.getString("carpeta"));
                mdirectorio.setIddirectorios(rs.getInt("iddirectorios"));
                lista.add(mdirectorio);
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
    
    //consulta para eliminar directorios
    public boolean eliminar(Directorio directorio) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM directorios  WHERE carpeta=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, directorio.getCarpeta());
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
