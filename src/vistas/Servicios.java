/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Yonathan Carvajal
 */
public class Servicios extends javax.swing.JDialog {

    public void transparecia() {
        eliminartablaservico.setOpaque(false);
        eliminartablaservico.setContentAreaFilled(false);
        eliminartablaservico.setBorderPainted(false);

        registrarservicio.setOpaque(false);
        registrarservicio.setContentAreaFilled(false);
        registrarservicio.setBorderPainted(false);

        eliminartablaagregarservicio.setOpaque(false);
        eliminartablaagregarservicio.setContentAreaFilled(false);
        eliminartablaagregarservicio.setBorderPainted(false);

        guardarservicios.setOpaque(false);
        guardarservicios.setContentAreaFilled(false);
        guardarservicios.setBorderPainted(false);

        panel2panel2.setOpaque(false);
    }
    
    /**
     * Creates new form SE
     */
    public Servicios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        ImageIcon rm = new ImageIcon(getClass().getResource("/img/rm1.jpg"));
        Icon fondo = new ImageIcon(rm.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(fondo);
        transparecia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2panel2 = new javax.swing.JPanel();
        registrarservicio = new javax.swing.JButton();
        txtregistroservicio = new rojerusan.RSMetroTextFullPlaceHolder();
        eliminartablaservico = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablatotalservicios = new rojerusan.RSTableMetro();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaagregarservicios = new rojerusan.RSTableMetro();
        eliminartablaagregarservicio = new javax.swing.JButton();
        guardarservicios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel2panel2.setBackground(new java.awt.Color(204, 204, 0));
        panel2panel2.setName("panel2panel2"); // NOI18N
        panel2panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrarservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        panel2panel2.add(registrarservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, 57));
        panel2panel2.add(txtregistroservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 280, 57));

        eliminartablaservico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        panel2panel2.add(eliminartablaservico, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        tablatotalservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tablatotalservicios.setRowHeight(30);
        jScrollPane8.setViewportView(tablatotalservicios);

        panel2panel2.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 276, 420));

        tablaagregarservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tablaagregarservicios.setRowHeight(30);
        jScrollPane9.setViewportView(tablaagregarservicios);

        panel2panel2.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 280, 357));

        eliminartablaagregarservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        panel2panel2.add(eliminartablaagregarservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 65, -1));

        guardarservicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        panel2panel2.add(guardarservicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 72, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panel2panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panel2panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java Servicios 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Servicios dialog = new Servicios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton eliminartablaagregarservicio;
    public javax.swing.JButton eliminartablaservico;
    public javax.swing.JButton guardarservicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel panel2panel2;
    public javax.swing.JButton registrarservicio;
    public rojerusan.RSTableMetro tablaagregarservicios;
    public rojerusan.RSTableMetro tablatotalservicios;
    public rojerusan.RSMetroTextFullPlaceHolder txtregistroservicio;
    // End of variables declaration//GEN-END:variables
}
