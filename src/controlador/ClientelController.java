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
import Consultas.Consultas_Servicio;
import Consultas.Consultas_Servicios_has_Clientes_Potenciales;
import Consultas.Consultas_SubCarpetas;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Configuracion;
import modelo.Documentos;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import vistas.Formulario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Directorio;
import modelo.Subcarpeta;
import modelo.Usuario;

/**
 *
 * @author Yonathan Carvajal
 */
public class ClientelController implements ActionListener {

    //modelo
    private final Cliente modelo;
    private final Servicio mods;
    private final Servicios_has_Clientes_Potenciales shcp;
    private final Documentos mdocumento;
    private final Configuracion mconfiguracion;
    private final Usuario user;

    //consultas
    private final Consultas_Servicio cons;
    private final Consultas_Cliente consultas;
    private final Consultas_Servicios_has_Clientes_Potenciales cshcp;
    private final Consultas_Documentos cdocumentos;
    private final Consultas_Configuraciones cconfiguraciones;

    private final Formulario formulario;
    private String directorio = null;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();

    ArrayList<Servicio> lista;

    public ClientelController(Cliente modelo, Consultas_Cliente consultas,
            Formulario formulario, Consultas_Servicio cons, Servicio mods, Servicios_has_Clientes_Potenciales shcp,
            Consultas_Servicios_has_Clientes_Potenciales cshcp, Documentos documento, Consultas_Documentos cdocumentos,
            Configuracion mconfiguracion, Consultas_Configuraciones cconfiguraciones, Usuario user) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.formulario = formulario;
        this.cons = cons;
        this.mods = mods;
        this.shcp = shcp;
        this.cshcp = cshcp;
        this.mdocumento = documento;
        this.cdocumentos = cdocumentos;
        this.mconfiguracion = mconfiguracion;
        this.cconfiguraciones = cconfiguraciones;
        this.user = user;

