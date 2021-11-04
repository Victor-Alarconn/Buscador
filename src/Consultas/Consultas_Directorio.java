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
import Modelos.Cliente;
import Modelos.Directorio;

/**
 *
 * @author yonathan
 */
public class Consultas_Directorio extends Conexion {

    //consulta para registrar
    public boolean registrar(Directorio directorio) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO directorios (carpeta, usuarios_idusuario,"
                + " directorios_iddirectorios, nodo_level) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, directorio.getCarpeta());
            ps.setInt(2, directorio.getUsuarios_idusuarios());
            ps.setInt(3, directorio.getDirectorios_iddirectorios());
            ps.setInt(4, directorio.getNodo_level());
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
                mdirectorio.setDirectorios_iddirectorios(rs.getInt("directorios_iddirectorios"));
                mdirectorio.setNodo_level(rs.getInt("nodo_level"));
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
        String sql = " DELETE FROM directorios  WHERE iddirectorios=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, directorio.getIddirectorios());
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
    
    //consulta para traer las rutas de los clientes en el controlador directorio para actualizar las carpetas
    public ArrayList<Cliente> rutas() {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT ruta FROM clientes_potenciales";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setRuta(rs.getString("ruta"));
                lista.add(cliente);
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
