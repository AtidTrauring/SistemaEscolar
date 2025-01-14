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
            datosTemarios = cb.buscaGrupoxDocente();

            // Limpia la tabla antes de cargar nuevos datos.
            limpiarTabla();

            // Agrega cada materia como una nueva fila en la tabla.
            for (String[] datosdg : datosTemarios) {
                modelo.addRow(new Object[]{datosdg[0], datosdg[1], datosdg[2]});
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
                    datosListas = cc.cargaComboCiclo();
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
                    datosListas = cc.cargaComboGrupo();
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
        if (JcmbxCiclo.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxCiclo.getSelectedItem().toString(), 0));
        }
        if (JcmbxGrupo.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxGrupo.getSelectedItem().toString(), 1));
        }
        if (!JtxtNombreDocente.getText().trim().isEmpty()) {
            filtros.add(RowFilter.regexFilter(JtxtNombreDocente.getText().trim(), 2));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca temario");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JlblCarrera.setText("Carrera");

        JcmbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblAsignatura.setText("Asignatura");

        JcmbxAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblUnidad.setText("Unidad");

        JcmbxUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblSubtema.setText("Subtema");

        JcmbxSubtema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JtableTemario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carrera", "Clave asignatura", "Asignatura", "Unidad", "Subtema"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JSPTablaTemario.setViewportView(JtableTemario);

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JSPTablaTemario)
                        .addContainerGap())
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblCarrera)
                            .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JcmbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblAsignatura))
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblUnidad)
                            .addComponent(JcmbxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JcmbxSubtema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblSubtema))
                        .addContainerGap(267, Short.MAX_VALUE))))
        );

        JpnlLienzoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JcmbxAsignatura, JcmbxCarrera, JcmbxSubtema, JcmbxUnidad});

        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblCarrera)
                        .addGap(29, 29, 29))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JlblUnidad)
                            .addComponent(JlblSubtema)
                            .addComponent(JlblAsignatura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcmbxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcmbxSubtema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcmbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPTablaTemario, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel JlblSubtema;
    private javax.swing.JLabel JlblUnidad;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableTemario;
    // End of variables declaration//GEN-END:variables
}
