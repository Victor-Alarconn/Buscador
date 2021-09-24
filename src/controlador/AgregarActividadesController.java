/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.Actividad;
import modelo.Usuario;
import org.json.simple.parser.ParseException;
import vistas.AgregarActividad;

/**
 *
 * @author programacion01
 */
public class AgregarActividadesController implements ActionListener  {
    
    private final Actividad macciones;
    private final AgregarActividad vacciones;
    private final Usuario user;

    public AgregarActividadesController(Actividad macciones, AgregarActividad vacciones, Usuario user) {
        this.macciones = macciones;
        this.vacciones = vacciones;
        this.user = user;
    }
    
    public void iniciar() throws IOException, ParseException {
        vacciones.setTitle(" Agregar Actividad");
        vacciones.setLocationRelativeTo(null);
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
