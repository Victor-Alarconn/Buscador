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
public class Crearusuario extends javax.swing.JDialog {

    public void transparecia() {
        paneluser.setOpaque(false);
    }
    
    /**
     * Creates new form Crearcliente
     */
    public Crearusuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
//        ImageIcon rm = new ImageIcon(getClass().getResource("/img/rm1.jpg"));
//        Icon fondo = new ImageIcon(rm.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
//        jLabel1.setIcon(fondo);
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

        paneluser = new javax.swing.JPanel();
        txtnombre = new rojerusan.RSMetroTextFullPlaceHolder();
        txtapellido = new rojerusan.RSMetroTextFullPlaceHolder();
        txtdocumento = new rojerusan.RSMetroTextFullPlaceHolder();
        txtcontraseña = new rojerusan.RSPasswordTextPlaceHolder();
        txtrol = new rojerusan.RSComboMetro();
        guardaruser = new javax.swing.JButton();
        checkconfiguraciones = new javax.swing.JCheckBox();
        checkcrearcliente = new javax.swing.JCheckBox();
        checkcarpetas = new javax.swing.JCheckBox();
        checkservicios = new javax.swing.JCheckBox();
        checkotros = new javax.swing.JCheckBox();
        checkcrearusuario = new javax.swing.JCheckBox();
        checkbuscar = new javax.swing.JCheckBox();
        checkeditarcliente = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        paneluser.setBackground(new java.awt.Color(102, 255, 102));
        paneluser.setName("paneluser"); // NOI18N

        txtnombre.setPlaceholder("Nombre");

        txtapellido.setPlaceholder("Apellido");

        txtdocumento.setPlaceholder("Documento");

        txtcontraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 2));
        txtcontraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcontraseña.setPlaceholder("Contraseña");
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });

        txtrol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtrol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtrolItemStateChanged(evt);
            }
        });

        guardaruser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        guardaruser.setText("Guardar");

        checkconfiguraciones.setText("Configuraciones");

        checkcrearcliente.setText("Crear Cliente");

        checkcarpetas.setText("Carpetas");

        checkservicios.setText("Servicios");

        checkotros.setText("Otros");
        checkotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkotrosActionPerformed(evt);
            }
        });

        checkcrearusuario.setText("Crear usuario");

        checkbuscar.setText("Buscar");

        checkeditarcliente.setText("Editar Cliente");

        javax.swing.GroupLayout paneluserLayout = new javax.swing.GroupLayout(paneluser);
        paneluser.setLayout(paneluserLayout);
        paneluserLayout.setHorizontalGroup(
            paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneluserLayout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtrol, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guardaruser))
                .addGap(57, 57, 57)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneluserLayout.createSequentialGroup()
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkconfiguraciones)
                            .addComponent(checkcarpetas)
                            .addComponent(checkcrearusuario))
                        .addGap(18, 18, 18)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneluserLayout.createSequentialGroup()
                                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkbuscar)
                                    .addComponent(checkservicios))
                                .addGap(22, 22, 22)
                                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkcrearcliente)
                                    .addComponent(checkeditarcliente)))
                            .addComponent(checkotros)))
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        paneluserLayout.setVerticalGroup(
            paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneluserLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneluserLayout.createSequentialGroup()
                        .addComponent(txtrol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardaruser))
                    .addGroup(paneluserLayout.createSequentialGroup()
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkconfiguraciones)
                            .addComponent(checkcrearcliente)
                            .addComponent(checkservicios))
                        .addGap(18, 18, 18)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkcarpetas)
                            .addComponent(checkeditarcliente)
                            .addComponent(checkbuscar))
                        .addGap(18, 18, 18)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkcrearusuario)
                            .addComponent(checkotros))))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(paneluser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(paneluser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkotrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkotrosActionPerformed

    private void txtrolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtrolItemStateChanged

    }//GEN-LAST:event_txtrolItemStateChanged

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaActionPerformed

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
            java.util.logging.Logger.getLogger(Crearusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crearusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crearusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crearusuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Crearusuario dialog = new Crearusuario(new javax.swing.JFrame(), true);
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
    public javax.swing.JCheckBox checkbuscar;
    public javax.swing.JCheckBox checkcarpetas;
    public javax.swing.JCheckBox checkconfiguraciones;
    public javax.swing.JCheckBox checkcrearcliente;
    public javax.swing.JCheckBox checkcrearusuario;
    public javax.swing.JCheckBox checkeditarcliente;
    public javax.swing.JCheckBox checkotros;
    public javax.swing.JCheckBox checkservicios;
    public javax.swing.JButton guardaruser;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel paneluser;
    public rojerusan.RSMetroTextFullPlaceHolder txtapellido;
    public rojerusan.RSPasswordTextPlaceHolder txtcontraseña;
    public rojerusan.RSMetroTextFullPlaceHolder txtdocumento;
    public rojerusan.RSMetroTextFullPlaceHolder txtnombre;
    public rojerusan.RSComboMetro txtrol;
    // End of variables declaration//GEN-END:variables
}
