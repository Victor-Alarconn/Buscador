/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Consultas.Consultas_Clase;
import Consultas.Consultas_Cliente_Potencial;
import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Directorio;
import Consultas.Consultas_Documentos;
import Consultas.Consultas_Llego;
import Consultas.Consultas_Servicio;
import Consultas.Consultas_Servicios_has_Clientes_Potenciales;
import Consultas.Consultas_usuario;
import buscador.Dialogos;
import controlador.ClaseController;
import controlador.Cliente_PotencialController;
import controlador.ConfiguracionesController;
import controlador.DirectorioController;
import controlador.LlegoController;
import controlador.ServicioController;
import controlador.UsuarioController;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelo.Clases;
import modelo.Cliente_Potencial;
import modelo.Configuracion;
import modelo.Directorio;
import modelo.Documentos;
import modelo.Llego;
import modelo.Servicio;
import modelo.Servicios_has_Clientes_Potenciales;


/**
 *
 * @author Yonathan Carvajal
 */
public class Principal extends javax.swing.JFrame {

    Servicio mods = new Servicio();
    Consultas_Servicio servicio = new Consultas_Servicio();

    Servicios_has_Clientes_Potenciales shcp = new Servicios_has_Clientes_Potenciales();
    Consultas_Servicios_has_Clientes_Potenciales cshcp = new Consultas_Servicios_has_Clientes_Potenciales();

    Configuracion mconfiguracion = new Configuracion();
    Consultas_Configuraciones cconfiguraciones = new Consultas_Configuraciones();
    Configuraciones vc = new Configuraciones(this, true);

    Cliente_Potencial modelo = new Cliente_Potencial();

    Documentos documento = new Documentos();
    Consultas_Documentos cdocumentos = new Consultas_Documentos();

    Consultas_Cliente_Potencial consulta = new Consultas_Cliente_Potencial();

    Consultas_Clase conc = new Consultas_Clase();
    Clases mc = new Clases();

    Consultas_Llego conl = new Consultas_Llego();
    Llego ml = new Llego();

    Directorio mod1 = new Directorio();
    Consultas_Directorio modc1 = new Consultas_Directorio();
    
    Formulario formulario = new Formulario(this, true);

    public void servicios() {
        txtservicio.removeAllItems();

        ArrayList<String> lista = new ArrayList<String>();
        Consultas_Servicio modc = new Consultas_Servicio();
        lista = modc.llenar();
        for (int i = 0; i < lista.size(); i++) {
            txtservicio.addItem(lista.get(i));
        }

        txtclase.removeAllItems();
        ArrayList<String> lista2 = new ArrayList<String>();
        Consultas_Clase mod = new Consultas_Clase();
        lista2 = mod.llenar();
        for (int i = 0; i < lista2.size(); i++) {
            txtclase.addItem(lista2.get(i));
        }

        txtllego.removeAllItems();
        ArrayList<String> lista3 = new ArrayList<String>();
        Consultas_Llego modelo = new Consultas_Llego();
        lista3 = modelo.llenar();
        for (int i = 0; i < lista3.size(); i++) {
            txtllego.addItem(lista3.get(i));
        }
    }

