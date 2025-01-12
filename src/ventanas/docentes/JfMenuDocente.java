package ventanas.docentes;

import ventanas.JfInicionSesion;
import utilitarios.CUtilitarios;

public class JfMenuDocente extends javax.swing.JFrame {

    private static String[] datosDocente;

    public JfMenuDocente(String[] datos) {
        initComponents();
        datosDocente = datos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblFondoDocente = new javax.swing.JLabel();
        JmbListaOpciones = new javax.swing.JMenuBar();
        JmnCalificacion = new javax.swing.JMenu();
        JmnBuscaGrupo = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Docente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JlblFondoDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoJefe.png"))); // NOI18N

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlblFondoDocente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlblFondoDocente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JmnCalificacion.setText("Calificaciones");
        JmnCalificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmnCalificacionMouseClicked(evt);
            }
        });
        JmbListaOpciones.add(JmnCalificacion);

        JmnBuscaGrupo.setText("Mis grupos");
        JmnBuscaGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmnBuscaGrupoMouseClicked(evt);
            }
        });
        JmbListaOpciones.add(JmnBuscaGrupo);

        setJMenuBar(JmbListaOpciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpnlLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpnlLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setTitle(datosDocente[2]);
    }//GEN-LAST:event_formWindowOpened

    private void JmnCalificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmnCalificacionMouseClicked
        JfAsignaCalificacion ac = new JfAsignaCalificacion(datosDocente);
        CUtilitarios.creaFrame(ac, "Asigna calificaciones");
        this.hide();
    }//GEN-LAST:event_JmnCalificacionMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfInicionSesion is = new JfInicionSesion();
        CUtilitarios.creaFrame(is, "Inicio de sesion");
    }//GEN-LAST:event_formWindowClosed

    private void JmnBuscaGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmnBuscaGrupoMouseClicked
        JfMisMaterias mm = new JfMisMaterias(datosDocente);
        CUtilitarios.creaFrame(mm, "Grupos por docentes");
        this.hide();
    }//GEN-LAST:event_JmnBuscaGrupoMouseClicked

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
            java.util.logging.Logger.getLogger(JfMenuDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfMenuDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfMenuDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfMenuDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfMenuDocente(datosDocente).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlblFondoDocente;
    private javax.swing.JMenuBar JmbListaOpciones;
    private javax.swing.JMenu JmnBuscaGrupo;
    private javax.swing.JMenu JmnCalificacion;
    private javax.swing.JPanel JpnlLienzo;
    // End of variables declaration//GEN-END:variables
}
