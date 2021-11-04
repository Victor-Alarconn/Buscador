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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import Modelos.Actividad;
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

    public boolean registrar(Actividad actividad) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO actividades (fecha,codigo,empresa,reporto,informe,del,"
                + "agregar,swp,macin,macout,hecho,concepto,prioridad,hora,qinformo,referencia) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, actividad.getFecha());
            ps.setString(2, actividad.getCodigo());
            ps.setString(3, actividad.getEmpresa());
            ps.setString(4, actividad.getReporto());
            ps.setString(5, actividad.getInforme());
            ps.setString(6, actividad.getDel());
            ps.setString(7, actividad.getAgregar());
            ps.setString(8, actividad.getSwp());
            ps.setString(9, actividad.getMacin());
            ps.setString(10, actividad.getMacout());
            ps.setString(11, actividad.getHecho());
            ps.setString(12, actividad.getConcepto());
            ps.setString(13, actividad.getPrioridad());
            ps.setString(14, actividad.getHora());
            ps.setString(15, actividad.getQinformo());
            ps.setString(16, actividad.getReferencia());
            ps.execute();
            jsonactividades();
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

    public boolean actualizarestado(Actividad actividad) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  actividades SET  hecho=? WHERE idactividades=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, actividad.getHecho());
            ps.setInt(2, actividad.getIdactividades());
            ps.execute();
            jsonactividades();
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

    public boolean modificar(Actividad actividad) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  actividades SET fecha=?,codigo=?,empresa=?,reporto=?,informe=?,del=?,agregar=?,swp=?,macin=?,macout=?  WHERE idactividades=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, actividad.getFecha());
            ps.setString(2, actividad.getCodigo());
            ps.setString(3, actividad.getEmpresa());
            ps.setString(4, actividad.getReporto());
            ps.setString(5, actividad.getInforme());
            ps.setString(6, actividad.getDel());
            ps.setString(7, actividad.getAgregar());
            ps.setString(8, actividad.getSwp());
            ps.setString(9, actividad.getMacin());
            ps.setString(10, actividad.getMacout());
            ps.setInt(11, actividad.getIdactividades());
            ps.execute();
            jsonactividades();
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

    public ArrayList<Actividad> llenar(String filtro, String fechade, String fechahasta) throws java.text.ParseException {
        ArrayList lista = new ArrayList();
        boolean f = false;
        if (filtro.equals("1")) {
            f = true;
        } else {
            if (filtro.equals("0")) {
                f = true;
            }
        }
        JSONParser parser = new JSONParser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try (Reader reader = new FileReader("temp" + File.separator + "actividades.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                if (f) {
                    Date date1 = dateFormat.parse((String) jsonObject.get("fecha"));
                    Date date2 = dateFormat.parse(fechade);
                    Date date3 = dateFormat.parse(fechahasta);
                    if (filtro.equals((String) jsonObject.get("hecho"))) {
                        if (date1.compareTo(date3) == 0 || date1.compareTo(date2) == 0) {
                            lista.add(crearacti(jsonObject));
                        } else {
                            if (date1.before(date3) && date1.after(date2)) {
                                lista.add(crearacti(jsonObject));
                            }
                        }
                    }
                } else {
                    Date date1 = dateFormat.parse((String) jsonObject.get("fecha"));
                    Date date2 = dateFormat.parse(fechade);
                    Date date3 = dateFormat.parse(fechahasta);
                    if (date1.before(date3) && date1.after(date2) || date1.compareTo(date3) == 0 || date1.compareTo(date2) == 0) {
                        lista.add(crearacti(jsonObject));
                    }

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

    public ArrayList<Actividad> llenarinit(String fechade) throws java.text.ParseException {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try (Reader reader = new FileReader("temp" + File.separator + "actividades.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                Date date1 = dateFormat.parse((String) jsonObject.get("fecha"));
                Date date2 = dateFormat.parse(fechade);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_WEEK, -8);
                if (date1.before(date2) && date1.after(calendar.getTime()) || date1.compareTo(date2) == 0) {
                    lista.add(crearacti(jsonObject));
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

    public ArrayList<Actividad> buscarcaracter(String parametro, String filtro) {
        ArrayList lista = new ArrayList();
        boolean f = false;
        if (filtro.equals("1")) {
            f = true;
        } else {
            if (filtro.equals("0")) {
                f = true;
            }
        }
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "actividades.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                if (f) {
                    if (filtro.equals((String) jsonObject.get("hecho")) && ((String) jsonObject.values().toString()).contains(parametro)) {
                        lista.add(crearacti(jsonObject));
                    }
                } else {
                    if (((String) jsonObject.values().toString()).contains(parametro)) {
                        
                        lista.add(crearacti(jsonObject));
                    }
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

    private Actividad crearacti(JSONObject jsonObject) {
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
        actividad.setAgregar((String) jsonObject.get("agregar"));
        actividad.setSwp((String) jsonObject.get("swp"));
        actividad.setMacin((String) jsonObject.get("macin"));
        actividad.setMacout((String) jsonObject.get("macout"));
        actividad.setHecho((String) jsonObject.get("hecho"));
        actividad.setConcepto((String) jsonObject.get("concepto"));
        actividad.setPrioridad((String) jsonObject.get("prioridad"));
        actividad.setHora((String) jsonObject.get("hora"));
        actividad.setQinformo((String) jsonObject.get("qinformo"));
        actividad.setReferencia((String) jsonObject.get("referencia"));
        return actividad;
    }

}
