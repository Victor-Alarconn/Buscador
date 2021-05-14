/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador;

import Consultas.Consultas_Clase;
import Consultas.Consultas_Cliente_Potencial;
import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Directorio;
import Consultas.Consultas_Documentos;
import Consultas.Consultas_Llego;
import Consultas.Consultas_Servicio;
import Consultas.Consultas_Servicios_has_Clientes_Potenciales;
import controlador.BusquedaController;
import controlador.ClaseController;
import controlador.Cliente_PotencialController;
import controlador.ConfiguracionesController;
import controlador.DirectorioController;
import controlador.EditarController;
import controlador.LlegoController;
import controlador.ServicioController;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;

import modelo.Clases;
import modelo.Cliente_Potencial;
import modelo.Configuracion;
import modelo.Directorio;
import modelo.Documentos;
import modelo.Llego;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import vistas.Configuraciones;
import vistas.Formulario;
import vistas.Principal;

/**
 *
 * @author Yonathan Carvajal
 */
public class Buscador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Configuracion mconfiguracion = new Configuracion();
        Consultas_Configuraciones cconfiguraciones = new Consultas_Configuraciones();
        Servicio mods = new Servicio();
        Cliente_Potencial modelo = new Cliente_Potencial();
        Documentos documento = new Documentos();
        Servicios_has_Clientes_Potenciales shcp = new Servicios_has_Clientes_Potenciales();
        Consultas_Servicios_has_Clientes_Potenciales cshcp = new Consultas_Servicios_has_Clientes_Potenciales();
        Consultas_Cliente_Potencial consulta = new Consultas_Cliente_Potencial();
        Consultas_Documentos cdocumentos = new Consultas_Documentos();
        Principal principal = new Principal();
        ////////cliente
        Cliente_Potencial mod = new Cliente_Potencial();
        Consultas_Cliente_Potencial modcp = new Consultas_Cliente_Potencial();
        BusquedaController bctrl = new BusquedaController(mod, modcp, principal);
        bctrl.iniciar();
        ///editar
        Consultas_Clase cc = new Consultas_Clase();
        Consultas_Llego cl = new Consultas_Llego();
        Consultas_Servicio modc = new Consultas_Servicio();
        EditarController edic = new EditarController(modelo,
                mods, shcp, documento, mconfiguracion, modc, consulta,
                cshcp, cdocumentos, cconfiguraciones, cc, cl,
                principal);
        edic.iniciar();

        principal.setExtendedState(MAXIMIZED_BOTH);
        principal.setVisible(true);
    }

}
