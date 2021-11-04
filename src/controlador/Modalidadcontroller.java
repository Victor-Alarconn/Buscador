/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Modalidad;
import static controlador.ClaseController.personalizado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import modelo.Modalidad;
import modelo.Usuario;
import vistas.Otros;


/**
 *
 * @author Yonathan Carvajal
 */
public class Modalidadcontroller implements ActionListener {

    private final Modalidad mm;
    private final Consultas_Modalidad mcm;
    private final Otros vm;
    private final Usuario user;

    final static Color personalizado = new Color(240, 240, 240);
    DefaultMutableTreeNode raiz;
    DefaultTreeModel modelotree;

    public Modalidadcontroller(Modalidad mm, Consultas_Modalidad mcm, Otros vm, Usuario user) {
        this.mm = mm;
        this.mcm = mcm;
        this.vm = vm;
        this.user = user;
        this.vm.agregarmodalidad.addActionListener(this);
        this.vm.eliminarmodalidad.addActionListener(this);
    }

    public void iniciar() {
        vm.setLocationRelativeTo(null);
        DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) vm.arbolmodalidad.getCellRenderer();
        render.setLeafIcon(new ImageIcon(getClass().getResource("/img/nube.png")));
        render.setOpenIcon(new ImageIcon(getClass().getResource("/img/nube.png")));
        render.setClosedIcon(new ImageIcon(getClass().getResource("/img/nube.png")));
        render.setPreferredSize(new Dimension(200, 42));
        render.setBackgroundNonSelectionColor(personalizado);
        MouseClicked();
        busqueda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vm.agregarmodalidad) {
            String carpeta = JOptionPane.showInputDialog(vm, "Ingrese el nombre del Modalidad");
            if (!carpeta.equals("")) {
                mm.setModalidad(carpeta);
                mm.setUsuarios_idusuario(user.getIdusuario());
                try {
                    if (!mcm.registrar(mm)) {
                        JOptionPane.showMessageDialog(null, "error guardando la modalidad");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Modalidadcontroller.class.getName()).log(Level.SEVERE, null, ex);
                }
                busqueda();
            }

        } else {
            if (e.getSource() == vm.eliminarmodalidad) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) vm.arbolmodalidad.getSelectionPath().getLastPathComponent();
                Modalidad modalidad = (Modalidad) nodo.getUserObject();
                try {
                    if (mcm.eliminar(modalidad)) {
                        busqueda();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void busqueda() {
        ArrayList<Modalidad> moda = mcm.llenar();
        raiz = new DefaultMutableTreeNode("Modalidades");
        Object[] dato = new Object[2];
        for (int i = 0; i < moda.size(); i++) {
            DefaultMutableTreeNode modalidad = new DefaultMutableTreeNode();
            modalidad.setUserObject(moda.get(i));
            raiz.add(modalidad);
        }
        modelotree = new DefaultTreeModel(raiz);
        vm.arbolmodalidad.setModel(modelotree);
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
                if (vm.arbolmodalidad.getSelectionRows().length > 0) {
                    vm.arbolmodalidad.setComponentPopupMenu(vm.jPopupMenu3);
                }
                // MouseEvent.BUTTON3 es el boton derecho
            }
        };
        vm.arbolmodalidad.addMouseListener(mouseListener);
    }
}
