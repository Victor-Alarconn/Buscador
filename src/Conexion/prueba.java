/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Yonathan Carvajal
 */
public class prueba extends conect {
    
   public boolean registrar(Usuario user) {
        com.mysql.jdbc.PreparedStatement ps = null;
        com.mysql.jdbc.Connection con = getConexion();

        String sql = "INSERT INTO usuarios (nombre,apellido, numero_documento,contrasena,roles_idroles,configuraciones,crearcliente,carpetas,servicios,otros,crearusuarios,buscar,editarcliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getNumero_documento());
            ps.setString(4, this.MD5(user.getContrasena()));
            ps.setInt(5, user.getRol());
            ps.setInt(6, user.getConfiguraciones());
            ps.setInt(7, user.getCrearcliente());
            ps.setInt(8, user.getCarpetas());
            ps.setInt(9, user.getServicios());
            ps.setInt(10, user.getOtros());
            ps.setInt(11, user.getCrearusuarios());
            ps.setInt(12, user.getBuscar());
            ps.setInt(13, user.getEditarcliente());
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
   public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");

            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {

        }
        return null;
    }
    
    
}
