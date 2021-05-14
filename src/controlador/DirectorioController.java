/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Directorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Directorio;
import vistas.Configuraciones;


/**
 *
 * @author yonathan
 */
public class DirectorioController implements ActionListener {

    private final Consultas_Directorio cdirectorio;
    private final Directorio mdirectorio;
    private final Configuraciones vdirectorio;

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();

    public DirectorioController(Consultas_Directorio cdirectorio, Directorio mdirectorio, Configuraciones vdirectorio) {
        this.cdirectorio = cdirectorio;
        this.mdirectorio = mdirectorio;
        this.vdirectorio = vdirectorio;
        this.vdirectorio.agregarcarpeta.addActionListener(this);
        this.vdirectorio.eliminaragregarcarpeta.addActionListener(this);
        this.vdirectorio.eliminarcarpeta.addActionListener(this);
        this.vdirectorio.guardarcarpeta.addActionListener(this);
    }

    public void iniciar() {
        vdirectorio.setTitle("Cliente Potencial");
//        formulario.setLocationRelativeTo(null);
        model.addColumn("Agregar carpeta");
        model2.addColumn("Carpetas");

        vdirectorio.tablaagregarcarpetas.setModel(model);
        vdirectorio.tablacarpetas.setModel(model2);
        busqueda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vdirectorio.guardarcarpeta) {
            for (int i = 0; i < vdirectorio.tablaagregarcarpetas.getRowCount(); i++) {
                mdirectorio.setCarpeta(vdirectorio.tablaagregarcarpetas.getValueAt(i, 0).toString());
                if (!cdirectorio.registrar(mdirectorio)) {
                    JOptionPane.showMessageDialog(null, "error guardado de documento");
                }
            }
            limpiaragregarcarpeta();
            limpiartablacarpeta();
            busqueda();
        }

        Object[] dato = new Object[5];
        if (e.getSource() == vdirectorio.agregarcarpeta) {
            if (vdirectorio.txtregistrarcarpeta.getText().length() != 0) {
                dato[0] = vdirectorio.txtregistrarcarpeta.getText();
                model.addRow(dato);
                vdirectorio.tablaagregarcarpetas.setModel(model);
                vdirectorio.txtregistrarcarpeta.setText("");
            }
        }
        if (e.getSource() == vdirectorio.eliminaragregarcarpeta) {
            int fila = vdirectorio.tablaagregarcarpetas.getSelectedRow();
            if (fila >= 0) {
                model.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(vdirectorio, "La tabla esta vacia o no sea seleccionado nada aun!");
            }
        }

        if (e.getSource() == vdirectorio.eliminarcarpeta) {
            int fila = vdirectorio.tablacarpetas.getSelectedRow();
            if (fila >= 0) {
                mdirectorio.setCarpeta(String.valueOf(vdirectorio.tablacarpetas.getValueAt(fila, 0)));
                if (cdirectorio.eliminar(mdirectorio)) {
                    model2.removeRow(fila);
                }
            }

        }
    }

    public void busqueda() {
        Object[] dato = new Object[1];
        for (int i = 0; i < cdirectorio.llenar().size(); i++) {
            dato[0] = cdirectorio.llenar().get(i);
            model2.addRow(dato);
            vdirectorio.tablacarpetas.setModel(model2);
        }

    }

    public void limpiaragregarcarpeta() {
        if (vdirectorio.tablaagregarcarpetas.getRowCount() >= 0) {
            int count = vdirectorio.tablaagregarcarpetas.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }

    public void limpiartablacarpeta() {
        if (vdirectorio.tablacarpetas.getRowCount() >= 0) {
            int count = vdirectorio.tablacarpetas.getRowCount();
            for (int i = 0; i < count; i++) {
                model2.removeRow(0);
            }
        }
    }

}
