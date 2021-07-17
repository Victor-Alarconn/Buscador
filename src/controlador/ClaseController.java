/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Clase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Clases;
import modelo.Llego;
import modelo.Usuario;
import vistas.Configuraciones;
import vistas.Otros;

/**
 *
 * @author yonathan
 */
public class ClaseController implements ActionListener {

    private final Consultas_Clase cc;
    private final Clases mc;
    private final Otros vc;
    private final Usuario user;

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();

    public ClaseController(Consultas_Clase cc, Clases mc, Otros vc, Usuario user) {
        this.cc = cc;
        this.mc = mc;
        this.vc = vc;
        this.user = user;
        this.vc.guardarclase.addActionListener(this);
        this.vc.agregarclase.addActionListener(this);
        this.vc.eliminarclase.addActionListener(this);
        this.vc.eliminaragregarclase.addActionListener(this);

    }

    public void iniciar() {
        vc.setTitle("Otros");
//      formulario.setLocationRelativeTo(null);
        model.addColumn("Agregar clase");
        model2.addColumn("Id");
        model2.addColumn("Clases");
        vc.tablaagregarclase.setModel(model);
        vc.tablaclase.setModel(model2);
        vc.tablaclase.getColumn("Id").setWidth(0);
        vc.tablaclase.getColumn("Id").setMinWidth(0);
        vc.tablaclase.getColumn("Id").setMaxWidth(0);
        busqueda();
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        vc.tablaclase.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        vc.tablaagregarclase.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vc.guardarclase) {
            for (int i = 0; i < vc.tablaagregarclase.getRowCount(); i++) {
                mc.setClase(vc.tablaagregarclase.getValueAt(i, 0).toString());
                mc.setUsuarios_idusuarios(user.getIdusuario());
                try {
                    if (!cc.registrar(mc)) {
                        JOptionPane.showMessageDialog(null, "error guardando la clase");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ClaseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limpiaragregarclase();
            limpiartablaclase();
            busqueda();

        } else {
            Object[] dato = new Object[5];
            if (e.getSource() == vc.agregarclase) {
                if (vc.txtregistrarclase.getText().length() != 0) {
                    dato[0] = vc.txtregistrarclase.getText();
                    model.addRow(dato);
                    vc.tablaagregarclase.setModel(model);
                    vc.txtregistrarclase.setText("");
                }
            } else {
                if (e.getSource() == vc.eliminarclase) {
                    int fila = vc.tablaclase.getSelectedRow();
                    if (fila >= 0) {
                        mc.setIdclases(Integer.parseInt(String.valueOf(vc.tablaclase.getValueAt(fila, 0))));
                        try {
                            if (cc.eliminar(mc)) {
                                if (fila >= 0) {
                                    model2.removeRow(fila);
                                }
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(ClaseController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {
                    if (e.getSource() == vc.eliminaragregarclase) {
                        int fila = vc.tablaagregarclase.getSelectedRow();
                        if (fila >= 0) {
                            model.removeRow(fila);
                        } else {
                            JOptionPane.showMessageDialog(vc, "La tabla esta vacia o no sea seleccionado nada aun!");
                        }
                    } else {
                    }
                }
            }
        }

    }

    public void busqueda() {
        ArrayList<Clases> clases= cc.llenar();
        Object[] dato = new Object[2];
        for (int i = 0; i < clases.size(); i++) {
            dato[0] = clases.get(i).getIdclases();
            dato[1] = clases.get(i).getClase();
            model2.addRow(dato);
            vc.tablaclase.setModel(model2);
        }

    }

    public void limpiaragregarclase() {
        if (vc.tablaagregarclase.getRowCount() >= 0) {
            int count = vc.tablaagregarclase.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }

    public void limpiartablaclase() {
        if (vc.tablaagregarclase.getRowCount() >= 0) {
            int count = vc.tablaclase.getRowCount();
            for (int i = 0; i < count; i++) {
                model2.removeRow(0);
            }
        }
    }

}