    public void transparecia() {
        botro.setOpaque(false);
        bsoftware.setOpaque(false);
        bequipos.setOpaque(false);
        bredes.setOpaque(false);

        botro1.setOpaque(false);
        bsoftware1.setOpaque(false);
        bequipos1.setOpaque(false);
        bredes1.setOpaque(false);

        abrirarchivos.setOpaque(false);
        abrirarchivos.setContentAreaFilled(false);
        abrirarchivos.setBorderPainted(false);

        editar.setOpaque(false);
        editar.setContentAreaFilled(false);
        editar.setBorderPainted(false);

        eliminarcliente.setOpaque(false);
        eliminarcliente.setContentAreaFilled(false);
        eliminarcliente.setBorderPainted(false);

///
        guardarformulario.setOpaque(false);
        guardarformulario.setContentAreaFilled(false);
        guardarformulario.setBorderPainted(false);

        agregardocumento.setOpaque(false);
        agregardocumento.setContentAreaFilled(false);
        agregardocumento.setBorderPainted(false);

        eliminardocumento.setOpaque(false);
        eliminardocumento.setContentAreaFilled(false);
        eliminardocumento.setBorderPainted(false);

        agregarservicio.setOpaque(false);
        agregarservicio.setContentAreaFilled(false);
        agregarservicio.setBorderPainted(false);

        eliminarservicio.setOpaque(false);
        eliminarservicio.setContentAreaFilled(false);
        eliminarservicio.setBorderPainted(false);
        ///// formulario editar
        guardarformulario1.setOpaque(false);
        guardarformulario1.setContentAreaFilled(false);
        guardarformulario1.setBorderPainted(false);

        agregardocumento1.setOpaque(false);
        agregardocumento1.setContentAreaFilled(false);
        agregardocumento1.setBorderPainted(false);

        eliminardocumento1.setOpaque(false);
        eliminardocumento1.setContentAreaFilled(false);
        eliminardocumento1.setBorderPainted(false);

        agregarservicio1.setOpaque(false);
        agregarservicio1.setContentAreaFilled(false);
        agregarservicio1.setBorderPainted(false);

        eliminarservicio1.setOpaque(false);
        eliminarservicio1.setContentAreaFilled(false);
        eliminarservicio1.setBorderPainted(false);

        subpanel1.setOpaque(false);
        subpanel4.setOpaque(false);
        subpanel3.setOpaque(false);

        panelprincipal.setOpaque(false);
        paneleditar.setOpaque(false);
        subpanel6.setOpaque(false);

    }
//   DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        transparecia();
        subpanel3.setVisible(false);
        paneleditar.setVisible(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamanio = tk.getScreenSize();
        int ancho = (int) tamanio.getWidth();
        int alto = (int) tamanio.getHeight();
        this.setResizable(true);
        jLabel1.setPreferredSize(new Dimension(ancho, alto));

        ImageIcon rm = new ImageIcon(getClass().getResource("/img/rm.jpg"));
        Icon fondo = new ImageIcon(rm.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(fondo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        subpanel1 = new javax.swing.JPanel();
        subpanel3 = new javax.swing.JPanel();
        txtnit = new rojerusan.RSMetroTextFullPlaceHolder();
        txtnombre = new rojerusan.RSMetroTextFullPlaceHolder();
        txtllego = new rojerusan.RSComboMetro();
        txtcelular1 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtretiro = new rojerusan.RSMetroTextFullPlaceHolder();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtnotas = new javax.swing.JTextArea();
        subpanel4 = new javax.swing.JPanel();
        agregarservicio = new javax.swing.JButton();
        eliminarservicio = new javax.swing.JButton();
        txtservicio = new rojerusan.RSComboMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaservicios = new rojerusan.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabladocumentos = new rojerusan.RSTableMetro();
        agregardocumento = new javax.swing.JButton();
        eliminardocumento = new javax.swing.JButton();
        txtdocumento = new rojerusan.RSMetroTextFullPlaceHolder();
        fecha_inicio_docum = new com.toedter.calendar.JDateChooser();
        fecha_vencimineto_docum = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtfecha_inicio = new com.toedter.calendar.JDateChooser();
        guardarformulario = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtdv = new rojerusan.RSMetroTextFullPlaceHolder();
        txtcelular2 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtcodigo = new rojerusan.RSMetroTextFullPlaceHolder();
        txtemail = new rojerusan.RSMetroTextFullPlaceHolder();
        txtclase = new rojerusan.RSComboMetro();
        txtempresa = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        botro = new javax.swing.JRadioButton();
        bsoftware = new javax.swing.JRadioButton();
        bredes = new javax.swing.JRadioButton();
        bequipos = new javax.swing.JRadioButton();
        txtfecha_llegada = new com.toedter.calendar.JDateChooser();
        paneleditar = new javax.swing.JPanel();
        txtnit1 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtnombre1 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtllego1 = new rojerusan.RSComboMetro();
        txtcelular11 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtretiro1 = new rojerusan.RSMetroTextFullPlaceHolder();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtnotas1 = new javax.swing.JTextArea();
        subpanel6 = new javax.swing.JPanel();
        agregarservicio1 = new javax.swing.JButton();
        eliminarservicio1 = new javax.swing.JButton();
        txtservicio1 = new rojerusan.RSComboMetro();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaservicios1 = new rojerusan.RSTableMetro();
        jScrollPane15 = new javax.swing.JScrollPane();
        tabladocumentos1 = new rojerusan.RSTableMetro();
        agregardocumento1 = new javax.swing.JButton();
        eliminardocumento1 = new javax.swing.JButton();
        txtdocumento1 = new rojerusan.RSMetroTextFullPlaceHolder();
        fecha_inicio_docum1 = new com.toedter.calendar.JDateChooser();
        fecha_vencimineto_docum1 = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtfecha_inicio1 = new com.toedter.calendar.JDateChooser();
        guardarformulario1 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        txtdv1 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtcelular21 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtcodigo1 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtemail1 = new rojerusan.RSMetroTextFullPlaceHolder();
        txtclase1 = new rojerusan.RSComboMetro();
        txtempresa1 = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        botro1 = new javax.swing.JRadioButton();
        bsoftware1 = new javax.swing.JRadioButton();
        bredes1 = new javax.swing.JRadioButton();
        bequipos1 = new javax.swing.JRadioButton();
        txtfecha_llegada1 = new com.toedter.calendar.JDateChooser();
        panelprincipal = new javax.swing.JPanel();
        txtbuscar = new rojerusan.RSMetroTextFullPlaceHolder();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabladatos = new rojerusan.RSTableMetro();
        eliminarcliente = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        abrirarchivos = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnbuscar = new javax.swing.JMenu();
        configuraciones1 = new javax.swing.JMenu();
        Crearcliente = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subpanel1.setName("subpanel1"); // NOI18N
        subpanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subpanel3.setBackground(new java.awt.Color(204, 255, 204));
        subpanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        subpanel3.setForeground(new java.awt.Color(255, 255, 255));
        subpanel3.setName("subpanel3"); // NOI18N

        txtnit.setPlaceholder("NIT/CC");

        txtnombre.setPlaceholder("Nombre");

        txtllego.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtcelular1.setPlaceholder("Celular1");

        txtretiro.setPlaceholder("Retiro");
        txtretiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtretiroActionPerformed(evt);
            }
        });

