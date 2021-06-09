/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Consultas.Consultas_usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelo.Usuario;

/**
 *
 * @author Yonathan Carvajal
 */
public class Principal extends javax.swing.JFrame {

    Usuario modu;
    Consultas_usuario cons;

    public void transparecia() {
        configuraciones1.setOpaque(false);
        configuraciones1.setContentAreaFilled(false);
//        configuraciones1.setBorderPainted(false);
        
        crearcliente.setOpaque(false);
        crearcliente.setContentAreaFilled(false);
//        crearcliente.setBorderPainted(false);

        otro.setOpaque(false);
        otro.setContentAreaFilled(false);
        
        servicios.setOpaque(false);
        servicios.setContentAreaFilled(false);
        
        crearusuario.setOpaque(false);
        crearusuario.setContentAreaFilled(false);
        
        carpetas.setOpaque(false);
        carpetas.setContentAreaFilled(false);
        
        abrirarchivos.setOpaque(false);
        abrirarchivos.setContentAreaFilled(false);
        
        editar.setOpaque(false);
        editar.setContentAreaFilled(false);

//        crearcliente.setOpaque(false);
        panelprincipal.setOpaque(false);
//        crearcliente.setContentAreaFilled(false);

    }
//   DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    public Principal(Usuario modu) {
        initComponents();
        transparecia();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamanio = tk.getScreenSize();
        int ancho = (int) tamanio.getWidth();
        int alto = (int) tamanio.getHeight();
        this.setSize(new Dimension(ancho, alto));
        
        ImageIcon rm = new ImageIcon(getClass().getResource("/img/fondo2.png"));
        Icon fondo = new ImageIcon(rm.getImage().getScaledInstance(this.getWidth(), alto, Image.SCALE_DEFAULT));
        jLabel1.setIcon(fondo);
       
        
        this.modu = modu;
//        System.out.println(modu.getConfiguraciones());
        if (modu.getRol() == 1) {
        } else {
            if (modu.getRol() == 2) {
                if (modu.getConfiguraciones() == 0) {
                    configuraciones1.setVisible(false);
                }
                if (modu.getCrearcliente() == 0) {
                    crearcliente.setVisible(false);
                }
                if (modu.getCarpetas() == 0) {
                    carpetas.setVisible(false);
                }
                if (modu.getServicios() == 0) {
                    servicios.setVisible(false);
                }
                if (modu.getOtros() == 0) {
                    otro.setVisible(false);
                }
                if (modu.getCrearusuarios() == 0) {
                    crearusuario.setVisible(false);
                }
            }
        }
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
        crearcliente = new javax.swing.JButton();
        configuraciones1 = new javax.swing.JButton();
        servicios = new javax.swing.JButton();
        crearusuario = new javax.swing.JButton();
        carpetas = new javax.swing.JButton();
        otro = new javax.swing.JButton();
        panelprincipal = new javax.swing.JPanel();
        txtbuscar = new rojerusan.RSMetroTextFullPlaceHolder();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabladatos = new rojerusan.RSTableMetro();
        editar = new javax.swing.JButton();
        abrirarchivos = new javax.swing.JButton();
        filtro = new rojerusan.RSComboMetro();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setExtendedState(MAXIMIZED_BOTH);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        crearcliente.setForeground(new java.awt.Color(255, 255, 255));
        crearcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clienteadd.png"))); // NOI18N
        crearcliente.setText("Crearcliente");
        crearcliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        crearcliente.setOpaque(false);
        jPanel1.add(crearcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 170, 70));

        configuraciones1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        configuraciones1.setForeground(new java.awt.Color(255, 255, 255));
        configuraciones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones (2).png"))); // NOI18N
        configuraciones1.setText("Directorio");
        configuraciones1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        configuraciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuraciones1ActionPerformed(evt);
            }
        });
        jPanel1.add(configuraciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 170, 70));

        servicios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        servicios.setForeground(new java.awt.Color(255, 255, 255));
        servicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/service.png"))); // NOI18N
        servicios.setText("Servicios");
        servicios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 170, 70));

        crearusuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        crearusuario.setForeground(new java.awt.Color(255, 255, 255));
        crearusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/useradd.png"))); // NOI18N
        crearusuario.setText("Usuarios");
        crearusuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(crearusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 170, -1));

        carpetas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        carpetas.setForeground(new java.awt.Color(255, 255, 255));
        carpetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folders.png"))); // NOI18N
        carpetas.setText("Carpetas");
        carpetas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(carpetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 170, 70));

        otro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        otro.setForeground(new java.awt.Color(255, 255, 255));
        otro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/otros.png"))); // NOI18N
        otro.setText("Otros");
        otro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(otro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 170, 70));

        panelprincipal.setBackground(new java.awt.Color(255, 153, 153));
        panelprincipal.setMaximumSize(new java.awt.Dimension(1280, 1080));
        panelprincipal.setName("panelpricipal"); // NOI18N
        panelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtbuscar.setBorderColor(new java.awt.Color(102, 102, 102));
        txtbuscar.setPhColor(new java.awt.Color(210, 43, 7));
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
        tabladatos.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        tabladatos.setColorFilasForeground1(new java.awt.Color(216, 74, 44));
        tabladatos.setColorFilasForeground2(new java.awt.Color(216, 74, 44));
        tabladatos.setColorSelBackgound(new java.awt.Color(216, 74, 44));
        tabladatos.setRowHeight(30);
        tabladatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabladatos);

        panelprincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 1000, 460));

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 43, 7), 2));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        panelprincipal.add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 90, 70));

        abrirarchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/open.png"))); // NOI18N
        abrirarchivos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 43, 7), 2));
        abrirarchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirarchivosActionPerformed(evt);
            }
        });
        panelprincipal.add(abrirarchivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 90, 70));

        filtro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nit\t", "nombre", "codigo" }));
        filtro.setColorArrow(new java.awt.Color(0, 0, 0));
        filtro.setColorBorde(new java.awt.Color(102, 102, 102));
        filtro.setColorFondo(new java.awt.Color(102, 102, 102));
        filtro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelprincipal.add(filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 220, 40));

        jPanel1.add(panelprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, 830));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void configuraciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuraciones1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_configuraciones1ActionPerformed

    private void tabladatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladatosMouseClicked
        //                int selecionar = tabladatos.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tabladatosMouseClicked

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed

    }//GEN-LAST:event_editarActionPerformed

    private void abrirarchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirarchivosActionPerformed

    }//GEN-LAST:event_abrirarchivosActionPerformed

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
    public javax.swing.JButton abrirarchivos;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JButton carpetas;
    public javax.swing.JButton configuraciones1;
    public javax.swing.JButton crearcliente;
    public javax.swing.JButton crearusuario;
    public javax.swing.JButton editar;
    public rojerusan.RSComboMetro filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JButton otro;
    private javax.swing.JPanel panelprincipal;
    public javax.swing.JButton servicios;
    public rojerusan.RSTableMetro tabladatos;
    public rojerusan.RSMetroTextFullPlaceHolder txtbuscar;
    // End of variables declaration//GEN-END:variables
}
