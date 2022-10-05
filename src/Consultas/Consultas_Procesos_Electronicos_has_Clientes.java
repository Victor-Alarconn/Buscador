/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import Modelos.Procesos_Electronicos_has_Clientes;
import Organizador.Recursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author programacion01
 */
public class Consultas_Procesos_Electronicos_has_Clientes extends Conexion{
     Recursos recursos = new Recursos();

    public boolean registrarservicio(Procesos_Electronicos_has_Clientes proceso) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO procesos_electronicos_has_clientes  (idp_electronicos,"
                + "idclientes_potenciales) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, proceso.getIdp_electronicos());
            ps.setInt(2, proceso.getIdclientes_potenciales());
            ps.execute();
            jsonserviciosclientes();
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
 
    public boolean buscar(Procesos_Electronicos_has_Clientes proceso) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM procesos_electronicos_has_clientes WHERE idp_electronicos=? AND"
                + " idclientes_potenciales=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, proceso.getIdp_electronicos());
            ps.setInt(2, proceso.getIdclientes_potenciales());
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
    
    //retorna json de procesos clientes
    public void jsonserviciosclientes() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT procesos_electronicos.idp_electronicos,proceso,idclientes_potenciales "
                + "FROM procesos_electronicos_has_clientes, procesos_electronicos "
                + "where procesos_electronicos.idp_electronicos=procesos_electronicos_has_clientes.idp_electronicos ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "proceoso_has_clientes.json");
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
    }

    public boolean eliminar(Procesos_Electronicos_has_Clientes proceso) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM procesos_electronicos_has_clientes WHERE idp_electronicos=? AND"
                + " idclientes_potenciales=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, proceso.getIdp_electronicos());
            ps.setInt(2, proceso.getIdclientes_potenciales());
            ps.execute();
            jsonserviciosclientes();
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
