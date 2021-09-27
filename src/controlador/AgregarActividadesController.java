/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Actividad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Actividad;
import modelo.Usuario;
import org.json.simple.parser.ParseException;
import vistas.AgregarActividad;

/**
 *
 * @author programacion01
 */
public class AgregarActividadesController implements ActionListener {

    private final Actividad macciones;
    private final AgregarActividad vacciones;
    private final Usuario user;
    Consultas_Actividad cactividad = new Consultas_Actividad();

    public AgregarActividadesController(Actividad macciones, AgregarActividad vacciones, Usuario user) {
        this.macciones = macciones;
        this.vacciones = vacciones;
        this.user = user;
        this.vacciones.btnguardar.addActionListener(this);
    }

    public void iniciar() throws IOException, ParseException {
        vacciones.setTitle(" Agregar Actividad");
        vacciones.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vacciones.btnguardar) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            macciones.setFecha(sdf.format(vacciones.txtfecha.getDate()));
            macciones.setCodigo(vacciones.txtcodigo.getText());
            macciones.setEmpresa(vacciones.txtempresa.getText());
            macciones.setReporto(vacciones.txtreporto.getText());
            macciones.setInforme(vacciones.txtinforme.getText());
            macciones.setMacin(vacciones.txtmacin.getText());
            macciones.setMacout(vacciones.txtmacsalida.getText());
            macciones.setHecho("0");
            if (vacciones.jbtdel.isSelected()) {
                macciones.setDel("x");
            } else {
                macciones.setDel("-");
            }
            if (vacciones.jbtadd.isSelected()) {
                macciones.setAgregar("x");
            } else {
                macciones.setAgregar("-");
            }
            if (vacciones.jbtswp.isSelected()) {
                macciones.setSwp("x");
            } else {
                macciones.setSwp("-");
            }
            try {                
                if(cactividad.registrar(macciones)){
                    vacciones.dispose();
                }
            } catch (IOException ex) {
                Logger.getLogger(AgregarActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
