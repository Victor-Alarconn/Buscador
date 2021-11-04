/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_Actividad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Actividad;
import Modelos.Usuario;
import org.json.simple.parser.ParseException;
import Vistas.EditarActividad;

/**
 *
 * @author programacion01
 */
public class EditarActividadController implements ActionListener{

    private final Actividad macciones;
    private final EditarActividad vacciones;
    private final Usuario user;
    Consultas_Actividad cactividad = new Consultas_Actividad();

    public EditarActividadController(Actividad macciones, EditarActividad vacciones, Usuario user) {
        this.macciones = macciones;
        this.vacciones = vacciones;
        this.user = user;
        this.vacciones.btnguardar.addActionListener(this);
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vacciones.btnguardar) {            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            macciones.setFecha(sdf.format(vacciones.txtfecha.getDate()));
            macciones.setCodigo(vacciones.txtcodigo.getText());
            macciones.setEmpresa(vacciones.txtempresa.getText());
            macciones.setReporto(vacciones.txtreporto.getText());
            macciones.setInforme(vacciones.txtinforme.getSelectedItem().toString());
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
                if(cactividad.modificar(macciones)){
                    vacciones.dispose();
                }
            } catch (IOException ex) {
                Logger.getLogger(AgregarActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void iniciar() throws IOException, ParseException, java.text.ParseException {
        vacciones.setTitle(" Editar Actividad");
        vacciones.setLocationRelativeTo(null);
        cargar();
    }

    private void cargar() throws java.text.ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = null;
        if (macciones.getFecha() != null && !macciones.getFecha().equals("")) {
            fechaDate = sdf.parse(macciones.getFecha());
            vacciones.txtfecha.setDate(fechaDate);
        }
        vacciones.txtcodigo.setText(macciones.getCodigo());
        vacciones.txtempresa.setText(macciones.getEmpresa());
//        vacciones.txtinforme.setText(macciones.getInforme());
        vacciones.txtmacin.setText(macciones.getMacin());
        vacciones.txtmacsalida.setText(macciones.getMacout());
        vacciones.txtreporto.setText(macciones.getReporto());
        if (macciones.getDel().equals("x")){
            vacciones.jbtdel.setSelected(true);
        } else {
           vacciones.jbtdel.setSelected(false);
        }
        if (macciones.getAgregar().equals("x")){
            vacciones.jbtadd.setSelected(true);
        } else {
           vacciones.jbtadd.setSelected(false);
        }
        if (macciones.getSwp().equals("x")){
            vacciones.jbtswp.setSelected(true);
        } else {
           vacciones.jbtswp.setSelected(false);
        }
    }
}
