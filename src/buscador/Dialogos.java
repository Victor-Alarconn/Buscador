/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador;

import vistas.Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author Yonathan Carvajal
 */
public class Dialogos {
    
    public void alerta(){
        Principal principal = new Principal();
        JOptionPane.showMessageDialog(principal, "El campo de busqueda esta vacio!", "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    
    public String crear(){
        String respuesta = JOptionPane.showInputDialog(null, "Nombre", "Crear carpeta", JOptionPane.CLOSED_OPTION);
        return respuesta;
    }
}
