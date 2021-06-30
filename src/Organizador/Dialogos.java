/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizador;

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
        String respuesta = JOptionPane.showInputDialog(null, "Nombre", "Crear ca", JOptionPane.CLOSED_OPTION);
        return respuesta;
    }
    public int j(){
       int respuesta = JOptionPane.showConfirmDialog(null, "El Usuario no posee un directoio desea crearlo?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       return respuesta;
    }
}
