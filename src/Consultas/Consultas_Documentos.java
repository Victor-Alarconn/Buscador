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
import modelo.Documentos;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Documentos extends Conexion {
    
    //consulta para registrar
    public boolean registrar(Documentos documentos) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO documentos (documento, fecha_inicio, fecha_vencimiento,"
                + "clientes_potenciales_idclientes_potenciales) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, documentos.getDocumento());
            ps.setString(2, documentos.getFecha_inicio());
            ps.setString(3, documentos.getFecha_vencimiento());
            ps.setInt(4, documentos.getClientes_potenciales_idclientes_potenciales());
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
    
    //consulta para buscar documentos
    public boolean buscar(int documentos) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM documentos WHERE iddocumentos=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, documentos);
            rs = ps.executeQuery();
            if (rs.next()) {
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
    
    //consulta para eliminar
    public boolean eliminar(Documentos documentos){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM documentos  WHERE iddocumentos=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, documentos.getIddocumentos());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                 System.err.println(e);
            }
        }
        
    }
    
}
