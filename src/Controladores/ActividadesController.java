/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import Modelos.Actividad;
import Modelos.Usuario;
import org.json.simple.parser.ParseException;
import Vistas.Actividades;
import Vistas.AgregarActividad;
import Vistas.EditarActividad;
import Vistas.Principal;
import javax.swing.RowFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
    private TableRowSorter<TableModel> modeloOrdenado;

    public ActividadesController(Actividad macciones, Actividades vacciones, Usuario user) {
        this.macciones = macciones;
        this.vacciones = vacciones;
        this.user = user;
        this.vacciones.btnactualizar.addActionListener(this);
        this.vacciones.hecho.addActionListener(this);
        this.vacciones.editar.addActionListener(this);
        this.vacciones.txthecho.addActionListener(this);
        this.vacciones.txtsinhacer.addActionListener(this);
        this.vacciones.txttodo.addActionListener(this);
    }

    public void iniciar() throws IOException, ParseException, java.text.ParseException {
//      agregamos titulo a la vista
        vacciones.setTitle("Actividades de Termianales");
        vacciones.setLocationRelativeTo(null);
        model.addColumn("Id");
        model.addColumn("Fecha");
        model.addColumn("Hora");
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
        model.addColumn("Concepto");
        model.addColumn("Prioridad");
        model.addColumn("Quien informo");
        model.addColumn("Referencia");
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
        vacciones.tablaactividades.getColumn("hecho").setWidth(0);
        vacciones.tablaactividades.getColumn("hecho").setMinWidth(0);
        vacciones.tablaactividades.getColumn("hecho").setMaxWidth(0);
        vacciones.tablaactividades.getColumn("Hora").setWidth(70);
        vacciones.tablaactividades.getColumn("Hora").setMinWidth(70);
        vacciones.tablaactividades.getColumn("Hora").setMaxWidth(70);
        // Metemos el modelo ordenable en la tabla.
        modeloOrdenado = new TableRowSorter<TableModel>(model);
        vacciones.tablaactividades.setRowSorter(modeloOrdenado);
        modeloOrdenado.setRowFilter(RowFilter.regexFilter("2", 1));
        vacciones.tablaactividades.setDefaultRenderer(vacciones.tablaactividades.getColumnClass(0), tablacolor);
        llenartableinit();
        keyevent();
        MouseClicked();
        vacciones.txttodo.setSelected(true);

//        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vacciones.btnactualizar) {

            try {
                cactividad.jsonactividades();
            } catch (IOException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiartabla();
            try {
                llenartable();
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vacciones.txttodo) {
            limpiartabla();
            try {
                llenartable();
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vacciones.txthecho) {
            limpiartabla();
            try {
                llenartable();
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vacciones.txtsinhacer) {
            limpiartabla();
            try {
                llenartable();
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                try {
                    llenartable();
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (e.getSource() == vacciones.editar) {
            int selecionar = vacciones.tablaactividades.getSelectedRow();
            if (selecionar != -1) {
                EditarActividad eactividad = new EditarActividad(principal, true);
                macciones.setIdactividades(Integer.parseInt(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 0))));
                macciones.setFecha(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 1)));
                macciones.setHora(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 2)));
                macciones.setCodigo(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 3)));
                macciones.setEmpresa(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 4)));
                macciones.setReporto(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 5)));
                macciones.setInforme(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 6)));
                macciones.setDel(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 7)));
                macciones.setAgregar(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 8)));
                macciones.setSwp(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 9)));
                macciones.setMacin(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 10)));
                macciones.setMacout(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 11)));
                macciones.setConcepto(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 13)));
                macciones.setPrioridad(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 14)));
                macciones.setQinformo(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 15)));
                macciones.setReferencia(String.valueOf(vacciones.tablaactividades.getValueAt(selecionar, 16)));
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
        vacciones.buscaractividad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    busqueda();
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void llenartable() throws java.text.ParseException {
        String filtro = "8";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechade = (sdf.format(vacciones.fechade.getDate()));
        String fechahasta = (sdf.format(vacciones.fechahasta.getDate()));
        if (vacciones.txthecho.isSelected()) {
            filtro = "1";
        } else {
            if (vacciones.txtsinhacer.isSelected()) {
                filtro = "0";
            }
        }
        listactividad = cactividad.llenar(filtro, fechade, fechahasta);
        llenartabla(listactividad);
    }

    private void llenartableinit() throws java.text.ParseException {
        String filtro = "8";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechade = (dtf.format(LocalDateTime.now()));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, -7);
        Date fechaParseada = new SimpleDateFormat("dd-MM-yyyy").parse(fechade);
        vacciones.fechahasta.setDate(fechaParseada);
        vacciones.fechade.setDate(calendar.getTime());
        listactividad = cactividad.llenarinit(fechade);
        llenartabla(listactividad);
    }

    public void busqueda() throws java.text.ParseException {
        if (vacciones.buscaractividad.getText().length() == 0) {
            limpiartabla();
            llenartable();
        }
        if (vacciones.buscaractividad.getText().length() > 0) {
            limpiartabla();
            String filtro = "8";
            if (vacciones.txthecho.isSelected()) {
                filtro = "1";
            } else {
                if (vacciones.txtsinhacer.isSelected()) {
                    filtro = "0";
                }
            }
            ArrayList<Actividad> listactividad = null;
            listactividad = cactividad.buscarcaracter(vacciones.buscaractividad.getText(), filtro);
            llenartabla(listactividad);
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

    private void llenartabla(ArrayList<Actividad> listactividad) {
        int cantidad = listactividad.size();
        Object[] dato = new Object[17];
        for (int i = 0; i < cantidad; i++) {
            dato[0] = listactividad.get(i).getIdactividades();
            dato[1] = listactividad.get(i).getFecha();
            dato[2] = listactividad.get(i).getHora();
            dato[3] = listactividad.get(i).getCodigo();
            dato[4] = listactividad.get(i).getEmpresa();
            dato[5] = listactividad.get(i).getReporto();
            dato[6] = listactividad.get(i).getInforme();
            dato[7] = listactividad.get(i).getDel();
            dato[8] = listactividad.get(i).getAgregar();
            dato[9] = listactividad.get(i).getSwp();
            dato[10] = listactividad.get(i).getMacin();
            dato[11] = listactividad.get(i).getMacout();
            dato[12] = listactividad.get(i).getHecho();
            dato[13] = listactividad.get(i).getConcepto();
            dato[14] = listactividad.get(i).getPrioridad();
            dato[15] = listactividad.get(i).getQinformo();
            dato[16] = listactividad.get(i).getReferencia();
            model.addRow(dato);
            vacciones.tablaactividades.setModel(model);
        }
    }

}
