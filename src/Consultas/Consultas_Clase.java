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
import Modelos.Clases;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author yonathan
 */
public class Consultas_Clase extends Conexion {

     Recursos recursos = new Recursos();
    

    //consulta para registrar
    public boolean registrar(Clases clases) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO clases (clase,usuarios_idusuario) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, clases.getClase());
            ps.setInt(2, clases.getUsuarios_idusuarios());
            ps.execute();
            jsonclases();
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
    public boolean eliminar(Clases clases) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM clases  WHERE idclases=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, clases.getIdclases());
            ps.execute();
            jsonclases();
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

    public void jsonclases() throws IOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM clases";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "clases.json");
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

    //consulta para llenar los los combobox
    public ArrayList<Clases> llenar() {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp"+File.separator+"clases.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                Clases clase = new Clases();
                Long myLong = (Long) jsonObject.get("idclases");
                int idmodulo = Math.toIntExact(myLong);
                clase.setIdclases(idmodulo);
                clase.setClase((String) jsonObject.get("clase"));
                lista.add(clase);
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
