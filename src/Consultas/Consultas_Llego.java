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
import Modelos.Clases;
import Modelos.Llego;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author yonathan
 */
public class Consultas_Llego extends Conexion {

    Recursos recursos = new Recursos();

    // consulta para registrar
    public boolean registrar(Llego llego) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO llego (llego,usuarios_idusuario) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, llego.getLlego());
            ps.setInt(2, llego.getUsuarios_idusuarios());
            ps.execute();
            jsonllego();
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
    public boolean eliminar(Llego llego) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM llego  WHERE idllego=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, llego.getIdllego());
            ps.execute();
            jsonllego();
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

    public void jsonllego() throws IOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM llego";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "llego.json");
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

    //consulta para llenar tablas y combobox
    public ArrayList<Llego> llenar() {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "llego.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                Llego llego = new Llego();
                Long myLong = (Long) jsonObject.get("idllego");
                int idllego = Math.toIntExact(myLong);
                llego.setIdllego(idllego);
                llego.setLlego((String) jsonObject.get("llego"));
                lista.add(llego);
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
