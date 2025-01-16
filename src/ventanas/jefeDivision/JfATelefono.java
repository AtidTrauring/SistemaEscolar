package ventanas.jefeDivision;

import crud.CBusquedas;
import java.util.Arrays;
import utilitarios.CUtilitarios;

public class JfATelefono extends javax.swing.JFrame {

    private CBusquedas cb = new CBusquedas();
    private static String[] datosJefe;
    private static String[] datosPersona;

    public JfATelefono(String[] datosJ, String[] datosP, String nombreBoton) {
        initComponents();
        datosJefe = datosJ;
        datosPersona = datosP;
        JbtnEnviar.setText(nombreBoton);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblNombre = new javax.swing.JLabel();
        JtxtNombre = new javax.swing.JTextField();
        JsNombre = new javax.swing.JSeparator();
        JlblTelefono = new javax.swing.JLabel();
        JtxtTelefono = new javax.swing.JTextField();
        JspTelefono = new javax.swing.JSeparator();
        JlblFondo = new javax.swing.JLabel();
        JbtnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agrega telefono");
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

        JlblNombre.setText("Ingresa nombre de la persona");

        JtxtNombre.setBorder(null);

        JlblTelefono.setText("Numero de telefono");

        JtxtTelefono.setBorder(null);

        JlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoATelefono.png"))); // NOI18N

        JbtnEnviar.setBackground(new java.awt.Color(153, 204, 255));
        JbtnEnviar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        JbtnEnviar.setText("Enviar");
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
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblNombre)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JspTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblTelefono)
                            .addComponent(JtxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbtnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(JlblFondo)
                        .addGap(22, 22, 22))))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JlblNombre)
                .addGap(12, 12, 12)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlblTelefono)
                        .addGap(12, 12, 12)
                        .addComponent(JtxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbtnEnviar))
                    .addComponent(JlblFondo))
                .addGap(42, 42, 42))
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuJefe mj = new JfMenuJefe(datosJefe);
        CUtilitarios.creaFrame(mj, datosJefe[2]);
    }//GEN-LAST:event_formWindowClosed

    private void JbtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnEnviarActionPerformed
        if (JtxtNombre.getText().isEmpty()) {
            CUtilitarios.msg("Porfavor ingrese un nombre", "Agrega telefono");
        } else {
            String telefono = CUtilitarios.validarTelefono(JtxtTelefono.getText());
            if (telefono != null) {
                // Ya cuento con datos desde otro Frame
                if (datosPersona.length > 0) {
                    String[] datosPersonaT = CUtilitarios.agregarElemento(datosPersona, telefono);
                    JfACorreo ac = new JfACorreo(datosJefe, datosPersonaT, "Enviar");
                    System.out.println("Datos con Telefono");
                    System.out.println(Arrays.toString(datosPersonaT));
                    CUtilitarios.creaFrame(ac, "Agrega correo");
                    this.hide();
                } else {
                    // No cuenta con ningun dato
                    // Busca a la persona y obtiene su Id, para asignarle el telefono
                }
            }

        }
    }//GEN-LAST:event_JbtnEnviarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (datosPersona.length > 0) {
            JtxtNombre.setText(datosPersona[0] + " " + datosPersona[1] + " " + datosPersona[2]);
            JtxtNombre.setEditable(false);
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(JfATelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfATelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfATelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfATelefono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfATelefono(datosJefe, datosPersona, new String()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnEnviar;
    private javax.swing.JLabel JlblFondo;
    private javax.swing.JLabel JlblNombre;
    private javax.swing.JLabel JlblTelefono;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JSeparator JsNombre;
    private javax.swing.JSeparator JspTelefono;
    private javax.swing.JTextField JtxtNombre;
    private javax.swing.JTextField JtxtTelefono;
    // End of variables declaration//GEN-END:variables
}
