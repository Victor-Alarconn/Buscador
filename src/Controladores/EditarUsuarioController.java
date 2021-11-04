/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelos.Rol;
import Modelos.Usuario;
import Vistas.Editarusuario;

/**
 *
 * @author yonathan
 */
public class EditarUsuarioController implements ActionListener {

    private final Usuario modelo;
    private final Consultas_usuario consulta;
    private final Editarusuario vista;
    Rol rol = new Rol();

    ArrayList<Rol> rollista;

    public EditarUsuarioController(Usuario modelo, Consultas_usuario consulta, Editarusuario vista) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vista = vista;
        this.vista.guardaruser.addActionListener(this);
        this.vista.txtrol.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Editar usuario");
        vista.setLocationRelativeTo(null);
        vista.txtrol.removeAllItems();
        rollista = consulta.llenar();
        for (int i = 0; i < rollista.size(); i++) {
            vista.txtrol.addItem(rollista.get(i));
        }
        inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.guardaruser) {

            Rol roles = (Rol) vista.txtrol.getModel().getSelectedItem();
            modelo.setRol(roles.getIdroles());
            modelo.setNombre(vista.txtnombre.getText());
            modelo.setContrasena(vista.txtcontraseña.getText());
            if (roles.getIdroles() == 2) {
                if (vista.checkconfiguraciones.isSelected()) {
                    modelo.setConfiguraciones(1);
                } else {
                    modelo.setConfiguraciones(0);
                }
                if (vista.checkcrearcliente.isSelected()) {
                    modelo.setCrearcliente(1);
                } else {
                    modelo.setCrearcliente(0);
                }
                if (vista.checkcarpetas.isSelected()) {
                    modelo.setCarpetas(1);
                } else {
                    modelo.setCarpetas(0);
                }

                if (vista.checkotros.isSelected()) {
                    modelo.setOtros(1);
                } else {
                    modelo.setOtros(0);
                }
                if (vista.checkcrearusuario.isSelected()) {
                    modelo.setCrearusuarios(1);
                } else {
                    modelo.setCrearusuarios(0);
                }
                if (vista.checkeditarcliente.isSelected()) {
                    modelo.setEditarcliente(1);
                } else {
                    modelo.setEditarcliente(0);
                }
                if (vista.checkbuscar.isSelected()) {
                    modelo.setBuscar(1);
                } else {
                    modelo.setBuscar(0);
                }
                if (vista.checkbackups.isSelected()) {
                    modelo.setBackups(1);
                } else {
                    modelo.setBackups(0);
                }

            }
            if (!vista.checkdesactivar.isSelected()) {
                modelo.setEstado(1);

            } else {
                modelo.setEstado(0);
            }
            if (consulta.modificarusuario(modelo)) {
                JOptionPane.showMessageDialog(null, "registro modificado");
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "error guardado");
            }

        }
        if (e.getSource() == vista.txtrol) {
            Rol roles = (Rol) vista.txtrol.getModel().getSelectedItem();
            if (roles != null) {
                if (roles.toString().equals("admin")) {
                    vista.checkconfiguraciones.setVisible(false);
                    vista.checkcrearcliente.setVisible(false);
                    vista.checkcarpetas.setVisible(false);
                    vista.checkotros.setVisible(false);
                    vista.checkcrearusuario.setVisible(false);
                    vista.checkeditarcliente.setVisible(false);
                    vista.checkbuscar.setVisible(false);
                    vista.checkbackups.setVisible(false);
                } else {
                    if (roles.toString().equals("user")) {
                        vista.checkconfiguraciones.setVisible(true);
                        vista.checkcrearcliente.setVisible(true);
                        vista.checkcarpetas.setVisible(true);
                        vista.checkotros.setVisible(true);
                        vista.checkcrearusuario.setVisible(true);
                        vista.checkeditarcliente.setVisible(true);
                        vista.checkbuscar.setVisible(true);
                        vista.checkbackups.setVisible(true);
                    }
                }
            }
        }
    }

    public void inicializar() {
        if (consulta.buscarusuario(modelo)) {
            vista.txtnombre.setText(modelo.getNombre());
            for (int i = 0; i < vista.txtrol.getComponentCount(); i++) {
                if (vista.txtrol.getModel().getElementAt(i).toString().equals(modelo.getSobrerol())) {
                    vista.txtrol.setSelectedIndex(i);
                }
            }

            if (modelo.getConfiguraciones() == 1) {
                vista.checkconfiguraciones.setSelected(true);
            }
            if (modelo.getCrearcliente() == 1) {
                vista.checkcrearcliente.setSelected(true);
            }
            if (modelo.getCarpetas() == 1) {
                vista.checkcarpetas.setSelected(true);
            }
            if (modelo.getEditarcliente() == 1) {
                vista.checkeditarcliente.setSelected(true);
            }
            if (modelo.getCrearusuarios() == 1) {
                vista.checkcrearusuario.setSelected(true);
            }
            if (modelo.getOtros() == 1) {
                vista.checkotros.setSelected(true);
            }
            if (modelo.getBuscar() == 1) {
                vista.checkbuscar.setSelected(true);
            }
            if (modelo.getBackups() == 1) {
                vista.checkbackups.setSelected(true);
            }
            if (modelo.getEstado() == 0) {
                vista.checkdesactivar.setSelected(true);
            }

        }

    }

}
