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
import modelo.Actividad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author programacion01
 */
public class Consultas_Actividad extends Conexion {

    Recursos recursos = new Recursos();

    public ArrayList<Actividad> llenar() {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "actividades.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                Actividad actividad = new Actividad();
                Long myLong = (Long) jsonObject.get("idactividades");
                int id = Math.toIntExact(myLong);
                actividad.setIdactividades(id);
                actividad.setFecha((String) jsonObject.get("fecha"));
                actividad.setCodigo((String) jsonObject.get("codigo"));
                actividad.setEmpresa((String) jsonObject.get("empresa"));
                actividad.setReporto((String) jsonObject.get("reporto"));
                actividad.setInforme((String) jsonObject.get("informe"));
                actividad.setDel((String) jsonObject.get("del"));
                actividad.setAdd((String) jsonObject.get("add"));
                actividad.setSwp((String) jsonObject.get("swp"));
                actividad.setMacin((String) jsonObject.get("macin"));
                actividad.setMacout((String) jsonObject.get("macout"));
                lista.add(actividad);
            }
            return lista;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void jsonactividades() throws IOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM actividades order by idactividades DESC";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "actividades.json");
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

    public ArrayList<Actividad> buscarcaracter(String parametro) {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "actividades.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
//                System.out.println(((String) jsonObject.values().toString()).contains(parametro));                
                if (((String) jsonObject.values().toString()).contains(parametro)) {
                    Actividad actividad = new Actividad();
                    Long myLong = (Long) jsonObject.get("idactividades");
                    int id = Math.toIntExact(myLong);
                    actividad.setIdactividades(id);
                    actividad.setFecha((String) jsonObject.get("fecha"));
                    actividad.setCodigo((String) jsonObject.get("codigo"));
                    actividad.setEmpresa((String) jsonObject.get("empresa"));
                    actividad.setReporto((String) jsonObject.get("reporto"));
                    actividad.setInforme((String) jsonObject.get("informe"));
                    actividad.setDel((String) jsonObject.get("del"));
                    actividad.setAdd((String) jsonObject.get("add"));
                    actividad.setSwp((String) jsonObject.get("swp"));
                    actividad.setMacin((String) jsonObject.get("macin"));
                    actividad.setMacout((String) jsonObject.get("macout"));
                    lista.add(actividad);
                }

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
