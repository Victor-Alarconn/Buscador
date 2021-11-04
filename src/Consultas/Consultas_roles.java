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
import javax.swing.JOptionPane;
import modelo.Rol;



/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_roles extends Conexion {


    
    
    public boolean registrar(Rol rol) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO roles (idroles,rol) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, rol.getIdroles());
            ps.setString(2, rol.getRol());
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

    public boolean consulta(Rol rol) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        if(con == null){
            JOptionPane.showMessageDialog(null, "error DB");
        }
        String sql = " SELECT * FROM roles WHERE rol=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, rol.getRol());
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
    
    
    
    

}
