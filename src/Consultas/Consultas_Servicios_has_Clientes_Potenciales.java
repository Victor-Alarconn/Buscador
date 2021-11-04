/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import Organizador.Recursos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelos.Servicios_has_Clientes_Potenciales;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Servicios_has_Clientes_Potenciales extends Conexion {
    
    Recursos recursos = new Recursos();

    public boolean registrarservicio(Servicios_has_Clientes_Potenciales servicios) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO servicios_has_clientes_potenciales  (servicios_idservicio,"
                + "clientes_potenciales_idclientes_potenciales) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, servicios.getServicios_idservicio());
            ps.setInt(2, servicios.getClientes_potenciales_idclientes_potenciales());
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
 
    public boolean buscar(Servicios_has_Clientes_Potenciales servicios) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM servicios_has_clientes_potenciales WHERE servicios_idservicio=? AND"
                + " clientes_potenciales_idclientes_potenciales=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, servicios.getServicios_idservicio());
            ps.setInt(2, servicios.getClientes_potenciales_idclientes_potenciales());
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
    
    //retorna json de servicios clientes
    public void jsonserviciosclientes() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT servicio,servicios.idservicio,clientes_potenciales_idclientes_potenciales  FROM servicios_has_clientes_potenciales INNER JOIN"
                + " servicios ON servicios.idservicio=servicios_has_clientes_potenciales.servicios_idservicio ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "serviciosclientes.json");
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

    public boolean eliminar(Servicios_has_Clientes_Potenciales servicios) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM servicios_has_clientes_potenciales WHERE servicios_idservicio=? AND"
                + " clientes_potenciales_idclientes_potenciales=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, servicios.getServicios_idservicio());
            ps.setInt(2, servicios.getClientes_potenciales_idclientes_potenciales());
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
