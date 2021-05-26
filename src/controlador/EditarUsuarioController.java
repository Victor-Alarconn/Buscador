/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Rol;
import modelo.Usuario;
import vistas.Editarusuario;

/**
 *
 * @author yonathan
 */
public class EditarUsuarioController implements ActionListener {

    private final Usuario modelo;
    private final Consultas_usuario consulta;
    private final Editarusuario vista;
    Rol rol = new Rol();

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

        inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.guardaruser) {
            rol.setRol(vista.txtrol.getSelectedItem().toString());
            if (consulta.buscar(rol)) {
                modelo.setRol(rol.getIdroles());
                modelo.setNombre(vista.txtnombre.getText());
                modelo.setApellido(vista.txtapellido.getText());
                modelo.setNumero_documento(vista.txtdocumento.getText());
                modelo.setContrasena(vista.txtcontraseña.getText());
                if (rol.getIdroles() == 2) {
                    if (vista.checkconfiguraciones.isSelected()) {
                        modelo.setConfiguraciones(1);
                    }
                    if (vista.checkcrearcliente.isSelected()) {
                        modelo.setCrearcliente(1);
                    }
                    if (vista.checkcarpetas.isSelected()) {
                        modelo.setCarpetas(1);
                    }
                    if (vista.checkservicios.isSelected()) {
                        modelo.setServicios(1);
                    }
                    if (vista.checkotros.isSelected()) {
                        modelo.setOtros(1);
                    }
                    if (vista.checkcrearusuario.isSelected()) {
                        modelo.setCrearusuarios(1);
                    }
                    if (vista.checkbuscar.isSelected()) {
                        modelo.setBuscar(1);
                    }
                    if (vista.checkeditarcliente.isSelected()) {
                        modelo.setEditarcliente(1);
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
        }
        if (e.getSource() == vista.txtrol) {
            if (vista.txtrol.getSelectedItem().toString().equals("admin")) {
                vista.checkconfiguraciones.setVisible(false);
                vista.checkcrearcliente.setVisible(false);
                vista.checkcarpetas.setVisible(false);
                vista.checkservicios.setVisible(false);
                vista.checkotros.setVisible(false);
                vista.checkcrearusuario.setVisible(false);
                vista.checkbuscar.setVisible(false);
                vista.checkeditarcliente.setVisible(false);
            } else {
                if (vista.txtrol.getSelectedItem().toString().equals("user")) {
                    vista.checkconfiguraciones.setVisible(true);
                    vista.checkcrearcliente.setVisible(true);
                    vista.checkcarpetas.setVisible(true);
                    vista.checkservicios.setVisible(true);
                    vista.checkotros.setVisible(true);
                    vista.checkcrearusuario.setVisible(true);
                    vista.checkbuscar.setVisible(true);
                    vista.checkeditarcliente.setVisible(true);
                }
            }

        }
    }

    public void inicializar() {
        if (consulta.buscarusuario(modelo)) {
            vista.txtnombre.setText(modelo.getNombre());
            vista.txtapellido.setText(modelo.getApellido());
            vista.txtdocumento.setText(modelo.getNumero_documento());
            vista.txtrol.addItem(modelo.getSobrerol());
            if (modelo.getConfiguraciones() == 1) {
                vista.checkconfiguraciones.setSelected(true);
            }
            if (modelo.getServicios() == 1) {
                vista.checkservicios.setSelected(true);
            }
            if (modelo.getCrearcliente() == 1) {
                vista.checkcrearcliente.setSelected(true);
            }
            if (modelo.getCarpetas() == 1) {
                vista.checkcarpetas.setSelected(true);
            }
            if (modelo.getBuscar() == 1) {
                vista.checkbuscar.setSelected(true);
            }
            if (modelo.getEditarcliente() == 1) {
                vista.checkeditarcliente.setSelected(true);
            }
            if (modelo.getCrearusuarios() == 1) {
                vista.checkconfiguraciones.setSelected(true);
            }
            if (modelo.getOtros() == 1) {
                vista.checkotros.setSelected(true);
            }
            if (modelo.getEstado() == 0) {
                vista.checkdesactivar.setSelected(true);
            }
            ArrayList<String> lista3 = new ArrayList<String>();
            lista3 = consulta.llenar();
            for (int i = 0; i < lista3.size(); i++) {
                vista.txtrol.addItem(lista3.get(i));
            }
        }

    }

}
