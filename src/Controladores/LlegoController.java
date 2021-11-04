/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_Llego;
import static Controladores.ClaseController.personalizado;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import Modelos.Llego;
import Modelos.Usuario;
import Vistas.Otros;

/**
 *
 * @author yonathan
 */
public class LlegoController implements ActionListener {

    private final Llego ml;
    private final Consultas_Llego cl;
    private final Otros vl;
    private final Usuario user;

    final static Color personalizado = new Color(240, 240, 240);
    DefaultMutableTreeNode raiz;
    DefaultTreeModel modelotree;

    public LlegoController(Llego ml, Consultas_Llego cl, Otros vl, Usuario user) {
        this.ml = ml;
        this.cl = cl;
        this.vl = vl;
        this.user = user;
        this.vl.agregarllego.addActionListener(this);
        this.vl.eliminarllego.addActionListener(this);
    }

    public void iniciar() {
        vl.setTitle("Otros");
        MouseClicked();
        vl.setLocationRelativeTo(null);
        DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) vl.arbolllego.getCellRenderer();
        render.setLeafIcon(new ImageIcon(getClass().getResource("/img/referido.png")));
        render.setOpenIcon(new ImageIcon(getClass().getResource("/img/referido.png")));
        render.setClosedIcon(new ImageIcon(getClass().getResource("/img/referido.png")));
        render.setBackgroundNonSelectionColor(personalizado);
        render.setPreferredSize(new Dimension(100, 32));
        busqueda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vl.agregarllego) {

            String llego = JOptionPane.showInputDialog(vl, "Ingrese el nombre");
            if (!llego.equals("")) {
                ml.setLlego(llego);
                ml.setUsuarios_idusuarios(user.getIdusuario());
                try {
                    if (!cl.registrar(ml)) {
                        JOptionPane.showMessageDialog(null, "error guardando la llego");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(LlegoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                busqueda();
            };

        } else {
            if (e.getSource() == vl.eliminarllego) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) vl.arbolllego.getSelectionPath().getLastPathComponent();
                Llego llego = (Llego) nodo.getUserObject();
                try {
                    if (cl.eliminar(llego)) {
                        busqueda();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(LlegoController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public void busqueda() {
        ArrayList<Llego> llego = cl.llenar();
        raiz = new DefaultMutableTreeNode("Llego");
        Object[] dato = new Object[2];
        for (int i = 0; i < llego.size(); i++) {
            DefaultMutableTreeNode servi = new DefaultMutableTreeNode();
            servi.setUserObject(llego.get(i));
            raiz.add(servi);
        }
        modelotree = new DefaultTreeModel(raiz);

        vl.arbolllego.setModel(modelotree);

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
                if (vl.arbolllego.getSelectionRows().length > 0) {
                    vl.arbolllego.setComponentPopupMenu(vl.jPopupMenu2);
                }
                // MouseEvent.BUTTON3 es el boton derecho
            }
        };
        vl.arbolllego.addMouseListener(mouseListener);
    }
}
