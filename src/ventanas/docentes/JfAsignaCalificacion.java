package ventanas.docentes;

import crud.CBusquedas;
import crud.CInserciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utilitarios.CUtilitarios;

public class JfAsignaCalificacion extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private DefaultComboBoxModel listas;
    private TableRowSorter tr;
    private final CBusquedas cb = new CBusquedas();
    private final CInserciones ci = new CInserciones();
    private ArrayList<String[]> datosAlumnos = new ArrayList<>();
    private static String[] datosDocente;
    private String[] alumno;
    private String idVersion;

    public JfAsignaCalificacion(String[] datos) {
        initComponents();
        datosDocente = datos;
        JtableGrupo.getTableHeader().setReorderingAllowed(false);
        cargaComboBox(JcmbxCiclo, 1);
        cargaComboBox(JcmbxGrupo, 3);
        cargaComboBox(JcmbxAsignatura, 4);
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) JtableGrupo.getModel();
        modelo.setRowCount(0);
    }

    private void cargarTabla() {
        modelo = (DefaultTableModel) JtableGrupo.getModel();
        String[] valoresBusqueda = new String[3];
        valoresBusqueda = obtenValoresBusqueda();
        if (valoresBusqueda != null) {
            try {
                System.out.println(Arrays.toString(valoresBusqueda));
                datosAlumnos = cb.buscaAlumnosGrupo(valoresBusqueda[2], valoresBusqueda[0], valoresBusqueda[1]);
                if (datosAlumnos.isEmpty()) {
                    CUtilitarios.msg("No se encontraron alumnos en el grupo indicado", "Asignar calificacion");
                } else {
                    limpiarTabla();
                    for (String[] datosAlumno : datosAlumnos) {
                        modelo.addRow(new Object[]{datosAlumno[0], datosAlumno[1]});
                    }
                    tr = new TableRowSorter<>(modelo);
                    JtableGrupo.setRowSorter(tr);
                }
            } catch (SQLException e) {
                CUtilitarios.msg_error("No se pudo cargar la información en la tabla", "Cargando Tabla");
            }

        }
    }

    private void cargaComboBox(JComboBox<String> combo, int metodoCarga) {
        listas = (DefaultComboBoxModel<String>) combo.getModel();
        try {
            datosAlumnos = cb.buscaMateriasDocente(datosDocente[1]);
            for (String[] datosVersion : datosAlumnos) {
                String elemento = "";
                switch (metodoCarga) {
                    case 1:
                        elemento = datosVersion[0];
                        break;
                    case 2:
                        elemento = datosVersion[1];
                        break;
                    case 3:
                        elemento = datosVersion[2];
                        break;
                    case 4:
                        elemento = datosVersion[3];
                        break;
                    default:
                        CUtilitarios.msg_error("Método de carga inválido", "Carga ComboBox");
                        return;
                }
                boolean existe = false;
                for (int i = 0; i < listas.getSize(); i++) {
                    if (listas.getElementAt(i).equals(elemento)) {
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    listas.addElement(elemento);
                }
            }
        } catch (SQLException e) {
            CUtilitarios.msg_error("Error al cargar datos en el ComboBox", "Carga ComboBox");
        }
    }

    private String[] obtenValoresBusqueda() {
        String grupo = (String) JcmbxGrupo.getSelectedItem();
        String ciclo = (String) JcmbxCiclo.getSelectedItem();
        String asignatura = (String) JcmbxAsignatura.getSelectedItem();
        if (grupo == null || grupo.equals("Seleccione una opcion")) {
            CUtilitarios.msg_advertencia("Por favor, seleccione un grupo.", "Advertencia");
            return null;
        }
        if (ciclo == null || ciclo.equals("Seleccione una opcion")) {
            CUtilitarios.msg_advertencia("Por favor, seleccione un ciclo.", "Advertencia");
            return null;
        }
        if (asignatura == null || asignatura.equals("Seleccione una opcion")) {
            CUtilitarios.msg_advertencia("Por favor, seleccione una asignatura.", "Advertencia");
            return null;
        }
        return new String[]{ciclo, asignatura, grupo};
    }

    private String[] obtenerValoresFilaTabla() {
        String[] valores = new String[2];
        int filaSeleccionada = JtableGrupo.getSelectedRow();
        if (filaSeleccionada != -1) {
            for (int i = 0; i < JtableGrupo.getColumnCount(); i++) {
                valores[i] = (String) JtableGrupo.getValueAt(filaSeleccionada, i);
            }
        } else {
            CUtilitarios.msg_error("Seleccione un alumno por favor!", "Obteniendo datos fila");
            return null;
        }
        return valores;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JSPTablaGrupo = new javax.swing.JScrollPane();
        JtableGrupo = new javax.swing.JTable();
        JlblGrupo = new javax.swing.JLabel();
        JcmbxGrupo = new javax.swing.JComboBox<>();
        JlblCiclo = new javax.swing.JLabel();
        JcmbxCiclo = new javax.swing.JComboBox<>();
        JlblAsignatura = new javax.swing.JLabel();
        JcmbxAsignatura = new javax.swing.JComboBox<>();
        JlblAlumno = new javax.swing.JLabel();
        JtxtAlumno = new javax.swing.JTextField();
        JlblCalificacion = new javax.swing.JLabel();
        JtxtCalificacion = new javax.swing.JTextField();
        JbtnCalifica = new javax.swing.JButton();
        JbtnBuscaGrupo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupos por docentes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JtableGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Alumno"
            }
        ));
        JtableGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtableGrupoMouseClicked(evt);
            }
        });
        JSPTablaGrupo.setViewportView(JtableGrupo);

        JlblGrupo.setText("Grupo");

        JcmbxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblCiclo.setText("Ciclo");

        JcmbxCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblAsignatura.setText("Asignatura");

        JcmbxAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblAlumno.setText("Alumno");

        JtxtAlumno.setEditable(false);

        JlblCalificacion.setText("Calificacion");

        JtxtCalificacion.setEditable(false);
        JtxtCalificacion.setToolTipText("Ingrese valores de 0 a 100");

        JbtnCalifica.setBackground(new java.awt.Color(153, 204, 255));
        JbtnCalifica.setText("Calificar");
        JbtnCalifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnCalificaActionPerformed(evt);
            }
        });

        JbtnBuscaGrupo.setBackground(new java.awt.Color(153, 204, 255));
        JbtnBuscaGrupo.setText("Buscar grupo");
        JbtnBuscaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnBuscaGrupoActionPerformed(evt);
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
                        .addComponent(JSPTablaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JlblAsignatura)
                            .addComponent(JlblGrupo)
                            .addComponent(JcmbxGrupo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JlblCiclo)
                            .addComponent(JcmbxCiclo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JcmbxAsignatura, 0, 202, Short.MAX_VALUE)
                            .addComponent(JbtnBuscaGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblAlumno)
                            .addComponent(JtxtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblCalificacion)
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addComponent(JtxtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JbtnCalifica, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JtxtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblCalificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtxtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbtnCalifica))))
                .addGap(19, 19, 19)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSPTablaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblAsignatura)
                        .addGap(16, 16, 16)
                        .addComponent(JcmbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlblGrupo)
                        .addGap(16, 16, 16)
                        .addComponent(JcmbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlblCiclo)
                        .addGap(16, 16, 16)
                        .addComponent(JcmbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(JbtnBuscaGrupo)))
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

    private void JbtnCalificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnCalificaActionPerformed
        if (JtxtCalificacion.getText().isEmpty()) {
            CUtilitarios.msg_error("Seleccione un alumno por favor!", "Obteniendo datos fila");
        } else {
            double calificacion = CUtilitarios.validaCalificaion(JtxtCalificacion.getText());
            if (calificacion != -1) {
                JtxtCalificacion.isEditable();
                try {
                    if (ci.insertaCalificacion(idVersion, alumno[0], calificacion)) {
                        CUtilitarios.msg("Se registro la calificacion, exitosamente", "Asignar califiacion");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JfAsignaCalificacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_JbtnCalificaActionPerformed

    private void JbtnBuscaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnBuscaGrupoActionPerformed
        String[] criteriosBusqueda = obtenValoresBusqueda();
        if (criteriosBusqueda != null) {
            try {
                idVersion = cb.buscaMateriaDocente(criteriosBusqueda[0], criteriosBusqueda[1], criteriosBusqueda[2], datosDocente[1]);
                if (idVersion.isEmpty()) {
                    CUtilitarios.msg("No hay ninguna grupo asignado con esa materia.", "Asignar calificacion.");
                } else {
                    cargarTabla();
                }
            } catch (SQLException ex) {
            }

        }
    }//GEN-LAST:event_JbtnBuscaGrupoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuDocente md = new JfMenuDocente(datosDocente);
        CUtilitarios.creaFrame(md, datosDocente[2]);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void JtableGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtableGrupoMouseClicked
        alumno = obtenerValoresFilaTabla();
        if (alumno != null) {
            JtxtAlumno.setText(alumno[1]);
            JtxtCalificacion.isEnabled();
            JtxtCalificacion.isEditable();
        }
    }//GEN-LAST:event_JtableGrupoMouseClicked

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
            java.util.logging.Logger.getLogger(JfAsignaCalificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfAsignaCalificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfAsignaCalificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfAsignaCalificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfAsignaCalificacion(datosDocente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaGrupo;
    private javax.swing.JButton JbtnBuscaGrupo;
    private javax.swing.JButton JbtnCalifica;
    private javax.swing.JComboBox<String> JcmbxAsignatura;
    private javax.swing.JComboBox<String> JcmbxCiclo;
    private javax.swing.JComboBox<String> JcmbxGrupo;
    private javax.swing.JLabel JlblAlumno;
    private javax.swing.JLabel JlblAsignatura;
    private javax.swing.JLabel JlblCalificacion;
    private javax.swing.JLabel JlblCiclo;
    private javax.swing.JLabel JlblGrupo;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableGrupo;
    private javax.swing.JTextField JtxtAlumno;
    private javax.swing.JTextField JtxtCalificacion;
    // End of variables declaration//GEN-END:variables
}
