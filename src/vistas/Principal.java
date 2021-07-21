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
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
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

        crearusuario.setOpaque(false);
        crearusuario.setContentAreaFilled(false);

        busqueda.setOpaque(false);
        busqueda.setContentAreaFilled(false);


        carpetas.setOpaque(false);
        carpetas.setContentAreaFilled(false);

        backup.setOpaque(false);
        backup.setContentAreaFilled(false);

        btnterminar.setOpaque(false);
        btnterminar.setContentAreaFilled(false);

        Cotizaciones.setOpaque(false);
        Cotizaciones.setContentAreaFilled(false);

        jPanel2.setOpaque(false);

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
        BufferedImage image = null;
        Image icon = new ImageIcon(getClass().getResource("/img/Organize.png")).getImage();
        setIconImage(icon);
        
        this.getRootPane().registerKeyboardAction(e -> {
            this.dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamanio = tk.getScreenSize();
        int ancho = (int) tamanio.getWidth();
        int alto = (int) tamanio.getHeight();
        this.setSize(new Dimension(ancho, alto));
        jPanel2.setPreferredSize(new Dimension(ancho, 70));

        ImageIcon rm = new ImageIcon(getClass().getResource("/img/fondo2.png"));
        Icon fondo = new ImageIcon(rm.getImage().getScaledInstance(this.getWidth(), alto, Image.SCALE_DEFAULT));

        jLabel1.setIcon(fondo);

        this.modu = modu;
//        System.out.println(modu.getConfiguraciones());

        if (modu.getRol()
                == 1) {
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
                if (modu.getOtros() == 0) {
                    otro.setVisible(false);
                }
                if (modu.getCrearusuarios() == 0) {
                    crearusuario.setVisible(false);
                }
                if (modu.getBuscar() == 0) {
                    busqueda.setVisible(false);
                }
                if (modu.getBackups() == 0) {
                    backup.setVisible(false);
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
        crearusuario = new javax.swing.JButton();
        carpetas = new javax.swing.JButton();
        otro = new javax.swing.JButton();
        busqueda = new javax.swing.JButton();
        backup = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnterminar = new javax.swing.JButton();
        Cotizaciones = new javax.swing.JButton();
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
        jPanel1.add(crearcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 170, 70));

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
        jPanel1.add(configuraciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 170, 70));

        crearusuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        crearusuario.setForeground(new java.awt.Color(255, 255, 255));
        crearusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/useradd.png"))); // NOI18N
        crearusuario.setText("Usuarios");
        crearusuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        crearusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearusuarioActionPerformed(evt);
            }
        });
        jPanel1.add(crearusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 170, -1));

        carpetas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        carpetas.setForeground(new java.awt.Color(255, 255, 255));
        carpetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folders.png"))); // NOI18N
        carpetas.setText("Carpetas");
        carpetas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(carpetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 170, 70));

        otro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        otro.setForeground(new java.awt.Color(255, 255, 255));
        otro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/otros.png"))); // NOI18N
        otro.setText("Otros");
        otro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(otro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 170, 70));

        busqueda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        busqueda.setForeground(new java.awt.Color(255, 255, 255));
        busqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_1.png"))); // NOI18N
        busqueda.setText("Buscar");
        busqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        busqueda.setOpaque(false);
        jPanel1.add(busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 170, 70));

        backup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backup.setForeground(new java.awt.Color(255, 255, 255));
        backup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Backup-64.png"))); // NOI18N
        backup.setText("Backup's");
        backup.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        backup.setOpaque(false);
        jPanel1.add(backup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 170, 70));

        jPanel2.setBackground(new java.awt.Color(209, 235, 247));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Organizador");

        btnterminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnterminar.setForeground(new java.awt.Color(255, 255, 255));
        btnterminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir48px.png"))); // NOI18N
        btnterminar.setText("Terminar");
        btnterminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        btnterminar.setOpaque(false);
        btnterminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                .addComponent(btnterminar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnterminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        Cotizaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cotizaciones.setForeground(new java.awt.Color(255, 255, 255));
        Cotizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cotizacion-64.png"))); // NOI18N
        Cotizaciones.setText("Cotizaciones");
        Cotizaciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        Cotizaciones.setOpaque(false);
        jPanel1.add(Cotizaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 170, 70));
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

    private void crearusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearusuarioActionPerformed

    private void btnterminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnterminarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public javax.swing.JButton Cotizaciones;
    public javax.swing.JButton backup;
    public javax.swing.JButton btnterminar;
    public javax.swing.JButton busqueda;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JButton carpetas;
    public javax.swing.JButton configuraciones1;
    public javax.swing.JButton crearcliente;
    public javax.swing.JButton crearusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JButton otro;
    // End of variables declaration//GEN-END:variables

}
