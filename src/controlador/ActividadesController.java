/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Actividad;
import Consultas.Consultas_Configuraciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Actividad;
import modelo.Usuario;
import org.json.simple.parser.ParseException;
import vistas.Actividades;
import vistas.AgregarActividad;
import vistas.Principal;

/**
 *
 * @author programacion01
 */
public class ActividadesController implements ActionListener {

    private final Actividad macciones;
    private final Actividades vacciones;
    private final Usuario user;

    DefaultTableModel model = new DefaultTableModel();
    Consultas_Actividad cactividad = new Consultas_Actividad();
    ArrayList<Actividad> listactividad;
    Principal principal = new Principal();
    public ActividadesController(Actividad macciones, Actividades vacciones, Usuario user) {
        this.macciones = macciones;
        this.vacciones = vacciones;
        this.user = user;
        this.vacciones.btnagregar.addActionListener(this);
    }

    public void iniciar() throws IOException, ParseException {
        vacciones.setTitle("Actividades de Termianales");
        vacciones.setLocationRelativeTo(null);
        model.addColumn("Id");
        model.addColumn("Fecha");
        model.addColumn("Codigo");
        model.addColumn("Empresa");
        model.addColumn("Reporto");
        model.addColumn("Informe");
        model.addColumn("Del");
        model.addColumn("Add");
        model.addColumn("Swp");
        model.addColumn("Mac Ingresa");
        model.addColumn("Mac Salida");
        vacciones.tablaactividades.setModel(model);
        vacciones.tablaactividades.getColumn("Del").setWidth(40);
        vacciones.tablaactividades.getColumn("Del").setMinWidth(40);
        vacciones.tablaactividades.getColumn("Del").setMaxWidth(40);
        vacciones.tablaactividades.getColumn("Add").setWidth(40);
        vacciones.tablaactividades.getColumn("Add").setMinWidth(40);
        vacciones.tablaactividades.getColumn("Add").setMaxWidth(40);
        vacciones.tablaactividades.getColumn("Swp").setWidth(40);
        vacciones.tablaactividades.getColumn("Swp").setMinWidth(40);
        vacciones.tablaactividades.getColumn("Swp").setMaxWidth(40);
        vacciones.tablaactividades.getColumn("Codigo").setWidth(50);
        vacciones.tablaactividades.getColumn("Codigo").setMinWidth(50);
        vacciones.tablaactividades.getColumn("Codigo").setMaxWidth(50);
        vacciones.tablaactividades.getColumn("Id").setWidth(0);
        vacciones.tablaactividades.getColumn("Id").setMinWidth(0);
        vacciones.tablaactividades.getColumn("Id").setMaxWidth(0);
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vacciones.tablaactividades.getColumnCount(); i++) {
            vacciones.tablaactividades.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }
        llenartable();
        keyevent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vacciones.btnagregar) {
            AgregarActividad agactividad = new AgregarActividad(principal, true);
            AgregarActividadesController cag = new AgregarActividadesController(macciones, agactividad, user);
            try {
                cag.iniciar();
            } catch (IOException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
            agactividad.setVisible(true);
        }
    }
    public void keyevent() {
        vacciones.txtbuscaractividad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                busqueda();
            }
        });
    }
    
    private void llenartable(){
         listactividad = cactividad.llenar();
        int cantidad = listactividad.size();
        Object[] dato = new Object[11];
        for (int i = 0; i < cantidad; i++) {
            dato[0] = listactividad.get(i).getIdactividades();
            dato[1] = listactividad.get(i).getFecha();
            dato[2] = listactividad.get(i).getCodigo();
            dato[3] = listactividad.get(i).getEmpresa();
            dato[4] = listactividad.get(i).getReporto();
            dato[5] = listactividad.get(i).getInforme();
            dato[6] = listactividad.get(i).getDel();
            dato[7] = listactividad.get(i).getAdd();
            dato[8] = listactividad.get(i).getSwp();
            dato[9] = listactividad.get(i).getMacin();
            dato[10] = listactividad.get(i).getMacout();
            model.addRow(dato);
            vacciones.tablaactividades.setModel(model);
        }
    }

    public void busqueda() {
        if (vacciones.txtbuscaractividad.getText().length() == 0) {
           limpiartabla();
           llenartable();            
        }
        if (vacciones.txtbuscaractividad.getText().length() > 0) {
            limpiartabla();
           ArrayList<Actividad> listactividad = null;
            listactividad = cactividad.buscarcaracter(vacciones.txtbuscaractividad.getText());
            int cantidad = listactividad.size();
            Object[] dato = new Object[11];
            for (int i = 0; i < cantidad; i++) {
                dato[0] = listactividad.get(i).getIdactividades();
                dato[1] = listactividad.get(i).getFecha();
                dato[2] = listactividad.get(i).getCodigo();
                dato[3] = listactividad.get(i).getEmpresa();
                dato[4] = listactividad.get(i).getReporto();
                dato[5] = listactividad.get(i).getInforme();
                dato[6] = listactividad.get(i).getDel();
                dato[7] = listactividad.get(i).getAdd();
                dato[8] = listactividad.get(i).getSwp();
                dato[9] = listactividad.get(i).getMacin();
                dato[10] = listactividad.get(i).getMacout();
                model.addRow(dato);
                vacciones.tablaactividades.setModel(model);
            }
        }
    }

    public void limpiartabla() {
        if (vacciones.tablaactividades.getRowCount() >= 0) {
            int count = vacciones.tablaactividades.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }
}
