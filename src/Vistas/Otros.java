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
 * @author Yonathan Carvajal
 */
public class Otros extends javax.swing.JDialog {

    public void transparecia() {
        panelotros.setOpaque(false);

    }

    /**
     * Creates new form Otros
     */
    public Otros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
//        ImageIcon rm = new ImageIcon(getClass().getResource("/img/rm1.jpg"));
//        Icon fondo = new ImageIcon(rm.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
//        jLabel1.setIcon(fondo);
        transparecia();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        agregarclases = new javax.swing.JMenuItem();
        eliminarclases = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        agregarllego = new javax.swing.JMenuItem();
        eliminarllego = new javax.swing.JMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        agregarmodalidad = new javax.swing.JMenuItem();
        eliminarmodalidad = new javax.swing.JMenuItem();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        agregarservicio = new javax.swing.JMenuItem();
        eliminarservicio = new javax.swing.JMenuItem();
        panelotros = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        arbolclase = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolllego = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        arbolmodalidad = new javax.swing.JTree();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        arbolservicios = new javax.swing.JTree();

        agregarclases.setText("Agregar Clase");
        jPopupMenu1.add(agregarclases);

        eliminarclases.setText("Eliminar Clase");
        jPopupMenu1.add(eliminarclases);

        agregarllego.setText("Agregar Llego");
        jPopupMenu2.add(agregarllego);

        eliminarllego.setText("Eliminar Llego");
        jPopupMenu2.add(eliminarllego);

        agregarmodalidad.setText("Agregar Modalidad ");
        jPopupMenu3.add(agregarmodalidad);

        eliminarmodalidad.setText("Eliminar Modalidad");
        jPopupMenu3.add(eliminarmodalidad);

        agregarservicio.setText("Agregar Servicio");
        jPopupMenu4.add(agregarservicio);

        eliminarservicio.setText("Eliminar Servicio");
        jPopupMenu4.add(eliminarservicio);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelotros.setBackground(new java.awt.Color(0, 102, 102));
        panelotros.setName("panelotros"); // NOI18N
        panelotros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jScrollPane5.setBackground(new java.awt.Color(255, 102, 153));
        jScrollPane5.setBorder(null);

        arbolclase.setBackground(new java.awt.Color(240, 240, 240));
        arbolclase.setMaximumSize(new java.awt.Dimension(0, 0));
        arbolclase.setPreferredSize(new java.awt.Dimension(0, 0));
        jScrollPane5.setViewportView(arbolclase);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelotros.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 460));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jScrollPane1.setBorder(null);

        arbolllego.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(arbolllego);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );

        panelotros.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 170, 460));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jScrollPane2.setBorder(null);

        arbolmodalidad.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane2.setViewportView(arbolmodalidad);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelotros.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 260, 460));

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jScrollPane3.setBorder(null);

        arbolservicios.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane3.setViewportView(arbolservicios);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        panelotros.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 220, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelotros, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelotros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Otros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Otros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Otros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Otros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Otros dialog = new Otros(new javax.swing.JFrame(), true);
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
    public javax.swing.JMenuItem agregarclases;
    public javax.swing.JMenuItem agregarllego;
    public javax.swing.JMenuItem agregarmodalidad;
    public javax.swing.JMenuItem agregarservicio;
    public javax.swing.JTree arbolclase;
    public javax.swing.JTree arbolllego;
    public javax.swing.JTree arbolmodalidad;
    public javax.swing.JTree arbolservicios;
    public javax.swing.JMenuItem eliminarclases;
    public javax.swing.JMenuItem eliminarllego;
    public javax.swing.JMenuItem eliminarmodalidad;
    public javax.swing.JMenuItem eliminarservicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPopupMenu jPopupMenu1;
    public javax.swing.JPopupMenu jPopupMenu2;
    public javax.swing.JPopupMenu jPopupMenu3;
    public javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelotros;
    // End of variables declaration//GEN-END:variables
}
