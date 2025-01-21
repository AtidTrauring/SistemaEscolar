package ventanas.jefeDivision;

import crud.CBusquedas;
import crud.CCargaCombos;
import crud.CInserciones;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.sql.SQLException;
import java.util.ArrayList;
import utilitarios.CUtilitarios;

public final class JfAPersona extends javax.swing.JFrame {

    private final CInserciones queryInserta = new CInserciones();
    private final CBusquedas cb = new CBusquedas();
    private final CCargaCombos cc = new CCargaCombos();
    private DefaultComboBoxModel comboCarreras;
    private ArrayList<String> datosCarreras = new ArrayList<>();
    private String nombres, apPaterno, apMaterno;
    private static String[] datosJefe;
    private static String personaL;
    private static String botonL;
    private final String regexNombres = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+(?: [a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+)?$";
    private final String titulos = this.getTitle();

    public boolean validaCampos() {
        return (CUtilitarios.validaCampo(nombres, JtxtNombres, regexNombres, "Ingrese nombre(s)", "Valores invalidos para nombre(s)", titulos))
                && (CUtilitarios.validaCampo(apPaterno, JtxtApPaterno, regexNombres, "Ingrerse un apellido paterno.", "Valores invalidos para apellido paterno", titulos))
                && (CUtilitarios.validaCampo(apMaterno, JtxtApMaterno, regexNombres, "Ingrese un apellido materno.", "Valores invalidos para apellido materno", titulos));
    }

    public JfAPersona(String[] datos, String persona, String nombreBoton) {
        initComponents();
        datosJefe = datos;
        personaL = persona;
        JbtnEnviar.setText(nombreBoton);
        asignaItem(persona, JcmbxOcupacion);
        cargaComboBox(JcmbxCarreras);
    }

    public void asignaItem(String persona, JComboBox combo) {
        if (null == persona) {

        } else {
            switch (persona) {
                case "Docente":
                    combo.setSelectedIndex(1);
                    combo.setEnabled(false);
                    break;
                case "Alumno":
                    combo.setSelectedIndex(2);
                    combo.setEnabled(false);
                    break;
                default:
                    break;
            }
        }
    }

    public void asignaItemCarrera(String carrera) {
        JcmbxOcupacion.addItem(nombres);
    }

    public void cargaComboBox(JComboBox combo) {
        comboCarreras = (DefaultComboBoxModel) combo.getModel();
        try {

            datosCarreras = cc.cargaComboCarrera();
            for (int i = 0; i < datosCarreras.size(); i++) {
                comboCarreras.addElement(datosCarreras.get(i));
            }

        } catch (SQLException e) {
            CUtilitarios.msg_error("No se pudieron cargar las carreras", "Cargando lista de opciones");
        }
    }

    private String[] obtenValoresCombos() {
        String ocupacion = (String) JcmbxOcupacion.getSelectedItem();
        String carrera = (String) JcmbxCarreras.getSelectedItem();
        if (ocupacion == null || ocupacion.equals("Seleccione una opcion")) {
            CUtilitarios.msg_advertencia("Por favor, seleccione una ocupacion", "Advertencia");
            return null;
        }
        if (carrera == null || carrera.equals("Seleccione una opcion")) {
            CUtilitarios.msg_advertencia("Por favor, seleccione una carrera.", "Advertencia");
            return null;
        }
        return new String[]{ocupacion, carrera};
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPnlLienzo = new javax.swing.JPanel();
        JlblNombres = new javax.swing.JLabel();
        JlblApellidoPaterno = new javax.swing.JLabel();
        JlblApellidoMaterno = new javax.swing.JLabel();
        JlblOcupacion = new javax.swing.JLabel();
        JlblCcarreras = new javax.swing.JLabel();
        JtxtNombres = new javax.swing.JTextField();
        JtxtApPaterno = new javax.swing.JTextField();
        JtxtApMaterno = new javax.swing.JTextField();
        JsNombre = new javax.swing.JSeparator();
        JsApellidoPaterno = new javax.swing.JSeparator();
        JsApellidoMaterno = new javax.swing.JSeparator();
        JcmbxCarreras = new javax.swing.JComboBox<>();
        JcmbxOcupacion = new javax.swing.JComboBox<>();
        JbtnEnviar = new javax.swing.JButton();
        JlblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar persona");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JPnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JlblNombres.setText("Nombre(s)");

        JlblApellidoPaterno.setText("Apellido Paterno");

        JlblApellidoMaterno.setText("Apellido Materno");

        JlblOcupacion.setText("Carrera");

        JlblCcarreras.setText("Ocupacion");

        JtxtNombres.setBorder(null);

        JtxtApPaterno.setBorder(null);

        JtxtApMaterno.setBorder(null);

        JcmbxCarreras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxCarreras.setToolTipText("");
        JcmbxCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxCarrerasActionPerformed(evt);
            }
        });

        JcmbxOcupacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Docente", "Alumno" }));
        JcmbxOcupacion.setToolTipText("");

        JbtnEnviar.setBackground(new java.awt.Color(153, 204, 255));
        JbtnEnviar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        JbtnEnviar.setText("Enviar");
        JbtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnEnviarActionPerformed(evt);
            }
        });

        JlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoAPersona.png"))); // NOI18N

        javax.swing.GroupLayout JPnlLienzoLayout = new javax.swing.GroupLayout(JPnlLienzo);
        JPnlLienzo.setLayout(JPnlLienzoLayout);
        JPnlLienzoLayout.setHorizontalGroup(
            JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnlLienzoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(JlblFondo)
                .addGap(68, 68, 68)
                .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPnlLienzoLayout.createSequentialGroup()
                        .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblApellidoMaterno)
                            .addComponent(JsApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JPnlLienzoLayout.createSequentialGroup()
                        .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPnlLienzoLayout.createSequentialGroup()
                                .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JlblApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtxtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JsApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPnlLienzoLayout.createSequentialGroup()
                                        .addComponent(JlblOcupacion)
                                        .addGap(0, 168, Short.MAX_VALUE))
                                    .addComponent(JcmbxCarreras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(JPnlLienzoLayout.createSequentialGroup()
                                .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JlblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPnlLienzoLayout.createSequentialGroup()
                                        .addComponent(JlblCcarreras)
                                        .addGap(0, 148, Short.MAX_VALUE))
                                    .addComponent(JcmbxOcupacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(JPnlLienzoLayout.createSequentialGroup()
                                .addComponent(JtxtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JbtnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        JPnlLienzoLayout.setVerticalGroup(
            JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblNombres)
                        .addGap(12, 12, 12)
                        .addComponent(JlblFondo))
                    .addGroup(JPnlLienzoLayout.createSequentialGroup()
                        .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JtxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPnlLienzoLayout.createSequentialGroup()
                                .addComponent(JlblCcarreras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JcmbxOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addComponent(JsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JPnlLienzoLayout.createSequentialGroup()
                                .addComponent(JlblApellidoPaterno)
                                .addGap(12, 12, 12)
                                .addComponent(JtxtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(JsApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPnlLienzoLayout.createSequentialGroup()
                                .addComponent(JlblOcupacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JcmbxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(JlblApellidoMaterno)))
                .addGap(2, 2, 2)
                .addGroup(JPnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(JsApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPnlLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPnlLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuJefe mj = new JfMenuJefe(datosJefe);
        CUtilitarios.creaFrame(mj, datosJefe[2]);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void JbtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnEnviarActionPerformed
        // Enviar String[5]
        /*
        [0] -> Nombre
        [1] -> Paterno
        [2] -> Materno
        [3] -> Ocupacion
        [4] -> idCarrera
         */
        String[] datosCombos = obtenValoresCombos();
        if (datosCombos != null && validaCampos()) {
            String[] datosPersonaInsertar = new String[5];
            try {
                int idCarrera = cb.obtenClaveCarreraSeleccionado(datosCombos[1]);
                datosPersonaInsertar[0] = JtxtNombres.getText();
                datosPersonaInsertar[1] = JtxtApPaterno.getText();
                datosPersonaInsertar[2] = JtxtApMaterno.getText();
                datosPersonaInsertar[3] = datosCombos[0];
                datosPersonaInsertar[4] = String.valueOf(idCarrera);
            } catch (Exception e) {
            }
            CUtilitarios.msg("A continuacion ingresa el telefono!", "Agrega " + personaL);
            JfATelefono at = new JfATelefono(datosJefe, datosPersonaInsertar, "Enviar");
            System.out.println("Datos desde APersona");
            for (String string : datosPersonaInsertar) {
                System.out.println(string);
            }
            CUtilitarios.creaFrame(at, "Agrega telefono");
            this.hide();
        }

    }//GEN-LAST:event_JbtnEnviarActionPerformed

    private void JcmbxCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxCarrerasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcmbxCarrerasActionPerformed
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
            java.util.logging.Logger.getLogger(JfAPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfAPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfAPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfAPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfAPersona(datosJefe, personaL, botonL).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPnlLienzo;
    private javax.swing.JButton JbtnEnviar;
    private javax.swing.JComboBox<String> JcmbxCarreras;
    private javax.swing.JComboBox<String> JcmbxOcupacion;
    private javax.swing.JLabel JlblApellidoMaterno;
    private javax.swing.JLabel JlblApellidoPaterno;
    private javax.swing.JLabel JlblCcarreras;
    private javax.swing.JLabel JlblFondo;
    private javax.swing.JLabel JlblNombres;
    private javax.swing.JLabel JlblOcupacion;
    private javax.swing.JSeparator JsApellidoMaterno;
    private javax.swing.JSeparator JsApellidoPaterno;
    private javax.swing.JSeparator JsNombre;
    private javax.swing.JTextField JtxtApMaterno;
    private javax.swing.JTextField JtxtApPaterno;
    private javax.swing.JTextField JtxtNombres;
    // End of variables declaration//GEN-END:variables
}
