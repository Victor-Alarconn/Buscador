/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import modelo.Clases;
import modelo.Cliente;
import modelo.Configuracion;
import modelo.Directorio;
import modelo.Documentos;
import modelo.Llego;
import modelo.Modalidad;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import modelo.Usuario;
import org.json.simple.parser.ParseException;
import vistas.Backups;
import vistas.Busqueda;
import vistas.Carpetas;
import vistas.Configuraciones;
import vistas.Cotizaciones;
import vistas.Formulario;
import vistas.Otros;
import vistas.Principal;

import vistas.Usuarios;

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

//    Usuario mod = new Usuario();
    Consultas_usuario consultasusuario = new Consultas_usuario();
    //instaciar vistas 
    Busqueda busqueda;
    Otros otro;
    Usuarios usu;
    Carpetas carpeta;
    Formulario formulario;
    Configuraciones vc;
    Backups backup;
    Cotizaciones cotizaciones;

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
        this.principal.busqueda.addActionListener(this);
        this.principal.backup.addActionListener(this);
        this.principal.Cotizaciones.addActionListener(this);

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
        backup = new Backups(principal, false);
        backup.setVisible(false);
        cotizaciones = new Cotizaciones(principal, false);
        cotizaciones.setVisible(false);
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
            if (!vc.isVisible() && !formulario.isVisible() && !backup.isVisible() && !cotizaciones.isVisible()) {
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
        //abre la vista de busqueda de clientes 
        if (e.getSource() == principal.busqueda) {
            if (!busqueda.isVisible()) {
                busqueda = new Busqueda(principal, false);
                BusquedaController bc = new BusquedaController(modelo, consulta, busqueda);
                try {
                    bc.iniciar();
                } catch (IOException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                busqueda.setVisible(true);
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
        //abre el formulario de backups 
        if (e.getSource() == principal.backup) {
            if (!backup.isVisible()) {
                backup = new Backups(principal, false);
                BackupController cbackup = new BackupController(consulta, modelo, backup, mod);
                try {
                    cbackup.iniciar();
                } catch (IOException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(OrganizadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                backup.setVisible(true);
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
