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
import modelo.Servicio;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Servicio extends Conexion {
    
    //consulta para registrar
    public boolean registrar(Servicio servicio) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO servicios (servicio) VALUES(?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, servicio.getServicio());
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
    public boolean modificar(Servicio servicio) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  servicios SET servicio=? WHERE idservicio=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, servicio.getServicio());
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
    
    //consultas eliminar
    public boolean eliminar(Servicio servicio) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM servicios  WHERE servicio=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, servicio.getServicio());
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
    
    //consulta para saber si un servicio contiene un letra
    public ArrayList<Servicio> buscarcaracter(String parametro) {
        ArrayList listaPersona = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM servicios  WHERE servicio LIKE'%" + parametro + "%'";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setIdservicio(Integer.parseInt(rs.getString(1)));
                servicio.setServicio(rs.getString(2));
                listaPersona.add(servicio);
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
    
    //consulta para buscar servicios
    public boolean buscar(Servicio servicio) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM servicios  WHERE servicio=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, servicio.getServicio());
            rs = ps.executeQuery();

            if (rs.next()) {
                servicio.setIdservicio(Integer.parseInt(rs.getString("idservicio")));
                servicio.setServicio(rs.getString("servicio"));
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

    //consulta para llenar la tabla de servicios y combobox
    public ArrayList<String> llenar() {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM servicios";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
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
