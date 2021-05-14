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
import modelo.Documentos;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Documentos extends Conexion {
    
    public boolean registrar(Documentos documentos) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO documentos (documento, fecha_inicio, fecha_vencimiento,"
                + "clientes_potenciales_idclientes_potenciales) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, documentos.getDocumento());
            ps.setString(2, documentos.getFecha_inicio());
            ps.setString(3, documentos.getFecha_vencimiento());
            ps.setInt(4, documentos.getClientes_potenciales_idclientes_potenciales());
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