        txtnotas.setColumns(20);
        txtnotas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnotas.setForeground(new java.awt.Color(0, 112, 192));
        txtnotas.setLineWrap(true);
        txtnotas.setRows(5);
        txtnotas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        txtnotas.setCaretColor(new java.awt.Color(0, 112, 192));
        jScrollPane6.setViewportView(txtnotas);

        subpanel4.setName("subpanel4"); // NOI18N

        agregarservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        agregarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarservicioActionPerformed(evt);
            }
        });

        eliminarservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N

        txtservicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tablaservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaservicios);

        tabladocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane4.setViewportView(tabladocumentos);

        agregardocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N

        eliminardocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N

        txtdocumento.setPlaceholder("Documento");

        fecha_inicio_docum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        fecha_inicio_docum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        fecha_vencimineto_docum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        fecha_vencimineto_docum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("DOCUMENTO");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("FECHA DE VENCIMIENTO");

        txtfecha_inicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        txtfecha_inicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        guardarformulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("FECHA INICIAL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha inicio");

        javax.swing.GroupLayout subpanel4Layout = new javax.swing.GroupLayout(subpanel4);
        subpanel4.setLayout(subpanel4Layout);
        subpanel4Layout.setHorizontalGroup(
            subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subpanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel4Layout.createSequentialGroup()
                        .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(subpanel4Layout.createSequentialGroup()
                                .addComponent(txtservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(subpanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtfecha_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(subpanel4Layout.createSequentialGroup()
                                .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(subpanel4Layout.createSequentialGroup()
                                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fecha_inicio_docum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(subpanel4Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel34)
                                        .addGap(48, 48, 48)))
                                .addComponent(jLabel33))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(agregarservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eliminarservicio))
                            .addComponent(guardarformulario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(subpanel4Layout.createSequentialGroup()
                        .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fecha_vencimineto_docum, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subpanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(eliminardocumento)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(agregardocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        subpanel4Layout.setVerticalGroup(
            subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subpanel4Layout.createSequentialGroup()
                .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subpanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtfecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(guardarformulario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subpanel4Layout.createSequentialGroup()
                        .addComponent(agregarservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(eliminarservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_vencimineto_docum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_inicio_docum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(subpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subpanel4Layout.createSequentialGroup()
                        .addComponent(agregardocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminardocumento))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtdv.setPlaceholder("DV");

        txtcelular2.setPlaceholder("Celular2");

        txtcodigo.setPlaceholder("Codigo");

        txtemail.setPlaceholder("Email");

        txtclase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtempresa.setPlaceholder("Empresa");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("NIT/CC");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("NOMBRE");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CELULAR");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("LLEGO");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("RETIRO");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("FECHA");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("NOTAS");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("DV");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("CODIGO");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("CELULAR");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("EMAIL");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("CLASE");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("EMPRESA");

        buttonGroup1.add(botro);
        botro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botro.setForeground(new java.awt.Color(255, 255, 255));
        botro.setText("otro");

        buttonGroup1.add(bsoftware);
        bsoftware.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bsoftware.setForeground(new java.awt.Color(255, 255, 255));
        bsoftware.setText("Software");

        buttonGroup1.add(bredes);
        bredes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bredes.setForeground(new java.awt.Color(255, 255, 255));
        bredes.setText("Redes");

        buttonGroup1.add(bequipos);
        bequipos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bequipos.setForeground(new java.awt.Color(255, 255, 255));
        bequipos.setText("Equipos");
        bequipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bequiposActionPerformed(evt);
            }
        });

        txtfecha_llegada.setBackground(new java.awt.Color(255, 51, 51));
        txtfecha_llegada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        txtfecha_llegada.setForeground(new java.awt.Color(255, 51, 51));
        txtfecha_llegada.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        txtfecha_llegada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout subpanel3Layout = new javax.swing.GroupLayout(subpanel3);
        subpanel3.setLayout(subpanel3Layout);
        subpanel3Layout.setHorizontalGroup(
            subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subpanel3Layout.createSequentialGroup()
                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subpanel3Layout.createSequentialGroup()
                        .addComponent(botro)
                        .addGap(53, 53, 53)
                        .addComponent(bsoftware)
                        .addGap(18, 18, 18)
                        .addComponent(bequipos)
                        .addGap(38, 38, 38)
                        .addComponent(bredes))
                    .addGroup(subpanel3Layout.createSequentialGroup()
                        .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subpanel3Layout.createSequentialGroup()
                                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtretiro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtllego, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtcelular1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtnit, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtfecha_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdv, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcelular2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtclase, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subpanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        subpanel3Layout.setVerticalGroup(
            subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel3Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subpanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20))
                            .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcelular2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28)))
                        .addGap(13, 13, 13)
                        .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtllego, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22)
                                .addComponent(jLabel29)))
                        .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subpanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfecha_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(subpanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel24)))
                                .addGap(11, 11, 11)
                                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtretiro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel31)))
                            .addGroup(subpanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtclase, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addComponent(subpanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(subpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bredes)
                    .addComponent(bequipos)
                    .addComponent(bsoftware)
                    .addComponent(botro))
                .addContainerGap())
        );

        subpanel1.add(subpanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 1060, 610));

        paneleditar.setBackground(new java.awt.Color(255, 204, 255));
        paneleditar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        paneleditar.setForeground(new java.awt.Color(255, 255, 255));
        paneleditar.setName("paneleditar"); // NOI18N

        txtnit1.setPlaceholder("NIT/CC");

        txtnombre1.setPlaceholder("Nombre");

        txtllego1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtcelular11.setPlaceholder("Celular1");

        txtretiro1.setPlaceholder("Retiro");
        txtretiro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtretiro1ActionPerformed(evt);
            }
        });

        txtnotas1.setColumns(20);
        txtnotas1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnotas1.setForeground(new java.awt.Color(0, 112, 192));
        txtnotas1.setLineWrap(true);
        txtnotas1.setRows(5);
        txtnotas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        txtnotas1.setCaretColor(new java.awt.Color(0, 112, 192));
        jScrollPane14.setViewportView(txtnotas1);

        subpanel6.setName("subpanel4"); // NOI18N

        agregarservicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        agregarservicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarservicio1ActionPerformed(evt);
            }
        });

        eliminarservicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N

        txtservicio1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tablaservicios1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaservicios1);

        tabladocumentos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane15.setViewportView(tabladocumentos1);

        agregardocumento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N

        eliminardocumento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N

        txtdocumento1.setPlaceholder("Documnento");

        fecha_inicio_docum1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        fecha_inicio_docum1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        fecha_vencimineto_docum1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        fecha_vencimineto_docum1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("DOCUMENTO");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("FECHA DE VENCIMINETO");

        txtfecha_inicio1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        txtfecha_inicio1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        guardarformulario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("FECHA INICIAL");

        javax.swing.GroupLayout subpanel6Layout = new javax.swing.GroupLayout(subpanel6);
        subpanel6.setLayout(subpanel6Layout);
        subpanel6Layout.setHorizontalGroup(
            subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subpanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpanel6Layout.createSequentialGroup()
                        .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(subpanel6Layout.createSequentialGroup()
                                .addComponent(txtservicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtfecha_inicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(subpanel6Layout.createSequentialGroup()
                                .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(subpanel6Layout.createSequentialGroup()
                                        .addComponent(txtdocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fecha_inicio_docum1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(subpanel6Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel37)
                                        .addGap(48, 48, 48)))
                                .addComponent(jLabel36)))
                        .addGap(18, 18, 18)
                        .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(agregarservicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eliminarservicio1))
                            .addComponent(guardarformulario1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(subpanel6Layout.createSequentialGroup()
                        .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fecha_vencimineto_docum1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subpanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(eliminardocumento1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(agregardocumento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        subpanel6Layout.setVerticalGroup(
            subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subpanel6Layout.createSequentialGroup()
                .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subpanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtservicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfecha_inicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(guardarformulario1))
                .addGap(17, 17, 17)
                .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subpanel6Layout.createSequentialGroup()
                        .addComponent(agregarservicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(eliminarservicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_vencimineto_docum1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_inicio_docum1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(subpanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subpanel6Layout.createSequentialGroup()
                        .addComponent(agregardocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminardocumento1))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtdv1.setPlaceholder("DV");

        txtcelular21.setPlaceholder("Celular2");

        txtcodigo1.setPlaceholder("Codigo");

        txtemail1.setPlaceholder("Email");

        txtclase1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtempresa1.setPlaceholder("Empresa");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("NIT/CC");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("NOMBRE");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("CELULAR");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("LLEGO");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("RETIRO");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("FECHA");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("NOTAS");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("DV");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("CODIGO");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("CELULAR");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("EMAIL");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("CLASE");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("EMPRESA");

        buttonGroup1.add(botro1);
        botro1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botro1.setForeground(new java.awt.Color(255, 255, 255));
        botro1.setText("otro");

        buttonGroup1.add(bsoftware1);
        bsoftware1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bsoftware1.setForeground(new java.awt.Color(255, 255, 255));
        bsoftware1.setText("Software");

        buttonGroup1.add(bredes1);
        bredes1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bredes1.setForeground(new java.awt.Color(255, 255, 255));
        bredes1.setText("Redes");

        buttonGroup1.add(bequipos1);
        bequipos1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bequipos1.setForeground(new java.awt.Color(255, 255, 255));
        bequipos1.setText("Equipos");
        bequipos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bequipos1ActionPerformed(evt);
            }
        });

        txtfecha_llegada1.setBackground(new java.awt.Color(255, 51, 51));
        txtfecha_llegada1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192)));
        txtfecha_llegada1.setForeground(new java.awt.Color(255, 51, 51));
        txtfecha_llegada1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        txtfecha_llegada1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout paneleditarLayout = new javax.swing.GroupLayout(paneleditar);
        paneleditar.setLayout(paneleditarLayout);
        paneleditarLayout.setHorizontalGroup(
            paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneleditarLayout.createSequentialGroup()
                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addGap(18, 18, 18)
                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneleditarLayout.createSequentialGroup()
                        .addComponent(botro1)
                        .addGap(53, 53, 53)
                        .addComponent(bsoftware1)
                        .addGap(18, 18, 18)
                        .addComponent(bequipos1)
                        .addGap(38, 38, 38)
                        .addComponent(bredes1))
                    .addGroup(paneleditarLayout.createSequentialGroup()
                        .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneleditarLayout.createSequentialGroup()
                                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtretiro1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtllego1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtcelular11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtnombre1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtnit1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtfecha_llegada1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneleditarLayout.createSequentialGroup()
                                        .addComponent(jLabel46)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneleditarLayout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdv1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneleditarLayout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcelular21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneleditarLayout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtemail1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneleditarLayout.createSequentialGroup()
                                        .addComponent(jLabel49)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtclase1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneleditarLayout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtempresa1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane14))
                        .addGap(18, 18, 18)
                        .addComponent(subpanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        paneleditarLayout.setVerticalGroup(
            paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneleditarLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneleditarLayout.createSequentialGroup()
                        .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdv1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39))
                            .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel46)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcelular11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel40))
                            .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcelular21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel47)))
                        .addGap(13, 13, 13)
                        .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtemail1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtllego1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41)
                                .addComponent(jLabel48)))
                        .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneleditarLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfecha_llegada1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43))
                                .addGap(11, 11, 11)
                                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtretiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42)))
                            .addGroup(paneleditarLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtclase1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50)
                                    .addComponent(txtempresa1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneleditarLayout.createSequentialGroup()
                        .addComponent(subpanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(paneleditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bredes1)
                    .addComponent(bequipos1)
                    .addComponent(bsoftware1)
                    .addComponent(botro1))
                .addContainerGap())
        );

        subpanel1.add(paneleditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 1060, 610));

        panelprincipal.setBackground(new java.awt.Color(255, 153, 153));
        panelprincipal.setName("panelpricipal"); // NOI18N
        panelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelprincipal.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabladatos.setRowHeight(30);
        tabladatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabladatos);

        panelprincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 1000, 460));

        eliminarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminaruser.png"))); // NOI18N
        panelprincipal.add(eliminarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 90, -1));

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        panelprincipal.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        abrirarchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/open.png"))); // NOI18N
        abrirarchivos.setBorder(null);
        abrirarchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirarchivosActionPerformed(evt);
            }
        });
        panelprincipal.add(abrirarchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 90, 80));

        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        panelprincipal.add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        subpanel1.add(panelprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 610));

        jPanel1.add(subpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 1060, 610));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rm1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 72));

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbuscarMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnbuscar);

        configuraciones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones (2).png"))); // NOI18N
        configuraciones1.setText("Configuraciones");
        configuraciones1.setPreferredSize(new java.awt.Dimension(170, 64));
        configuraciones1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configuraciones1MouseClicked(evt);
            }
        });
        jMenuBar1.add(configuraciones1);

        Crearcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/crearuser.png"))); // NOI18N
        Crearcliente.setText("Crear Cliente");
        Crearcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearclienteMouseClicked(evt);
            }
        });
        jMenuBar1.add(Crearcliente);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
