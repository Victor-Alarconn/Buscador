/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_Servicios;
import java.awt.Color;
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
import Modelos.Servicio;
import Modelos.Usuario;
import Vistas.Otros;

/**
 *
 * @author Yonathan Carvajal
 */
public class ServicioController implements ActionListener {

    private final Servicio modelo;
    private final Consultas_Servicios consulta;
    private final Otros vservicios;
    private final Usuario user;

    DefaultMutableTreeNode raiz;
    DefaultTreeModel modelotree;
    final static Color personalizado = new Color(240,240,240);
    

    public ServicioController(Servicio modelo, Consultas_Servicios consulta, Otros vservicios, Usuario user) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vservicios = vservicios;
        this.user = user;
        this.vservicios.agregarservicio.addActionListener(this);
        this.vservicios.eliminarservicio.addActionListener(this);
    }

    public void iniciar() {
        vservicios.setLocationRelativeTo(null);
        //cambia los iconos del arbol
        MouseClicked();
        DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) vservicios.arbolservicios.getCellRenderer();
        render.setLeafIcon(new ImageIcon(getClass().getResource("/img/servicestree.png")));
        render.setOpenIcon(new ImageIcon(getClass().getResource("/img/packsoft.png")));
        render.setClosedIcon(new ImageIcon(getClass().getResource("/img/servicestree.png")));
        render.setBackgroundNonSelectionColor(personalizado);
        busqueda();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vservicios.agregarservicio) {
            String carpeta = JOptionPane.showInputDialog(vservicios, "Ingrese el nombre del servicio");
            if (!carpeta.equals("")) {
                modelo.setServicio(carpeta);
                modelo.setUsuarios_idusuarios(user.getIdusuario());
                try {
                    if (!consulta.registrar(modelo)) {
                        JOptionPane.showMessageDialog(null, "error guardado de documento");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                busqueda();
            }

        }

        if (e.getSource() == vservicios.eliminarservicio) {
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) vservicios.arbolservicios.getSelectionPath().getLastPathComponent();
            Servicio servi = (Servicio) nodo.getUserObject();
            try {
                if (consulta.eliminar(servi)) {
                    busqueda();
                }
            } catch (IOException ex) {
                Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void busqueda() {
        ArrayList<Servicio> servicio;
        raiz = new DefaultMutableTreeNode("Servicios");
        Object[] dato = new Object[1];
        servicio = consulta.llenar();
        for (int i = 0; i < servicio.size(); i++) {
            DefaultMutableTreeNode servi = new DefaultMutableTreeNode();
            servi.setUserObject(servicio.get(i));
            raiz.add(servi);
        }
        modelotree = new DefaultTreeModel(raiz);
        vservicios.arbolservicios.setModel(modelotree);

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
                if (vservicios.arbolservicios.getSelectionRows().length > 0) {
                    vservicios.arbolservicios.setComponentPopupMenu(vservicios.jPopupMenu4);
                }
                // MouseEvent.BUTTON3 es el boton derecho
            }
        };
        vservicios.arbolservicios.addMouseListener(mouseListener);
    }
}
