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
import modelo.Servicios_has_Clientes_Potenciales;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Servicios_has_Clientes_Potenciales extends Conexion {

    public boolean registrarservicio(Servicios_has_Clientes_Potenciales servicios) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO servicios_has_clientes_potenciales  (servicios_idservicio,"
                + "clientes_potenciales_idclientes_potenciales,fecha_de_inicio) VALUES(?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, servicios.getServicios_idservicio());
            ps.setInt(2, servicios.getClientes_potenciales_idclientes_potenciales());
            ps.setString(3, servicios.getFecha_de_inicio());
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

    public boolean modificar(Servicios_has_Clientes_Potenciales servicios) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  servicios_has_clientes_potenciales SET nit=?, nombre=?, empresa=? WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, servicios.getFecha_de_inicio());
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

    public boolean buscar(Servicios_has_Clientes_Potenciales servicios) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM servicios_has_clientes_potenciales WHERE servicios_idservicio=? AND"
                + " clientes_potenciales_idclientes_potenciales=? AND fecha_de_inicio=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, servicios.getServicios_idservicio());
            ps.setInt(2, servicios.getClientes_potenciales_idclientes_potenciales());
            ps.setString(3, servicios.getFecha_de_inicio());
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

    public boolean eliminar(Servicios_has_Clientes_Potenciales servicios) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM servicios_has_clientes_potenciales WHERE servicios_idservicio=? AND"
                + " clientes_potenciales_idclientes_potenciales=? AND fecha_de_inicio=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, servicios.getServicios_idservicio());
            ps.setInt(2, servicios.getClientes_potenciales_idclientes_potenciales());
            ps.setString(3, servicios.getFecha_de_inicio());
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
