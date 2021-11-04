/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_Clase;
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
import Modelos.Clases;
import Modelos.Usuario;
import Vistas.Otros;

/**
 *
 * @author yonathan
 */
public class ClaseController implements ActionListener {
    
    private final Consultas_Clase cc;
    private final Clases mc;
    private final Otros vc;
    private final Usuario user;
    final static Color personalizado = new Color(240,240,240);
    DefaultMutableTreeNode raiz;
    DefaultTreeModel modelotree;
    
    public ClaseController(Consultas_Clase cc, Clases mc, Otros vc, Usuario user) {
        this.cc = cc;
        this.mc = mc;
        this.vc = vc;
        this.user = user;
        this.vc.agregarclases.addActionListener(this);
        this.vc.eliminarclases.addActionListener(this);
    }
    
    public void iniciar() {
        vc.setTitle("Otros");
        MouseClicked();
//      formulario.setLocationRelativeTo(null);
        //cambia los iconos del arbol
        DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) vc.arbolclase.getCellRenderer();
        render.setLeafIcon(new ImageIcon(getClass().getResource("/img/tiendas2.png")));
        render.setOpenIcon(new ImageIcon(getClass().getResource("/img/tiendas.png")));
        render.setClosedIcon(new ImageIcon(getClass().getResource("/img/tiendas2.png")));
        render.setBackgroundNonSelectionColor(personalizado);
        render.setPreferredSize(new Dimension(100, 32));
        busqueda();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vc.agregarclases) {
            String carpeta = JOptionPane.showInputDialog(vc, "Ingrese el nombre del Clase");
            if (!carpeta.equals("")) {
                mc.setClase(carpeta);
                mc.setUsuarios_idusuarios(user.getIdusuario());
                try {
                    if (!cc.registrar(mc)) {
                        JOptionPane.showMessageDialog(null, "error guardando la clase");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ClaseController.class.getName()).log(Level.SEVERE, null, ex);
                }
                busqueda();
            } 
        } else {
            if (e.getSource() == vc.eliminarclases) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) vc.arbolclase.getSelectionPath().getLastPathComponent();
                Clases clase = (Clases) nodo.getUserObject();
                try {
                    if (cc.eliminar(clase)) {
                        busqueda();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
    }
    
    public void busqueda() {
        ArrayList<Clases> clases = cc.llenar();
        raiz = new DefaultMutableTreeNode("Clases");
        Object[] dato = new Object[2];
        for (int i = 0; i < clases.size(); i++) {
            
            DefaultMutableTreeNode servi = new DefaultMutableTreeNode();
            servi.setUserObject(clases.get(i));
            raiz.add(servi);
        }
        modelotree = new DefaultTreeModel(raiz);
        vc.arbolclase.setModel(modelotree);
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
                if (vc.arbolclase.getSelectionRows().length > 0) {
                    vc.arbolclase.setComponentPopupMenu(vc.jPopupMenu1);
                }
                // MouseEvent.BUTTON3 es el boton derecho
            }
        };
        vc.arbolclase.addMouseListener(mouseListener);
    }
    
}