        this.formulario.guardarformulario.addActionListener(this);
        this.formulario.agregarservicio.addActionListener(this);
        this.formulario.agregardocumento.addActionListener(this);
        this.formulario.eliminardocumento.addActionListener(this);
        this.formulario.eliminarservicio.addActionListener(this);
    }

    public void iniciar() {
        busqueda();
        keyevent();
        formulario.mensajenit.setVisible(false);
        formulario.setTitle("Cliente Potencial");
        formulario.setLocationRelativeTo(null);
        model.addColumn("Servicio/Producto");
        model.addColumn("Fecha de inicio");
        formulario.tablaservicios.setModel(model);
        model1.addColumn("Documento");
        model1.addColumn("Fecha inicio");
        model1.addColumn("Fecha vvence");
        formulario.tabladocumentos.setModel(model1);

        formulario.txtservicio.removeAllItems();
        lista = cons.llenar();
        for (int i = 0; i < lista.size(); i++) {
            formulario.txtservicio.addItem(lista.get(i).getServicio());
        }

        formulario.txtclase.removeAllItems();
        Consultas_Clase mod = new Consultas_Clase();
        ArrayList<String> lista2 = mod.llenar();
        for (int i = 0; i < lista2.size(); i++) {
            formulario.txtclase.addItem(lista2.get(i));
        }

        formulario.txtmodalidad.removeAllItems();
        Consultas_Modalidad mmodalidad = new Consultas_Modalidad();
        ArrayList<String> lista4 = new ArrayList<String>();

        lista4 = mmodalidad.llenar();
        for (int i = 0; i < lista4.size(); i++) {
            formulario.txtmodalidad.addItem(lista4.get(i));
        }

        formulario.txtllego.removeAllItems();
        ArrayList<String> lista3 = new ArrayList<String>();
        Consultas_Llego modelo = new Consultas_Llego();
        lista3 = modelo.llenar();
        for (int i = 0; i < lista3.size(); i++) {
            formulario.txtllego.addItem(lista3.get(i));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formulario.guardarformulario) {
            if (cconfiguraciones.cargar(mconfiguracion)) {
                directorio = mconfiguracion.getDirectorio();
            }
            modelo.setNit(formulario.txtnit.getText());
            modelo.setEmpresa(formulario.txtempresa.getText());
            if (formulario.txtnombre.getText().equals("")) {
                JOptionPane.showMessageDialog(formulario, "El campo nombre esta vacio");
            } else {
                modelo.setNombre(formulario.txtnombre.getText());
                modelo.setCelular1(formulario.txtcelular1.getText());
                modelo.setCelular2(formulario.txtcelular2.getText());
//            Pattern pattern = Pattern
//                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//
//            Matcher mather = pattern.matcher(formulario.txtemail.getText());
                modelo.setEmail(formulario.txtemail.getText());
                modelo.setClase(formulario.txtclase.getSelectedItem().toString());
                modelo.setLlego(formulario.txtllego.getSelectedItem().toString());
                if (!formulario.txtvlrprincipal.getText().equals("")) {
                    modelo.setVlrprincipal(Integer.parseInt(formulario.txtvlrprincipal.getText()));
                }

                if (!formulario.txtvlrterminal.getText().equals("")) {
                    modelo.setVlrterminal(Integer.parseInt(formulario.txtvlrterminal.getText()));
                }
                if (!formulario.txtnumequipos.getText().equals("")) {
                    modelo.setNumequipos(Integer.parseInt(formulario.txtnumequipos.getText()));
                }
                if (formulario.txtfecha_llegada.getDate() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    modelo.setFecha_llegada(sdf.format(formulario.txtfecha_llegada.getDate()));
                    modelo.setModalidad(formulario.txtmodalidad.getSelectedItem().toString());
                    if (formulario.txtcodigo.getText().equals("")) {
                        JOptionPane.showMessageDialog(formulario, "El campo codigo esta vacio");
                    } else {
                        modelo.setNotas(formulario.txtnotas.getText());
                        modelo.setCodigo(formulario.txtcodigo.getText().toUpperCase());
                        modelo.setDv(formulario.txtdv.getText());
                        modelo.setRuta(directorio + File.separator + formulario.txtcodigo.getText().toUpperCase() + "_" + formulario.txtnombre.getText().toUpperCase());
                        if (formulario.clientepotecial.isSelected()) {
                            modelo.setCliente_potencial(1);
                        } else {
                            modelo.setCliente_potencial(0);
                        }
                        if (formulario.bequipos.isSelected()) {
                            modelo.setCategoria("Equipos");
                        }
                        if (formulario.bredes.isSelected()) {
                            modelo.setCategoria("Redes");
                        }
                        if (formulario.bsoftware.isSelected()) {
                            modelo.setCategoria("Software");
                        }
                        if (formulario.botro.isSelected()) {
                            modelo.setCategoria("Otro");
                        }
                        if (formulario.txtfecha_arriendo.getDate() != null) {
                            modelo.setFecha_arriendo(sdf.format(formulario.txtfecha_arriendo.getDate()));
                        }
                        modelo.setContacto(formulario.txtcontacto.getText());
                        modelo.setUsuarios_idusuario(user.getIdusuario());
                        //guardando el cliente 
                        if (consultas.registrar(modelo)) {
                            modelo.setNit(formulario.txtnit.getText());
                            if (consultas.buscarr(modelo)) {
                                // guardando la tabla servicios
                                for (int i = 0; i < formulario.tablaservicios.getRowCount(); i++) {
                                    for (int j = 0; j < lista.size(); j++) {
                                        if (lista.get(j).getServicio().equals(formulario.tablaservicios.getValueAt(i, 0).toString())) {
                                            shcp.setServicios_idservicio(lista.get(j).getIdservicio());
                                            shcp.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
                                            shcp.setFecha_de_inicio(formulario.tablaservicios.getValueAt(i, 1).toString());
                                            if (!cshcp.registrarservicio(shcp)) {
                                                JOptionPane.showMessageDialog(null, "error guardando de servicios");
                                            }
                                        }
                                    }
                                }
                                //guardando la tabla documnetos
                                for (int i = 0; i < formulario.tabladocumentos.getRowCount(); i++) {
                                    mdocumento.setDocumento(formulario.tabladocumentos.getValueAt(i, 0).toString());
                                    mdocumento.setFecha_inicio(formulario.tabladocumentos.getValueAt(i, 1).toString());
                                    mdocumento.setFecha_vencimiento(formulario.tabladocumentos.getValueAt(i, 2).toString());
                                    mdocumento.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
                                    if (!cdocumentos.registrar(mdocumento)) {
                                        JOptionPane.showMessageDialog(null, "error guardando de documentos");
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "registro guardado");
                                crear_carpeta(directorio);
                                formulario.dispose();
                                this.limpiar();
                                this.limpiardocumentos();
                                this.limpiarservicios();

                            } else {
                                JOptionPane.showMessageDialog(null, "error de registro cliente");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "error guardado el cliente");
                        }
                        //cortar
                    }
                } else {
                    JOptionPane.showMessageDialog(formulario, "El campo fecha esta vacio");
                }
            }

        }
        //boton agregar servicio
        Object[] dato = new Object[5];
        if (e.getSource() == formulario.agregarservicio) {
            if (formulario.txtfecha_inicio.getDate() != null) {
                dato[0] = formulario.txtservicio.getSelectedItem().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                dato[1] = sdf.format(formulario.txtfecha_inicio.getDate());
                model.addRow(dato);
                formulario.tablaservicios.setModel(model);
                formulario.txtfecha_inicio.setCalendar(null);
            } else {
                JOptionPane.showMessageDialog(formulario, "Campo de fecha vacio");
            }

        }
        //boton agregar documento
        Object[] tabladocumentos = new Object[5];
        if (e.getSource() == formulario.agregardocumento) {
            if (formulario.fecha_vencimineto_docum.getDate() != null && formulario.fecha_inicio_docum.getDate() != null) {
                tabladocumentos[0] = formulario.txtdocumento.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                tabladocumentos[1] = sdf.format(formulario.fecha_inicio_docum.getDate());
                tabladocumentos[2] = sdf.format(formulario.fecha_vencimineto_docum.getDate());
                model1.addRow(tabladocumentos);
                formulario.tabladocumentos.setModel(model1);
                formulario.fecha_inicio_docum.setCalendar(null);
                formulario.fecha_vencimineto_docum.setCalendar(null);
                formulario.txtdocumento.setText("");
            } else {
                JOptionPane.showMessageDialog(formulario, "Campos de fechas vacios");
            }

        }
        //boton eliminar servicio
        if (e.getSource() == formulario.eliminarservicio) {
            int fila = formulario.tablaservicios.getSelectedRow();
            if (fila >= 0) {
                model.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(formulario, "La tabla esta vacia o no sea seleccionado nada aun!");
            }

        }
        //boton eliminar documnento
        if (e.getSource() == formulario.eliminardocumento) {
            int fila = formulario.tabladocumentos.getSelectedRow();
            if (fila >= 0) {
                model1.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(formulario, "La tabla esta vacia o no sea seleccionado nada aun!");
            }
        }

    }

    // funcion para crear una carpeta 
    private void crear_carpeta(String path) {
        Consultas_Directorio cd = new Consultas_Directorio();
        Consultas_SubCarpetas csubcarpeta = new Consultas_SubCarpetas();
        ArrayList<Subcarpeta> subcarpeta;
        ArrayList<Directorio> directorios;
        subcarpeta = csubcarpeta.allsubcategorias();
        directorios = cd.llenar();

        String nombre = formulario.txtcodigo.getText().toUpperCase() + "_" + formulario.txtnombre.getText().toUpperCase();
        if (nombre == null) {
        } else {
            File file = Crear_archivo(path, nombre);
            Object[] idsubcategorias = new Object[subcarpeta.size()];
            Object[] subcategorias = new Object[subcarpeta.size()];
            Object[] carpetas = new Object[directorios.size()];
            Object[] idcarpetas = new Object[directorios.size()];
            for (int i = 0; i < subcarpeta.size(); i++) {
                idsubcategorias[i] = subcarpeta.get(i).getDirectorios_iddirectorios();
                subcategorias[i] = subcarpeta.get(i).getSubcarpeta();
            }
            for (int i = 0; i < directorios.size(); i++) {
                carpetas[i] = cd.llenar().get(i).getCarpeta();
                idcarpetas[i] = cd.llenar().get(i).getIddirectorios();
            }
            try {
                file.mkdir();
                System.out.println("carpeta "+file);
                for (int i = 0; i < directorios.size(); i++) {
                    File fil = Crear_archivo(file.toString(), carpetas[i].toString());
                    System.out.println("carpeta " + fil);
                    try {
                        fil.mkdir();
                        for (int j = 0; j < subcategorias.length; j++) {
                            if (idsubcategorias[j].equals(idcarpetas[i])) {
                                File subfile = Crear_archivo(fil.toString(), subcategorias[j].toString());
                                System.out.println("sub " + subfile);
                                subfile.mkdir();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            abrirarchivo(directorio + File.separator + nombre);
        }
    }

    public void busqueda() {
        ArrayList<Directorio> directorios;
        Consultas_Directorio cd = new Consultas_Directorio();
        directorios = cd.llenar();
        Object[] dato = new Object[1];
        for (int i = 0; i < directorios.size(); i++) {
            dato[0] = directorios.get(i);
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
//funcion para limpiar el formulario

    public void limpiar() {
        formulario.txtnit.setText("");
        formulario.txtnombre.setText("");
        formulario.txtcelular1.setText("");
        formulario.txtcelular2.setText("");
        formulario.txtdv.setText("");
        formulario.txtcodigo.setText("");
        formulario.txtemail.setText("");
        formulario.txtempresa.setText("");
        formulario.txtdocumento.setText("");
        formulario.txtnotas.setText("");
        formulario.txtfecha_llegada.setCalendar(null);
        formulario.buttonGroup1.clearSelection();
    }

    public void limpiarservicios() {
        if (formulario.tablaservicios.getRowCount() >= 0) {
            int count = formulario.tablaservicios.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
        }
    }

    public void limpiardocumentos() {
        if (formulario.tabladocumentos.getRowCount() >= 0) {
            int count = formulario.tabladocumentos.getRowCount();
            for (int i = 0; i < count; i++) {
                model1.removeRow(0);
            }
        }
    }

    public void keyevent() {
        formulario.txtnit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                consultanit();
            }
        });
    }

    public void consultanit() {
        modelo.setNit(formulario.txtnit.getText());
        if (consultas.buscarr(modelo)) {
            formulario.mensajenit.setVisible(true);
        } else {
            formulario.mensajenit.setVisible(false);
        }
    }
}
