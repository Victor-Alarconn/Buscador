/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_Actividad;
import Consultas.Consultas_Cliente;
import Organizador.Recursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Actividad;
import Modelos.Cliente;
import Modelos.Usuario;
import org.json.simple.parser.ParseException;
import Vistas.AgregarActividad;
import java.util.Calendar;

/**
 *
 * @author programacion01
 */
public class AgregarActividadesController implements ActionListener {

    private final Actividad macciones;
    private final AgregarActividad vacciones;
    private final Usuario user;
    Consultas_Actividad cactividad = new Consultas_Actividad();
    Cliente mcliente = new Cliente();
    Consultas_Cliente ccliente = new Consultas_Cliente();
    Recursos dialogo = new Recursos();

    public AgregarActividadesController(Actividad macciones, AgregarActividad vacciones, Usuario user) {
        this.macciones = macciones;
        this.vacciones = vacciones;
        this.user = user;
        this.vacciones.btnguardar.addActionListener(this);
    }

    public void iniciar() throws IOException, ParseException, java.text.ParseException {
        vacciones.setTitle(" Agregar Actividad");
        vacciones.setLocationRelativeTo(null);
        buscar();
        String timeStamp = new SimpleDateFormat("h:mm a").format(Calendar.getInstance().getTime());
         String timeStamp23 = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        SimpleDateFormat timeStamp2 = new SimpleDateFormat("dd-MM-yyyy");
        vacciones.txthora.setText(timeStamp);
        vacciones.txtfecha.setDate(timeStamp2.parse(timeStamp23));
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
            macciones.setConcepto(vacciones.txtconcepto.getText());
            macciones.setHora(vacciones.txthora.getText());
            macciones.setQinformo(vacciones.txtquieninformo.getSelectedItem().toString());
            macciones.setPrioridad(vacciones.txtprioridad.getSelectedItem().toString());
            macciones.setReferencia(vacciones.txtreferencia.getText());
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
    
    public void buscar() {    
        mcliente.setCodigo(macciones.getCodigo().toUpperCase());
        String t = mcliente.getCodigo();
                
        if (ccliente.buscarcoodigocliente(mcliente)) {
            vacciones.txtempresa.setText(mcliente.getNombre());
            vacciones.txtcodigo.setText(mcliente.getCodigo());
        }
    }

}
