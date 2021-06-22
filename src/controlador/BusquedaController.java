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
import Consultas.Consultas_Servicio;
import Consultas.Consultas_Servicios_has_Clientes_Potenciales;
import Consultas.Consultas_usuario;
import buscador.Dialogos;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Clases;
import modelo.Cliente;
import modelo.Configuracion;
import modelo.Directorio;
import modelo.Documentos;
import modelo.Llego;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;
import modelo.Usuario;
import vistas.Configuraciones;
import vistas.Editarcliente;
import vistas.Formulario;
import vistas.Principal;

/**
 *
 * @author Yonathan Carvajal
 */
public class BusquedaController implements ActionListener {

    private final Cliente modelo;
    private final Consultas_Cliente consulta;
    private final Principal principal;

    DefaultTableModel model = new DefaultTableModel();
    Dialogos dialogo = new Dialogos();

    Servicio mods = new Servicio();
    Consultas_Servicio servicio = new Consultas_Servicio();

    Servicios_has_Clientes_Potenciales shcp = new Servicios_has_Clientes_Potenciales();
    Consultas_Servicios_has_Clientes_Potenciales cshcp = new Consultas_Servicios_has_Clientes_Potenciales();

    Configuracion mconfiguracion = new Configuracion();
    Consultas_Configuraciones cconfiguraciones = new Consultas_Configuraciones();
//            Configuraciones vc = new Configuraciones(principal, true);

    Documentos documento = new Documentos();
    Consultas_Documentos cdocumentos = new Consultas_Documentos();

    Consultas_Clase conc = new Consultas_Clase();
    Clases mc = new Clases();

    Consultas_Llego conl = new Consultas_Llego();
    Llego ml = new Llego();

    Directorio mod1 = new Directorio();
    Consultas_Directorio modc1 = new Consultas_Directorio();

    Usuario mod = new Usuario();

    Consultas_usuario consultasusuario = new Consultas_usuario();

    public BusquedaController(Cliente modelo, Consultas_Cliente consulta, Principal principal) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.principal = principal;

        this.principal.editar.addActionListener(this);
        this.principal.abrirarchivos.addActionListener(this);
    }

    public void iniciar() {
        principal.setTitle("Busqueda");
        principal.setLocationRelativeTo(null);
        model.addColumn("ID");
        model.addColumn("ruta");
        model.addColumn("Nit");
        model.addColumn("Dv");
        model.addColumn("Telefono");
        model.addColumn("Correo");
        model.addColumn("Contacto");
        model.addColumn("Nombre");
        model.addColumn("Codigo");
        model.addColumn("Fecha Inicio");
        model.addColumn("Fecha Arriendo");
        principal.tabladatos.setModel(model);
        principal.tabladatos.getColumn("ID").setWidth(0);
        principal.tabladatos.getColumn("ID").setMinWidth(0);
        principal.tabladatos.getColumn("ID").setMaxWidth(0);
        principal.tabladatos.getColumn("ruta").setWidth(0);
        principal.tabladatos.getColumn("ruta").setMinWidth(0);
        principal.tabladatos.getColumn("ruta").setMaxWidth(0);
        principal.tabladatos.getColumn("Codigo").setWidth(63);
        principal.tabladatos.getColumn("Codigo").setMinWidth(63);
        principal.tabladatos.getColumn("Codigo").setMaxWidth(63);
        principal.tabladatos.getColumn("Dv").setWidth(40);
        principal.tabladatos.getColumn("Dv").setMinWidth(40);
        principal.tabladatos.getColumn("Dv").setMaxWidth(40);
        keyevent();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.abrirarchivos) {
            int fila = principal.tabladatos.getSelectedRow();
            abrirarchivo(String.valueOf(principal.tabladatos.getValueAt(fila, 1)));
        }

        if (e.getSource() == principal.editar) {
            Editarcliente editarcliente = new Editarcliente(null, true);
            int selecionar = principal.tabladatos.getSelectedRow();
            if (selecionar != -1) {
                modelo.setIdclientes_potenciales(Integer.parseInt(String.valueOf(principal.tabladatos.getValueAt(selecionar, 0))));
                EditarClienteController editarcli = new EditarClienteController(modelo, mods, shcp, documento,
                        mconfiguracion, servicio, consulta, cshcp, cdocumentos, cconfiguraciones, conc, conl,
                        editarcliente);
                editarcli.iniciar();
                editarcliente.setVisible(true);
            }

        }
    }

    public void keyevent() {
        principal.txtbuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                busqueda();
            }
        });
    }

    public void limpiartabla() {
        if (principal.tabladatos.getRowCount() >= 0) {
            int count = principal.tabladatos.getRowCount();
            for (int i = 0; i < count; i++) {
                model.removeRow(0);
            }
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

    public void limpiar() {
//        pricipal.txtnombre.setText("");
//        pricipal.txtapellido.setText("");
//        pricipal.txtdocumento.setText("");
    }

    public void busqueda() {
        if (principal.txtbuscar.getText().length() == 0) {
            limpiartabla();
            //dialogo.alerta();
        }
        if (principal.txtbuscar.getText().length() > 0) {
            limpiartabla();
            ArrayList<Cliente> lista;
//            String filtrocliente = null;
//            if (principal.filtrocliente.getSelectedItem().toString().equals("cliente_potencial")) {
//                filtrocliente = "1";
//            }else{
//                if (principal.filtrocliente.getSelectedItem().toString().equals("cliente")) {
//                    filtrocliente = "0";
//                }else{
//                    if (principal.filtrocliente.getSelectedItem().toString().equals("todo")) {
//                        
//                    }
//                }
//            }
            lista = consulta.buscarcaracter(principal.txtbuscar.getText(), principal.filtro.getSelectedItem().toString(),principal.filtrocliente.getSelectedItem().toString());
            int cantidad = lista.size();
            Object[] dato = new Object[11];
            for (int i = 0; i < cantidad; i++) {
                dato[0] = lista.get(i).getIdclientes_potenciales();
                dato[1] = lista.get(i).getRuta();
                dato[2] = lista.get(i).getNit();
                dato[3] = lista.get(i).getDv();
                dato[4] = lista.get(i).getCelular1();
                dato[5] = lista.get(i).getEmail();
                dato[6] = lista.get(i).getContacto();
                dato[7] = lista.get(i).getNombre();
                dato[8] = lista.get(i).getCodigo();
                dato[9] = lista.get(i).getFecha_llegada();
                dato[10] = lista.get(i).getFecha_arriendo();
                model.addRow(dato);
                principal.tabladatos.setModel(model);
            }
        }
    }

}