//        Usuario mod = new Usuario();
//        
//        Registro_Usuario resgistrar_usuario = new Registro_Usuario(this, true);
//        UsuarioController ctrl = new UsuarioController(mod, modc, resgistrar_usuario);
//        ctrl.iniciar();
//        resgistrar_usuario.setVisible(true);
    }//GEN-LAST:event_registrarActionPerformed

    private void tabladatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladatosMouseClicked
        //        int selecionar = tabladatos.rowAtPoint(evt.getPoint());
        //        abrirarchivo(String.valueOf(tabladatos.getValueAt(selecionar, 5)));
    }//GEN-LAST:event_tabladatosMouseClicked

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        panelprincipal.setVisible(false);
        subpanel3.setVisible(false);
        paneleditar.setVisible(true);

    }//GEN-LAST:event_editarActionPerformed

    private void abrirarchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirarchivosActionPerformed

    }//GEN-LAST:event_abrirarchivosActionPerformed

    private void configuraciones1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configuraciones1MouseClicked

        ServicioController ctrl = new ServicioController(mods, servicio, vc);
        ctrl.iniciar();
        //otros

        ClaseController cctrl = new ClaseController(conc, mc, vc);
        cctrl.iniciar();

        LlegoController lc = new LlegoController(ml, conl, vc);
        lc.iniciar();
        //directorio

        DirectorioController ctrc = new DirectorioController(modc1, mod1, vc);
        ctrc.iniciar();

        ConfiguracionesController ccontroller = new ConfiguracionesController(mconfiguracion, cconfiguraciones, vc);
        ccontroller.iniciar();
        vc.setVisible(true);
    }//GEN-LAST:event_configuraciones1MouseClicked

    private void txtretiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtretiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtretiroActionPerformed

    private void agregarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarservicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarservicioActionPerformed

    private void bequiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bequiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bequiposActionPerformed

    private void CrearclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearclienteMouseClicked

       
        Cliente_PotencialController controlador = new Cliente_PotencialController(modelo, consulta,
                formulario, servicio, mods, shcp, cshcp, documento, cdocumentos,
                mconfiguracion, cconfiguraciones);
        controlador.iniciar();
