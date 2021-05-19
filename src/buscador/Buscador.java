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
        
        login login = new login();
        login.setVisible(true);
       
    }

}
