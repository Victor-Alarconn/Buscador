/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Modelos.Usuario;
import Vistas.Crearusuario;
import Vistas.Editarusuario;
import Vistas.Usuarios;

/**
 *
 * @author yonathan
 */
public class UsuariosController implements ActionListener  {
    
    private final Usuario modelo;
    private final Consultas_usuario consulta;
    private final Usuarios usuarios;
    
    DefaultTableModel model = new DefaultTableModel();

    public UsuariosController(Usuario modelo, Consultas_usuario consulta, Usuarios usuarios) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.usuarios = usuarios;
        this.usuarios.crearusuario.addActionListener(this);
        this.usuarios.ediataruser.addActionListener(this);
        this.usuarios.eliminaruser.addActionListener(this);
    }
    
     public void iniciar() {
        usuarios.setTitle("usuarios");
        usuarios.setLocationRelativeTo(null);
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Rol");
        model.addColumn("Esatado");
        usuarios.tablauser.setModel(model);
        usuarios.tablauser.getColumn("ID").setWidth(0);
        usuarios.tablauser.getColumn("ID").setMinWidth(0);
        usuarios.tablauser.getColumn("ID").setMaxWidth(0);
    
        keyevent();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usuarios.crearusuario) {
            Crearusuario crearuser = new Crearusuario(null, true);
            CrearUsuarioController uctrl = new CrearUsuarioController(modelo, consulta, crearuser);
            uctrl.iniciar();
            crearuser.setVisible(true);
        }
        if (e.getSource() == usuarios.ediataruser) {
            Editarusuario ediuser = new Editarusuario(null, true);
            int selecionar = usuarios.tablauser.getSelectedRow();
            if (selecionar != -1) {
                modelo.setIdusuario(Integer.parseInt(String.valueOf(usuarios.tablauser.getValueAt(selecionar, 0))));
                EditarUsuarioController edic = new EditarUsuarioController(modelo, consulta, ediuser);
                edic.iniciar();
                ediuser.setVisible(true);
            }
        }
        if (e.getSource() == usuarios.eliminaruser) {
            int selecionar = usuarios.tablauser.getSelectedRow();   
            modelo.setIdusuario(Integer.parseInt(String.valueOf(usuarios.tablauser.getValueAt(selecionar, 0))));
            if (consulta.eliminar(modelo)) {
                this.busqueda();
            }
        }
    }
    
    public void keyevent() {
        usuarios.txtbuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                busqueda();
            }
        });
    }

    public void limpiartabla() {
        if (usuarios.tablauser.getRowCount() >= 0) {
            int count = usuarios.tablauser.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }
    
    public void busqueda() {
        if (usuarios.txtbuscar.getText().length() == 0) {
            limpiartabla();
            //dialogo.alerta();
        }
        if (usuarios.txtbuscar.getText().length() > 0) {
            limpiartabla();
            ArrayList<Usuario> usuario;
            Object[] dato = new Object[4];
            usuario = consulta.buscarcaracter(usuarios.txtbuscar.getText(),usuarios.filtro.getSelectedItem().toString());
            
            for (int i = 0; i < usuario.size(); i++) {
                dato[0] = usuario.get(i).getIdusuario();
                dato[1] = usuario.get(i).getNombre();
                dato[2] = usuario.get(i).getSobrerol();
                dato[3] = usuario.get(i).getSobreestado();
                model.addRow(dato);
                usuarios.tablauser.setModel(model);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
}
