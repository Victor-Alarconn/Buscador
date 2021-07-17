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
import Consultas.Consultas_Mac;
import Consultas.Consultas_Modalidad;
import Consultas.Consultas_Servicios;
import Consultas.Consultas_Servicios_has_Clientes_Potenciales;
import Organizador.Recursos;
import java.awt.Desktop;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Configuracion;
import modelo.Documentos;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import vistas.Formulario;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.Clases;
import modelo.Directorio;
import modelo.Llego;
import modelo.Mac;
import modelo.Modalidad;
import modelo.Usuario;

/**
 *
 * @author Yonathan Carvajal
 */
public class ClienteController implements ActionListener {

    //modelo
    private final Cliente modelo;
    private final Servicio mods;
    private final Servicios_has_Clientes_Potenciales shcp;
    private final Documentos mdocumento;
    private final Configuracion mconfiguracion;
    private final Usuario user;

    //consultas
    private final Consultas_Servicios cons;
    private final Consultas_Cliente consultas;
    private final Consultas_Servicios_has_Clientes_Potenciales cshcp;
    private final Consultas_Documentos cdocumentos;
    private final Consultas_Configuraciones cconfiguraciones;

    private final Formulario formulario;
    private String directorio = null;
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();

    ArrayList<Servicio> lista;
    ArrayList<Configuracion> mconfig;

    Consultas_Mac cmac = new Consultas_Mac();
    Mac mmac = new Mac();
    Recursos dialogo = new Recursos();

    Consultas_Llego cllego = new Consultas_Llego();
    Consultas_Modalidad mmodalidad = new Consultas_Modalidad();
    Consultas_Clase mod = new Consultas_Clase();
    ArrayList<Modalidad> modulo4;
    ArrayList<Llego> modulo;
    ArrayList<Clases> modulo1;

    public ClienteController(Cliente modelo, Consultas_Cliente consultas,
            Formulario formulario, Consultas_Servicios cons, Servicio mods, Servicios_has_Clientes_Potenciales shcp,
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
        formulario.setTitle("Cliente");
        formulario.setLocationRelativeTo(null);
//        keyevent();
        formulario.mensajenit.setVisible(false);
        model.addColumn("Servicio/Producto");
        formulario.tablaservicios.setModel(model);
        model1.addColumn("Documento");
        model1.addColumn("Fecha inicio");
        model1.addColumn("Fecha vence");
        formulario.tabladocumentos.setModel(model1);
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        formulario.tablaservicios.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);

        mconfig = cconfiguraciones.cargar(mmac.conseguirMAC());
        for (int i = 0; i < mconfig.size(); i++) {
            if (mconfig.get(i).getModulo().toLowerCase().equals("clientes")) {
                directorio = mconfig.get(i).getDirectorio();
                break;
            }
        }
        if (directorio == null) {
            formulario.mensajealerta.setVisible(true);
        } else {
            formulario.mensajealerta.setVisible(false);
        }

        formulario.txtservicio.removeAllItems();
        lista = cons.llenar();
        for (int i = 0; i < lista.size(); i++) {
            formulario.txtservicio.addItem(lista.get(i));
        }

        formulario.txtclase.removeAllItems();
        modulo1 = mod.llenar();
        for (int i = 0; i < modulo1.size(); i++) {
            formulario.txtclase.addItem(modulo1.get(i));
        }

        formulario.txtmodalidad.removeAllItems();
        modulo4 = mmodalidad.llenar();
        for (int i = 0; i < modulo4.size(); i++) {
            formulario.txtmodalidad.addItem(modulo4.get(i));
        }

        modulo = cllego.llenar();
        formulario.txtllego.removeAllItems();
        for (int i = 0; i < modulo.size(); i++) {
            formulario.txtllego.addItem(modulo.get(i));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formulario.guardarformulario) {

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
                if (!formulario.txtvalor_total.getText().equals("")) {
                    modelo.setValor_total(formulario.txtvalor_total.getText());
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

                        modelo.setRuta(File.separator + formulario.txtcodigo.getText().toUpperCase() + "_" + formulario.txtnombre.getText().toUpperCase().trim());

                        if (formulario.electronica.isSelected()) {
                            modelo.setElectronica(1);
                        } else {
                            modelo.setElectronica(0);
                        }
                        if (formulario.sucursal.isSelected()) {
                            modelo.setSucursal(1);
                        } else {
                            modelo.setSucursal(0);
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
                        try {
                            if (consultas.registrar(modelo)) {
                                // guardando la tabla servicios
                                for (int i = 0; i < formulario.tablaservicios.getRowCount(); i++) {
                                    for (int j = 0; j < lista.size(); j++) {
                                        if (lista.get(j).getServicio().equals(formulario.tablaservicios.getValueAt(i, 0).toString())) {
                                            shcp.setServicios_idservicio(lista.get(j).getIdservicio());
                                            shcp.setClientes_potenciales_idclientes_potenciales(modelo.getIdclientes_potenciales());
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
                                JOptionPane.showMessageDialog(null, "error guardado el cliente");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(formulario, "El campo fecha esta vacio");
                }
            }

        }
        //boton agregar servicio
        Object[] dato = new Object[5];
        if (e.getSource() == formulario.agregarservicio) {
            dato[0] = formulario.txtservicio.getSelectedItem().toString();
            model.addRow(dato);
            formulario.tablaservicios.setModel(model);
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
        ArrayList<Directorio> directorios;
        directorios = cd.llenar();
        String nombre = formulario.txtcodigo.getText().toUpperCase() + "_" + formulario.txtnombre.getText().toUpperCase().trim();
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
