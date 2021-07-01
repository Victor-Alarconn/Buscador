/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Documentos;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;

/**
 *
 * @author Yonathan Carvajal
 */
public class Consultas_Cliente extends Conexion {

    //consulta para registrar 
    public boolean registrar(Cliente cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "INSERT INTO clientes_potenciales (nit,nombre,empresa,"
                + "celular1,celular2,email,fecha_llegada,clase,"
                + "modalidad,notas,codigo,llego,categoria,ruta,dv,"
                + "usuarios_idusuario,fecha_arriendo,contacto,"
                + "cliente_potencial,vlrprincipal,numequipos,vlrterminal,electronica,sucursal) VALUES(?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();// recupera el id autoincrementable del registro hecho
            if (rs != null && rs.next()) {
                int llave = rs.getInt(1);
                cliente.setIdclientes_potenciales(llave);
            }
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
    public boolean modificar(Cliente cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  clientes_potenciales SET nit=?, nombre=?, empresa=?,"
                + " celular1=?, celular2=?, email=?, fecha_llegada=?, clase=?, modalidad=?, notas=?, codigo=?, llego=?, categoria=?,dv=?,"
                + " fecha_arriendo=?, contacto=?, vlrprincipal=?,"
                + " numequipos=?,vlrterminal=?, electronica=?, sucursal=?,cliente_potencial=?,backupruta=?"
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
            ps.setString(23, cliente.getBackupruta());
            ps.setInt(24, cliente.getIdclientes_potenciales());
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

    public boolean modificarruta(Cliente cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE  clientes_potenciales SET backupruta=? WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cliente.getBackupruta());
            ps.setInt(2, cliente.getIdclientes_potenciales());
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

    //consulta para eliminar
    public boolean eliminar(Cliente cliente) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = " DELETE FROM clientes_potenciales  WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdclientes_potenciales());
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

    //consulta para buscar cliente 
    public boolean buscar(Cliente cliente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM clientes_potenciales  WHERE idclientes_potenciales=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdclientes_potenciales());
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setIdclientes_potenciales(Integer.parseInt(rs.getString("idclientes_potenciales")));
                cliente.setNit(rs.getString("nit"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmpresa(rs.getString("empresa"));
                cliente.setCelular1(rs.getString("celular1"));
                cliente.setCelular2(rs.getString("celular2"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFecha_llegada(rs.getString("fecha_llegada"));
                cliente.setClase(rs.getString("clase"));
                cliente.setModalidad(rs.getString("modalidad"));
                cliente.setNotas(rs.getString("notas"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setLlego(rs.getString("llego"));
                cliente.setCategoria(rs.getString("categoria"));
                cliente.setRuta(rs.getString("ruta"));
                cliente.setDv(rs.getString("dv"));
                cliente.setFecha_arriendo(rs.getString("fecha_arriendo"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setCliente_potencial(rs.getInt("cliente_potencial"));
                cliente.setVlrprincipal(rs.getInt("vlrprincipal"));
                cliente.setNumequipos(rs.getInt("numequipos"));
                cliente.setVlrterminal(rs.getInt("vlrterminal"));
                cliente.setElectronica(rs.getInt("electronica"));
                cliente.setSucursal(rs.getInt("sucursal"));
                return true;
            }

            return false;
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

    //consulta para buscar por el nit del cliente en formulario
    public boolean buscarr(Cliente cliente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM clientes_potenciales  WHERE nit=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, cliente.getNit());
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setIdclientes_potenciales(Integer.parseInt(rs.getString("idclientes_potenciales")));
                cliente.setNit(rs.getString("nit"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmpresa(rs.getString("empresa"));
                cliente.setCelular1(rs.getString("celular1"));
                cliente.setCelular2(rs.getString("celular2"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFecha_llegada(rs.getString("fecha_llegada"));
                cliente.setClase(rs.getString("clase"));
                cliente.setModalidad(rs.getString("modalidad"));
                cliente.setNotas(rs.getString("notas"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setLlego(rs.getString("llego"));
                cliente.setCategoria(rs.getString("categoria"));
                cliente.setRuta(rs.getString("ruta"));
                cliente.setDv(rs.getString("dv"));
                return true;
            }

            return false;
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

    //consulta para buscar si el nit del cliente contie un parametro
    public ArrayList<Cliente> buscarcaracter(String parametro, String filtro) {
        ArrayList listaPersona = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = null;
        if (filtro.equals("electronica")) {
            sql = " SELECT * FROM clientes_potenciales  WHERE " + filtro + "=1";
        } else {
            if (filtro.equals("sucursal")) {
                sql = " SELECT * FROM clientes_potenciales  WHERE " + filtro + "=1";
            } else {
                sql = " SELECT * FROM clientes_potenciales  WHERE " + filtro + " LIKE'%" + parametro + "%'";
            }
        }
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdclientes_potenciales(Integer.parseInt(rs.getString(1)));
                cliente.setNit(rs.getString("nit"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCodigo(rs.getString("codigo"));
                cliente.setFecha_llegada(rs.getString("fecha_llegada"));
                cliente.setRuta(rs.getString("ruta"));
                cliente.setFecha_arriendo(rs.getString("fecha_arriendo"));
                cliente.setDv(rs.getString("dv"));
                cliente.setCelular1(rs.getString("celular1"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setBackupruta(rs.getString("backupruta"));
                listaPersona.add(cliente);
            }
            return listaPersona;
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
        return null;
    }

    //consulta para llenar la tabla de servicios del formulario editar 
    public ArrayList<Servicio> llenar(Cliente cliente) {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT servicios.servicio FROM servicios_has_clientes_potenciales INNER JOIN"
                + " servicios ON servicios.idservicio=servicios_has_clientes_potenciales.servicios_idservicio "
                + "WHERE servicios_has_clientes_potenciales.clientes_potenciales_idclientes_potenciales=?";
        try {
//            ps = (PreparedStatement) con.prepareStatement(sql);
//            rs = ps.executeQuery();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdclientes_potenciales());
            rs = ps.executeQuery();
            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setServicio(rs.getString(1));
                lista.add(servicio);
            }
            return lista;
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
        return null;
    }

    //consulta para llenar la tabla documentos en el formulario editar
    public ArrayList<Documentos> clientedocumentos(Cliente cliente) {
        ArrayList lista = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = " SELECT * FROM `documentos` WHERE documentos.clientes_potenciales_idclientes_potenciales=?";
        try {
//            ps = (PreparedStatement) con.prepareStatement(sql);
//            rs = ps.executeQuery();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, cliente.getIdclientes_potenciales());
            rs = ps.executeQuery();
            while (rs.next()) {
                Documentos documento = new Documentos();
                documento.setIddocumentos(rs.getInt(1));
                documento.setDocumento(rs.getString(2));
                documento.setFecha_inicio(rs.getString(3));
                documento.setFecha_vencimiento(rs.getString(4));
                lista.add(documento);
            }
            return lista;
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
        return null;
    }
}
