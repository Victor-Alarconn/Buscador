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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Servicio;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Servicios extends Conexion {

    Recursos recursos = new Recursos();
    
    //consulta para registrar
    public boolean registrar(Servicio servicio) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO servicios (servicio,usuarios_idusuario) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, servicio.getServicio());
            ps.setInt(2, servicio.getUsuarios_idusuarios());
            ps.execute();
            jsonservicios();
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
    public boolean modificar(Servicio servicio) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  servicios SET servicio=? WHERE idservicio=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, servicio.getServicio());
            ps.execute();
            jsonservicios();
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
    public boolean eliminar(Servicio servicio) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM servicios  WHERE idservicio=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, servicio.getIdservicio());
            ps.execute();
            jsonservicios();
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

    public void jsonservicios() throws IOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM servicios";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "servicios.json");
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

    //consulta para llenar la tabla de servicios y combobox
    public ArrayList<Servicio> llenar() {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "servicios.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                Servicio servicio = new Servicio();
                Long myLong = (Long) jsonObject.get("idservicio");
                int id = Math.toIntExact(myLong);
                servicio.setIdservicio(id);
                servicio.setServicio((String) jsonObject.get("servicio"));
                lista.add(servicio);
            }
            return lista;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

}
