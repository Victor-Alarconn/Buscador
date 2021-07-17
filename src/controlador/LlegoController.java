/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Llego;
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
import modelo.Llego;
import modelo.Usuario;
import vistas.Otros;


/**
 *
 * @author yonathan
 */
public class LlegoController implements ActionListener{

    private final Llego ml;
    private final Consultas_Llego cl;
    private final Otros vl;
    private final Usuario user;

    DefaultTableModel modell = new DefaultTableModel();
    DefaultTableModel modell2 = new DefaultTableModel();

    public LlegoController(Llego ml, Consultas_Llego cl, Otros vl, Usuario user) {
        this.ml = ml;
        this.cl = cl;
        this.vl = vl;
        this.user = user;
        this.vl.agregarllego.addActionListener(this);
        this.vl.eliminaragregarllego.addActionListener(this);
        this.vl.eliminarllego.addActionListener(this);
        this.vl.guardarllego.addActionListener(this);
    }
    public void iniciar() {
        vl.setTitle("Otros");
        vl.setLocationRelativeTo(null);
        modell.addColumn("Agregar llego");
        modell2.addColumn("ID");
        modell2.addColumn("Llego");
        vl.tablaagregarllego.setModel(modell);
        vl.tablallego.setModel(modell2);
        vl.tablallego.getColumn("ID").setWidth(0);
        vl.tablallego.getColumn("ID").setMinWidth(0);
        vl.tablallego.getColumn("ID").setMaxWidth(0);
        busqueda();
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        vl.tablallego.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        vl.tablaagregarllego.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
//        vl.tablallego.setFont(new java.awt.Font("Tahoma", 0, 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == vl.guardarllego) {
            for (int i = 0; i < vl.tablaagregarllego.getRowCount(); i++) {
                ml.setLlego(vl.tablaagregarllego.getValueAt(i, 0).toString());
                ml.setUsuarios_idusuarios(user.getIdusuario());
                try {
                    if (!cl.registrar(ml)) {
                        JOptionPane.showMessageDialog(null, "error guardando la clase");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(LlegoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limpiaragregarllego();
            limpiartablallego();
            busqueda();

        } else {
            Object[] dato = new Object[5];
            if (e.getSource() == vl.agregarllego) {
                if (vl.txtregistrarllego.getText().length() != 0) {
                    dato[0] = vl.txtregistrarllego.getText();
                    modell.addRow(dato);
                    vl.tablaagregarllego.setModel(modell);
                    vl.txtregistrarllego.setText("");
                }
            } else {
                if (e.getSource() == vl.eliminarllego) {
                    int fila = vl.tablallego.getSelectedRow();
                    if (fila >= 0) {
                        ml.setIdllego(Integer.parseInt(String.valueOf(vl.tablallego.getValueAt(fila, 0))));
                        try {
                            if (cl.eliminar(ml)) {
                                if (fila >= 0) {
                                    modell2.removeRow(fila);
                                }
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(LlegoController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {
                    if (e.getSource() == vl.eliminaragregarllego) {
                        int fila = vl.tablaagregarllego.getSelectedRow();
                        if (fila >= 0) {
                            modell.removeRow(fila);
                        } else {
                            JOptionPane.showMessageDialog(vl, "La tabla esta vacia o no sea seleccionado nada aun!");
                        }
                    } else {
                    }
                }
            }
        }
    }
    
    public void busqueda() {
        ArrayList<Llego> llego=cl.llenar();
        Object[] dato = new Object[2];
        for (int i = 0; i < llego.size(); i++) {
            dato[0] = llego.get(i).getIdllego();
            dato[1] = llego.get(i).getLlego();
            modell2.addRow(dato);
            vl.tablallego.setModel(modell2);
        }

    }

    public void limpiaragregarllego() {
        if (vl.tablaagregarllego.getRowCount() >= 0) {
            int count = vl.tablaagregarllego.getRowCount();
            for (int i = 0; i < count; i++) {
                modell.removeRow(0);
            }
        }
    }

    public void limpiartablallego() {
        if (vl.tablallego.getRowCount() >= 0) {
            int count = vl.tablallego.getRowCount();
            for (int i = 0; i < count; i++) {
                modell2.removeRow(0);
            }
        }
    }

    
}
