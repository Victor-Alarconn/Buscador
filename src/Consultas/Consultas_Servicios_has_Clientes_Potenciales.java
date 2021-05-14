/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Servicios_has_Clientes_Potenciales extends Conexion  {
    
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
}
