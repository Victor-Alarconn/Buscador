/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Clase;
import Consultas.Consultas_Cliente;
import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Directorio;
import Consultas.Consultas_Documentos;
import Consultas.Consultas_Llego;
import Consultas.Consultas_Modalidad;
import Consultas.Consultas_Servicios;
import Consultas.Consultas_Servicios_has_Clientes_Potenciales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import modelo.Cliente;
import modelo.Configuracion;
import modelo.Directorio;
import modelo.Documentos;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import vistas.Editarcliente;

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
    private final Consultas_Documentos cdocumentos;
    private final Consultas_Configuraciones cconfiguraciones;
    private final Consultas_Clase cc;
    private final Consultas_Llego cl;

    private final Editarcliente formulario;
    private String directorio = null;
    private String prefijo = null;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();

    ArrayList<Servicio> lista;
    ArrayList<Servicio> servicio;

    public EditarClienteController(Cliente modelo, Servicio mods,
            Servicios_has_Clientes_Potenciales shcp, Documentos mdocumento, Configuracion mconfiguracion,
            Consultas_Servicios cons, Consultas_Cliente consultas,
            Consultas_Servicios_has_Clientes_Potenciales cshcp, Consultas_Documentos cdocumentos,
            Consultas_Configuraciones cconfiguraciones, Consultas_Clase cc, Consultas_Llego cl,
            Editarcliente formulario) {
        this.modelo = modelo;
        this.mods = mods;
        this.shcp = shcp;
        this.mdocumento = mdocumento;
        this.mconfiguracion = mconfiguracion;
        this.cons = cons;
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
    }

    public void iniciar() {
        busqueda();
        formulario.setTitle("Editar Cliente Potencial");
        formulario.setLocationRelativeTo(null);
        model.addColumn("Servicio/Producto");
        formulario.tablaservicios1.setModel(model);
        model1.addColumn("ID");
        model1.addColumn("Documento");
        model1.addColumn("Fecha de inicial");
        model1.addColumn("Fecha de vencimiento");
        formulario.tabladocumentos1.setModel(model1);
        formulario.tabladocumentos1.getColumn("ID").setWidth(0);
        formulario.tabladocumentos1.getColumn("ID").setMinWidth(0);
        formulario.tabladocumentos1.getColumn("ID").setMaxWidth(0);
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        formulario.tablaservicios1.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        formulario.tabladocumentos1.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        formulario.tabladocumentos1.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        formulario.tabladocumentos1.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        inicializarcliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formulario.guardarformulario1) {
            modelo.setNit(formulario.txtnit1.getText());
            modelo.setNombre(formulario.txtnombre1.getText());
            modelo.setEmpresa(formulario.txtempresa1.getText());
            modelo.setCelular1(formulario.txtcelular11.getText());
            modelo.setCelular2(formulario.txtcelular21.getText());
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
//            modelo.setCodigo(formulario.txtcodigo1.getText());
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
            if (consultas.modificar(modelo)) {
                for (int i = 0; i < formulario.tablaservicios1.getRowCount(); i++) {

                    for (int j = 0; j < lista.size(); j++) {
                        if (lista.get(j).getServicio().equals(formulario.tablaservicios1.getValueAt(i, 0).toString())) {
                            shcp.setServicios_idservicio(lista.get(j).getIdservicio());
                            shcp.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
                            if (!cshcp.buscar(shcp)) {
                                if (!cshcp.registrarservicio(shcp)) {
                                    JOptionPane.showMessageDialog(null, "error guardado de servicios");
                                }
                            }
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
                formulario.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "error guardado el cliente");
            }
        }

        //boton agregar servicio
        Object[] dato = new Object[5];
        if (e.getSource() == formulario.agregarservicio1) {
            dato[0] = formulario.txtservicio1.getSelectedItem().toString();
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
            mods.setServicio(formulario.tablaservicios1.getValueAt(fila, 0).toString());
            if (cons.buscar(mods)) {
                shcp.setServicios_idservicio(mods.getIdservicio());
                shcp.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
                if (fila >= 0) {
                    if (cshcp.eliminar(shcp)) {
                        model.removeRow(fila);
                    }
                } else {
                    JOptionPane.showMessageDialog(formulario, "La tabla esta vacia o no sea seleccionado nada aun!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "error guardado");
            }

        }
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

    public void busqueda() {
        ArrayList<Directorio> directorio;
        Consultas_Directorio cd = new Consultas_Directorio();
        directorio = cd.llenar();
        Object[] dato = new Object[1];
        for (int i = 0; i < directorio.size(); i++) {
            dato[0] = directorio.get(i);
        }

    }

    public void limpiar() {
        formulario.txtnit1.setText("");
        formulario.txtnombre1.setText("");
        formulario.txtcelular11.setText("");
        formulario.txtcelular21.setText("");
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

        formulario.txtservicio1.removeAllItems();
        Consultas_Servicios modc = new Consultas_Servicios();
        lista = modc.llenar();
        for (int i = 0; i < lista.size(); i++) {
            formulario.txtservicio1.addItem(lista.get(i).getServicio());
        }

        formulario.txtmodalidad1.removeAllItems();
        Consultas_Modalidad mmodalidad = new Consultas_Modalidad();
        ArrayList<String> lista4 = new ArrayList<String>();

        formulario.txtclase1.removeAllItems();
        ArrayList<String> lista2 = new ArrayList<String>();
//        Consultas_Clase mod = new Consultas_Clase();

        formulario.txtllego1.removeAllItems();
        ArrayList<String> lista3 = new ArrayList<String>();
        //llena la tabla de servicios 

        servicio = consultas.llenar(modelo);
        Object[] datos = new Object[2];
        for (int i = 0; i < servicio.size(); i++) {
            datos[0] = servicio.get(i).getServicio();
            model.addRow(datos);
            formulario.tablaservicios1.setModel(model);
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
                formulario.txtnit1.setText(modelo.getNit());
                formulario.txtnombre1.setText(modelo.getNombre());
                formulario.txtcelular11.setText(modelo.getCelular1());
                formulario.txtllego1.addItem(modelo.getLlego());
                formulario.txtvlrprincipal1.setText(String.valueOf(modelo.getVlrprincipal()));
                formulario.txtnumequipos1.setText(String.valueOf(modelo.getNumequipos()));
                formulario.txtvlrterminal1.setText(String.valueOf(modelo.getVlrterminal()));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date fechaDate = null;
                fechaDate = sdf.parse(modelo.getFecha_llegada());
                formulario.txtfecha_llegada1.setDate(fechaDate);
//                if (modelo.getFecha_arriendo() != null) {
//                    fechaDate = sdf.parse(modelo.getFecha_arriendo());
//                    formulario.txtfecha_arriendo1.setDate(fechaDate);
//                }
                formulario.txtmodalidad1.addItem(modelo.getModalidad());
                formulario.txtnotas1.setText(modelo.getNotas());
                formulario.txtdv1.setText(modelo.getDv());
                formulario.txtcodigo1.setText(modelo.getCodigo());
                formulario.txtcelular21.setText(modelo.getCelular2());
                formulario.txtemail1.setText(modelo.getEmail());
                formulario.txtclase1.addItem(modelo.getClase());
                formulario.txtempresa1.setText(modelo.getEmpresa());
                formulario.txtcontacto1.setText(modelo.getContacto());
                if (modelo.getCliente_potencial() == 1) {
                    formulario.clientepotencial.setSelected(true);
                } else {
                    formulario.clientepotencial.setSelected(false);
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
        lista2 = cc.llenar();
        for (int i = 0; i < lista2.size(); i++) {
            formulario.txtclase1.addItem(lista2.get(i));
        }
        lista3 = cl.llenar();
        for (int i = 0; i < lista3.size(); i++) {
            formulario.txtllego1.addItem(lista3.get(i));
        }
        lista4 = mmodalidad.llenar();
        for (int i = 0; i < lista4.size(); i++) {
            formulario.txtmodalidad1.addItem(lista4.get(i));
        }
    }
}
