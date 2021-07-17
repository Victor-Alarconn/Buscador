/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Servicios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Servicio;
import modelo.Usuario;
import vistas.Configuraciones;
import vistas.Principal;
import vistas.Servicios;

/**
 *
 * @author Yonathan Carvajal
 */
public class ServicioController implements ActionListener {

    private final Servicio modelo;
    private final Consultas_Servicios consulta;
    private final Servicios vservicios;
    private final Usuario user;

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();

    public ServicioController(Servicio modelo, Consultas_Servicios consulta, Servicios vservicios, Usuario user) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vservicios = vservicios;
        this.user = user;
        this.vservicios.registrarservicio.addActionListener(this);
        this.vservicios.eliminartablaagregarservicio.addActionListener(this);
        this.vservicios.eliminartablaservico.addActionListener(this);
        this.vservicios.guardarservicios.addActionListener(this);
    }

    public void iniciar() {
        vservicios.setTitle(" Crear servicios");
        vservicios.setLocationRelativeTo(null);
        model.addColumn("Servicios");
        model2.addColumn("Agregar Servicios");
        vservicios.tablatotalservicios.setModel(model);
        vservicios.tablaagregarservicios.setModel(model2);
        busqueda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vservicios.guardarservicios) {
            for (int i = 0; i < vservicios.tablaagregarservicios.getRowCount(); i++) {
                modelo.setServicio(vservicios.tablaagregarservicios.getValueAt(i, 0).toString());
                modelo.setUsuarios_idusuarios(user.getIdusuario());
                try {
                    if (!consulta.registrar(modelo)) {
                        JOptionPane.showMessageDialog(null, "error guardado de documento");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            limpiaragregarcarpeta();
            limpiartablacarpeta();
            busqueda();
        }

        Object[] dato = new Object[5];
        if (e.getSource() == vservicios.registrarservicio) {
            if (vservicios.txtregistroservicio.getText().length() != 0) {
                dato[0] = vservicios.txtregistroservicio.getText();
                model2.addRow(dato);
                vservicios.tablaagregarservicios.setModel(model2);
                vservicios.txtregistroservicio.setText("");
            }

        }

        if (e.getSource() == vservicios.eliminartablaagregarservicio) {
            int fila = vservicios.tablaagregarservicios.getSelectedRow();
            if (fila >= 0) {
                model2.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(vservicios, "La tabla esta vacia o no sea seleccionado nada aun!");
            }
        }

        if (e.getSource() == vservicios.eliminartablaservico) {
            int fila = vservicios.tablatotalservicios.getSelectedRow();
            if (fila >= 0) {
                modelo.setServicio(String.valueOf(vservicios.tablatotalservicios.getValueAt(fila, 0)));
                try {
                    if (consulta.eliminar(modelo)) {
                        model.removeRow(fila);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public void busqueda() {
        ArrayList<Servicio> servicio;
        Object[] dato = new Object[1];
        servicio =consulta.llenar();
        for (int i = 0; i < servicio.size(); i++) {
            dato[0] = servicio.get(i).getServicio();
            model.addRow(dato);
            vservicios.tablatotalservicios.setModel(model);
        }

    }

    public void limpiaragregarcarpeta() {
        if (vservicios.tablaagregarservicios.getRowCount() >= 0) {
            int count = vservicios.tablaagregarservicios.getRowCount();
            for (int i = 0; i < count; i++) {
                model2.removeRow(0);
            }
        }
    }

    public void limpiartablacarpeta() {
        if (vservicios.tablatotalservicios.getRowCount() >= 0) {
            int count = vservicios.tablatotalservicios.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }
}
