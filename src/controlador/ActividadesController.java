/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Actividad;
import Organizador.TablaColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabableView;
import modelo.Actividad;
import modelo.Usuario;
import org.json.simple.parser.ParseException;
import vistas.Actividades;
import vistas.AgregarActividad;
import vistas.EditarActividad;
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
    TablaColor tablacolor = new TablaColor();

    public ActividadesController(Actividad macciones, Actividades vacciones, Usuario user) {
        this.macciones = macciones;
        this.vacciones = vacciones;
        this.user = user;
        this.vacciones.btnagregar.addActionListener(this);
        this.vacciones.btnactualizar.addActionListener(this);
        this.vacciones.hecho.addActionListener(this);
        this.vacciones.editar.addActionListener(this);
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
        model.addColumn("hecho");
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
        vacciones.tablaactividades.setDefaultRenderer(vacciones.tablaactividades.getColumnClass(0), tablacolor);
        llenartable();
        keyevent();
        MouseClicked();
//        
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

        if (e.getSource() == vacciones.btnactualizar) {

            try {
                cactividad.jsonactividades();
            } catch (IOException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiartabla();
            llenartable();
        }
        if (e.getSource() == vacciones.hecho) {
            int selecionar = vacciones.tablaactividades.getSelectedRow();
            if (selecionar != -1) {
                macciones.setIdactividades(Integer.parseInt(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 0))));
                macciones.setHecho("1");
                try {
                    cactividad.actualizarestado(macciones);
                } catch (IOException ex) {
                    Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                limpiartabla();
                llenartable();
            }
        }

        if (e.getSource() == vacciones.editar) {
            int selecionar = vacciones.tablaactividades.getSelectedRow();
            if (selecionar != -1) {
                EditarActividad eactividad = new EditarActividad(principal, true);
                macciones.setIdactividades(Integer.parseInt(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 0))));
                macciones.setFecha(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 1)));
                macciones.setCodigo(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 2)));
                macciones.setEmpresa(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 3)));
                macciones.setReporto(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 4)));
                macciones.setInforme(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 5)));
                macciones.setDel(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 6)));
                macciones.setAgregar(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 7)));
                macciones.setSwp(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 8)));
                macciones.setMacin(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 9)));
                macciones.setMacout(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 10)));                
                EditarActividadController cag = new EditarActividadController(macciones, eactividad, user);
                try {
                    cag.iniciar();
                } catch (IOException ex) {
                    Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                eactividad.setVisible(true);
            }
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

    private void llenartable() {
        listactividad = cactividad.llenar();
        int cantidad = listactividad.size();
        Object[] dato = new Object[12];
        for (int i = 0; i < cantidad; i++) {
            dato[0] = listactividad.get(i).getIdactividades();
            dato[1] = listactividad.get(i).getFecha();
            dato[2] = listactividad.get(i).getCodigo();
            dato[3] = listactividad.get(i).getEmpresa();
            dato[4] = listactividad.get(i).getReporto();
            dato[5] = listactividad.get(i).getInforme();
            dato[6] = listactividad.get(i).getDel();
            dato[7] = listactividad.get(i).getAgregar();
            dato[8] = listactividad.get(i).getSwp();
            dato[9] = listactividad.get(i).getMacin();
            dato[10] = listactividad.get(i).getMacout();
            dato[11] = listactividad.get(i).getHecho();

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
            Object[] dato = new Object[12];
            for (int i = 0; i < cantidad; i++) {
                dato[0] = listactividad.get(i).getIdactividades();
                dato[1] = listactividad.get(i).getFecha();
                dato[2] = listactividad.get(i).getCodigo();
                dato[3] = listactividad.get(i).getEmpresa();
                dato[4] = listactividad.get(i).getReporto();
                dato[5] = listactividad.get(i).getInforme();
                dato[6] = listactividad.get(i).getDel();
                dato[7] = listactividad.get(i).getAgregar();
                dato[8] = listactividad.get(i).getSwp();
                dato[9] = listactividad.get(i).getMacin();
                dato[10] = listactividad.get(i).getMacout();
                dato[11] = listactividad.get(i).getHecho();
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
                if (vacciones.tablaactividades.getSelectedRows().length > 0) {
                    vacciones.tablaactividades.setComponentPopupMenu(vacciones.popup);
                }
                // MouseEvent.BUTTON3 es el boton derecho
            }
        };
        vacciones.tablaactividades.addMouseListener(mouseListener);
    }
}
