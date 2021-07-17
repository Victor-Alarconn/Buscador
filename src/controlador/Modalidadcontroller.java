/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Modalidad;
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
import modelo.Modalidad;
import modelo.Usuario;
import vistas.VModalidad;

/**
 *
 * @author Yonathan Carvajal
 */
public class Modalidadcontroller implements ActionListener {

    private final Modalidad mm;
    private final Consultas_Modalidad mcm;
    private final VModalidad vm;
    private final Usuario user;

    DefaultTableModel modell = new DefaultTableModel();
    DefaultTableModel modell2 = new DefaultTableModel();

    public Modalidadcontroller(Modalidad mm, Consultas_Modalidad mcm, VModalidad vm, Usuario user) {
        this.mm = mm;
        this.mcm = mcm;
        this.vm = vm;
        this.user = user;
        this.vm.agregarmodalidad.addActionListener(this);
        this.vm.eliminaragregarmodalidad.addActionListener(this);
        this.vm.eliminarmodalidad.addActionListener(this);
        this.vm.guardarmodalidad.addActionListener(this);
    }

    public void iniciar() {
        vm.setTitle("Modalidad");
        vm.setLocationRelativeTo(null);
        modell.addColumn("Agregar Modalidad");
        modell2.addColumn("ID");
        modell2.addColumn("Modalidades");
        vm.tablaagregarmodalidad.setModel(modell);
        vm.tablamodalidad.setModel(modell2);
        vm.tablamodalidad.getColumn("ID").setWidth(0);
        vm.tablamodalidad.getColumn("ID").setMinWidth(0);
        vm.tablamodalidad.getColumn("ID").setMaxWidth(0);
        busqueda();
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        vm.tablamodalidad.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vm.guardarmodalidad) {
            for (int i = 0; i < vm.tablaagregarmodalidad.getRowCount(); i++) {
                mm.setModalidad(vm.tablaagregarmodalidad.getValueAt(i, 0).toString());
                mm.setUsuarios_idusuario(user.getIdusuario());
                try {
                    if (!mcm.registrar(mm)) {
                        JOptionPane.showMessageDialog(null, "error guardando la modalidad");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Modalidadcontroller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limpiaragregarllego();
            limpiartablallego();
            busqueda();

        } else {
            Object[] dato = new Object[5];
            if (e.getSource() == vm.agregarmodalidad) {
                if (vm.txtregistrarmodalidad.getText().length() != 0) {
                    dato[0] = vm.txtregistrarmodalidad.getText();
                    modell.addRow(dato);
                    vm.tablaagregarmodalidad.setModel(modell);
                    vm.txtregistrarmodalidad.setText("");
                }
            } else {
                if (e.getSource() == vm.eliminarmodalidad) {
                    int fila = vm.tablamodalidad.getSelectedRow();
                    if (fila >= 0) {
                        mm.setIdmodalidad(Integer.parseInt(String.valueOf(vm.tablamodalidad.getValueAt(fila, 0))));
                        try {
                            if (mcm.eliminar(mm)) {
                                if (fila >= 0) {
                                    modell2.removeRow(fila);
                                }
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Modalidadcontroller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {
                    if (e.getSource() == vm.eliminaragregarmodalidad) {
                        int fila = vm.tablaagregarmodalidad.getSelectedRow();
                        if (fila >= 0) {
                            modell.removeRow(fila);
                        } else {
                            JOptionPane.showMessageDialog(vm, "La tabla esta vacia o no sea seleccionado nada aun!");
                        }
                    } else {
                    }
                }
            }
        }
    }

    public void busqueda() {
        ArrayList<Modalidad> llego = mcm.llenar();
        Object[] dato = new Object[2];
        for (int i = 0; i < llego.size(); i++) {
            dato[0] = llego.get(i).getIdmodalidad();
            dato[1] = llego.get(i).getModalidad();
            modell2.addRow(dato);
            vm.tablamodalidad.setModel(modell2);
        }

    }

    public void limpiaragregarllego() {
        if (vm.tablaagregarmodalidad.getRowCount() >= 0) {
            int count = vm.tablaagregarmodalidad.getRowCount();
            for (int i = 0; i < count; i++) {
                modell.removeRow(0);
            }
        }
    }

    public void limpiartablallego() {
        if (vm.tablamodalidad.getRowCount() >= 0) {
            int count = vm.tablamodalidad.getRowCount();
            for (int i = 0; i < count; i++) {
                modell2.removeRow(0);
            }
        }
    }

}
