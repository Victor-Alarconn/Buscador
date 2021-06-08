/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador;


import Consultas.Consultas_Cliente_Potencial;
import Consultas.Consultas_usuario;

import controlador.OrganizadorController;

import static java.awt.Frame.MAXIMIZED_BOTH;

import modelo.Cliente_Potencial;
import modelo.Usuario;


import vistas.Principal;
import vistas.login;

/**
 *
 * @author Yonathan Carvajal
 */
public class Buscador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Consultas_usuario cu = new Consultas_usuario();
        Usuario u =  new Usuario();
        u.setNombre("admin");
        u.setContrasena("123");
        u.setConfiguraciones(1);
        u.setCrearcliente(1);
        u.setCarpetas(1);
        u.setServicios(1);
        u.setOtros(1);
        u.setCrearusuarios(1);
        u.setBuscar(1);
        u.setEditarcliente(1);
        u.setRol(1);
        //condicional para saber si existe el usuario por defaelt
        if (!cu.logindefault(u)) {
            // si el usuario no existe crea uno nuevo
            cu.registrar(u);
        }
        login login = new login();
        login.setVisible(true);
       
    }

}
