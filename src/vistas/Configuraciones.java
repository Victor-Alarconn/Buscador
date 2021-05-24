/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Consultas.Consultas_Servicio;
import Consultas.Consultas_usuario;
import controlador.ServicioController;
import controlador.UsuarioController;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import modelo.Servicio;
import modelo.Usuario;

/**
 *
 * @author yonathan
 */
public class Configuraciones extends javax.swing.JDialog {

    Usuario modu;
    Consultas_usuario cons;

    public void transparecia() {
        panel2panel1.setOpaque(false);
    }

    /**
     * Creates new form Configuraciones
     */
    public Configuraciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        transparecia();
        this.setResizable(false);
//        this.setSize(new Dimension(ancho,alto));
         this.setResizable(false);
        ImageIcon rm = new ImageIcon(getClass().getResource("/img/rm1.jpg"));
        Icon fondo = new ImageIcon(rm.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(fondo);
//        labelc.setIcon(fondo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        panel2panel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtprefijo = new rojerusan.RSMetroTextFullPlaceHolder();
        txtdirectorio = new rojerusan.RSMetroTextFullPlaceHolder();
        buscar = new rojerusan.RSMaterialButtonRound();
        guardarconfiguracion = new rojerusan.RSMaterialButtonRound();
        jLabel1 = new javax.swing.JLabel();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel2panel1.setName("panel2panel1"); // NOI18N
        panel2panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Directorio");
        panel2panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 83, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Prefijo");
        panel2panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 163, -1, -1));

        txtprefijo.setPlaceholder("Escribe un prefijo");
        panel2panel1.add(txtprefijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 153, 370, -1));

        txtdirectorio.setPlaceholder("Directorio");
        panel2panel1.add(txtdirectorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 73, 370, -1));

        buscar.setText("buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        panel2panel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 63, 230, 60));

        guardarconfiguracion.setText("Guardar");
        guardarconfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarconfiguracionActionPerformed(evt);
            }
        });
        panel2panel1.add(guardarconfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 143, 230, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(panel2panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(panel2panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setCurrentDirectory(new File("c:\\"));
        jf.setDialogTitle("Selecione una carpeta");
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.setAcceptAllFileFilterUsed(false);
        if (jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = jf.getSelectedFile();
            txtdirectorio.setText(archivo.getPath());
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void guardarconfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarconfiguracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarconfiguracionActionPerformed

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
            java.util.logging.Logger.getLogger(Configuraciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuraciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuraciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuraciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Configuraciones dialog = new Configuraciones(new javax.swing.JFrame(), true);
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
    private rojerusan.RSMaterialButtonRound buscar;
    public rojerusan.RSMaterialButtonRound guardarconfiguracion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel panel2panel1;
    public rojerusan.RSMetroTextFullPlaceHolder txtdirectorio;
    public rojerusan.RSMetroTextFullPlaceHolder txtprefijo;
    // End of variables declaration//GEN-END:variables
}
