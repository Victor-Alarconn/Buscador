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
import Organizador.Dialogos;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import modelo.Clases;
import modelo.Cliente;
import modelo.Configuracion;
import modelo.Directorio;
import modelo.Documentos;
import modelo.Llego;
import modelo.Mac;
import modelo.Modalidad;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import modelo.Usuario;
import vistas.Cotizaciones;
import vistas.Formulario;

/**
 *
 * @author Yonathan Carvajal
 */
public class Cliente_PotencialController implements ActionListener {

    //modelo
    private final Cliente modelo;
    private final Configuracion mconfiguracion;
    private final Usuario user;

    //consultas
    private final Consultas_Cliente consultas;
    private final Consultas_Configuraciones cconfiguraciones;

    private final Cotizaciones formulario;
    private String directorio = null;

    ArrayList<Configuracion> mconfig;

    Consultas_Mac cmac = new Consultas_Mac();
    Mac mmac = new Mac();
    Dialogos dialogo = new Dialogos();

    Consultas_Llego cllego = new Consultas_Llego();
    Consultas_Modalidad mmodalidad = new Consultas_Modalidad();
    Consultas_Clase mod = new Consultas_Clase();
    ArrayList<Modalidad> modulo4;
    ArrayList<Llego> modulo;
    ArrayList<Clases> modulo1;
        
    public Cliente_PotencialController(Cliente modelo, Consultas_Cliente consultas,
            Cotizaciones formulario, Configuracion mconfiguracion, Consultas_Configuraciones cconfiguraciones, Usuario user) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.formulario = formulario;
        this.mconfiguracion = mconfiguracion;
        this.cconfiguraciones = cconfiguraciones;
        this.user = user;

        this.formulario.guardarformulario.addActionListener(this);
        this.formulario.abrirdirectorio.addActionListener(this);
    }

    public void iniciar() {
        busqueda();
        formulario.setTitle("Cliente Potencial");
        formulario.setLocationRelativeTo(null);
        mmac.setMacs(mmac.conseguirMAC());
        if (cmac.buscar(mmac)) {
            mconfig = cconfiguraciones.cargar(mmac.getIdmacs());
            for (int i = 0; i < mconfig.size(); i++) {
                if (mconfig.get(i).getModulo().toLowerCase().equals("cotizaciones")) {
                    directorio = mconfig.get(i).getDirectorio();
                }
            }
            if (directorio == null) {
                formulario.mensajealerta.setVisible(true);
            } else {
                formulario.mensajealerta.setVisible(false);
            }
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
        
        formulario.getRootPane().registerKeyboardAction(e -> {
            consultanombre();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formulario.guardarformulario) {
            modelo.setEmpresa(formulario.txtempresa.getText());
            if (formulario.txtnombre.getText().equals("")) {
                JOptionPane.showMessageDialog(formulario, "El campo nombre esta vacio");
            } else {
                modelo.setNombre(formulario.txtnombre.getText());
                modelo.setCelular1(formulario.txtcelular1.getText());
                modelo.setCelular2(formulario.txtcelular2.getText());
                modelo.setEmail(formulario.txtemail.getText());
                Clases modulo = (Clases) formulario.txtclase.getModel().getSelectedItem();
                modelo.setClase(modulo.getClase());
                Llego modulo1 = (Llego) formulario.txtllego.getModel().getSelectedItem();
                modelo.setLlego(modulo1.getLlego());
                modelo.setCliente_potencial(1);
                modelo.setRutacotizacon(File.separator + formulario.txtnombre.getText().toUpperCase().trim());
                if (formulario.txtfecha_cotizacion.getDate() != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    modelo.setFechacotizacion(sdf.format(formulario.txtfecha_cotizacion.getDate()));
                    Modalidad modulo2 = (Modalidad) formulario.txtmodalidad.getModel().getSelectedItem();
                    modelo.setModalidad(modulo2.getModalidad());
                    modelo.setNotas(formulario.txtnotas.getText());
                    modelo.setContacto(formulario.txtcontacto.getText());
                    modelo.setUsuarios_idusuario(user.getIdusuario());
                    //guardando el cliente 
                    if (consultas.registrar(modelo)) {
                        crear_carpeta(directorio);
                        JOptionPane.showMessageDialog(null, "registro guardado");
                        formulario.dispose();
                        this.limpiar();

                    } else {
                        JOptionPane.showMessageDialog(null, "error guardado el cliente");
                    }

                } else {
                    JOptionPane.showMessageDialog(formulario, "El campo fecha esta vacio");
                }
            }

        }
        if (e.getSource()== formulario.abrirdirectorio) {
            abrirarchivo(directorio + modelo.getRutacotizacon());
        }
    }

    // funcion para crear una carpeta 
    private void crear_carpeta(String path) {
        Consultas_Directorio cd = new Consultas_Directorio();
        ArrayList<Directorio> directorios;
        directorios = cd.llenar();
        String nombre = formulario.txtnombre.getText().toUpperCase().trim();
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
        formulario.txtnombre.setText("");
        formulario.txtcelular1.setText("");
        formulario.txtcelular2.setText("");
        formulario.txtemail.setText("");
        formulario.txtempresa.setText("");
        formulario.txtnotas.setText("");
    }

    public void consultanombre() {
        modelo.setNombre(formulario.txtnombre.getText());
        if (consultas.buscarnombrecliente(modelo)) {
            System.out.println(modelo.getCelular1());
            formulario.txtnombre.setText(modelo.getNombre());
            formulario.txtcelular1.setText(modelo.getCelular1());
            formulario.txtcelular2.setText(modelo.getCelular2());
            formulario.txtcontacto.setText(modelo.getContacto());
            formulario.txtemail.setText(modelo.getEmail());
            formulario.txtempresa.setText(modelo.getEmpresa());
            formulario.txtnotas.setText(modelo.getNotas());
            for (int i = 0; i < modulo.size(); i++) {
                if (formulario.txtllego.getModel().getElementAt(i).toString().equals(modelo.getLlego())) {
                    formulario.txtllego.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < modulo4.size(); i++) {
                if (formulario.txtmodalidad.getModel().getElementAt(i).toString().equals(modelo.getModalidad())) {
                    formulario.txtmodalidad.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < modulo1.size(); i++) {
                if (formulario.txtclase.getModel().getElementAt(i).toString().equals(modelo.getClase())) {
                    formulario.txtclase.setSelectedIndex(i);
                }
            }
            
        }
    }

}
