package ventanas.jefeDivision;

import utilitarios.CUtilitarios;

public class JfConsultaAuditorias extends javax.swing.JFrame {

    private static String[] datosJefe;

    public JfConsultaAuditorias(String[] datos) {
        initComponents();
        datosJefe = datos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JcmbxConsultas = new javax.swing.JComboBox<>();
        JlblConsultas = new javax.swing.JLabel();
        JbtnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccion de auditorias");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JcmbxConsultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Auditoria de las Asignaturas", "Auditoria de la relacion de Asignatura con Semestre", "Auditoria de la relacion de Asignatura con Unidad", "Auditoria de las Carreras", "Auditoria de la relacion de Carreras con Asignatura", "Auditoria de los Ciclos", "Auditoria de los Codigos postal", "Auditoria de las Colonias", "Auditoria de las Contraseñas", "Auditoria de los Correos", "Auditoria de las Direcciones", "Auditoria de los Docentes", "Auditoria de la relacion de Docentes con Carreras", "Auditoria de la relacion de Docentes con Grupos", "Auditoria de la relacion de Docentes con Versiones", "Auditoria de los Estados", "Auditoria de los Estudiantes", "Auditoria de la relacion de Estudiante con Carrera", "Auditoria de la relacion de Estudiante con Grupo", "Auditoria de la relacion de Estudiante con Versiones de los cursos", "Auditoria de los Grupos", "Auditoria de los Jefes de carrera", "Auditoria de los Municipios", "Auditoria de los Origenes de las materias", "Auditoria de los Docentes/Alumnos/Jefes de carrera (Personas)", "Auditoria de los Semestres", "Auditoria de los Subtemas", "Auditoria de los Telefonos", "Auditoria de los Tipos de asignatura", "Auditoria de las Unidades", "Auditoria de las Versiones de los cursos", " " }));

        JlblConsultas.setText("Seleccione una Auditoria");

        JbtnEnviar.setText("Muestrame");
        JbtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JcmbxConsultas, 0, 401, Short.MAX_VALUE)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblConsultas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JbtnEnviar)))
                .addContainerGap())
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlblConsultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JcmbxConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JbtnEnviar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

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

    private void JbtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnEnviarActionPerformed
        if (JcmbxConsultas.getSelectedIndex() == 0) {
            CUtilitarios.msg("Porfavor seleccione una Auditoria!", "Consultar auditorias.");
        } else {
            JfConsultaAuditoriasTabla caj = new JfConsultaAuditoriasTabla(datosJefe, JcmbxConsultas.getSelectedIndex());
            CUtilitarios.creaFrame(caj, "Consultas de Auditorias.");
            this.hide();
        }

    }//GEN-LAST:event_JbtnEnviarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuJefe mj = new JfMenuJefe(datosJefe);
        CUtilitarios.creaFrame(mj, datosJefe[2]);
    }//GEN-LAST:event_formWindowClosed
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
            java.util.logging.Logger.getLogger(JfConsultaAuditorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfConsultaAuditorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfConsultaAuditorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfConsultaAuditorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfConsultaAuditorias(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnEnviar;
    private javax.swing.JComboBox<String> JcmbxConsultas;
    private javax.swing.JLabel JlblConsultas;
    private javax.swing.JPanel JpnlLienzo;
    // End of variables declaration//GEN-END:variables
}
