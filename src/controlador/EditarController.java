/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Clase;
import Consultas.Consultas_Cliente_Potencial;
import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Directorio;
import Consultas.Consultas_Documentos;
import Consultas.Consultas_Llego;
import Consultas.Consultas_Servicio;
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
import javax.swing.table.DefaultTableModel;
import modelo.Cliente_Potencial;
import modelo.Configuracion;
import modelo.Documentos;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import vistas.Editarcliente;

/**
 *
 * @author yonathan
 */
public class EditarController implements ActionListener {

    //modelo
    private final Cliente_Potencial modelo;
    private final Servicio mods;
    private final Servicios_has_Clientes_Potenciales shcp;
    private final Documentos mdocumento;
    private final Configuracion mconfiguracion;

    //consultas
    private final Consultas_Servicio cons;
    private final Consultas_Cliente_Potencial consultas;
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

    public EditarController(Cliente_Potencial modelo, Servicio mods,
            Servicios_has_Clientes_Potenciales shcp, Documentos mdocumento, Configuracion mconfiguracion,
            Consultas_Servicio cons, Consultas_Cliente_Potencial consultas,
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
        formulario.setTitle("Ediatr Cliente Potencial");
        formulario.setLocationRelativeTo(null);
        model.addColumn("Servicio/Producto");
        model.addColumn("Fecha de inicio");

        formulario.tablaservicios1.setModel(model);
        model1.addColumn("ID");
        model1.addColumn("Documento");
        model1.addColumn("Fecha de inicial");
        model1.addColumn("Fecha de vencimiento");
        formulario.tabladocumentos1.setModel(model1);
        formulario.tabladocumentos1.getColumn("ID").setWidth(0);
        formulario.tabladocumentos1.getColumn("ID").setMinWidth(0);
        formulario.tabladocumentos1.getColumn("ID").setMaxWidth(0);
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
            modelo.setRetiro(formulario.txtretiro1.getText());
            modelo.setNotas(formulario.txtnotas1.getText());
            modelo.setDv(formulario.txtdv1.getText());
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
                    mods.setServicio(formulario.tablaservicios1.getValueAt(i, 0).toString());
                    if (cons.buscar(mods)) {
                        shcp.setServicios_idservicio(mods.getIdservicio());
                        shcp.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
//                        System.out.println(modelo.getIdclientes_potenciales());
                        shcp.setFecha_de_inicio(formulario.tablaservicios1.getValueAt(i, 1).toString());
                        if (!cshcp.buscar(shcp)) {
                            if (!cshcp.registrarservicio(shcp)) {
                                JOptionPane.showMessageDialog(null, "error guardado de servicios");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "error guardado");
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
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            dato[1] = sdf.format(formulario.txtfecha_inicio1.getDate());
            model.addRow(dato);
            formulario.tablaservicios1.setModel(model);
            formulario.txtfecha_inicio1.setCalendar(null);
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
                System.out.println(modelo.getIdclientes_potenciales());
                shcp.setFecha_de_inicio(formulario.tablaservicios1.getValueAt(fila, 1).toString());
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
        Consultas_Directorio cd = new Consultas_Directorio();
        Object[] dato = new Object[1];
        for (int i = 0; i < cd.llenar().size(); i++) {
            dato[0] = cd.llenar().get(i);
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
        formulario.txtretiro1.setText("");
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
        if (cconfiguraciones.cargar(mconfiguracion)) {
            directorio = mconfiguracion.getDirectorio();
            prefijo = mconfiguracion.getPrefijo();
        }

        formulario.txtservicio1.removeAllItems();

        ArrayList<String> lista = new ArrayList<String>();
        Consultas_Servicio modc = new Consultas_Servicio();
        lista = modc.llenar();
        for (int i = 0; i < lista.size(); i++) {
            formulario.txtservicio1.addItem(lista.get(i));
        }

        formulario.txtclase1.removeAllItems();
        ArrayList<String> lista2 = new ArrayList<String>();
//        Consultas_Clase mod = new Consultas_Clase();

        formulario.txtllego1.removeAllItems();
        ArrayList<String> lista3 = new ArrayList<String>();
        //llena la tabla de servicios 
        int con = consultas.llenar(modelo).size();
        Object[] datos = new Object[2];
        for (int i = 0; i < con; i++) {
            datos[0] = consultas.llenar(modelo).get(i).getServicio();
            datos[1] = consultas.llenar(modelo).get(i).getFecha();
            model.addRow(datos);
            formulario.tablaservicios1.setModel(model);
        }

        int cantidad = consultas.clientedocumentos(modelo).size();
        Object[] datos5 = new Object[4];
        for (int i = 0; i < cantidad; i++) {
            datos5[0] = consultas.clientedocumentos(modelo).get(i).getIddocumentos();
            datos5[1] = consultas.clientedocumentos(modelo).get(i).getDocumento();
            datos5[2] = consultas.clientedocumentos(modelo).get(i).getFecha_inicio();
            datos5[3] = consultas.clientedocumentos(modelo).get(i).getFecha_vencimiento();
            model1.addRow(datos5);
            formulario.tabladocumentos1.setModel(model1);
        }

        if (consultas.buscar(modelo)) {
            try {
                formulario.txtnit1.setText(modelo.getNit());
                formulario.txtnombre1.setText(modelo.getNombre());
                formulario.txtcelular11.setText(modelo.getCelular1());
                formulario.txtllego1.addItem(modelo.getLlego());

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date fechaDate = null;
                fechaDate = sdf.parse(modelo.getFecha_llegada());
                formulario.txtfecha_llegada1.setDate(fechaDate);

                formulario.txtretiro1.setText(modelo.getRetiro());
                formulario.txtnotas1.setText(modelo.getNotas());
                formulario.txtdv1.setText(modelo.getDv());
                formulario.txtcodigo1.setText(modelo.getCodigo());
                formulario.txtcelular21.setText(modelo.getCelular2());
                formulario.txtemail1.setText(modelo.getEmail());
                formulario.txtclase1.addItem(modelo.getClase());
                formulario.txtempresa1.setText(modelo.getEmpresa());
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
            } catch (ParseException ex) {
                Logger.getLogger(EditarController.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
