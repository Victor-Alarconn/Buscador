/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Cliente;
import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Mac;
import Organizador.Recursos;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Configuracion;
import modelo.Mac;
import modelo.Usuario;
import vistas.Backups;

/**
 *
 * @author Yonathan Carvajal
 */
public class BackupController implements ActionListener {

    private final Consultas_Cliente ccliente;
    private final Cliente mcliente;
    private final Backups vbackups;
    private final Usuario user;

    DefaultTableModel model = new DefaultTableModel();
    Recursos dialogo = new Recursos();

    ArrayList<Configuracion> mconfig;
    Consultas_Configuraciones cconfiguraciones = new Consultas_Configuraciones();
    private String directorio = null;
    private boolean cliente;

    Consultas_Mac cmac = new Consultas_Mac();
    Mac mmac = new Mac();

    public BackupController(Consultas_Cliente ccliente, Cliente mcliente, Backups vbackups, Usuario user) {
        this.ccliente = ccliente;
        this.mcliente = mcliente;
        this.vbackups = vbackups;
        this.user = user;
        this.vbackups.btnbuscar.addActionListener(this);
        this.vbackups.abrirdirectorio.addActionListener(this);
    }

    public void iniciar() {
        vbackups.setTitle("Backup's");
        vbackups.setLocationRelativeTo(null);
        model.addColumn("Backup");
        vbackups.tablabackups.setModel(model);
        mmac.setMacs(mmac.conseguirMAC());
        mconfig = cconfiguraciones.cargar(mmac.conseguirMAC());
        for (int i = 0; i < mconfig.size(); i++) {
            if (mconfig.get(i).getModulo().toLowerCase().equals("backups")) {
                directorio = mconfig.get(i).getDirectorio();
            }
        }

        keyevent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vbackups.btnbuscar) {
            buscar();
        }

        if (e.getSource() == vbackups.abrirdirectorio) {
            if (cliente) {
                abrirarchivo(directorio + mcliente.getBackupruta());
            }
        }

    }

    public void backupsalmacenados(String dir) {
        File[] files = new File(dir).listFiles();
        if (files != null) {
            for (File elemento : files) {
                if (elemento.isDirectory()) {
                    //System.out.println(elemento.getName() + " es un directorio " + elemento.getPath());
                    Object[] dato = new Object[]{elemento.getName(), elemento.getPath()};
                    model.addRow(dato);
                    vbackups.tablabackups.setModel(model);
                } else {
                    if (elemento.isFile()) {
                        //System.out.println(elemento.getName() + " es un archivo " + elemento.getPath());
                        Object[] dato = new Object[]{elemento.getName(), elemento.getPath()};
                        model.addRow(dato);
                        vbackups.tablabackups.setModel(model);
                    }
                }
            }
        }

    }

    public File Crear_archivo(String path, String nombre) {
        File file = new File(path, nombre);
        return file;
    }

    // funcion para abrir un archivo desde la tabla 
    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
//            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void keyevent() {
        this.vbackups.txtcodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buscar();
                }
            }
        });
    }

    public void buscar() {
        mcliente.setCodigo(vbackups.txtcodigo.getText().toUpperCase());
        if (ccliente.buscarcoodigocliente(mcliente)) {
//            System.out.println(mcliente.getBackupruta());
            vbackups.txtnombre.setText(mcliente.getNombre());
            if (mcliente.getBackupruta() == null || mcliente.getBackupruta().equals("")) {
                int respuesta = dialogo.j();
                if (respuesta == 0) {
                    String nombre = vbackups.txtnombre.getText().toUpperCase();
                    File file = Crear_archivo(directorio, mcliente.getCodigo() + "_" + nombre);
                    file.mkdir();
                    String ruta = File.separator + mcliente.getCodigo() + "_" + nombre;
                    mcliente.setIdclientes_potenciales(mcliente.getIdclientes_potenciales());
                    mcliente.setBackupruta(ruta);
                    try {
                        ccliente.modificarruta(mcliente);
                    } catch (IOException ex) {
                        Logger.getLogger(BackupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    abrirarchivo(directorio + ruta);
                    limpiarcampos();
                }
            } else {
                limpiartabla();
                cliente = true;
                backupsalmacenados(directorio + mcliente.getBackupruta());
            }
        } else {
            JOptionPane.showMessageDialog(vbackups, "el Cliente no se encuentra en la base de datos");
        }

    }

    public void limpiarcampos() {
        vbackups.txtcodigo.setText("");
        vbackups.txtnombre.setText("");
    }

    public void limpiartabla() {
        if (vbackups.tablabackups.getRowCount() >= 0) {
            int count = vbackups.tablabackups.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }

}
