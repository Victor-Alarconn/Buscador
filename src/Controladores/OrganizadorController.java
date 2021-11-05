/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_Clase;
import Consultas.Consultas_Cliente;
import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Directorio;
import Consultas.Consultas_Documentos;
import Consultas.Consultas_Llego;
import Consultas.Consultas_Modalidad;
import Consultas.Consultas_Servicios;
import Consultas.Consultas_Servicios_has_Clientes_Potenciales;
import Consultas.Consultas_usuario;
import Organizador.Recursos;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Modelos.Actividad;
import Modelos.Clases;
import Modelos.Cliente;
import Modelos.Configuracion;
import Modelos.Directorio;
import Modelos.Documentos;
import Modelos.Llego;
import Modelos.Modalidad;
import Modelos.Servicio;
import Modelos.Servicios_has_Clientes_Potenciales;
import Modelos.Usuario;
import org.json.simple.parser.ParseException;
import Vistas.Actividades;
import Vistas.Busqueda;
import Vistas.Carpetas;
import Vistas.Configuraciones;
import Vistas.Cotizaciones;
import Vistas.Formulario;
import Vistas.Otros;
import Vistas.Principal;

import Vistas.Usuarios;

/**
 *
 * @author Yonathan Carvajal
 */
public class OrganizadorController implements ActionListener {

    private final Cliente modelo;
    private final Consultas_Cliente consulta;
    private final Principal principal;
    private final Usuario mod;

    DefaultTableModel model = new DefaultTableModel();
    Recursos dialogo = new Recursos();

    Servicio mods = new Servicio();
    Consultas_Servicios servicio = new Consultas_Servicios();

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

    Modalidad mm = new Modalidad();
    Consultas_Modalidad mcm = new Consultas_Modalidad();
    
    Actividad mactividad = new Actividad();

//    Usuario mod = new Usuario();
    Consultas_usuario consultasusuario = new Consultas_usuario();
    //instaciar vistas 
    Busqueda busqueda;
    Otros otro;
    Usuarios usu;
    Carpetas carpeta;
    Formulario formulario;
    Configuraciones vc;
    Cotizaciones cotizaciones;
    Actividades vacciones;

    public OrganizadorController(Cliente modelo, Consultas_Cliente consulta, Principal principal, Usuario mod) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.principal = principal;
        this.mod = mod;
        this.principal.crearcliente.addActionListener(this);
        this.principal.configuraciones1.addActionListener(this);
        this.principal.carpetas.addActionListener(this);
        this.principal.crearusuario.addActionListener(this);
        this.principal.otro.addActionListener(this);
        this.principal.Cotizaciones.addActionListener(this);
        this.principal.acciones.addActionListener(this);

    }

    public void iniciar() {
        principal.setTitle("Organizador");
        //inicializar vistas 
        busqueda = new Busqueda(principal, false);
        busqueda.setVisible(false);
        otro = new Otros(principal, false);
        otro.setVisible(false);
        usu = new Usuarios(principal, false);
        usu.setVisible(false);
        carpeta = new Carpetas(principal, false);
        carpeta.setVisible(false);
        formulario = new Formulario(principal, false);
        formulario.setVisible(false);
        vc = new Configuraciones(principal, true);
        vc.setVisible(false);
        cotizaciones = new Cotizaciones(principal, false);
        cotizaciones.setVisible(false);
        cotizaciones = new Cotizaciones(principal, false);
        cotizaciones.setVisible(false);
        vacciones = new Actividades();
        vacciones.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //abre el formulario para registrar el cliente 
        if (e.getSource() == principal.crearcliente) {
            if (!formulario.isVisible() && !vc.isVisible()) {
                formulario = new Formulario(principal, false);
                ClienteController controlador = new ClienteController(modelo, consulta,
                        formulario, servicio, mods, shcp, cshcp, documento, cdocumentos,
                        mconfiguracion, cconfiguraciones, mod);
                try {
                    controlador.iniciar();
                } catch (IOException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                formulario.setVisible(true);
            }
        }
        //abre la configuracion de rutas 
        if (e.getSource() == principal.configuraciones1) {
            if (!vc.isVisible() && !formulario.isVisible() && !cotizaciones.isVisible()) {
                vc = new Configuraciones(principal, true);
                ConfiguracionesController ccontroller = new ConfiguracionesController(mconfiguracion, cconfiguraciones, vc, mod);
                try {
                    ccontroller.iniciar();
                } catch (IOException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                vc.setVisible(true);
            }
        }
        
        //abre las vista de otros
        if (e.getSource() == principal.otro) {
            if (!otro.isVisible()) {
                otro = new Otros(principal, false);
                ClaseController cctrl = new ClaseController(conc, mc, otro, mod);
                cctrl.iniciar();

                LlegoController lc = new LlegoController(ml, conl, otro, mod);
                lc.iniciar();

                Modalidadcontroller mc = new Modalidadcontroller(mm, mcm, otro, mod);
                mc.iniciar();

                ServicioController ctrl = new ServicioController(mods, servicio, otro, mod);
                ctrl.iniciar();
                otro.setVisible(true);
            }
        }

        //abre la vista de usuarios 
        if (e.getSource() == principal.crearusuario) {
            if (!usu.isVisible()) {
                usu = new Usuarios(principal, false);
                UsuariosController uc = new UsuariosController(mod, consultasusuario, usu);
                uc.iniciar();
                usu.setVisible(true);
            }

        }
        //abre la vista de carpetas 
        if (e.getSource() == principal.carpetas) {
            if (!carpeta.isVisible()) {
                carpeta = new Carpetas(principal, false);
                DirectorioController ctrc = new DirectorioController(modc1, mod1, carpeta, mod);
                try {
                    ctrc.iniciar();
                } catch (IOException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                carpeta.setVisible(true);
            }
        }
        
        //abre el formularo de cotizaciones 
        if (e.getSource() == principal.Cotizaciones) {
            if (!cotizaciones.isVisible()) {
                cotizaciones = new Cotizaciones(principal, false);
                CotizacionController cp = new CotizacionController(modelo, consulta,
                        cotizaciones, mconfiguracion, cconfiguraciones, mod);
                try {
                    cp.iniciar();
                } catch (IOException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                cotizaciones.setVisible(true);
            }
        }

        if (e.getSource() == principal.acciones) {
            if (!vacciones.isVisible()) {
                vacciones = new Actividades();
                ActividadesController cp = new ActividadesController(mactividad, vacciones, mod);
                try {
                    cp.iniciar();
                } catch (IOException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 vacciones.setVisible(true);
            }        
           
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

}
