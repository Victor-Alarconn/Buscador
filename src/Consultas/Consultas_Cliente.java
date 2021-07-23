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
import modelo.Cliente;
import modelo.Documentos;
import modelo.Servicio;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Cliente extends Conexion {

    Recursos recursos = new Recursos();

    //consulta para registrar 
    public boolean registrar(Cliente cliente) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "INSERT INTO clientes_potenciales (nit,nombre,empresa,"
                + "celular1,celular2,email,fecha_llegada,clase,"
                + "modalidad,notas,codigo,llego,categoria,ruta,dv,"
                + "usuarios_idusuario,fecha_arriendo,contacto,"
                + "cliente_potencial,vlrprincipal,numequipos,vlrterminal,"
                + "electronica,sucursal,fechacotizacion,rutacotizacion,numero_cotizacion,"
                + "programa,equipos,valor_total) VALUES(?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getEmpresa());
            ps.setString(4, cliente.getCelular1());
            ps.setString(5, cliente.getCelular2());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getFecha_llegada());
            ps.setString(8, cliente.getClase());
            ps.setString(9, cliente.getModalidad());
            ps.setString(10, cliente.getNotas());
            ps.setString(11, cliente.getCodigo());
            ps.setString(12, cliente.getLlego());
            ps.setString(13, cliente.getCategoria());
            ps.setString(14, cliente.getRuta());
            ps.setString(15, cliente.getDv());
            ps.setInt(16, cliente.getUsuarios_idusuario());
            ps.setString(17, cliente.getFecha_arriendo());
            ps.setString(18, cliente.getContacto());
            ps.setInt(19, cliente.getCliente_potencial());
            ps.setInt(20, cliente.getVlrprincipal());
            ps.setInt(21, cliente.getNumequipos());
            ps.setInt(22, cliente.getVlrterminal());
            ps.setInt(23, cliente.getElectronica());
            ps.setInt(24, cliente.getSucursal());
            ps.setString(25, cliente.getFechacotizacion());
            ps.setString(26, cliente.getRutacotizacon());
            ps.setString(27, cliente.getNumero_cotizacion());
            ps.setInt(28, cliente.getPrograma());
            ps.setInt(29, cliente.getEqipos());
            ps.setString(30, cliente.getValor_total());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();// recupera el id autoincrementable del registro hecho
            if (rs != null && rs.next()) {
                int llave = rs.getInt(1);
                cliente.setIdclientes_potenciales(llave);
            }
            jsonclientes();
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
    public boolean modificar(Cliente cliente) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  clientes_potenciales SET nit=?, nombre=?, empresa=?,"
                + " celular1=?, celular2=?, email=?, fecha_llegada=?, clase=?, modalidad=?, notas=?, codigo=?, llego=?, categoria=?,dv=?,"
                + " fecha_arriendo=?, contacto=?, vlrprincipal=?,"
                + " numequipos=?,vlrterminal=?, electronica=?, sucursal=?,cliente_potencial=?,ruta=?,valor_total=?"
                + " WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getEmpresa());
            ps.setString(4, cliente.getCelular1());
            ps.setString(5, cliente.getCelular2());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getFecha_llegada());
            ps.setString(8, cliente.getClase());
            ps.setString(9, cliente.getModalidad());
            ps.setString(10, cliente.getNotas());
            ps.setString(11, cliente.getCodigo());
            ps.setString(12, cliente.getLlego());
            ps.setString(13, cliente.getCategoria());
            ps.setString(14, cliente.getDv());
            ps.setString(15, cliente.getFecha_arriendo());
            ps.setString(16, cliente.getContacto());
            ps.setInt(17, cliente.getVlrprincipal());
            ps.setInt(18, cliente.getNumequipos());
            ps.setInt(19, cliente.getVlrterminal());
            ps.setInt(20, cliente.getElectronica());
            ps.setInt(21, cliente.getSucursal());
            ps.setInt(22, cliente.getCliente_potencial());
            ps.setString(23, cliente.getRuta());
            ps.setString(24, cliente.getValor_total());
            ps.setInt(25, cliente.getIdclientes_potenciales());
            ps.execute();
            jsonclientes();
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

    public boolean modificarruta(Cliente cliente) throws IOException {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  clientes_potenciales SET backupruta=? WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cliente.getBackupruta());
            ps.setInt(2, cliente.getIdclientes_potenciales());
            ps.execute();
            jsonclientes();
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

    //consulta para buscar cliente 
    public boolean buscar(Cliente cliente) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "clientes.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                Long myLong = (Long) jsonObject.get("idclientes_potenciales");
                int id = Math.toIntExact(myLong);
                if (cliente.getIdclientes_potenciales() == id) {
                    cliente.setIdclientes_potenciales(id);
                    cliente.setNit((String) jsonObject.get("nit"));
                    cliente.setNombre((String) jsonObject.get("nombre"));
                    cliente.setEmpresa((String) jsonObject.get("empresa"));
                    cliente.setCelular1((String) jsonObject.get("celular1"));
                    cliente.setCelular2((String) jsonObject.get("celular2"));
                    cliente.setEmail((String) jsonObject.get("email"));
                    cliente.setFecha_llegada((String) jsonObject.get("fecha_llegada"));
                    cliente.setClase((String) jsonObject.get("clase"));
                    cliente.setModalidad((String) jsonObject.get("modalidad"));
                    cliente.setNotas((String) jsonObject.get("notas"));
                    cliente.setCodigo((String) jsonObject.get("codigo"));
                    cliente.setLlego((String) jsonObject.get("llego"));
                    cliente.setCategoria((String) jsonObject.get("categoria"));
                    cliente.setRuta((String) jsonObject.get("ruta"));
                    cliente.setDv((String) jsonObject.get("dv"));
                    cliente.setFecha_arriendo((String) jsonObject.get("fecha_arriendo"));
                    cliente.setContacto((String) jsonObject.get("contacto"));
                    Long cp = (Long) jsonObject.get("cliente_potencial");
                    cliente.setCliente_potencial(Math.toIntExact(cp));
                    Long vlr = (Long) jsonObject.get("vlrprincipal");
                    cliente.setVlrprincipal(Math.toIntExact(vlr));
                    Long neqp = (Long) jsonObject.get("numequipos");
                    cliente.setNumequipos(Math.toIntExact(neqp));
                    Long vlrt = (Long) jsonObject.get("vlrterminal");
                    cliente.setVlrterminal(Math.toIntExact(vlrt));
                    Long elec = (Long) jsonObject.get("electronica");
                    cliente.setElectronica(Math.toIntExact(elec));
                    Long suc = (Long) jsonObject.get("sucursal");
                    cliente.setSucursal(Math.toIntExact(suc));
                    cliente.setValor_total((String) jsonObject.get("valor_total"));
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;

    }

    //consulta para buscar por el nit del cliente en formulario
    public boolean buscarr(Cliente cliente) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "clientes.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                if (cliente.getNit().equals((String) jsonObject.get("nit"))) {
                    Long myLong = (Long) jsonObject.get("idclientes_potenciales");
                    cliente.setIdclientes_potenciales(Math.toIntExact(myLong));
                    cliente.setNit((String) jsonObject.get("nit"));
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;

    }

    //buscar cliente por codigopublic boolean buscarr(Cliente cliente) {
    public boolean buscarcoodigocliente(Cliente cliente) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "clientes.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                if (cliente.getCodigo().equals((String) jsonObject.get("codigo"))) {
                    Long myLong = (Long) jsonObject.get("idclientes_potenciales");
                    cliente.setIdclientes_potenciales(Math.toIntExact(myLong));
                    cliente.setNit((String) jsonObject.get("nit"));
                    cliente.setNombre((String) jsonObject.get("nombre"));
                    cliente.setEmpresa((String) jsonObject.get("empresa"));
                    cliente.setCelular1((String) jsonObject.get("celular1"));
                    cliente.setCelular2((String) jsonObject.get("celular2"));
                    cliente.setEmail((String) jsonObject.get("email"));
                    cliente.setFecha_llegada((String) jsonObject.get("fecha_llegada"));
                    cliente.setClase((String) jsonObject.get("clase"));
                    cliente.setModalidad((String) jsonObject.get("modalidad"));
                    cliente.setNotas((String) jsonObject.get("notas"));
                    cliente.setCodigo((String) jsonObject.get("codigo"));
                    cliente.setLlego((String) jsonObject.get("llego"));
                    cliente.setCategoria((String) jsonObject.get("categoria"));
                    cliente.setRuta((String) jsonObject.get("ruta"));
                    cliente.setDv((String) jsonObject.get("dv"));
                    cliente.setBackupruta((String) jsonObject.get("backupruta"));
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean buscarnombrecliente(Cliente cliente) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "clientes.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                if (cliente.getNombre().equals((String) jsonObject.get("nombre"))) {
                    Long myLong = (Long) jsonObject.get("idclientes_potenciales");
                    cliente.setIdclientes_potenciales(Math.toIntExact(myLong));
                    cliente.setNombre((String) jsonObject.get("nombre"));
                    cliente.setEmpresa((String) jsonObject.get("empresa"));
                    cliente.setContacto((String) jsonObject.get("contacto"));
                    cliente.setCelular1((String) jsonObject.get("celular1"));
                    cliente.setCelular2((String) jsonObject.get("celular2"));
                    cliente.setEmail((String) jsonObject.get("email"));
                    cliente.setClase((String) jsonObject.get("clase"));
                    cliente.setModalidad((String) jsonObject.get("modalidad"));
                    cliente.setNotas((String) jsonObject.get("notas"));
                    cliente.setLlego((String) jsonObject.get("llego"));
                    cliente.setCategoria((String) jsonObject.get("categoria"));
                    cliente.setRutacotizacon((String) jsonObject.get("rutacotizacion"));
                    cliente.setNumero_cotizacion((String) jsonObject.get("numero_cotizacion"));
                    Long pro = (Long) jsonObject.get("programa");
                    cliente.setPrograma(Math.toIntExact(pro));
                    Long equi = (Long) jsonObject.get("equipos");
                    cliente.setEqipos(Math.toIntExact(equi));
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;

    }

    //retorna jsonde clientes
    public void jsonclientes() throws IOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM clientes_potenciales";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            recursos.crearjson(rs, "clientes.json");
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

    //consulta para llenar la tabla de servicios del formulario editar 
    public ArrayList<Servicio> llenar(Cliente cliente) {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "serviciosclientes.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                if (cliente.getIdclientes_potenciales() == Math.toIntExact((Long) jsonObject.get("clientes_potenciales_idclientes_potenciales"))) {
                    Servicio servicio = new Servicio();
                    servicio.setServicio((String) jsonObject.get("servicio"));
                    servicio.setIdservicio(Math.toIntExact((Long) jsonObject.get("idservicio")));
                    lista.add(servicio);
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

    //consulta para llenar la tabla documentos en el formulario editar
    public ArrayList<Documentos> clientedocumentos(Cliente cliente) {
        ArrayList lista = new ArrayList();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "documentos.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                if (cliente.getIdclientes_potenciales() == Math.toIntExact((Long) jsonObject.get("clientes_potenciales_idclientes_potenciales"))) {
                    Documentos documento = new Documentos();
                    documento.setIddocumentos(Math.toIntExact((Long) jsonObject.get("iddocumentos")));
                    documento.setDocumento((String) jsonObject.get("documento"));
                    documento.setFecha_inicio((String) jsonObject.get("fecha_inicio"));
                    documento.setFecha_vencimiento((String) jsonObject.get("fecha_vencimiento"));
                    lista.add(documento); 
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
    //consulta para buscar si el nit del cliente contie un parametro

    public ArrayList<Cliente> buscarcaracter(String parametro, String filtro) {
        ArrayList listaPersona = new ArrayList();
        Long parametro1 = 0L;
        boolean f = false;
        if (filtro.equals("electronica")) {
            f = true;
            parametro1 = 1L;
        } else {
            if (filtro.equals("sucursal")) {
                f = true;
                parametro1 = 1L;
            } else {
                if (filtro.equals("cliente potencial")) {
                    f = true;
                    parametro1 = 1L;
                    filtro = "cliente_potencial";
                }
            }
        }

        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("temp" + File.separator + "clientes.json")) {
            JSONArray jsonarray = (JSONArray) parser.parse(reader);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                if (f) {
                    if (parametro1.equals((Long) jsonObject.get(filtro))) {
                        Cliente cliente = new Cliente();
                        Long myLong = (Long) jsonObject.get("idclientes_potenciales");
                        int id = Math.toIntExact(myLong);
                        cliente.setIdclientes_potenciales(id);
                        cliente.setNit((String) jsonObject.get("nit"));
                        cliente.setNombre((String) jsonObject.get("nombre"));
                        cliente.setCodigo((String) jsonObject.get("codigo"));
                        cliente.setFecha_llegada((String) jsonObject.get("fecha_llegada"));
                        cliente.setRuta((String) jsonObject.get("ruta"));
                        cliente.setFecha_arriendo((String) jsonObject.get("fecha_arriendo"));
                        cliente.setDv((String) jsonObject.get("dv"));
                        cliente.setCelular1((String) jsonObject.get("celular1"));
                        cliente.setEmail((String) jsonObject.get("email"));
                        cliente.setContacto((String) jsonObject.get("contacto"));
                        cliente.setBackupruta((String) jsonObject.get("backupruta"));
                        cliente.setRutacotizacon((String) jsonObject.get("rutacotizacion"));
                        Long myLongi = (Long) jsonObject.get("cliente_potencial");
                        int idcliente = Math.toIntExact(myLongi);
                        cliente.setCliente_potencial(idcliente);
                        cliente.setFechacotizacion((String) jsonObject.get("fechacotizacion"));
                        listaPersona.add(cliente);
                    }
                } else {
                    if (parametro.equals((String) jsonObject.get(filtro))) {
                        Cliente cliente = new Cliente();
                        Long myLong = (Long) jsonObject.get("idclientes_potenciales");
                        int id = Math.toIntExact(myLong);
                        cliente.setIdclientes_potenciales(id);
                        cliente.setNit((String) jsonObject.get("nit"));
                        cliente.setNombre((String) jsonObject.get("nombre"));
                        cliente.setCodigo((String) jsonObject.get("codigo"));
                        cliente.setFecha_llegada((String) jsonObject.get("fecha_llegada"));
                        cliente.setRuta((String) jsonObject.get("ruta"));
                        cliente.setFecha_arriendo((String) jsonObject.get("fecha_arriendo"));
                        cliente.setDv((String) jsonObject.get("dv"));
                        cliente.setCelular1((String) jsonObject.get("celular1"));
                        cliente.setEmail((String) jsonObject.get("email"));
                        cliente.setContacto((String) jsonObject.get("contacto"));
                        cliente.setBackupruta((String) jsonObject.get("backupruta"));
                        cliente.setRutacotizacon((String) jsonObject.get("rutacotizacion"));
                        Long myLongi = (Long) jsonObject.get("cliente_potencial");
                        int idcliente = Math.toIntExact(myLongi);
                        cliente.setCliente_potencial(idcliente);
                        cliente.setFechacotizacion((String) jsonObject.get("fechacotizacion"));
                        listaPersona.add(cliente);
                    }
                }

            }
            return listaPersona;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

}
