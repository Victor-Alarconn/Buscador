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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

    public void iniciar() throws IOException, ParseException {
        vacciones.setTitle(" Agregar Actividad");
        vacciones.setLocationRelativeTo(null);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechade = (dtf.format(LocalDateTime.now()));
        Date fechaParseada;
        try {
            fechaParseada = new SimpleDateFormat("dd-MM-yyyy").parse(fechade);
            vacciones.txtfecha.setDate(fechaParseada);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(AgregarActividadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        buscar();
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm a");
        vacciones.txthora.setText(dtf1.format(LocalDateTime.now()));
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
            macciones.setConcepto(vacciones.txtconcepto.getText());
            macciones.setPrioridad(vacciones.txtprioridad.getSelectedItem().toString());
            macciones.setHora(vacciones.txthora.getText().toString());
            macciones.setQinformo(vacciones.txtquieninformo.getSelectedItem().toString());
            macciones.setReferencia(vacciones.txtreferencia.getText());
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
                if (cactividad.registrar(macciones)) {
                    vacciones.dispose();
                }
            } catch (IOException ex) {
                Logger.getLogger(AgregarActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void buscar() {
        mcliente.setCodigo(macciones.getCodigo().toUpperCase());
        if (ccliente.buscarcoodigocliente(mcliente)) {
            vacciones.txtempresa.setText(mcliente.getNombre());
            vacciones.txtcodigo.setText(mcliente.getCodigo());
        }
    }

}
