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
        checkeditarcliente = new javax.swing.JCheckBox();
        checkdesactivar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        checkmodalidad = new javax.swing.JCheckBox();
        checkbuscar = new javax.swing.JCheckBox();
        checkbackups = new javax.swing.JCheckBox();
        checkcotizaciones = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        paneluser.setBackground(new java.awt.Color(102, 255, 102));
        paneluser.setName("paneluser"); // NOI18N

        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        txtnombre.setBorderColor(new java.awt.Color(102, 102, 102));
        txtnombre.setPhColor(new java.awt.Color(216, 74, 44));
        txtnombre.setPlaceholder("Nombre");

        txtapellido.setForeground(new java.awt.Color(0, 0, 0));
        txtapellido.setBorderColor(new java.awt.Color(102, 102, 102));
        txtapellido.setPhColor(new java.awt.Color(216, 74, 44));
        txtapellido.setPlaceholder("Apellido");

        txtdocumento.setForeground(new java.awt.Color(0, 0, 0));
        txtdocumento.setBorderColor(new java.awt.Color(102, 102, 102));
        txtdocumento.setPhColor(new java.awt.Color(216, 74, 44));
        txtdocumento.setPlaceholder("Documento");

        txtcontraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        txtcontraseña.setForeground(new java.awt.Color(0, 0, 0));
        txtcontraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcontraseña.setPhColor(new java.awt.Color(216, 74, 44));
        txtcontraseña.setPlaceholder("Contraseña");
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });

        txtrol.setColorArrow(new java.awt.Color(0, 0, 0));
        txtrol.setColorBorde(new java.awt.Color(102, 102, 102));
        txtrol.setColorFondo(new java.awt.Color(102, 102, 102));
        txtrol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtrol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtrolItemStateChanged(evt);
            }
        });

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

        checkservicios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkservicios.setText("Servicios");

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

        checkmodalidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkmodalidad.setText("Modalidad");

        checkbuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkbuscar.setText("Buscar");

        checkbackups.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkbackups.setText("Backups");

        checkcotizaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkcotizaciones.setText("Cotizaciones");

        javax.swing.GroupLayout paneluserLayout = new javax.swing.GroupLayout(paneluser);
        paneluser.setLayout(paneluserLayout);
        paneluserLayout.setHorizontalGroup(
            paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneluserLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtrol, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneluserLayout.createSequentialGroup()
                        .addComponent(guardaruser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkdesactivar)))
                .addGap(57, 57, 57)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneluserLayout.createSequentialGroup()
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkconfiguraciones)
                            .addComponent(checkcarpetas)
                            .addComponent(checkcrearusuario)
                            .addComponent(checkbackups))
                        .addGap(18, 18, 18)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkcotizaciones)
                            .addComponent(checkotros)
                            .addGroup(paneluserLayout.createSequentialGroup()
                                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkservicios)
                                    .addComponent(checkmodalidad))
                                .addGap(22, 22, 22)
                                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkbuscar)
                                    .addComponent(checkcrearcliente)
                                    .addComponent(checkeditarcliente))))))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneluserLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGap(15, 15, 15)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guardaruser)
                            .addComponent(checkdesactivar)))
                    .addGroup(paneluserLayout.createSequentialGroup()
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkconfiguraciones)
                            .addComponent(checkcrearcliente)
                            .addComponent(checkservicios))
                        .addGap(18, 18, 18)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkcarpetas)
                            .addComponent(checkeditarcliente)
                            .addComponent(checkotros))
                        .addGap(18, 18, 18)
                        .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkcrearusuario)
                            .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(checkmodalidad)
                                .addComponent(checkbuscar)))))
                .addGap(18, 18, 18)
                .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkbackups)
                    .addComponent(checkcotizaciones))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(paneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paneluserLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneluser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneluser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaActionPerformed

    private void txtrolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtrolItemStateChanged

    }//GEN-LAST:event_txtrolItemStateChanged

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
    public javax.swing.JCheckBox checkcotizaciones;
    public javax.swing.JCheckBox checkcrearcliente;
    public javax.swing.JCheckBox checkcrearusuario;
    public javax.swing.JCheckBox checkdesactivar;
    public javax.swing.JCheckBox checkeditarcliente;
    public javax.swing.JCheckBox checkmodalidad;
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
