package ventanas.jefeDivision;

import crud.CBusquedas;
import crud.CCargaCombos;
import crud.CInserciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import utilitarios.CUtilitarios;
import ventanas.docentes.JfAsignaCalificacion;

public class JfAsignaAlumno extends javax.swing.JFrame {

    private static String[] datosJefe;
    private DefaultComboBoxModel comboCiclos;
    private DefaultComboBoxModel comboGrupos;
    private ArrayList<String> datosCiclos = new ArrayList<>();
    private ArrayList<String> datosGrupos = new ArrayList<>();
    private final CCargaCombos cc = new CCargaCombos();
    private CBusquedas cb = new CBusquedas();
    private final CInserciones ci = new CInserciones();

    public JfAsignaAlumno(String[] datos) {
        initComponents();
        datosJefe = datos;
        cargaComboBoxCiclo(JcmbxCiclo);
        cargaComboBoxGrupo(JcmbxGrupo);
    }

    public void cargaComboBoxCiclo(JComboBox combo) {
        comboCiclos = (DefaultComboBoxModel) combo.getModel();
        try {

            datosCiclos = cc.cargaComboCiclo();
            for (int i = 0; i < datosCiclos.size(); i++) {
                comboCiclos.addElement(datosCiclos.get(i));
            }

        } catch (SQLException e) {
            CUtilitarios.msg_error("No se pudieron cargar los ciclos", "Cargando lista de opciones");
        }
    }

    public void cargaComboBoxGrupo(JComboBox combo) {
        comboGrupos = (DefaultComboBoxModel) combo.getModel();
        try {

            datosGrupos = cc.cargaComboGrupo();
            for (int i = 0; i < datosGrupos.size(); i++) {
                comboGrupos.addElement(datosGrupos.get(i));
            }

        } catch (SQLException e) {
            CUtilitarios.msg_error("No se pudieron cargar los grupos", "Cargando lista de opciones");
        }
    }

    private String[] obtenValoresCombos(JComboBox jcmbxCiclo, JComboBox jcmbxGrupo) {
        String ciclo = (String) JcmbxCiclo.getSelectedItem();
        String grupo = (String) JcmbxGrupo.getSelectedItem();

        // Verificar si los combobox están vacíos o sin seleccionar una opción válida
        if (ciclo == null || ciclo.equals("Seleccione una opcion")) {
            CUtilitarios.msg_advertencia("Por favor, seleccione un ciclo", "Advertencia");
            return null;
        }
        if (grupo == null || grupo.equals("Seleccione una opcion")) {
            CUtilitarios.msg_advertencia("Por favor, seleccione un grupo", "Advertencia");
            return null;
        }

        return new String[]{ciclo, grupo};
    }

    private void buscaAlumno(String nombre) {
        if (nombre.isEmpty()) {
            CUtilitarios.msg_advertencia("Por favor, ingresa un nombre para buscar.", "Advertencia");
            return;
        }
        try {
            String datosAlumno = cb.buscaAlumnoPorNombre(nombre);
            if (datosAlumno == null || datosAlumno.isEmpty()) {
                CUtilitarios.msg_advertencia("No se encontraron datos del alumno.", "Sin datos");
            } else {
                JlblDatosAlumno.setText(datosAlumno);
            }
        } catch (SQLException e) {
            CUtilitarios.msg_error("Ocurrió un error al buscar el alumno: " + e.getMessage(), "Error de base de datos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblGrupo = new javax.swing.JLabel();
        JcmbxGrupo = new javax.swing.JComboBox<>();
        JlblCiclo = new javax.swing.JLabel();
        JcmbxCiclo = new javax.swing.JComboBox<>();
        JlblNombre = new javax.swing.JLabel();
        JtxtNombre = new javax.swing.JTextField();
        JsNombre = new javax.swing.JSeparator();
        JlblDatosAlumno = new javax.swing.JLabel();
        JlblFondo = new javax.swing.JLabel();
        JbtnAsignar = new javax.swing.JButton();
        JbtnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asigna alumno");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JlblGrupo.setText("Grupo");

        JcmbxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblCiclo.setText("Ciclo");

        JcmbxCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblNombre.setText("Ingrese el nombre del alumno");

        JlblDatosAlumno.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del alumno"));

        JlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoAGrupo.png"))); // NOI18N

        JbtnAsignar.setBackground(new java.awt.Color(153, 204, 255));
        JbtnAsignar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        JbtnAsignar.setText("Asignar");
        JbtnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnAsignarActionPerformed(evt);
            }
        });

        JbtnBuscar.setBackground(new java.awt.Color(153, 204, 255));
        JbtnBuscar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        JbtnBuscar.setText("Buscar");
        JbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnBuscarActionPerformed(evt);
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
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblNombre)
                            .addComponent(JtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblGrupo)
                            .addComponent(JcmbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblCiclo)
                            .addComponent(JcmbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblDatosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlblFondo)
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbtnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblNombre)
                        .addGap(12, 12, 12)
                        .addComponent(JtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(JpnlLienzoLayout.createSequentialGroup()
                            .addComponent(JlblCiclo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JcmbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JpnlLienzoLayout.createSequentialGroup()
                            .addComponent(JlblGrupo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(JcmbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblDatosAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JlblFondo))))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(JbtnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JbtnAsignar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void JbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnBuscarActionPerformed
        String nombre = JtxtNombre.getText().trim();
        buscaAlumno(nombre);
    }//GEN-LAST:event_JbtnBuscarActionPerformed

    private void JbtnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnAsignarActionPerformed
        if (JtxtNombre.getText().isEmpty()) {
            CUtilitarios.msg_error("Ingrese un alumno por favor!", "Datos ");
        } else {
            if (ci.insertaAlumnoGrupo(idEstudiante, idGrupo)){
                CUtilitarios.msg("Se agrego el alumno al grupo", "Asignar alumno");
                JtxtNombre.setText("");
            }
        }
    }//GEN-LAST:event_JbtnAsignarActionPerformed

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
            java.util.logging.Logger.getLogger(JfAsignaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfAsignaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfAsignaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfAsignaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfAsignaAlumno(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnAsignar;
    private javax.swing.JButton JbtnBuscar;
    private javax.swing.JComboBox<String> JcmbxCiclo;
    private javax.swing.JComboBox<String> JcmbxGrupo;
    private javax.swing.JLabel JlblCiclo;
    private javax.swing.JLabel JlblDatosAlumno;
    private javax.swing.JLabel JlblFondo;
    private javax.swing.JLabel JlblGrupo;
    private javax.swing.JLabel JlblNombre;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JSeparator JsNombre;
    private javax.swing.JTextField JtxtNombre;
    // End of variables declaration//GEN-END:variables
}
