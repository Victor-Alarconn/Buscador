/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Cliente_Potencial;
import buscador.Dialogos;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente_Potencial;
import vistas.Principal;

/**
 *
 * @author Yonathan Carvajal
 */
public class BusquedaController implements ActionListener {

    private final Cliente_Potencial modelo;
    private final Consultas_Cliente_Potencial consulta;
    private final Principal principal;
    DefaultTableModel model = new DefaultTableModel();
    Dialogos dialogo = new Dialogos();

    public BusquedaController(Cliente_Potencial modelo, Consultas_Cliente_Potencial consulta, Principal principal) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.principal = principal;
        this.principal.abrirarchivos.addActionListener(this);
    }

    public void iniciar() {
        principal.setTitle("Busqueda");
        model.addColumn("ID");
        model.addColumn("Nit");
        model.addColumn("Nombre");
        model.addColumn("Codigo");
        model.addColumn("fecha");
        model.addColumn("ruta");
        principal.tabladatos.setModel(model);
//        principal.tabladatos.getColumn("ID").setWidth(0);
//        principal.tabladatos.getColumn("ID").setMinWidth(0);
//        principal.tabladatos.getColumn("ID").setMaxWidth(0);
        keyevent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.abrirarchivos) {
            int fila = principal.tabladatos.getSelectedRow();
            abrirarchivo(String.valueOf(principal.tabladatos.getValueAt(fila, 5)));
        }
        
    }

    public void keyevent() {
        principal.txtbuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                busqueda();
            }
        });
    }

    public void limpiartabla() {
        if (principal.tabladatos.getRowCount() >= 0) {
            int count = principal.tabladatos.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }

    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void limpiar() {
//        pricipal.txtnombre.setText("");
//        pricipal.txtapellido.setText("");
//        pricipal.txtdocumento.setText("");
    }

    public void busqueda() {
        if (principal.txtbuscar.getText().length() == 0) {
            limpiartabla();
            //dialogo.alerta();
        }
        if (principal.txtbuscar.getText().length() > 0) {
            limpiartabla();
            Object[] dato = new Object[6];
            int cantidad = consulta.buscarcaracter(principal.txtbuscar.getText()).size();
            for (int i = 0; i < cantidad; i++) {
                dato[0] = consulta.buscarcaracter(principal.txtbuscar.getText()).get(i).getIdclientes_potenciales();                          
                dato[1] = consulta.buscarcaracter(principal.txtbuscar.getText()).get(i).getNit();
                dato[2] = consulta.buscarcaracter(principal.txtbuscar.getText()).get(i).getNombre();  
                dato[3] = consulta.buscarcaracter(principal.txtbuscar.getText()).get(i).getCodigo();
                dato[4] = consulta.buscarcaracter(principal.txtbuscar.getText()).get(i).getFecha_llegada();
                dato[5] = consulta.buscarcaracter(principal.txtbuscar.getText()).get(i).getRuta();
                model.addRow(dato);
                principal.tabladatos.setModel(model);
            }
        }
    }

}
