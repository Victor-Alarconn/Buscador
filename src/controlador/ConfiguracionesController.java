/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Modulos;
import Consultas.Consultas_usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import modelo.Configuracion;
import modelo.Modulo;
import modelo.Usuario;
import vistas.Configuraciones;

/**
 *
 * @author Yonathan Carvajal
 */
public class ConfiguracionesController implements ActionListener {

    private final Configuracion mconfiguraciones;
    private final Consultas_Configuraciones cconfiguraciones;
    private final Configuraciones vconfiguraciones;
    private final Usuario user;

    Consultas_usuario cu = new Consultas_usuario();
    Usuario u = new Usuario();

    Consultas_Modulos cmodulo = new Consultas_Modulos();
    Modulo mmodulo = new Modulo();

    DefaultTableModel modell = new DefaultTableModel();
    ArrayList<Configuracion> configuracion;

    public ConfiguracionesController(Configuracion mconfiguraciones,
            Consultas_Configuraciones cconfiguraciones,
            Configuraciones vconfiguraciones, Usuario user) {
        this.mconfiguraciones = mconfiguraciones;
        this.cconfiguraciones = cconfiguraciones;
        this.vconfiguraciones = vconfiguraciones;
        this.user = user;
        this.vconfiguraciones.guardarconfiguracion.addActionListener(this);
        this.vconfiguraciones.btnbuscar.addActionListener(this);
        this.vconfiguraciones.EditarMenuItem1.addActionListener(this);
        this.vconfiguraciones.eliminarMenuItem1.addActionListener(this);
    }

    public void iniciar() {
        vconfiguraciones.setTitle("Configuraciones");
        modell.addColumn("ID");
        modell.addColumn("Ruta");
        modell.addColumn("Modulo");
        vconfiguraciones.tablarutas.setModel(modell);
        vconfiguraciones.tablarutas.getColumn("ID").setWidth(0);
        vconfiguraciones.tablarutas.getColumn("ID").setMinWidth(0);
        vconfiguraciones.tablarutas.getColumn("ID").setMaxWidth(0);
        vconfiguraciones.tablarutas.getColumn("Modulo").setWidth(100);
        vconfiguraciones.tablarutas.getColumn("Modulo").setMinWidth(100);
        vconfiguraciones.tablarutas.getColumn("Modulo").setMaxWidth(100);
        vconfiguraciones.setLocationRelativeTo(null);
        vconfiguraciones.idtabla.setVisible(false);
        config();
        MouseClicked();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // boton para guardar configuraciones 
        if (e.getSource() == vconfiguraciones.guardarconfiguracion) {
            if (!vconfiguraciones.txtdirectorio.getText().equals("")) {

                Modulo modulo = (Modulo) vconfiguraciones.txtmodulo.getModel().getSelectedItem();
                mconfiguraciones.setModulos_idmodulos(modulo.getIdmodulo());
                mconfiguraciones.setDirectorio(vconfiguraciones.txtdirectorio.getText());
                mconfiguraciones.setUsuarios_idusuario(user.getIdusuario());
                if (!vconfiguraciones.idtabla.getText().equals("")) {
                    mconfiguraciones.setIdconfiguracion(Integer.parseInt(vconfiguraciones.idtabla.getText()));
                    if (cconfiguraciones.modificar(mconfiguraciones)) {
                        JOptionPane.showMessageDialog(vconfiguraciones, "registro modificado");
                        limpiarcampos();
                    } else {
                        JOptionPane.showMessageDialog(vconfiguraciones, "Error modificando el registro");
                    }
                } else {
                    boolean estado = false;
                    if (vconfiguraciones.tablarutas.getRowCount() > 0) {
                        for (int i = 0; i < vconfiguraciones.tablarutas.getRowCount(); i++) {
                            if (modulo.getModulo().equals(vconfiguraciones.tablarutas.getValueAt(i, 2).toString())) {
                                estado = false;
                                JOptionPane.showMessageDialog(vconfiguraciones, "Existe una ruta para este modulo");
                                break;
                            } else {
                                estado = true;
                            }
                        }
                        if (estado) {
                            if (cconfiguraciones.registrar(mconfiguraciones)) {
                                JOptionPane.showMessageDialog(vconfiguraciones, "registro guardado");
                                limpiarcampos();
                            } else {
                                JOptionPane.showMessageDialog(vconfiguraciones, "error al guardando");
                            }
                        }
                    } else {
                        if (cconfiguraciones.registrar(mconfiguraciones)) {
                            JOptionPane.showMessageDialog(vconfiguraciones, "registro guardado");
                            limpiarcampos();
                        } else {
                            JOptionPane.showMessageDialog(vconfiguraciones, "error al guardando");
                        }
                    }

                }
            }
            if (!vconfiguraciones.usuariodefecto.isSelected()) {
                u.setEstado(1);
                u.setNombre("admin");
                cu.modificar(u);
            } else {
                u.setEstado(0);
                u.setNombre("admin");
                cu.modificar(u);
            }
            limpiartabla();
            this.config();
        }

        if (e.getSource() == vconfiguraciones.btnbuscar) {
            JFileChooser jf = new JFileChooser();
            jf.setCurrentDirectory(new File("c:\\"));
            jf.setDialogTitle("Selecione una carpeta");
            jf.setAcceptAllFileFilterUsed(false);
            jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (jf.showOpenDialog(vconfiguraciones) == JFileChooser.APPROVE_OPTION) {
                File archivo = jf.getSelectedFile();
                vconfiguraciones.txtdirectorio.setText(archivo.getPath());
            }
        }

        if (e.getSource() == vconfiguraciones.EditarMenuItem1) {
            int fila = vconfiguraciones.tablarutas.getSelectedRow();
            vconfiguraciones.txtdirectorio.setText(vconfiguraciones.tablarutas.getValueAt(fila, 1).toString());
            vconfiguraciones.idtabla.setText(vconfiguraciones.tablarutas.getValueAt(fila, 0).toString());
            for (int i = 0; i < vconfiguraciones.txtmodulo.getComponentCount(); i++) {
                if (vconfiguraciones.txtmodulo.getModel().getElementAt(i).toString().equals(vconfiguraciones.tablarutas.getValueAt(fila, 2).toString())) {
                    vconfiguraciones.txtmodulo.setSelectedIndex(i);
                }
            }
        }

        if (e.getSource() == vconfiguraciones.eliminarMenuItem1) {
            int fila = vconfiguraciones.tablarutas.getSelectedRow();
            mconfiguraciones.setIdconfiguracion(Integer.parseInt(vconfiguraciones.tablarutas.getValueAt(fila, 0).toString()));
            if (cconfiguraciones.eliminar(mconfiguraciones)) {
                limpiartabla();
                config();
            }

        }

    }

