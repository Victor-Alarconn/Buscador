/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Directorio;
import Consultas.Consultas_SubCarpetas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import modelo.Directorio;
import modelo.Subcarpeta;
import modelo.Usuario;
import vistas.Carpetas;
import vistas.Configuraciones;
import vistas.SubCarpetas;

/**
 *
 * @author yonathan
 */
public class DirectorioController implements ActionListener {

    private final Consultas_Directorio cdirectorio;
    private final Directorio mdirectorio;
    private final Carpetas vdirectorio;
    private Usuario user;

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();

    Subcarpeta msubcarpeta = new Subcarpeta();
    Consultas_SubCarpetas csubcarpeta = new Consultas_SubCarpetas();

    DefaultMutableTreeNode raiz;
    DefaultTreeModel modelo;

    public DirectorioController(Consultas_Directorio cdirectorio,
            Directorio mdirectorio, Carpetas vdirectorio, Usuario user) {
        this.cdirectorio = cdirectorio;
        this.mdirectorio = mdirectorio;
        this.vdirectorio = vdirectorio;
        this.user = user;
        this.vdirectorio.agregarcarpeta.addActionListener(this);
        this.vdirectorio.eliminarmenuitem.addActionListener(this);
        this.vdirectorio.guardarcarpeta.addActionListener(this);

    }

    public void iniciar() {
        vdirectorio.setTitle("Carpetas");
        vdirectorio.setLocationRelativeTo(null);
        busqueda();
    }

    public void registrardirectorio() {
        if (cdirectorio.registrar(mdirectorio)) {
            modelo = new DefaultTreeModel(raiz);
            vdirectorio.arbol.setModel(modelo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vdirectorio.guardarcarpeta) {
            busqueda();
        }

        Object[] dato = new Object[1];
        if (e.getSource() == vdirectorio.agregarcarpeta) {
            if (vdirectorio.arbol.getSelectionCount() > 0) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) vdirectorio.arbol.getSelectionPath().getLastPathComponent();
                if (nodo.getLevel() > 0) {
                    String carpeta = JOptionPane.showInputDialog(vdirectorio, "Ingrese el nombre de la carpeta");
                    mdirectorio.setUsuarios_idusuarios(user.getIdusuario());
                    mdirectorio.setCarpeta(carpeta);
                    Directorio direct = (Directorio) nodo.getUserObject();
                    mdirectorio.setDirectorios_iddirectorios(direct.getIddirectorios());
                    mdirectorio.setNodo_level(nodo.getLevel()+1);
                    registrardirectorio();
                    busqueda();
                }
            } else {
                mdirectorio.setUsuarios_idusuarios(user.getIdusuario());
                mdirectorio.setCarpeta("ppp");
                mdirectorio.setDirectorios_iddirectorios(0);
                mdirectorio.setNodo_level(1);
                registrardirectorio();
                busqueda();
            }
//            
//        
        }
        if (e.getSource() == vdirectorio.eliminarmenuitem) {
//            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) vdirectorio.arbol.getSelectionPath().getLastPathComponent();

//            Directorio directorio = (Directorio) nodo.getUserObject();
        }

//        if (e.getSource() == vdirectorio.eliminarcarpeta) {
//                         
//        }
//        //boton para agregar subcarpeta 
//        if (e.getSource() == vdirectorio.agregarsubcarpeta) {
//            
//        }
    }

    public void busqueda() {
        ArrayList<Directorio> directorio;
        Object[] dato = new Object[2];

        directorio = cdirectorio.llenar();
        raiz = new DefaultMutableTreeNode("Directorios");
        m(directorio);
        for (int i = 0; i < directorio.size(); i++) {
            DefaultMutableTreeNode directorios = new DefaultMutableTreeNode();
            directorios.setUserObject(directorio.get(i));
            if (directorio.get(i).getDirectorios_iddirectorios() != 0) {
                for (int j = 0; j < directorio.size(); j++) {
                    if (directorio.get(i).getIddirectorios() == directorio.get(j).getDirectorios_iddirectorios()) {
                        DefaultMutableTreeNode subdirectorios = new DefaultMutableTreeNode();
                        subdirectorios.setUserObject(directorio.get(j));
                        directorios.add(subdirectorios);
                        raiz.add(directorios);
                    }
                }
            } else {
                raiz.add(directorios);
            }

        }
        modelo = new DefaultTreeModel(raiz);
        vdirectorio.arbol.setModel(modelo);
    }
    public void m(ArrayList<Directorio> directorio){
        
    }
}
