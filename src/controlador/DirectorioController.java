/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Directorio;
import Consultas.Consultas_SubCarpetas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Directorio;
import modelo.Subcarpeta;
import modelo.Usuario;
import vistas.Carpetas;
import vistas.Configuraciones;
import vistas.SubCarpetas;

/**
 *
 * @author yonathan
 */
public class DirectorioController implements ActionListener {

    private final Consultas_Directorio cdirectorio;
    private final Directorio mdirectorio;
    private final Carpetas vdirectorio;
    private Usuario user;

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();

    Subcarpeta msubcarpeta = new Subcarpeta();
    Consultas_SubCarpetas csubcarpeta = new Consultas_SubCarpetas();

    public DirectorioController(Consultas_Directorio cdirectorio, 
            Directorio mdirectorio, Carpetas vdirectorio, Usuario user) {
        this.cdirectorio = cdirectorio;
        this.mdirectorio = mdirectorio;
        this.vdirectorio = vdirectorio;
        this.user = user;
        this.vdirectorio.agregarcarpeta.addActionListener(this);
        this.vdirectorio.eliminaragregarcarpeta.addActionListener(this);
        this.vdirectorio.eliminarcarpeta.addActionListener(this);
        this.vdirectorio.guardarcarpeta.addActionListener(this);
        this.vdirectorio.agregarsubcarpeta.addActionListener(this);
    }

    public void iniciar() {
        vdirectorio.setTitle("Carpetas");
        vdirectorio.setLocationRelativeTo(null);
        model.addColumn("Agregar carpeta");
        model2.addColumn("Carpetas");
        model2.addColumn("id");
        vdirectorio.tablaagregarcarpetas.setModel(model);
        vdirectorio.tablacarpetas.setModel(model2);
        vdirectorio.tablacarpetas.getColumn("id").setWidth(0);
        vdirectorio.tablacarpetas.getColumn("id").setMinWidth(0);
        vdirectorio.tablacarpetas.getColumn("id").setMaxWidth(0);
        busqueda();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vdirectorio.guardarcarpeta) {
            for (int i = 0; i < vdirectorio.tablaagregarcarpetas.getRowCount(); i++) {
                mdirectorio.setCarpeta(vdirectorio.tablaagregarcarpetas.getValueAt(i, 0).toString());
                mdirectorio.setUsuarios_idusuarios(user.getIdusuario());
                if (!cdirectorio.registrar(mdirectorio)) {
                    JOptionPane.showMessageDialog(null, "error guardado de documento");
                }
            }
            limpiaragregarcarpeta();
            limpiartablacarpeta();
            busqueda();
        }

        Object[] dato = new Object[1];
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
        //boton para agregar subcarpeta 
        if (e.getSource() == vdirectorio.agregarsubcarpeta) {
            SubCarpetas vsubcarpetas = new SubCarpetas(null, true);
            int fila = vdirectorio.tablacarpetas.getSelectedRow();
            if (fila >= 0) {
                mdirectorio.setCarpeta(String.valueOf(vdirectorio.tablacarpetas.getValueAt(fila, 0)));
                mdirectorio.setIddirectorios(Integer.parseInt(String.valueOf(vdirectorio.tablacarpetas.getValueAt(fila, 1))));
                SubCarpetasController ctrsubcarpeta = new SubCarpetasController(msubcarpeta, csubcarpeta, vsubcarpetas, mdirectorio, user);
                ctrsubcarpeta.iniciar();
                vsubcarpetas.setVisible(true);
            }
        }

    }

    public void busqueda() {
        ArrayList<Directorio> directorio;
        Object[] dato = new Object[2];
        directorio = cdirectorio.llenar();
        for (int i = 0; i < directorio.size(); i++) {
            dato[0] = directorio.get(i).getCarpeta();
            dato[1] = directorio.get(i).getIddirectorios();
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
