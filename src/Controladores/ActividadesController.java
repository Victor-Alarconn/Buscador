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
import javax.swing.table.DefaultTableModel;
import Modelos.Actividad;
import Modelos.Usuario;
import org.json.simple.parser.ParseException;
import Vistas.Actividades;
import Vistas.EditarActividad;
import Vistas.Principal;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        this.vacciones.generarpdf.addActionListener(this);
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
        modeloOrdenado = new TableRowSorter<>(model);
        vacciones.tablaactividades.setRowSorter(modeloOrdenado);
//        modeloOrdenado.setRowFilter(RowFilter.regexFilter("2", 1));
        vacciones.tablaactividades.setDefaultRenderer(vacciones.tablaactividades.getColumnClass(0), tablacolor);
        llenartableinit();
        keyevent();
        MouseClicked();
        vacciones.txttodo.setSelected(true);

//        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vacciones.generarpdf) {
            GenerarPDF();
        }

        if (e.getSource() == vacciones.btnactualizar) {

            try {
                cactividad.jsonactividades();
            } catch (IOException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiartabla();
            try {
                busqueda();
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vacciones.txttodo) {
            limpiartabla();
            try {
                 busqueda();
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vacciones.txthecho) {
            limpiartabla();
            try {
                 busqueda();
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vacciones.txtsinhacer) {
            limpiartabla();
            try {
                 busqueda();
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
                     busqueda();
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
        vacciones.buscaractividad2.addKeyListener(new KeyAdapter() {
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
        vacciones.buscaractividad.setText("");
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
        if (vacciones.buscaractividad.getText().length() > 0 || vacciones.buscaractividad2.getText().length() > 00) {
            limpiartabla();
            String filtro = "8";
            if (vacciones.txthecho.isSelected()) {
                filtro = "1";
            } else {
                if (vacciones.txtsinhacer.isSelected()) {
                    filtro = "0";
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechade = (sdf.format(vacciones.fechade.getDate()));
            String fechahasta = (sdf.format(vacciones.fechahasta.getDate()));
            listactividad = cactividad.buscarcaracter(vacciones.buscaractividad.getText(),vacciones.buscaractividad2.getText(), filtro, fechade, fechahasta);
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

    private void GenerarPDF() {
        try {
            int del = 0;
            int add = 0;
            int swp = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechade = (sdf.format(vacciones.fechade.getDate()));
            String fechahasta = (sdf.format(vacciones.fechahasta.getDate()));

            Document documento = new Document(PageSize.A4.rotate(), 10f, 10f, 10f, 0f);
            //documento.setPageSize(PageSize.A4.rotate());
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/"+listactividad.get(0).getEmpresa()+".pdf"));
            documento.open();
            Paragraph titulo = new Paragraph("Actividad Terminales\n",
                    FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLACK)
            );
            Paragraph subtitulo = new Paragraph(listactividad.get(0).getEmpresa() + "\n\n",
                    FontFactory.getFont("arial", 16, Font.BOLD, BaseColor.BLACK)
            );
            Paragraph fechas = new Paragraph("Informe del: " + fechade + " hasta: " + fechahasta + " \n\n",
                    FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK)
            );
            //centrar el texto
            titulo.setAlignment(Element.ALIGN_CENTER);
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            fechas.setAlignment(Element.ALIGN_CENTER);
            //agregar  el texto al pdf
            documento.add(titulo);
            documento.add(subtitulo);
            documento.add(fechas);

            //crear tabla de pdf 
            PdfPTable tabla = new PdfPTable(7);
//            tabla.setWidthPercentage(100f);

            tabla.addCell("Fecha");
            tabla.addCell("Reporto");
            tabla.addCell("Informo");
            tabla.addCell("Proceso");
            tabla.addCell("Mac Ingresa");
            tabla.addCell("Mac Salida");
            tabla.addCell("Concepto");

            int cantidad = listactividad.size();
            String proceso = null;
            for (int i = 0; i < cantidad; i++) {
                PdfPCell cell1 = new PdfPCell();
//                    cell1.setBorder(Rectangle.NO_BORDER);
//                    cell1.setPadding(4.0f);
                Paragraph t = new Paragraph(listactividad.get(i).getFecha(),
                        FontFactory.getFont("arial", 10, BaseColor.BLACK));
                cell1.addElement(t);
                t.setAlignment(Element.ALIGN_CENTER);

                PdfPCell cell2 = new PdfPCell();
                Paragraph t2 = new Paragraph(listactividad.get(i).getReporto(),
                        FontFactory.getFont("arial", 10, BaseColor.BLACK));
                cell2.addElement(t2);
                t2.setAlignment(Element.ALIGN_CENTER);

                PdfPCell cell3 = new PdfPCell();
                Paragraph t3 = new Paragraph(listactividad.get(i).getInforme(),
                        FontFactory.getFont("arial", 10, BaseColor.BLACK));
                cell3.addElement(t3);
                t3.setAlignment(Element.ALIGN_CENTER);
                if (listactividad.get(i).getDel().toLowerCase().equals("x")) {
                    proceso = "Del";
                    del++;
                } else {
                    if (listactividad.get(i).getAgregar().toLowerCase().equals("x")) {
                        proceso = "Add";
                        add++;
                    } else {
                        if (listactividad.get(i).getSwp().toLowerCase().equals("x")) {
                            proceso = "Swp";
                            swp++;
                        }
                    }
                }
                PdfPCell cell4 = new PdfPCell();
                Paragraph t4 = new Paragraph(proceso,
                        FontFactory.getFont("arial", 10, BaseColor.BLACK));
                t4.setAlignment(Element.ALIGN_CENTER);
                cell4.addElement(t4);

                PdfPCell cell5 = new PdfPCell();
                Paragraph t5 = new Paragraph(listactividad.get(i).getMacin(),
                        FontFactory.getFont("arial", 10, BaseColor.BLACK));
                t5.setAlignment(Element.ALIGN_CENTER);
                cell5.addElement(t5);

                PdfPCell cell6 = new PdfPCell();
                Paragraph t6 = new Paragraph(listactividad.get(i).getMacout(),
                        FontFactory.getFont("arial", 10, BaseColor.BLACK));
                cell6.addElement(t6);
                t6.setAlignment(Element.ALIGN_CENTER);

                PdfPCell cell7 = new PdfPCell();
                Paragraph t7 = new Paragraph(listactividad.get(i).getConcepto(),
                        FontFactory.getFont("arial", 10, BaseColor.BLACK));
                cell7.addElement(t7);

                tabla.addCell(cell1);
                tabla.addCell(cell2);
                tabla.addCell(cell3);
                tabla.addCell(cell4);
                tabla.addCell(cell5);
                tabla.addCell(cell6);
                tabla.addCell(cell7);
            }
            Paragraph cant = new Paragraph("Agregadas: " + add +" Borradas: " + del +  " Cambiadas: " + swp + " \n\n",
                    FontFactory.getFont("arial", 8, BaseColor.BLACK)
            );
            cant.setAlignment(Element.ALIGN_CENTER);
            documento.add(cant);
            float[] medidaCeldas = {0.25f, 0.25f, 0.25f, 0.25f, 0.30f, 0.30f, 0.70f};
            tabla.setWidths(medidaCeldas);
            documento.add(tabla);
            documento.close();
            abrirarchivo(ruta + "/Desktop/"+listactividad.get(0).getEmpresa()+".pdf");
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ActividadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
//            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
