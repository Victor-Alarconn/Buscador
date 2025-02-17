/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizador;

import Consultas.ResultSetConverter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import Vistas.Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author Yonathan Carvajal
 */
public class Recursos {

    ResultSetConverter r = new ResultSetConverter();

    public void alerta() {
        Principal principal = new Principal();
        JOptionPane.showMessageDialog(principal, "El campo de busqueda esta vacio!", "Alerta", JOptionPane.WARNING_MESSAGE);
    }

    public String crear() {
        String respuesta = JOptionPane.showInputDialog(null, "Nombre", "Crear ca", JOptionPane.CLOSED_OPTION);
        return respuesta;
    }

    public int j() {
        int respuesta = JOptionPane.showConfirmDialog(null, "El Usuario no posee un directoio desea crearlo?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return respuesta;
    }

    public String fechacotizacon() {
        String respuesta = JOptionPane.showInputDialog(null, "fecha", "Fecha de cotizacion", JOptionPane.CLOSED_OPTION);
        return respuesta;
    }
    
     public String fecharetiro() {
        String respuesta = JOptionPane.showInputDialog(null, "fecha", "Fecha de cotizacion", JOptionPane.CLOSED_OPTION);
        return respuesta;
    }

    public int confirmacion() {
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea agregar la carpeta a los clientes ya existentes?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return respuesta;
    }

    public void crearjson(ResultSet rs, String nombre) {
        try {
            File archivo = new File("temp" + File.separator + nombre);
            archivo.deleteOnExit();
            FileWriter fw = new FileWriter(archivo);
            fw.write(r.convert(rs).toString());
            fw.close();

        } catch (Exception e) {
        }

    }
}
