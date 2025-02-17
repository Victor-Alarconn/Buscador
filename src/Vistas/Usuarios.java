/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author yonathan
 */
public class Usuarios extends javax.swing.JDialog {

    public void transparencia() {
        crearusuario.setOpaque(false);
        crearusuario.setContentAreaFilled(false);

        ediataruser.setOpaque(false);
        ediataruser.setContentAreaFilled(false);

        eliminaruser.setOpaque(false);
        eliminaruser.setContentAreaFilled(false);
    }

    /**
     * Creates new form Usuarios
     */
    public Usuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        transparencia();
         
//        this.setResizable(false);
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

        jPanel1 = new javax.swing.JPanel();
        ediataruser = new javax.swing.JButton();
        eliminaruser = new javax.swing.JButton();
        crearusuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        filtro = new javax.swing.JComboBox<>();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablauser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ediataruser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editaruser32.png"))); // NOI18N
        ediataruser.setText("editar");
        ediataruser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(ediataruser, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 100, 40));

        eliminaruser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminaruser32.png"))); // NOI18N
        eliminaruser.setText("eliminar");
        eliminaruser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(eliminaruser, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 100, 40));

        crearusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/crearuser32.png"))); // NOI18N
        crearusuario.setText("crear");
        crearusuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        jPanel1.add(crearusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 90, 40));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nombre", "apellido", "numero_documento" }));
        jPanel1.add(filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 160, 25));
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 25));

        tablauser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablauser);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 760, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuarios dialog = new Usuarios(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton crearusuario;
    public javax.swing.JButton ediataruser;
    public javax.swing.JButton eliminaruser;
    public javax.swing.JComboBox<String> filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablauser;
    public javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
