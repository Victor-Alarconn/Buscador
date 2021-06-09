/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador;

import Consultas.Consultas_Cliente_Potencial;
import Consultas.Consultas_roles;
import Consultas.Consultas_usuario;

import controlador.OrganizadorController;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;

import modelo.Cliente_Potencial;
import modelo.Rol;
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
    static Consultas_roles cr = new Consultas_roles();

    public static void main(String[] args) {
        
        Consultas_usuario cu = new Consultas_usuario();
        Buscador b = new Buscador();

        Rol rol = new Rol();

        Usuario u = new Usuario();
        u.setNombre("admin");
        u.setContrasena("123");
        u.setConfiguraciones(1);
        u.setCrearcliente(1);
        u.setCarpetas(1);
        u.setServicios(1);
        u.setOtros(1);
        u.setCrearusuarios(1);
        u.setEditarcliente(1);
        u.setRol(1);

        //funcion para agregar los roles cuando se instala la app
        rol.setRol("admin");
        rol.setIdroles(1);
        if (!cr.consulta(rol)) {
            if (b.agregarrol(rol)) {
                rol.setRol("user");
                rol.setIdroles(2);
                b.agregarrol(rol);
            }
        }

        //condicional para saber si existe el usuario por defaelt
        if (!cu.logindefault(u)) {
            // si el usuario no existe crea uno nuevo
            cu.registrar(u);
        }
        login login = new login();
        login.setVisible(true);

    }

    public boolean agregarrol(Rol rol) {
        if (cr.registrar(rol)) {
            return true;
        }
        return false;
    }

}
