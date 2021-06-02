/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Clase;
import Consultas.Consultas_Cliente_Potencial;
import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Directorio;
import Consultas.Consultas_Documentos;
import Consultas.Consultas_Llego;
import Consultas.Consultas_Servicio;
import Consultas.Consultas_Servicios_has_Clientes_Potenciales;
import Consultas.Consultas_usuario;
import buscador.Dialogos;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
import modelo.Clases;
import modelo.Cliente_Potencial;
import modelo.Configuracion;
import modelo.Directorio;
import modelo.Documentos;
import modelo.Llego;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import modelo.Usuario;
import vistas.Busqueda;
import vistas.Carpetas;
import vistas.Configuraciones;
import vistas.Crearusuario;
import vistas.Editarcliente;
import vistas.Formulario;
import vistas.Otros;
import vistas.Principal;
import vistas.Servicios;
import vistas.Usuarios;

/**
 *
 * @author Yonathan Carvajal
 */
public class OrganizadorController implements ActionListener {

    private final Cliente_Potencial modelo;
    private final Consultas_Cliente_Potencial consulta;
    private final Principal principal;
    private final Usuario mod;

    DefaultTableModel model = new DefaultTableModel();
    Dialogos dialogo = new Dialogos();

    Servicio mods = new Servicio();
    Consultas_Servicio servicio = new Consultas_Servicio();

    Servicios_has_Clientes_Potenciales shcp = new Servicios_has_Clientes_Potenciales();
    Consultas_Servicios_has_Clientes_Potenciales cshcp = new Consultas_Servicios_has_Clientes_Potenciales();

    Configuracion mconfiguracion = new Configuracion();
    Consultas_Configuraciones cconfiguraciones = new Consultas_Configuraciones();
//            Configuraciones vc = new Configuraciones(principal, true);

    Documentos documento = new Documentos();
    Consultas_Documentos cdocumentos = new Consultas_Documentos();

    Consultas_Clase conc = new Consultas_Clase();
    Clases mc = new Clases();

    Consultas_Llego conl = new Consultas_Llego();
    Llego ml = new Llego();

    Directorio mod1 = new Directorio();
    Consultas_Directorio modc1 = new Consultas_Directorio();

//    Usuario mod = new Usuario();

    Consultas_usuario consultasusuario = new Consultas_usuario();

    public OrganizadorController(Cliente_Potencial modelo, Consultas_Cliente_Potencial consulta, Principal principal, Usuario mod) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.principal = principal;
        this.mod = mod;
        this.principal.crearcliente.addActionListener(this);
        this.principal.configuraciones1.addActionListener(this);
        this.principal.carpetas.addActionListener(this);
        this.principal.servicios.addActionListener(this);
        this.principal.crearusuario.addActionListener(this);
        this.principal.otro.addActionListener(this);
    }

    public void iniciar() {
        principal.setTitle("Busqueda");
        BusquedaController bc = new BusquedaController(modelo, consulta, principal);
        bc.iniciar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.crearcliente) {
            Formulario formulario = new Formulario(principal, true);
            Cliente_PotencialController controlador = new Cliente_PotencialController(modelo, consulta,
                    formulario, servicio, mods, shcp, cshcp, documento, cdocumentos,
                    mconfiguracion, cconfiguraciones, mod);
            controlador.iniciar();

            formulario.setVisible(true);
        }

        if (e.getSource() == principal.configuraciones1) {
            Configuraciones vc = new Configuraciones(principal, true);
            
            ConfiguracionesController ccontroller = new ConfiguracionesController(mconfiguracion, cconfiguraciones, vc);
            ccontroller.iniciar();
            vc.setVisible(true);
        }

//        if (e.getSource() == principal.busqueda) {
//            Busqueda busqueda = new Busqueda(principal, true);
//            BusquedaController bc = new BusquedaController(modelo, consulta, busqueda);
//            bc.iniciar();
//            busqueda.setVisible(true);
//        }
        if (e.getSource() == principal.servicios) {
            Servicios servic= new Servicios(principal, true);
            ServicioController ctrl = new ServicioController(mods, servicio, servic);
            ctrl.iniciar();
            servic.setVisible(true);     
        }
        if (e.getSource() == principal.otro) {
            Otros otro = new Otros(principal, true);
            ClaseController cctrl = new ClaseController(conc, mc, otro);
            cctrl.iniciar();

            LlegoController lc = new LlegoController(ml, conl, otro);
            lc.iniciar();
            otro.setVisible(true);
            
        }
        
        
        if (e.getSource() == principal.crearusuario) {

               Usuarios usu = new Usuarios(principal,true);
               UsuariosController uc = new UsuariosController(mod, consultasusuario, usu);
               uc.iniciar();
               usu.setVisible(true);
        }
        
        if (e.getSource() == principal.carpetas) {
            Carpetas carpeta = new Carpetas(principal, true);
            DirectorioController ctrc = new DirectorioController(modc1, mod1, carpeta);
            ctrc.iniciar();
            carpeta.setVisible(true);
        }

    }

    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void limpiar() {
//        pricipal.txtnombre.setText("");
//        pricipal.txtapellido.setText("");
//        pricipal.txtdocumento.setText("");
    }

}
