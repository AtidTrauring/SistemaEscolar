package ventanas.jefeDivision;

import crud.CBusquedas;
import crud.CCargaCombos;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utilitarios.CUtilitarios;

public class JfBuscaTemario extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private DefaultComboBoxModel listas;
    private TableRowSorter tr;
    private ArrayList<String[]> datosTemarios = new ArrayList<>();
    private ArrayList<String> datosListas = new ArrayList<>();
    private CBusquedas cb = new CBusquedas();
    private CCargaCombos cc = new CCargaCombos();

    private static String[] datosJefe;

    public JfBuscaTemario(String[] datos) {
        initComponents();
        datosJefe = datos;
    }

    /**
     * Método: limpiarTabla Descripción: Elimina todos los datos del modelo de
     * la tabla.
     */
    private void limpiarTabla() {
        // Obtiene el modelo de datos de la tabla.
        modelo = (DefaultTableModel) JtableTemario.getModel();

        // Establece el número de filas en 0 para vaciar la tabla.
        modelo.setRowCount(0);
    }

    /**
     * Método: cargarTabla Descripción: Carga los datos de las materias
     * asignadas al docente en la tabla.
     */
    private void cargarTabla() {
        // Obtiene el modelo de datos de la tabla.
        modelo = (DefaultTableModel) JtableTemario.getModel();

        try {
            // Obtiene los datos de las materias del docente a través del objeto de búsqueda.
            datosTemarios = cb.buscaTemario();

            // Limpia la tabla antes de cargar nuevos datos.
            limpiarTabla();

            // Agrega cada materia como una nueva fila en la tabla.
            for (String[] datosTemario : datosTemarios) {
                modelo.addRow(new Object[]{datosTemario[0], datosTemario[1], datosTemario[2], datosTemario[3], datosTemario[4]});
            }

            // Configura el TableRowSorter para la tabla.
            tr = new TableRowSorter<>(modelo);
            JtableTemario.setRowSorter(tr);
        } catch (SQLException e) {
            // Muestra un mensaje de error si ocurre un problema al cargar los datos.
            CUtilitarios.msg_error("No se pudo cargar la información en la tabla", "Cargando Tabla");
        }
    }

    /**
     * Método: cargaComboBox Descripción: Llena un JComboBox con datos filtrados
     * según el método de carga. utilizará.
     */
    public void cargaComboBox(JComboBox combo, int metodoCarga) {
        //  Obtenemos el modelo del JComboBox
        listas = (DefaultComboBoxModel) combo.getModel();
        try {
            switch (metodoCarga) {
                case 1:
                    // Obtenemos los valores de la tabla
                    datosListas = cc.cargaComboCarrera();
                    // listas.addElement("Seleccione una opcion");
                    // Asiganamos los valores obtenidos al JComboBox
                    for (int i = 0; i < datosListas.size(); i++) {
                        // Añadimos items por string dentro de la lista
                        listas.addElement(datosListas.get(i));
                    }
                    // Limpiamos la lista para cargar los datos del siguiente JComboBox
                    datosListas.clear();
                    break;
                case 2:
                    datosListas = cc.cargaComboAsignatura();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 3:
                    datosListas = cc.cargaComboUnidad();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 4:
                    datosListas = cc.cargaComboSubtema();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
            }

        } catch (SQLException e) {
        }

    }

    /**
     * Método: aplicaFiltros Descripción: Aplica filtros a los datos de la tabla
     * basándose en las selecciones de los JComboBox.
     */
    private void aplicaFiltros() {
        // Obtiene el modelo de datos de la tabla.
        modelo = (DefaultTableModel) JtableTemario.getModel();

        // Configura un TableRowSorter para la tabla.
        tr = new TableRowSorter<>(modelo);
        JtableTemario.setRowSorter(tr);

        // Lista para almacenar los filtros que se aplicarán.
        ArrayList<RowFilter<Object, Object>> filtros = new ArrayList<>();

        // Verifica las selecciones de cada JComboBox y agrega filtros correspondientes.
        if (JcmbxCarrera.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxCarrera.getSelectedItem().toString(), 0));
        }
        if (JcmbxAsignatura.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxAsignatura.getSelectedItem().toString(), 2));
        }
        if (JcmbxUnidad.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxUnidad.getSelectedItem().toString(), 3));
        }
        if (JcmbxSubtema.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxSubtema.getSelectedItem().toString(), 4));
        }
        if (!JtxtClaveAsignatura.getText().trim().isEmpty()) {
            filtros.add(RowFilter.regexFilter(JtxtClaveAsignatura.getText().trim(), 1));
        }

        // Combina todos los filtros en uno solo.
        RowFilter<Object, Object> rf = RowFilter.andFilter(filtros);

        // Aplica el filtro combinado al TableRowSorter.
        tr.setRowFilter(rf);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblCarrera = new javax.swing.JLabel();
        JcmbxCarrera = new javax.swing.JComboBox<>();
        JlblAsignatura = new javax.swing.JLabel();
        JcmbxAsignatura = new javax.swing.JComboBox<>();
        JlblUnidad = new javax.swing.JLabel();
        JcmbxUnidad = new javax.swing.JComboBox<>();
        JlblSubtema = new javax.swing.JLabel();
        JcmbxSubtema = new javax.swing.JComboBox<>();
        JSPTablaTemario = new javax.swing.JScrollPane();
        JtableTemario = new javax.swing.JTable();
        JtxtClaveAsignatura = new javax.swing.JTextField();
        JlblClaveAsignatura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca temario");
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

        JlblCarrera.setText("Carrera");

        JcmbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxCarrera.setMaximumSize(new java.awt.Dimension(250, 22));
        JcmbxCarrera.setMinimumSize(new java.awt.Dimension(220, 22));
        JcmbxCarrera.setPreferredSize(new java.awt.Dimension(220, 22));
        JcmbxCarrera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmbxCarreraItemStateChanged(evt);
            }
        });

        JlblAsignatura.setText("Asignatura");

        JcmbxAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxAsignatura.setMaximumSize(new java.awt.Dimension(250, 22));
        JcmbxAsignatura.setMinimumSize(new java.awt.Dimension(220, 22));
        JcmbxAsignatura.setPreferredSize(new java.awt.Dimension(220, 22));
        JcmbxAsignatura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmbxAsignaturaItemStateChanged(evt);
            }
        });

        JlblUnidad.setText("Unidad");

        JcmbxUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxUnidad.setMaximumSize(new java.awt.Dimension(250, 22));
        JcmbxUnidad.setMinimumSize(new java.awt.Dimension(220, 22));
        JcmbxUnidad.setPreferredSize(new java.awt.Dimension(220, 22));
        JcmbxUnidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmbxUnidadItemStateChanged(evt);
            }
        });

        JlblSubtema.setText("Subtema");

        JcmbxSubtema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxSubtema.setMaximumSize(new java.awt.Dimension(250, 22));
        JcmbxSubtema.setMinimumSize(new java.awt.Dimension(220, 22));
        JcmbxSubtema.setPreferredSize(new java.awt.Dimension(220, 22));
        JcmbxSubtema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmbxSubtemaItemStateChanged(evt);
            }
        });

        JtableTemario.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JtableTemario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carrera", "Clave asignatura", "Asignatura", "Unidad", "Subtema"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JSPTablaTemario.setViewportView(JtableTemario);

        JtxtClaveAsignatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtxtClaveAsignaturaKeyReleased(evt);
            }
        });

        JlblClaveAsignatura.setText("Clave asignatura");

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JlblCarrera)
                    .addComponent(JlblAsignatura)
                    .addComponent(JlblUnidad)
                    .addComponent(JlblSubtema)
                    .addComponent(JlblClaveAsignatura)
                    .addComponent(JcmbxUnidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcmbxSubtema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtxtClaveAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcmbxAsignatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JcmbxCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPTablaTemario, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblCarrera)
                        .addGap(29, 29, 29))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(JcmbxCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(JlblAsignatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JcmbxAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlblUnidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JcmbxUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlblSubtema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JcmbxSubtema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlblClaveAsignatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JtxtClaveAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JSPTablaTemario, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void JcmbxCarreraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxCarreraItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxCarreraItemStateChanged

    private void JcmbxAsignaturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxAsignaturaItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxAsignaturaItemStateChanged

    private void JcmbxUnidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxUnidadItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxUnidadItemStateChanged

    private void JcmbxSubtemaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxSubtemaItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxSubtemaItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargaComboBox(JcmbxCarrera, 1);
        cargaComboBox(JcmbxAsignatura, 2);
        cargaComboBox(JcmbxUnidad, 3);
        cargaComboBox(JcmbxSubtema, 4);
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void JtxtClaveAsignaturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtClaveAsignaturaKeyReleased
        aplicaFiltros();
    }//GEN-LAST:event_JtxtClaveAsignaturaKeyReleased
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
            java.util.logging.Logger.getLogger(JfBuscaTemario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfBuscaTemario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfBuscaTemario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfBuscaTemario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfBuscaTemario(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaTemario;
    private javax.swing.JComboBox<String> JcmbxAsignatura;
    private javax.swing.JComboBox<String> JcmbxCarrera;
    private javax.swing.JComboBox<String> JcmbxSubtema;
    private javax.swing.JComboBox<String> JcmbxUnidad;
    private javax.swing.JLabel JlblAsignatura;
    private javax.swing.JLabel JlblCarrera;
    private javax.swing.JLabel JlblClaveAsignatura;
    private javax.swing.JLabel JlblSubtema;
    private javax.swing.JLabel JlblUnidad;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableTemario;
    private javax.swing.JTextField JtxtClaveAsignatura;
    // End of variables declaration//GEN-END:variables
}