//        servicios();
        panelprincipal.setVisible(false);
        subpanel3.setVisible(true);
        paneleditar.setVisible(false);

    }//GEN-LAST:event_CrearclienteMouseClicked

    private void btnbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscarMouseClicked
        panelprincipal.setVisible(true);
        subpanel3.setVisible(false);
        paneleditar.setVisible(false);
    }//GEN-LAST:event_btnbuscarMouseClicked

    private void txtretiro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtretiro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtretiro1ActionPerformed

    private void agregarservicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarservicio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarservicio1ActionPerformed

    private void bequipos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bequipos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bequipos1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Crearcliente;
    public javax.swing.JButton abrirarchivos;
    public javax.swing.JButton agregardocumento;
    public javax.swing.JButton agregardocumento1;
    public javax.swing.JButton agregarservicio;
    public javax.swing.JButton agregarservicio1;
    public javax.swing.JRadioButton bequipos;
    public javax.swing.JRadioButton bequipos1;
    public javax.swing.JRadioButton botro;
    public javax.swing.JRadioButton botro1;
    public javax.swing.JRadioButton bredes;
    public javax.swing.JRadioButton bredes1;
    public javax.swing.JRadioButton bsoftware;
    public javax.swing.JRadioButton bsoftware1;
    private javax.swing.JMenu btnbuscar;
    public javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu configuraciones1;
    public javax.swing.JButton editar;
    public javax.swing.JButton eliminarcliente;
    public javax.swing.JButton eliminardocumento;
    public javax.swing.JButton eliminardocumento1;
    public javax.swing.JButton eliminarservicio;
    public javax.swing.JButton eliminarservicio1;
    public com.toedter.calendar.JDateChooser fecha_inicio_docum;
    public com.toedter.calendar.JDateChooser fecha_inicio_docum1;
    public com.toedter.calendar.JDateChooser fecha_vencimineto_docum;
    public com.toedter.calendar.JDateChooser fecha_vencimineto_docum1;
    public javax.swing.JButton guardarformulario;
    public javax.swing.JButton guardarformulario1;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JPanel paneleditar;
    private javax.swing.JPanel panelprincipal;
    private javax.swing.JButton registrar;
    private javax.swing.JPanel subpanel1;
    public javax.swing.JPanel subpanel3;
    private javax.swing.JPanel subpanel4;
    private javax.swing.JPanel subpanel6;
    public rojerusan.RSTableMetro tabladatos;
    public rojerusan.RSTableMetro tabladocumentos;
    public rojerusan.RSTableMetro tabladocumentos1;
    public rojerusan.RSTableMetro tablaservicios;
    public rojerusan.RSTableMetro tablaservicios1;
    public rojerusan.RSMetroTextFullPlaceHolder txtbuscar;
    public rojerusan.RSMetroTextFullPlaceHolder txtcelular1;
    public rojerusan.RSMetroTextFullPlaceHolder txtcelular11;
    public rojerusan.RSMetroTextFullPlaceHolder txtcelular2;
    public rojerusan.RSMetroTextFullPlaceHolder txtcelular21;
    public rojerusan.RSComboMetro txtclase;
    public rojerusan.RSComboMetro txtclase1;
    public rojerusan.RSMetroTextFullPlaceHolder txtcodigo;
    public rojerusan.RSMetroTextFullPlaceHolder txtcodigo1;
    public rojerusan.RSMetroTextFullPlaceHolder txtdocumento;
    public rojerusan.RSMetroTextFullPlaceHolder txtdocumento1;
    public rojerusan.RSMetroTextFullPlaceHolder txtdv;
    public rojerusan.RSMetroTextFullPlaceHolder txtdv1;
    public rojerusan.RSMetroTextFullPlaceHolder txtemail;
    public rojerusan.RSMetroTextFullPlaceHolder txtemail1;
    public rojerusan.RSMetroTextFullPlaceHolder txtempresa;
    public rojerusan.RSMetroTextFullPlaceHolder txtempresa1;
    public com.toedter.calendar.JDateChooser txtfecha_inicio;
    public com.toedter.calendar.JDateChooser txtfecha_inicio1;
    public com.toedter.calendar.JDateChooser txtfecha_llegada;
    public com.toedter.calendar.JDateChooser txtfecha_llegada1;
    public rojerusan.RSComboMetro txtllego;
    public rojerusan.RSComboMetro txtllego1;
    public rojerusan.RSMetroTextFullPlaceHolder txtnit;
    public rojerusan.RSMetroTextFullPlaceHolder txtnit1;
    public rojerusan.RSMetroTextFullPlaceHolder txtnombre;
    public rojerusan.RSMetroTextFullPlaceHolder txtnombre1;
    public javax.swing.JTextArea txtnotas;
    public javax.swing.JTextArea txtnotas1;
    public rojerusan.RSMetroTextFullPlaceHolder txtretiro;
    public rojerusan.RSMetroTextFullPlaceHolder txtretiro1;
    public rojerusan.RSComboMetro txtservicio;
    public rojerusan.RSComboMetro txtservicio1;
    // End of variables declaration//GEN-END:variables
}
