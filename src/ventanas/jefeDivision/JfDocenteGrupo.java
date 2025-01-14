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

public class JfDocenteGrupo extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private DefaultComboBoxModel listas;
    private TableRowSorter tr;
    private ArrayList<String[]> datosDG = new ArrayList<>();
    private ArrayList<String> datosListas = new ArrayList<>();
    private CBusquedas cb = new CBusquedas();
    private CCargaCombos cc = new CCargaCombos();
    private static String[] datosJefe;

    public JfDocenteGrupo(String[] datos) {
        initComponents();
        datosJefe = datos;
        // Configura la tabla para no permitir reordenar columnas.
        JtableGrupo.getTableHeader().setReorderingAllowed(false);

        // Carga los datos iniciales en los ComboBox correspondientes.
        cargaComboBox(JcmbxCiclo, 1);
        cargaComboBox(JcmbxGrupo, 2);

        // Carga los datos iniciales en la tabla.
        cargarTabla();
    }

    /**
     * Método: limpiarTabla Descripción: Elimina todos los datos del modelo de
     * la tabla.
     */
    private void limpiarTabla() {
        // Obtiene el modelo de datos de la tabla.
        modelo = (DefaultTableModel) JtableGrupo.getModel();

        // Establece el número de filas en 0 para vaciar la tabla.
        modelo.setRowCount(0);
    }

    /**
     * Método: cargarTabla Descripción: Carga los datos de las materias
     * asignadas al docente en la tabla.
     */
    private void cargarTabla() {
        // Obtiene el modelo de datos de la tabla.
        modelo = (DefaultTableModel) JtableGrupo.getModel();

        try {
            // Obtiene los datos de las materias del docente a través del objeto de búsqueda.
            datosDG = cb.buscaGrupoxDocente();

            // Limpia la tabla antes de cargar nuevos datos.
            limpiarTabla();

            // Agrega cada materia como una nueva fila en la tabla.
            for (String[] datosdg : datosDG) {
                modelo.addRow(new Object[]{datosdg[0], datosdg[1], datosdg[2]});
            }

            // Configura el TableRowSorter para la tabla.
            tr = new TableRowSorter<>(modelo);
            JtableGrupo.setRowSorter(tr);
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
        modelo = (DefaultTableModel) JtableGrupo.getModel();

        // Configura un TableRowSorter para la tabla.
        tr = new TableRowSorter<>(modelo);
        JtableGrupo.setRowSorter(tr);

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
        JSPTablaGrupo = new javax.swing.JScrollPane();
        JtableGrupo = new javax.swing.JTable();
        JlblGrupo = new javax.swing.JLabel();
        JcmbxGrupo = new javax.swing.JComboBox<>();
        JlblCiclo = new javax.swing.JLabel();
        JcmbxCiclo = new javax.swing.JComboBox<>();
        JtxtNombreDocente = new javax.swing.JTextField();
        JlblNombreDocente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupos atendidos por docentes");
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
                "Ciclo", "Grupo", "Docente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JSPTablaGrupo.setViewportView(JtableGrupo);

        JlblGrupo.setText("Grupo");

        JcmbxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxGrupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmbxGrupoItemStateChanged(evt);
            }
        });

        JlblCiclo.setText("Ciclo");

        JcmbxCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxCiclo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmbxCicloItemStateChanged(evt);
            }
        });

        JtxtNombreDocente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JtxtNombreDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtxtNombreDocenteKeyReleased(evt);
            }
        });

        JlblNombreDocente.setText("Nombre del docente");

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSPTablaGrupo)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblCiclo)
                            .addComponent(JcmbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JlblGrupo)
                            .addComponent(JcmbxGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblNombreDocente)
                            .addComponent(JtxtNombreDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 429, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblCiclo)
                        .addGap(16, 16, 16)
                        .addComponent(JcmbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblGrupo)
                        .addGap(16, 16, 16)
                        .addComponent(JcmbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblNombreDocente)
                        .addGap(18, 18, 18)
                        .addComponent(JtxtNombreDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPTablaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void JtxtNombreDocenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtNombreDocenteKeyReleased
        aplicaFiltros();
    }//GEN-LAST:event_JtxtNombreDocenteKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuJefe mj = new JfMenuJefe(datosJefe);
        CUtilitarios.creaFrame(mj, datosJefe[2]);
    }//GEN-LAST:event_formWindowClosed

    private void JcmbxGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxGrupoItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxGrupoItemStateChanged

    private void JcmbxCicloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxCicloItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxCicloItemStateChanged
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
            java.util.logging.Logger.getLogger(JfDocenteGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfDocenteGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfDocenteGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfDocenteGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfDocenteGrupo(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaGrupo;
    private javax.swing.JComboBox<String> JcmbxCiclo;
    private javax.swing.JComboBox<String> JcmbxGrupo;
    private javax.swing.JLabel JlblCiclo;
    private javax.swing.JLabel JlblGrupo;
    private javax.swing.JLabel JlblNombreDocente;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableGrupo;
    private javax.swing.JTextField JtxtNombreDocente;
    // End of variables declaration//GEN-END:variables
}
