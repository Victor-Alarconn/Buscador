/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.*;
import Organizador.Recursos;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Modelos.*;
import Vistas.Editarcliente;

/**
 *
 * @author yonathan
 */
public class EditarClienteController implements ActionListener {

    //modelo
    private final Cliente modelo;
    private final Servicio mods;
    private final Servicios_has_Clientes_Potenciales shcp;
    private final Documentos mdocumento;
    private final Configuracion mconfiguracion;

    //consultas
    private final Consultas_Servicios cons;
    private final Consultas_Cliente consultas;
    private final Consultas_Servicios_has_Clientes_Potenciales cshcp;
    private final Consultas_Procesos_Electronicos consp;
    private final Consultas_Documentos cdocumentos;
    private final Consultas_Configuraciones cconfiguraciones;
    private final Consultas_Clase cc;
    private final Consultas_Llego cl;

    private final Editarcliente formulario;
    private String directorio = null;
    private String prefijo = null;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel modeltablaproceso = new DefaultTableModel();


    ArrayList<Servicio> lista;
    ArrayList<Servicio> servicio;
    ArrayList<Proceso_Electronico> arrayprocesos;
    ArrayList<Proceso_Electronico> listaprocesos;
    Consultas_Llego cllego = new Consultas_Llego();
    Consultas_Modalidad mmodalidad = new Consultas_Modalidad();
    Consultas_Servicios modc = new Consultas_Servicios();
    Consultas_Clase mod = new Consultas_Clase();
    ArrayList<Modalidad> modulo4;
    ArrayList<Llego> modulo;
    ArrayList<Clases> modulo1;

    Consultas_Mac cmac = new Consultas_Mac();
    Mac mmac = new Mac();
    ArrayList<Configuracion> mconfig;

    Recursos dialogo = new Recursos();

    public EditarClienteController(Cliente modelo, Servicio mods,
            Servicios_has_Clientes_Potenciales shcp, Documentos mdocumento, Configuracion mconfiguracion,
            Consultas_Servicios cons, Consultas_Cliente consultas,
            Consultas_Servicios_has_Clientes_Potenciales cshcp, Consultas_Documentos cdocumentos,
            Consultas_Configuraciones cconfiguraciones, Consultas_Clase cc, Consultas_Llego cl,
            Editarcliente formulario,Consultas_Procesos_Electronicos consp) {
        this.modelo = modelo;
        this.mods = mods;
        this.shcp = shcp;
        this.mdocumento = mdocumento;
        this.mconfiguracion = mconfiguracion;
        this.cons = cons;
         this.consp = consp;
        this.consultas = consultas;
        this.cshcp = cshcp;
        this.cdocumentos = cdocumentos;
        this.cconfiguraciones = cconfiguraciones;
        this.cc = cc;
        this.cl = cl;
        this.formulario = formulario;
        this.formulario.guardarformulario1.addActionListener(this);
        this.formulario.agregarservicio1.addActionListener(this);
        this.formulario.eliminarservicio1.addActionListener(this);
        this.formulario.agregardocumento1.addActionListener(this);
        this.formulario.eliminardocumento1.addActionListener(this);
//        this.formulario.clientepotencial.addActionListener(this);
    }

