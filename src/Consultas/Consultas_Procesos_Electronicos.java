/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import Modelos.Proceso_Electronico;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author programacion01
 */
public class Consultas_Procesos_Electronicos extends Conexion {
    Recursos recursos = new Recursos();
    
    //consulta para registrar
    public boolean registrar(Proceso_Electronico proceso) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO procesos_electronicos (proceso,usuarios_idusuarios) VALUES(?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, proceso.getProceso());
            ps.setInt(2, proceso.getUsuarios_idusuarios());
            ps.execute();
            jsonprocesos();
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
    public boolean modificar(Proceso_Electronico proceso) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  procesos_electronicos SET proceso=? WHERE idp_electronicos=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, proceso.getProceso());
            ps.execute();
            jsonprocesos();
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
    public boolean eliminar(Proceso_Electronico proceso) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM procesos_electronicos  WHERE idp_electronicos=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, proceso.getIdp_electronicos());
            ps.execute();
            jsonprocesos();
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

    public void jsonprocesos() throws IOException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM procesos_electronicos";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "procesoselectonicos.json");
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
    public ArrayList<Proceso_Electronico> llenar() {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "procesoselectonicos.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                Proceso_Electronico proceso = new Proceso_Electronico();
                Long myLong = (Long) jsonObject.get("idp_electronicos");
                int id = Math.toIntExact(myLong);
                proceso.setIdp_electronicos(id);
                proceso.setProceso((String) jsonObject.get("proceso"));
                lista.add(proceso);
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
