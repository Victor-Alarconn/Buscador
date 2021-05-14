/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Llego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Llego;
import vistas.Configuraciones;
import vistas.Principal;

/**
 *
 * @author yonathan
 */
public class LlegoController implements ActionListener{

    private final Llego ml;
    private final Consultas_Llego cl;
    private final Configuraciones vl;

    DefaultTableModel modell = new DefaultTableModel();
    DefaultTableModel modell2 = new DefaultTableModel();

    public LlegoController(Llego ml, Consultas_Llego cl, Configuraciones vl) {
        this.ml = ml;
        this.cl = cl;
        this.vl = vl;
        
        this.vl.agregarllego.addActionListener(this);
        this.vl.eliminaragregarllego.addActionListener(this);
        this.vl.eliminarllego.addActionListener(this);
        this.vl.guardarllego.addActionListener(this);
    }
    public void iniciar() {
        vl.setTitle("Otros");
//        formulario.setLocationRelativeTo(null);
        modell.addColumn("Agregar llego");
        modell2.addColumn("Llego");
        vl.tablaagregarllego.setModel(modell);
        vl.tablallego.setModel(modell2);
        busqueda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == vl.guardarllego) {
            for (int i = 0; i < vl.tablaagregarllego.getRowCount(); i++) {
                ml.setLlego(vl.tablaagregarllego.getValueAt(i, 0).toString());
                if (!cl.registrar(ml)) {
                    JOptionPane.showMessageDialog(null, "error guardando la clase");
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
                        ml.setLlego(String.valueOf(vl.tablallego.getValueAt(fila, 0)));
                        if (cl.eliminar(ml)) {
                            if (fila >= 0) {
                                modell2.removeRow(fila);
                            }
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
        Object[] dato = new Object[1];
        for (int i = 0; i < cl.llenar().size(); i++) {
            dato[0] = cl.llenar().get(i);
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
