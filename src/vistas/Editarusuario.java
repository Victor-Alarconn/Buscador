/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author yonathan
 */
public class Editarusuario extends javax.swing.JDialog {

    public void transparecia() {
        paneluser.setOpaque(false);
        
        guardaruser.setOpaque(false);
        guardaruser.setContentAreaFilled(false);
    }
    
    /**
     * Creates new form Ediatarusuario
     */
    public Editarusuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        transparecia();
        this.setResizable(false);
//        ImageIcon rm = new ImageIcon(getClass().getResource("/img/rm1.jpg"));
//        Icon fondo = new ImageIcon(rm.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
//        jLabel1.setIcon(fondo);
this.getRootPane().registerKeyboardAction(e -> {
            this.dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneluser = new javax.swing.JPanel();
        guardaruser = new javax.swing.JButton();
        checkconfiguraciones = new javax.swing.JCheckBox();
        checkcrearcliente = new javax.swing.JCheckBox();
        checkcarpetas = new javax.swing.JCheckBox();
        checkotros = new javax.swing.JCheckBox();
        checkcrearusuario = new javax.swing.JCheckBox();
        checkeditarcliente = new javax.swing.JCheckBox();
        checkdesactivar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        checkbuscar = new javax.swing.JCheckBox();
        checkbackups = new javax.swing.JCheckBox();
        txtnombre = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JPasswordField();
        txtrol = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        paneluser.setBackground(new java.awt.Color(102, 255, 102));
        paneluser.setName("paneluser"); // NOI18N

        guardaruser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        guardaruser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        guardaruser.setText("Guardar");
        guardaruser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(216, 74, 44), 2, true));

        checkconfiguraciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkconfiguraciones.setText("Configuraciones");

        checkcrearcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkcrearcliente.setText("Crear Cliente");

        checkcarpetas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkcarpetas.setText("Carpetas");

        checkotros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkotros.setText("Otros");
        checkotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkotrosActionPerformed(evt);
            }
        });

        checkcrearusuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkcrearusuario.setText("Crear usuario");

        checkeditarcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkeditarcliente.setText("Editar Cliente");

        checkdesactivar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkdesactivar.setText("Desactivar");

        checkbuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkbuscar.setText("Buscar");

        checkbackups.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkbackups.setText("Backups");

        txtrol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña");

        javax.swing.GroupLayout paneluserLayout = new javax.swing.GroupLayout(paneluser);
        paneluser.setLayout(paneluserLayout);
        paneluserLayout.setHorizontalGroup(
            paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneluserLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(paneluserLayout.createSequentialGroup()
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtrol, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(txtcontraseña))
                            .addGroup(paneluserLayout.createSequentialGroup()
                                .addComponent(guardaruser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkdesactivar))
                            .addComponent(jLabel3))
                        .addGap(44, 44, 44)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkconfiguraciones)
                            .addComponent(checkcarpetas)
                            .addComponent(checkcrearusuario))
                        .addGap(18, 18, 18)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkotros)
                            .addGroup(paneluserLayout.createSequentialGroup()
                                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkbackups)
                                    .addComponent(checkbuscar))
                                .addGap(34, 34, 34)
                                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkcrearcliente)
                                    .addComponent(checkeditarcliente))))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneluserLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 379, Short.MAX_VALUE)))
        );
        paneluserLayout.setVerticalGroup(
            paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneluserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtrol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardaruser)
                    .addComponent(checkdesactivar))
                .addGap(15, 15, 15))
            .addGroup(paneluserLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkconfiguraciones)
                    .addComponent(checkcrearcliente)
                    .addComponent(checkbuscar))
                .addGap(18, 18, 18)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkcarpetas)
                    .addComponent(checkeditarcliente)
                    .addComponent(checkotros))
                .addGap(18, 18, 18)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkcrearusuario)
                    .addComponent(checkbackups))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneluserLayout.createSequentialGroup()
                    .addGap(0, 43, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 216, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneluser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneluser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkotrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkotrosActionPerformed

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
            java.util.logging.Logger.getLogger(Editarusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editarusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editarusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editarusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Editarusuario dialog = new Editarusuario(new javax.swing.JFrame(), true);
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
    public javax.swing.JCheckBox checkbackups;
    public javax.swing.JCheckBox checkbuscar;
    public javax.swing.JCheckBox checkcarpetas;
    public javax.swing.JCheckBox checkconfiguraciones;
    public javax.swing.JCheckBox checkcrearcliente;
    public javax.swing.JCheckBox checkcrearusuario;
    public javax.swing.JCheckBox checkdesactivar;
    public javax.swing.JCheckBox checkeditarcliente;
    public javax.swing.JCheckBox checkotros;
    public javax.swing.JButton guardaruser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPanel paneluser;
    public javax.swing.JPasswordField txtcontraseña;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JComboBox txtrol;
    // End of variables declaration//GEN-END:variables
}
