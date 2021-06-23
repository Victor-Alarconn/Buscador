/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author Yonathan Carvajal
 */
public class VModalidad extends javax.swing.JDialog {

    
    public void transparecia() {
        panelotros.setOpaque(false);

        eliminaragregarmodalidad.setOpaque(false);
        eliminaragregarmodalidad.setContentAreaFilled(false);

        eliminarmodalidad.setOpaque(false);
        eliminarmodalidad.setContentAreaFilled(false);

        agregarmodalidad.setOpaque(false);
        agregarmodalidad.setContentAreaFilled(false);

        

        guardarmodalidad.setOpaque(false);
        guardarmodalidad.setContentAreaFilled(false);

    }
    
    
    /**
     * Creates new form Otros1
     */
    public VModalidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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

        panelotros = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablamodalidad = new javax.swing.JTable();
        eliminarmodalidad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaagregarmodalidad = new javax.swing.JTable();
        txtregistrarmodalidad = new javax.swing.JTextField();
        agregarmodalidad = new javax.swing.JButton();
        eliminaragregarmodalidad = new javax.swing.JButton();
        guardarmodalidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelotros.setBackground(new java.awt.Color(0, 102, 102));
        panelotros.setName("panelotros"); // NOI18N
        panelotros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablamodalidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(tablamodalidad);

        panelotros.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 210));

        eliminarmodalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        eliminarmodalidad.setText("Eliminar");
        eliminarmodalidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 43, 7), 2, true));
        panelotros.add(eliminarmodalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, -1));

        tablaagregarmodalidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(tablaagregarmodalidad);

        panelotros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 170, 180));
        panelotros.add(txtregistrarmodalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 170, -1));

        agregarmodalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        agregarmodalidad.setText("Agregar");
        agregarmodalidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 43, 7), 2));
        panelotros.add(agregarmodalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 110, 57));

        eliminaragregarmodalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        eliminaragregarmodalidad.setText("Eliminar");
        eliminaragregarmodalidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 43, 7), 2));
        panelotros.add(eliminaragregarmodalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 110, -1));

        guardarmodalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        guardarmodalidad.setText("Guardar");
        guardarmodalidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 43, 7), 2));
        panelotros.add(guardarmodalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelotros, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelotros, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(VModalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VModalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VModalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VModalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VModalidad dialog = new VModalidad(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton agregarmodalidad;
    public javax.swing.JButton eliminaragregarmodalidad;
    public javax.swing.JButton eliminarmodalidad;
    public javax.swing.JButton guardarmodalidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelotros;
    public javax.swing.JTable tablaagregarmodalidad;
    public javax.swing.JTable tablamodalidad;
    public javax.swing.JTextField txtregistrarmodalidad;
    // End of variables declaration//GEN-END:variables
}
