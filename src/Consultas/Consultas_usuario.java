/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import controlador.OrganizadorController;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente_Potencial;
import modelo.Rol;
import modelo.Usuario;
import vistas.Configuraciones;
import vistas.Principal;
import vistas.login;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_usuario extends Conexion {

    public boolean registrar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (nombre,apellido, numero_documento,contrasena,roles_idroles,configuraciones,crearcliente,carpetas,servicios,otros,crearusuarios,buscar,editarcliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
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

    public boolean modificar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  usuarios SET nombre=?, apellido=? WHERE idusuario=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setInt(3, user.getIdusuario());
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

    public boolean eliminar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM usuarios  WHERE idusuario=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, user.getIdusuario());
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

    public ArrayList<Usuario> buscarcaracter(String parametro) {
        ArrayList listaPersona = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM usuarios  WHERE nombre LIKE'%" + parametro + "%'";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdusuario(Integer.parseInt(rs.getString(1)));
                user.setNombre(rs.getString(2));
                user.setApellido(rs.getString(3));
                user.setNumero_documento(rs.getString(4));
                listaPersona.add(user);
            }
            return listaPersona;
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

    public boolean buscar(Rol roles) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM roles  WHERE roles.rol=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, roles.getRol());
            rs = ps.executeQuery();
            if (rs.next()) {
                roles.setIdroles(Integer.parseInt(rs.getString("idroles")));
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

    public ArrayList<String> llenar() {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM roles";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                lista.add(rs.getString("rol"));
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

    public boolean login(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM usuarios WHERE usuarios.nombre=? AND usuarios.contrasena=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, this.MD5(user.getContrasena()));
            rs = ps.executeQuery();
            if (rs.next()) {
                
                user.setRol(Integer.parseInt(rs.getString("roles_idroles")));
                user.setConfiguraciones(Integer.parseInt(rs.getString("configuraciones")));
                user.setCrearcliente(Integer.parseInt(rs.getString("crearcliente")));
                user.setCarpetas(Integer.parseInt(rs.getString("carpetas")));
                user.setServicios(Integer.parseInt(rs.getString("servicios")));
                user.setOtros(Integer.parseInt(rs.getString("otros")));
                user.setCrearusuarios(Integer.parseInt(rs.getString("crearusuarios")));
                user.setBuscar(Integer.parseInt(rs.getString("buscar")));
                user.setEditarcliente(Integer.parseInt(rs.getString("editarcliente")));
//                user.setConfiguraciones(Integer.parseInt(rs.getString("configuraciones")));
                Principal principal = new Principal(user);
//                user.setIdusuario(rs.getInt(1));
                
                Cliente_Potencial mod = new Cliente_Potencial();
                Consultas_Cliente_Potencial modcp = new Consultas_Cliente_Potencial();
                OrganizadorController bctrl = new OrganizadorController(mod, modcp, principal);
                bctrl.iniciar();

                principal.setExtendedState(MAXIMIZED_BOTH);
                principal.setVisible(true);
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
    
    public String MD5(String md5){
        try{
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString(); 
        }catch(java.security.NoSuchAlgorithmException e){
            
        }
        return null; 
    }
}
