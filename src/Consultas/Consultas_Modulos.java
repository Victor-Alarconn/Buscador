/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import Organizador.Recursos;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Modulo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Modulos extends Conexion {

    Recursos recursos = new Recursos();

    public boolean registrar(Modulo modulo) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO modulos (modulo,usuarios_idusuario) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, modulo.getModulo());
            ps.setInt(2, modulo.getUsuarios_idusuario());
            ps.execute();
            jsonmodulos();
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
    public boolean eliminar(Modulo modulo) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM modulos  WHERE idmodulo=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, modulo.getIdmodulo());
            ps.execute();
            jsonmodulos();
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
    
    //consulta para llenar el json temporal de modulos
    public void jsonmodulos() throws IOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM modulos";
        
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "modulos.json");
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
    //consulta para cargar los modulos en la vista
    public ArrayList<Modulo> llenar() {
        ArrayList lista = new ArrayList();
            JSONParser parser = new JSONParser();
            try (Reader reader = new FileReader("temp"+File.separator+"modulos.json")) {
                JSONArray jsonarray = (JSONArray) parser.parse(reader);
                for (int i = 0; i < jsonarray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                    Long myLong = (Long) jsonObject.get("idmodulo");
                    int idmodulo = Math.toIntExact(myLong);
                    Long usuarios_idusuari = (Long) jsonObject.get("usuarios_idusuario");
                    int usuarios_idusuario = Math.toIntExact(usuarios_idusuari);
                    Modulo modulo = new Modulo();
                    modulo.setIdmodulo(idmodulo);
                    modulo.setModulo((String) jsonObject.get("modulo"));
                    modulo.setUsuarios_idusuario(usuarios_idusuario);
                    lista.add(modulo);
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
