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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Rol;
import modelo.Usuario;
import org.json.simple.parser.ParseException;
import vistas.Principal;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_usuario extends Conexion {

    
    
    //consulta para registrar 
    public boolean registrar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO usuarios (nombre,contrasena,roles_idroles,"
                + "configuraciones,crearcliente,carpetas,"
                + "otros,crearusuarios,editarcliente,buscar,"
                + "backups) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, this.MD5(user.getContrasena()));
            ps.setInt(3, user.getRol());
            ps.setInt(4, user.getConfiguraciones());
            ps.setInt(5, user.getCrearcliente());
            ps.setInt(6, user.getCarpetas());
            ps.setInt(7, user.getOtros());
            ps.setInt(8, user.getCrearusuarios());
            ps.setInt(9, user.getEditarcliente());
            ps.setInt(10, user.getBuscar());
            ps.setInt(11, user.getBackups());
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

    //consulta para modificar 
    public boolean modificar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  usuarios SET  estado=? WHERE nombre=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, user.getEstado());
            ps.setString(2, user.getNombre());
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

    //consulta para buscar por filtrp y parametro en la tabla de usuarios
    public ArrayList<Usuario> buscarcaracter(String parametro, String filtro) {
        ArrayList listaPersona = new ArrayList();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM usuarios  WHERE " + filtro + " LIKE'%" + parametro + "%'";
        Rol rol = new Rol();
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while (rs.next()) {
                
                Usuario user = new Usuario();
                user.setIdusuario(Integer.parseInt(rs.getString(1)));
                user.setNombre(rs.getString("nombre"));
                rol.setIdroles(Integer.parseInt(rs.getString("roles_idroles")));
                this.buscarrol(rol);
                user.setSobrerol(rol.getRol());
                if (Integer.parseInt(rs.getString("estado")) == 1) {
                    user.setSobreestado("Activo");
                } else {
                    user.setSobreestado("Desactivado");
                }
                
                
                
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

    //consult para buscar el rol por nombre 
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

//    consulta para buscar el rol por id
    public boolean buscarrol(Rol roles) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM roles  WHERE roles.idroles=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, roles.getIdroles());
            rs = ps.executeQuery();
            if (rs.next()) {
                roles.setRol(rs.getString("rol"));
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

    //consulta para traer la informacion del usuario por default
    public boolean buscarusueriodefault(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM usuarios  WHERE usuarios.nombre=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setEstado(Integer.parseInt(rs.getString("estado")));
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

    //consulta para traer todos los roles
    public ArrayList<Rol> llenar() {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM roles";
        
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdroles(rs.getInt("idroles"));
                rol.setRol(rs.getString("rol"));
                
                lista.add(rol);
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

    //consulta para acceder por login 
    public boolean login(Usuario user) throws IOException, ParseException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM usuarios WHERE usuarios.nombre=? AND usuarios.contrasena=? AND usuarios.estado=1";
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
                user.setOtros(Integer.parseInt(rs.getString("otros")));
                user.setCrearusuarios(Integer.parseInt(rs.getString("crearusuarios")));
                user.setEditarcliente(Integer.parseInt(rs.getString("editarcliente")));
                user.setIdusuario(Integer.parseInt(rs.getString("idusuario")));
                user.setBuscar(rs.getInt("buscar"));
                user.setBackups(rs.getInt("backups"));
                Principal principal = new Principal(user);
//                user.setIdusuario(rs.getInt(1));

                Cliente mod = new Cliente();
                Consultas_Cliente modcp = new Consultas_Cliente();
                OrganizadorController bctrl = new OrganizadorController(mod, modcp, principal, user);
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

    //consulta para verificar si el usuario por defaul existe
    public boolean logindefault(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM usuarios WHERE usuarios.nombre=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setIdusuario(rs.getInt("idusuario"));
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

    //funcion para encriptar un string 
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

    //consulta para trer la informacion de un usuario
    public boolean buscarusuario(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM usuarios inner join roles on usuarios.roles_idroles=roles.idroles WHERE usuarios.idusuario=? ";
        Rol rol = new Rol();
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, user.getIdusuario());
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setNombre(rs.getString("nombre"));
                user.setRol(rs.getInt("roles_idroles"));
                user.setConfiguraciones(Integer.parseInt(rs.getString("configuraciones")));
                user.setCrearcliente(Integer.parseInt(rs.getString("crearcliente")));
                user.setCarpetas(Integer.parseInt(rs.getString("carpetas")));
                user.setOtros(Integer.parseInt(rs.getString("otros")));
                user.setCrearusuarios(Integer.parseInt(rs.getString("crearusuarios")));
                user.setEditarcliente(Integer.parseInt(rs.getString("editarcliente")));
                user.setEstado(Integer.parseInt(rs.getString("estado")));
                user.setBuscar(rs.getInt("buscar"));
                user.setBackups(rs.getInt("backups"));
                user.setSobrerol(rs.getString("rol"));
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

    //consulta para modificar un usuario
    public boolean modificarusuario(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  usuarios SET  nombre=?,"
                + " roles_idroles=?, configuraciones=?, crearcliente=?, carpetas=?, otros=?,"
                + "crearusuarios=?, editarcliente=?, estado=?,buscar=?,backups=? WHERE idusuario=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setInt(2, user.getRol());
            ps.setInt(3, user.getConfiguraciones());
            ps.setInt(4, user.getCrearcliente());
            ps.setInt(5, user.getCarpetas());
            ps.setInt(6, user.getOtros());
            ps.setInt(7, user.getCrearusuarios());
            ps.setInt(8, user.getEditarcliente());
            ps.setInt(9, user.getEstado());
            ps.setInt(10, user.getBuscar());
            ps.setInt(11, user.getBackups());
            ps.setInt(12, user.getIdusuario());
            ps.execute();
            if (!user.getContrasena().equals("")) {
                this.modificarcontrasena(user);
            }
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

    //consulta para modificar la contraseña
    public boolean modificarcontrasena(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  usuarios SET contrasena=? WHERE idusuario=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, this.MD5(user.getContrasena()));
            ps.setInt(2, user.getIdusuario());
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
