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
import vistas.Configuraciones;
import vistas.Crearusuario;

/**
 *
 * @author Yonathan Carvajal
 */
public class UsuarioController implements ActionListener {

    private final Usuario modelo;
    private final Consultas_usuario consulta;
    private final Crearusuario vista;
    Rol rol = new Rol();

    public UsuarioController(Usuario modelo, Consultas_usuario consulta, Crearusuario vista) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vista = vista;
        this.vista.guardaruser.addActionListener(this);
        this.vista.txtrol.addActionListener(this);

    }

    public void iniciar() {
        vista.setTitle("Registrar usuario");
        vista.setLocationRelativeTo(null);
        vista.txtrol.removeAllItems();
        ArrayList<String> lista3 = new ArrayList<String>();
        lista3 = consulta.llenar();
        for (int i = 0; i < lista3.size(); i++) {
            vista.txtrol.addItem(lista3.get(i));
        }
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
                if (consulta.registrar(modelo)) {
                    JOptionPane.showMessageDialog(null, "registro guardado");
                    this.limpiar();
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

    public void limpiar() {
        vista.txtnombre.setText("");
        vista.txtapellido.setText("");
        vista.txtdocumento.setText("");
        vista.txtcontraseña.setText("");
        vista.checkconfiguraciones.setSelected(false);
        vista.checkcrearcliente.setSelected(false);
        vista.checkcarpetas.setSelected(false);
        vista.checkservicios.setSelected(false);
        vista.checkotros.setSelected(false);
        vista.checkcrearusuario.setSelected(false);
        vista.checkbuscar.setSelected(false);
        vista.checkeditarcliente.setSelected(false);
    }
}
