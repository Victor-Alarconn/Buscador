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
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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

    public ConfiguracionesController(Configuracion mconfiguraciones,
            Consultas_Configuraciones cconfiguraciones,
            Configuraciones vconfiguraciones, Usuario user) {
        this.mconfiguraciones = mconfiguraciones;
        this.cconfiguraciones = cconfiguraciones;
        this.vconfiguraciones = vconfiguraciones;
        this.user = user;
        this.vconfiguraciones.guardarconfiguracion.addActionListener(this);
        this.vconfiguraciones.btnbuscar.addActionListener(this);
    }

    public void iniciar() {
        vconfiguraciones.setTitle("Configuraciones");
        modell.addColumn("ID");
        modell.addColumn("Ruta");
        modell.addColumn("Modulo");
        vconfiguraciones.tablarutas.setModel(modell);
        vconfiguraciones.setLocationRelativeTo(null);
        this.config();
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // boton para guardar configuraciones 
        if (e.getSource() == vconfiguraciones.guardarconfiguracion) {
            Modulo modulo = (Modulo) vconfiguraciones.txtmodulo.getModel().getSelectedItem();
            mconfiguraciones.setModulos_idmodulos(modulo.getIdmodulo());
            mconfiguraciones.setDirectorio(vconfiguraciones.txtdirectorio.getText());
            mconfiguraciones.setUsuarios_idusuario(user.getIdusuario());
            if (cconfiguraciones.registrar(mconfiguraciones)) {
                JOptionPane.showMessageDialog(vconfiguraciones, "registro guardado");
                if (!vconfiguraciones.usuariodefecto.isSelected()) {
                    u.setEstado(1);
                    u.setNombre("admin");
                    cu.modificar(u);
                } else {
                    u.setEstado(0);
                    u.setNombre("admin");
                    cu.modificar(u);
                }
                this.config();
            } else {
                JOptionPane.showMessageDialog(vconfiguraciones, "error al guardar");
            }
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
        
        ArrayList<Configuracion> configuracion;
        configuracion=cconfiguraciones.cargar();
        Object[] dato = new Object[3];
        for (int i = 0; i < configuracion.size(); i++) {
            dato[0] = configuracion.get(i).getIdconfiguracion();
            dato[1] = configuracion.get(i).getDirectorio();
            dato[2] = configuracion.get(i).getModulo();
            modell.addRow(dato);
            vconfiguraciones.tablarutas.setModel(modell);
        }

    }
    
   
     
    
}
