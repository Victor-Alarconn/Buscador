/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_SubCarpetas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Directorio;
import modelo.Subcarpeta;
import vistas.SubCarpetas;

/**
 *
 * @author yonathan
 */
public class SubCarpetasController implements ActionListener {

    private final Subcarpeta msubcarpetas;
    private final Consultas_SubCarpetas csubcarpetas;
    private final SubCarpetas vsubcarpetas;
    private final Directorio mdirectotio;

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();

    public SubCarpetasController(Subcarpeta msubcarpetas, Consultas_SubCarpetas csubcarpetas, SubCarpetas vsubcarpetas, Directorio mdirectotio) {
        this.msubcarpetas = msubcarpetas;
        this.csubcarpetas = csubcarpetas;
        this.vsubcarpetas = vsubcarpetas;
        this.mdirectotio = mdirectotio;
        this.vsubcarpetas.agregarsubcarpeta.addActionListener(this);
        this.vsubcarpetas.eliminaragregarsubcarpeta.addActionListener(this);
        this.vsubcarpetas.eliminarsubcarpeta.addActionListener(this);
        this.vsubcarpetas.guardarsubcarpeta.addActionListener(this);
    }

    public void iniciar() {
        vsubcarpetas.setTitle("SubCarpetas");
        vsubcarpetas.setLocationRelativeTo(null);
        model.addColumn("Agregar Subcarpeta");
        model2.addColumn("SubCarpetas");
        vsubcarpetas.tablaagregarsubcarpetas.setModel(model);
        vsubcarpetas.tablasubcarpetas.setModel(model2);
        vsubcarpetas.labeltiitulo.setText(mdirectotio.getCarpeta());
        
        llenartabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //metodo para agregar subcarpetas a la tabla 
        Object[] dato = new Object[1];
        if (e.getSource() == vsubcarpetas.agregarsubcarpeta) {
            if (vsubcarpetas.txtregistrarsubcarpeta.getText().length() != 0) {
                dato[0] = vsubcarpetas.txtregistrarsubcarpeta.getText();
                model.addRow(dato);
                vsubcarpetas.tablaagregarsubcarpetas.setModel(model);
                vsubcarpetas.txtregistrarsubcarpeta.setText("");

            }
        }

        // metodo para eliminar carpetas de la tabla 
        if (e.getSource() == vsubcarpetas.eliminaragregarsubcarpeta) {
            int fila = vsubcarpetas.tablaagregarsubcarpetas.getSelectedRow();
            if (fila >= 0) {
                model.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(vsubcarpetas, "La tabla esta vacia o no sea seleccionado nada aun!");
            }
        }

        // metodo para guardar las subcarpetas
        if (e.getSource() == vsubcarpetas.guardarsubcarpeta) {
            for (int i = 0; i < vsubcarpetas.tablaagregarsubcarpetas.getRowCount(); i++) {
                msubcarpetas.setSubcarpeta(vsubcarpetas.tablaagregarsubcarpetas.getValueAt(i, 0).toString());
                msubcarpetas.setDirectorios_iddirectorios(mdirectotio.getIddirectorios());
                if (!csubcarpetas.registrar(msubcarpetas)) {
                    JOptionPane.showMessageDialog(null, "error guardado de la subcarpeta");
                } else {
                    limpiaragregarsubcarpeta();
                    limpiartablasubcarpeta();
                    llenartabla();
                }

            }
        }

        //metodo para elminar las subcarpetas de la base de datos 
        if (e.getSource() == vsubcarpetas.eliminarsubcarpeta) {
            int fila = vsubcarpetas.tablasubcarpetas.getSelectedRow();
            if (fila >= 0) {
                msubcarpetas.setSubcarpeta(String.valueOf(vsubcarpetas.tablasubcarpetas.getValueAt(fila, 0)));
                if (csubcarpetas.eliminar(msubcarpetas)) {
                    model2.removeRow(fila);
                }
            }
        }
    }

    public void llenartabla() {
        ArrayList<String> subcarpeta;
        Object[] dato = new Object[1];
        msubcarpetas.setDirectorios_iddirectorios(mdirectotio.getIddirectorios());
        subcarpeta = csubcarpetas.llenar(msubcarpetas);
        for (int i = 0; i < subcarpeta.size(); i++) {
            dato[0] = subcarpeta.get(i);
            model2.addRow(dato);
            vsubcarpetas.tablasubcarpetas.setModel(model2);
        }
    }

    public void limpiaragregarsubcarpeta() {
        if (vsubcarpetas.tablaagregarsubcarpetas.getRowCount() >= 0) {
            int count = vsubcarpetas.tablaagregarsubcarpetas.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }

    public void limpiartablasubcarpeta() {
        if (vsubcarpetas.tablasubcarpetas.getRowCount() >= 0) {
            int count = vsubcarpetas.tablasubcarpetas.getRowCount();
            for (int i = 0; i < count; i++) {
                model2.removeRow(0);
            }
        }
    }

}
