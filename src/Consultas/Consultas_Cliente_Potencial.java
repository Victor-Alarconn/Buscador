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
import modelo.Cliente_Potencial;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Cliente_Potencial extends Conexion {
    public boolean registrar(Cliente_Potencial cliente){
        PreparedStatement ps = null;
        Connection con = getConexion();
       
        String sql = "INSERT INTO clientes_potenciales (nit,nombre,empresa,"
                + "celular1,celular2,email,fecha_llegada,clase,retiro,notas,codigo,llego,categoria,ruta,dv) VALUES(?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getEmpresa());
            ps.setString(4, cliente.getCelular1());
            ps.setString(5, cliente.getCelular2());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getFecha_llegada());
            ps.setString(8, cliente.getClase());
            ps.setString(9, cliente.getRetiro());
            ps.setString(10, cliente.getNotas());
            ps.setString(11, cliente.getCodigo());
            ps.setString(12, cliente.getLlego());
            ps.setString(13, cliente.getCategoria());
            ps.setString(14, cliente.getRuta());
            ps.setString(15, cliente.getDv());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                 System.err.println(e);
            }
        }
        
    }
    
    public boolean modificar(Cliente_Potencial cliente){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  clientes_potenciales SET nit=?, nombre=?, empresa=?,"
                + " celular1=?, celular2=?, email=?, fecha_llegada=?, clase=?, retiro=?, notas=?, codigo=?, llego=?, categoria=?,dv=?"
                + " WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getEmpresa());
            ps.setString(4, cliente.getCelular1());
            ps.setString(5, cliente.getCelular2());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getFecha_llegada());
            ps.setString(8, cliente.getClase());
            ps.setString(9, cliente.getRetiro());
            ps.setString(10, cliente.getNotas());
            ps.setString(11, cliente.getCodigo());
            ps.setString(12, cliente.getLlego());
            ps.setString(13, cliente.getCategoria());
            ps.setString(14, cliente.getDv());
            ps.setInt(15, cliente.getIdclientes_potenciales());
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
    
    public boolean eliminar(Cliente_Potencial cliente){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM clientes_potenciales  WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdclientes_potenciales());
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
     
    public boolean buscar(Cliente_Potencial cliente){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM clientes_potenciales  WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdclientes_potenciales());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cliente.setIdclientes_potenciales(Integer.parseInt(rs.getString("idclientes_potenciales")));
                cliente.setNit(rs.getString("nit"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmpresa(rs.getString("empresa"));
                cliente.setCelular1(rs.getString("celular1"));
                cliente.setCelular2(rs.getString("celular2"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFecha_llegada(rs.getString("fecha_llegada"));
                cliente.setClase(rs.getString("clase"));
                cliente.setRetiro(rs.getString("retiro"));
                cliente.setNotas(rs.getString("notas"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setLlego(rs.getString("llego"));
                cliente.setCategoria(rs.getString("categoria"));
                cliente.setRuta(rs.getString("ruta"));
                cliente.setDv(rs.getString("dv"));
                return true;
            }
            
            return false;
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
    
    public boolean buscarr(Cliente_Potencial cliente){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM clientes_potenciales  WHERE nit=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cliente.getNit());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cliente.setIdclientes_potenciales(Integer.parseInt(rs.getString("idclientes_potenciales")));
                cliente.setNit(rs.getString("nit"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmpresa(rs.getString("empresa"));
                cliente.setCelular1(rs.getString("celular1"));
                cliente.setCelular2(rs.getString("celular2"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFecha_llegada(rs.getString("fecha_llegada"));
                cliente.setClase(rs.getString("clase"));
                cliente.setRetiro(rs.getString("retiro"));
                cliente.setNotas(rs.getString("notas"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setLlego(rs.getString("llego"));
                cliente.setCategoria(rs.getString("categoria"));
                cliente.setRuta(rs.getString("ruta"));
                cliente.setDv(rs.getString("dv"));
                return true;
            }
            
            return false;
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
    
    public ArrayList<Cliente_Potencial> buscarcaracter(String parametro) {
        ArrayList listaPersona = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM clientes_potenciales  WHERE nit LIKE'%" + parametro + "%'";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Cliente_Potencial cliente = new Cliente_Potencial();
                cliente.setIdclientes_potenciales(Integer.parseInt(rs.getString(1)));
                cliente.setNit(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setCodigo(rs.getString(12));
                cliente.setFecha_llegada(rs.getString(8));
                cliente.setRuta(rs.getString(15));
                listaPersona.add(cliente);
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
    
    public ArrayList<String> llenar(Cliente_Potencial cliente) {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT servicios.servicio,servicios_has_clientes_potenciales.fecha_de_inicio FROM servicios_has_clientes_potenciales INNER JOIN"
                + " servicios ON servicios.idservicio=servicios_has_clientes_potenciales.servicios_idservicio "
                + "WHERE servicios_has_clientes_potenciales.clientes_potenciales_idclientes_potenciales=?";
        try {
//            ps = (PreparedStatement) con.prepareStatement(sql);
//            rs = ps.executeQuery();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdclientes_potenciales());
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("servicio"));
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