    public void iniciar() throws IOException, org.json.simple.parser.ParseException {
        formulario.setTitle("Editar Cliente Potencial");
        formulario.setLocationRelativeTo(null);
        model.addColumn("Servicio/Producto");
        model.addColumn("ID");
        formulario.tablaservicios1.setModel(model);
        model1.addColumn("ID");
        model1.addColumn("Documento");
        model1.addColumn("Fecha de inicial");
        model1.addColumn("Fecha de vencimiento");
        formulario.tabladocumentos1.setModel(model1);
        formulario.tabladocumentos1.getColumn("ID").setWidth(0);
        formulario.tabladocumentos1.getColumn("ID").setMinWidth(0);
        formulario.tabladocumentos1.getColumn("ID").setMaxWidth(0);
        formulario.tablaservicios1.getColumn("ID").setWidth(0);
        formulario.tablaservicios1.getColumn("ID").setMinWidth(0);
        formulario.tablaservicios1.getColumn("ID").setMaxWidth(0);
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        modeltablaproceso.addColumn("Proceso");
        formulario.tablaprocesos.setModel(modeltablaproceso);
        formulario.tablaservicios1.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        formulario.tabladocumentos1.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        formulario.tabladocumentos1.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        formulario.tabladocumentos1.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        formulario.txtclase1.removeAllItems();
        modulo1 = mod.llenar();
        for (int i = 0; i < modulo1.size(); i++) {
            formulario.txtclase1.addItem(modulo1.get(i));
        }
        formulario.txtmodalidad1.removeAllItems();
        modulo4 = mmodalidad.llenar();
        for (int i = 0; i < modulo4.size(); i++) {
            formulario.txtmodalidad1.addItem(modulo4.get(i));
        }
        modulo = cllego.llenar();
        formulario.txtllego1.removeAllItems();
        for (int i = 0; i < modulo.size(); i++) {
            formulario.txtllego1.addItem(modulo.get(i));
        }
        formulario.txtprocesos.removeAllItems();
        listaprocesos = consp.llenar();
        for (int i = 0; i < listaprocesos.size(); i++) {
            formulario.txtprocesos.addItem(listaprocesos.get(i));
        }       
        
        formulario.txtservicio1.removeAllItems();
        lista = modc.llenar();
        for (int i = 0; i < lista.size(); i++) {
            formulario.txtservicio1.addItem(lista.get(i));
        }
        mconfig = cconfiguraciones.cargar();
        for (int i = 0; i < mconfig.size(); i++) {
            if (mconfig.get(i).getModulo().toLowerCase().equals("clientes")) {
                directorio = mconfig.get(i).getDirectorio();
                break;
            }
        }
        inicializarcliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formulario.guardarformulario1) {
            modelo.setNit(formulario.txtnit1.getText());
            modelo.setNombre(formulario.txtnombre1.getText());
            modelo.setEmpresa(formulario.txtempresa1.getText());
            modelo.setCelular1(formulario.txtcelular11.getText());
            modelo.setNombre_referido(formulario.txtnombrereferido.getText());
            modelo.setEmail(formulario.txtemail1.getText());
            modelo.setClase(formulario.txtclase1.getSelectedItem().toString());
            modelo.setLlego(formulario.txtllego1.getSelectedItem().toString());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            modelo.setFecha_llegada(sdf.format(formulario.txtfecha_llegada1.getDate()));
            modelo.setModalidad(formulario.txtmodalidad1.getSelectedItem().toString());
            modelo.setNotas(formulario.txtnotas1.getText());
            modelo.setDv(formulario.txtdv1.getText());
            if (formulario.txtfecha_arriendo1.getDate() != null) {
                modelo.setFecha_arriendo(sdf.format(formulario.txtfecha_arriendo1.getDate()));
            }
            modelo.setVlrprincipal(Integer.parseInt(formulario.txtvlrprincipal1.getText()));
            modelo.setNumequipos(Integer.parseInt(formulario.txtnumequipos1.getText()));
            modelo.setVlrterminal(Integer.parseInt(formulario.txtvlrterminal1.getText()));
            modelo.setValor_total(formulario.txtvalor_total1.getText());
//            if (!formulario.clientepotencial.isSelected()) {
//                modelo.setCodigo(formulario.txtcodigo1.getText());
//                modelo.setRuta(File.separator + formulario.txtcodigo1.getText().toUpperCase() + "_" + formulario.txtnombre1.getText().toUpperCase().trim());
//            }
//            if (formulario.clientepotencial.isSelected()) {
//                modelo.setCliente_potencial(1);
//            } else {
//                modelo.setCliente_potencial(0);
//            }
//            if (formulario.electronica.isSelected()) {
//                modelo.setElectronica(1);
//            } else {
//                modelo.setElectronica(0);
//            }
            if (formulario.sucursal.isSelected()) {
                modelo.setSucursal(1);
            } else {
                modelo.setSucursal(0);
            }
            //condicionales de selecion  de categoria 
            if (formulario.bequipos1.isSelected()) {
                modelo.setCategoria("Equipos");
            }
            if (formulario.bredes1.isSelected()) {
                modelo.setCategoria("Redes");
            }
            if (formulario.bsoftware1.isSelected()) {
                modelo.setCategoria("Software");
            }
            if (formulario.botro1.isSelected()) {
                modelo.setCategoria("Otro");
            }
            try {
                if (consultas.modificar(modelo)) {
                    for (int i = 0; i < formulario.tablaservicios1.getRowCount(); i++) {
                        shcp.setServicios_idservicio(Integer.parseInt(formulario.tablaservicios1.getValueAt(i, 1).toString()));
                        shcp.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
                        if (!cshcp.buscar(shcp)) {
                            if (!cshcp.registrarservicio(shcp)) {
                                JOptionPane.showMessageDialog(null, "error guardado de servicios");
                            }
                        }
                    }
                    //guardando la tabla documnetos
                    for (int i = 0; i < formulario.tabladocumentos1.getRowCount(); i++) {
//                    System.out.println(formulario.tabladocumentos1.getValueAt(i, 0));
                        if (formulario.tabladocumentos1.getValueAt(i, 0) == null) {
                            mdocumento.setDocumento(formulario.tabladocumentos1.getValueAt(i, 1).toString());
                            mdocumento.setFecha_inicio(formulario.tabladocumentos1.getValueAt(i, 2).toString());
                            mdocumento.setFecha_vencimiento(formulario.tabladocumentos1.getValueAt(i, 3).toString());
                            mdocumento.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
                            if (!cdocumentos.registrar(mdocumento)) {
                                JOptionPane.showMessageDialog(null, "error guardado de documento");
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Cliente modificado");
//                    if (!formulario.clientepotencial.isSelected()) {
//                        crear_carpeta(directorio);
//                    }
                    formulario.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "error guardado el cliente");
                }
            } catch (IOException ex) {
                Logger.getLogger(EditarClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //boton agregar servicio
        Object[] dato = new Object[2];
        if (e.getSource() == formulario.agregarservicio1) {
            Servicio servi = (Servicio) formulario.txtservicio1.getModel().getSelectedItem();
            dato[0] = servi.getServicio();
            dato[1] = servi.getIdservicio();
            model.addRow(dato);
            formulario.tablaservicios1.setModel(model);
        }
        //boton agregar documento
        Object[] tabladocumentos = new Object[5];
        if (e.getSource() == formulario.agregardocumento1) {
            tabladocumentos[1] = formulario.txtdocumento1.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            tabladocumentos[2] = sdf.format(formulario.fecha_inicio_docum1.getDate());
            tabladocumentos[3] = sdf.format(formulario.fecha_vencimineto_docum1.getDate());
            model1.addRow(tabladocumentos);
            formulario.tabladocumentos1.setModel(model1);
//            formulario.fecha_inicio_docum1.setCalendar(null);
//            formulario.fecha_vencimineto_docum1.setCalendar(null);
            formulario.txtdocumento1.setText("");
        }
        //boton eliminar servicio
        if (e.getSource() == formulario.eliminarservicio1) {
            int fila = formulario.tablaservicios1.getSelectedRow();
            shcp.setServicios_idservicio(Integer.parseInt(formulario.tablaservicios1.getValueAt(fila, 1).toString()));
            shcp.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
            if (fila >= 0) {
                if (cshcp.eliminar(shcp)) {
                    model.removeRow(fila);
                    JOptionPane.showMessageDialog(formulario, "servicio borrado");
                }
            } else {
                JOptionPane.showMessageDialog(formulario, "La tabla esta vacia o no sea seleccionado nada aun!");
            }

        }
//        if (e.getSource() == formulario.clientepotencial) {
//            if (!formulario.clientepotencial.isSelected()) {
//                formulario.txtcodigo1.setEnabled(true);
//            } else {
//                formulario.txtcodigo1.setEnabled(false);
//            }
//        }
        //boton eliminar documnento
        if (e.getSource() == formulario.eliminardocumento1) {
            int fila = formulario.tabladocumentos1.getSelectedRow();
            mdocumento.setIddocumentos(Integer.parseInt(formulario.tabladocumentos1.getValueAt(fila, 0).toString()));
            System.out.println(mdocumento.getIddocumentos());
            if (cdocumentos.eliminar(mdocumento)) {
                if (fila >= 0) {
                    model1.removeRow(fila);
                } else {
                    JOptionPane.showMessageDialog(formulario, "La tabla esta vacia o no sea seleccionado nada aun!");
                }
            }

        }

    }

    private void crear_carpeta(String path) {
        Consultas_Directorio cd = new Consultas_Directorio();
        ArrayList<Directorio> directorios;
        directorios = cd.llenar();
        String nombre = formulario.txtcodigo1.getText().toUpperCase() + "_" + formulario.txtnombre1.getText().toUpperCase().trim();
        if (nombre == null) {
        } else {
            File file = Crear_archivo(path, nombre);
            try {
                file.mkdir();
                for (int i = 0; i < directorios.size(); i++) {
                    File fil = Crear_archivo(file.toString(), directorios.get(i).toString());
                    if (directorios.get(i).getNodo_level() == 1) {
                        fil.mkdir();
                        busacarsubcarpetas(directorios.get(i), directorios, fil);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            abrirarchivo(directorio + File.separator + nombre);
        }
    }

    public void busacarsubcarpetas(Directorio y, ArrayList<Directorio> d, File fil) {
        for (int j = 0; j < d.size(); j++) {
            if (y.getIddirectorios() == d.get(j).getDirectorios_iddirectorios()) {
                File subfile = Crear_archivo(fil.toString(), d.get(j).toString());
                subfile.mkdir();
                busacarsubcarpetas(d.get(j), d, subfile);
            }
        }

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
// funcion para crear un archivo

    public File Crear_archivo(String path, String nombre) {
        File file = new File(path, nombre);
        return file;
    }

    public void limpiar() {
        formulario.txtnit1.setText("");
        formulario.txtnombre1.setText("");
        formulario.txtcelular11.setText("");
        formulario.txtnombrereferido.setText("");
        formulario.txtdv1.setText("");
        formulario.txtcodigo1.setText("");
        formulario.txtemail1.setText("");
        formulario.txtempresa1.setText("");
        formulario.txtdocumento1.setText("");
        formulario.txtnotas1.setText("");
        formulario.txtfecha_llegada1.setCalendar(null);
        formulario.buttonGroup1.clearSelection();
    }

    public void limpiarservicios() {
        if (formulario.tablaservicios1.getRowCount() >= 0) {
            int count = formulario.tablaservicios1.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }

    public void limpiardocumentos() {
        if (formulario.tabladocumentos1.getRowCount() >= 0) {
            int count = formulario.tabladocumentos1.getRowCount();
            for (int i = 0; i < count; i++) {
                model1.removeRow(0);
            }
        }
    }

    public void inicializarcliente() {
        formulario.tabladocumentos1.setModel(model1);

        //llena la tabla de servicios 
        servicio = consultas.llenar(modelo);
        Object[] datos = new Object[2];
        for (int i = 0; i < servicio.size(); i++) {
            datos[0] = servicio.get(i).getServicio();
            datos[1] = servicio.get(i).getIdservicio();
            model.addRow(datos);
            formulario.tablaservicios1.setModel(model);
        }
        
        //llena la tabla de procesos 
        arrayprocesos = consultas.llenarprocesos(modelo);
        Object[] procesos = new Object[3];
        for (int i = 0; i < arrayprocesos.size(); i++) {
            procesos[0] = arrayprocesos.get(i).getProceso();
            procesos[1] = arrayprocesos.get(i).getUsuarios_idusuarios();
            modeltablaproceso.addRow(procesos);
            formulario.tablaprocesos.setModel(modeltablaproceso);
        }

        ArrayList<Documentos> documentos;
        documentos = consultas.clientedocumentos(modelo);
        Object[] datos5 = new Object[4];
        for (int i = 0; i < documentos.size(); i++) {
            datos5[0] = documentos.get(i).getIddocumentos();
            datos5[1] = documentos.get(i).getDocumento();
            datos5[2] = documentos.get(i).getFecha_inicio();
            datos5[3] = documentos.get(i).getFecha_vencimiento();
            model1.addRow(datos5);
            formulario.tabladocumentos1.setModel(model1);
        }
//
        if (consultas.buscar(modelo)) {
            try {
                formulario.txtsoporte.setSelectedItem(modelo.getTsoporte());
                
                
                formulario.txtnit1.setText(modelo.getNit());
                formulario.txtnombre1.setText(modelo.getNombre());
                formulario.txtcelular11.setText(modelo.getCelular1());
                for (int i = 0; i < modulo.size(); i++) {
                    if (formulario.txtllego1.getModel().getElementAt(i).toString().equals(modelo.getLlego())) {
                        formulario.txtllego1.setSelectedIndex(i);
                        break;
                    }
                }

                formulario.txtvlrprincipal1.setText(String.valueOf(modelo.getVlrprincipal()));
                formulario.txtvlrnomina.setText(String.valueOf(modelo.getVlrnomina()));
                formulario.txtvlrecepcion.setText(String.valueOf(modelo.getVlrecepcion()));
                formulario.txtnumequipos1.setText(String.valueOf(modelo.getNumequipos()));
                formulario.txtvlrterminal1.setText(String.valueOf(modelo.getVlrterminal()));
                formulario.txtvalor_total1.setText(String.valueOf(modelo.getValor_total()));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date fechaDate = null;

                if (modelo.getFecha_llegada() != null && !modelo.getFecha_llegada().equals("")) {
                    fechaDate = sdf.parse(modelo.getFecha_llegada());
                    formulario.txtfecha_llegada1.setDate(fechaDate);
                }
                if (modelo.getFecha_arriendo() != null && !modelo.getFecha_arriendo().equals("")) {
                    fechaDate = sdf.parse(modelo.getFecha_arriendo());
                    formulario.txtfecha_arriendo1.setDate(fechaDate);
                }

                for (int i = 0; i < modulo4.size(); i++) {
                    if (formulario.txtmodalidad1.getModel().getElementAt(i).toString().equals(modelo.getModalidad())) {
                        formulario.txtmodalidad1.setSelectedIndex(i);
                        break;
                    }
                }
                formulario.txtnotas1.setText(modelo.getNotas());
                formulario.txtdv1.setText(modelo.getDv());
                formulario.txtcodigo1.setText(modelo.getCodigo());
                formulario.txtnombrereferido.setText(modelo.getNombre_referido());
                formulario.txtemail1.setText(modelo.getEmail());

                for (int i = 0; i < modulo1.size(); i++) {
                    if (formulario.txtclase1.getModel().getElementAt(i).toString().equals(modelo.getClase())) {
                        formulario.txtclase1.setSelectedIndex(i);
                        break;
                    }
                }
                formulario.txtempresa1.setText(modelo.getEmpresa());
                formulario.txtcontacto1.setText(modelo.getContacto());
//                if (modelo.getCliente_potencial() == 1) {
//                    formulario.clientepotencial.setSelected(true);
//                } else {
//                    formulario.clientepotencial.setSelected(false);
//                }
//                if (modelo.getElectronica() == 1) {
//                    formulario.electronica.setSelected(true);
//                } else {
//                    formulario.electronica.setSelected(false);
//                }
                if (modelo.getSucursal() == 1) {
                    formulario.sucursal.setSelected(true);
                } else {
                    formulario.sucursal.setSelected(false);
                }
                if (modelo.getCategoria() != null) {
                    if (modelo.getCategoria().equals("Equipos")) {
                        formulario.bequipos1.setSelected(true);
                    } else {
                        if (modelo.getCategoria().equals("Redes")) {
                            formulario.bredes1.setSelected(true);
                        } else {
                            if (modelo.getCategoria().equals("Software")) {
                                formulario.bsoftware1.setSelected(true);
                            } else {
                                if (modelo.getCategoria().equals("Otro")) {
                                    formulario.botro1.setSelected(true);
                                } else {

                                }

                            }
                        }
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(EditarClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
