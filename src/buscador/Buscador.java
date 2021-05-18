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
import controlador.OrganizadorController;
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
import vistas.Editarcliente;
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
        Principal principal = new Principal();
        ////////cliente
        Cliente_Potencial mod = new Cliente_Potencial();
        Consultas_Cliente_Potencial modcp = new Consultas_Cliente_Potencial();
        OrganizadorController bctrl = new OrganizadorController(mod, modcp, principal);
        bctrl.iniciar();
        principal.setExtendedState(MAXIMIZED_BOTH);
        principal.setVisible(true);
    }

}