    public void config() {

        u.setNombre("admin");
        if (cu.buscarusueriodefault(u)) {
            if (u.getEstado() == 0) {
                vconfiguraciones.usuariodefecto.setSelected(true);
            }
        }

        ArrayList<Modulo> modulo = cmodulo.llenar();
        vconfiguraciones.txtmodulo.removeAllItems();
        for (int i = 0; i < modulo.size(); i++) {
            vconfiguraciones.txtmodulo.addItem(modulo.get(i));
        }

        configuracion = cconfiguraciones.cargar();
        Object[] dato = new Object[3];
        for (int i = 0; i < configuracion.size(); i++) {
            dato[0] = configuracion.get(i).getIdconfiguracion();
            dato[1] = configuracion.get(i).getDirectorio();
            dato[2] = configuracion.get(i).getModulo();
            modell.addRow(dato);
            vconfiguraciones.tablarutas.setModel(modell);
        }

    }

    public void MouseClicked() {
        MouseListener mouseListener = new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (vconfiguraciones.tablarutas.getSelectedRows().length > 0) {
                    vconfiguraciones.tablarutas.setComponentPopupMenu(vconfiguraciones.popup);
                }
                // MouseEvent.BUTTON3 es el boton derecho
            }
        };
        vconfiguraciones.tablarutas.addMouseListener(mouseListener);
    }

    public void limpiartabla() {
        if (vconfiguraciones.tablarutas.getRowCount() >= 0) {
            int count = vconfiguraciones.tablarutas.getRowCount();
            for (int i = 0; i < count; i++) {
                modell.removeRow(0);
            }
        }
    }

    public void limpiarcampos() {
        vconfiguraciones.txtdirectorio.setText("");
        vconfiguraciones.idtabla.setText("");
    }
}
