/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Directorio;
import Consultas.Consultas_Mac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import modelo.Cliente;
import modelo.Configuracion;
import modelo.Directorio;
import modelo.Mac;
import modelo.Usuario;
import vistas.Carpetas;
import vistas.Configuraciones;

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

    DefaultMutableTreeNode raiz;
    DefaultTreeModel modelo;

    Consultas_Mac cmac = new Consultas_Mac();
    Mac mmac = new Mac();
    ArrayList<Configuracion> mconfig;
    Consultas_Configuraciones cconfiguraciones = new Consultas_Configuraciones();
    private String directorio = null;
    ArrayList<Cliente> rutas;

    public DirectorioController(Consultas_Directorio cdirectorio,
            Directorio mdirectorio, Carpetas vdirectorio, Usuario user) {
        this.cdirectorio = cdirectorio;
        this.mdirectorio = mdirectorio;
        this.vdirectorio = vdirectorio;
        this.user = user;
        this.vdirectorio.agregarmenuitem.addActionListener(this);
        this.vdirectorio.eliminarmenuitem.addActionListener(this);

    }

    public void iniciar() {
        vdirectorio.setTitle("Carpetas");
        vdirectorio.setLocationRelativeTo(null);
        mmac.setMacs(mmac.conseguirMAC());
        if (cmac.buscar(mmac)) {
            mconfig = cconfiguraciones.cargar(mmac.getIdmacs());
            for (int i = 0; i < mconfig.size(); i++) {
                if (mconfig.get(i).getModulo().toLowerCase().equals("clientes")) {
                    directorio = mconfig.get(i).getDirectorio();
                }
            }

        }
        rutas = cdirectorio.rutas();

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
        Object[] dato = new Object[1];
        if (e.getSource() == vdirectorio.agregarmenuitem) {
            if (vdirectorio.arbol.getSelectionCount() > 0) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) vdirectorio.arbol.getSelectionPath().getLastPathComponent();
                
                if (nodo.getLevel() > 0) {
                    agregarnodo(nodo);
                    Directorio direct = (Directorio) nodo.getUserObject();

                    mdirectorio.setDirectorios_iddirectorios(direct.getIddirectorios());
                    registrardirectorio();
                    busqueda();
                } else {
//                    System.out.println(nodo.getLevel());
                    agregarnodo(nodo);
                    registrardirectorio();
                    busqueda();
                }
            }
        }
        if (e.getSource() == vdirectorio.eliminarmenuitem) {
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) vdirectorio.arbol.getSelectionPath().getLastPathComponent();
            Directorio directorio = (Directorio) nodo.getUserObject();
            if (cdirectorio.eliminar(directorio)) {
                busqueda();
            }
        }
    }

    public void estructurarcarpeta(DefaultMutableTreeNode nodo, String carpeta) {
        TreeNode[] d = nodo.getPath();
        

        String miarray[] = new String[d.length-1];
       
        for (int i = 1; i < d.length; i++) {
           miarray[i-1] = d[i].toString();
        } 
        StringBuffer cadena = new StringBuffer();
        for (int x = 0; x < miarray.length; x++) {
            cadena = cadena.append(miarray[x]+File.separator);
        }
        for (int i = 0; i < rutas.size(); i++) {
        Crear_archivo(directorio+rutas.get(i).getRuta()+File.separator+cadena, carpeta);
        }
        
       
    }
    
    public void Crear_archivo(String path, String nombre) {
        File file = new File(path, nombre);
        file.mkdir();
    }

    public void agregarnodo(DefaultMutableTreeNode nodo) {
        String carpeta = JOptionPane.showInputDialog(vdirectorio, "Ingrese el nombre de la carpeta");
        if (!carpeta.equals("")) {
            mdirectorio.setUsuarios_idusuarios(user.getIdusuario());
            mdirectorio.setCarpeta(carpeta);
            mdirectorio.setNodo_level(nodo.getLevel() + 1);
            estructurarcarpeta(nodo,carpeta);
        }

    }

    public void busqueda() {
        ArrayList<Directorio> directorio;
        Object[] dato = new Object[2];
        directorio = cdirectorio.llenar();
        raiz = new DefaultMutableTreeNode("Directorios Cliente");
        for (int i = 0; i < directorio.size(); i++) {
            DefaultMutableTreeNode directorios = new DefaultMutableTreeNode();
            directorios.setUserObject(directorio.get(i));
            busacarsubcarpetas(directorio.get(i), directorio, directorios);
            if (directorio.get(i).getNodo_level() == 1) {
                raiz.add(directorios);
            }
        }
        modelo = new DefaultTreeModel(raiz);
        vdirectorio.arbol.setModel(modelo);
    }

    public void busacarsubcarpetas(Directorio y, ArrayList<Directorio> d, DefaultMutableTreeNode directorios) {
        for (int j = 0; j < d.size(); j++) {
            if (y.getIddirectorios() == d.get(j).getDirectorios_iddirectorios()) {
                DefaultMutableTreeNode subdirectorios = new DefaultMutableTreeNode();
                subdirectorios.setUserObject(d.get(j));
                directorios.add(subdirectorios);
                busacarsubcarpetas(d.get(j), d, subdirectorios);
            }
        }

    }
}
