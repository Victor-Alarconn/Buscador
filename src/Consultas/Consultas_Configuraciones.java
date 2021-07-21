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
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Configuracion;
import modelo.Mac;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Configuraciones extends Conexion {
    
    Recursos recursos = new Recursos();
    Mac mmac = new Mac();
    //consulta para registrar 
    public boolean registrar(Configuracion configuraciones) throws IOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "INSERT INTO configuracion (directorio,usuarios_idusuario,modulos_idmodulo,macs_idmacs) VALUES(?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, configuraciones.getDirectorio());
            ps.setInt(2, configuraciones.getUsuarios_idusuario());
            ps.setInt(3, configuraciones.getModulos_idmodulos());
            ps.setInt(4, configuraciones.getMacs_idmacs());
            ps.execute();
            jsonconfiguraciones();
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
    
    
    public void jsonconfiguraciones() throws IOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String mac = mmac.conseguirMAC();
        String sql = " SELECT idconfiguracion,directorio,modulo FROM configuracion "
                + "inner join modulos "
                + "on modulos_idmodulo=modulos.idmodulo "
                + "inner join macs "
                + "on  configuracion.macs_idmacs=macs.idmacs WHERE macs.macs='" + mac + "'";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "configuraciones.json");
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

    //consulta para cargar las configuraciones en la vista
    public ArrayList<Configuracion> cargar() throws ParseException {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "configuraciones.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                Long myLong = (Long) jsonObject.get("idconfiguracion");
                Configuracion configuraciones = new Configuracion();
                configuraciones.setDirectorio((String) jsonObject.get("directorio"));
                configuraciones.setIdconfiguracion(Math.toIntExact(myLong));
                configuraciones.setModulo((String) jsonObject.get("modulo"));
                lista.add(configuraciones);
            }
            return lista;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    

    //consulta para modificar las configuraciones
    public boolean modificar(Configuracion configuraciones) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  configuracion SET directorio=?, modulos_idmodulo=?, usuarios_idusuario=? WHERE idconfiguracion=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, configuraciones.getDirectorio());
            ps.setInt(2, configuraciones.getModulos_idmodulos());
            ps.setInt(3, configuraciones.getUsuarios_idusuario());
            ps.setInt(4, configuraciones.getIdconfiguracion());
            ps.execute();
            jsonconfiguraciones();
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
    public boolean eliminar(Configuracion configuraciones) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM configuracion  WHERE idconfiguracion=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, configuraciones.getIdconfiguracion());
            jsonconfiguraciones();
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
