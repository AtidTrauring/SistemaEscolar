package ventanas.docentes;

import crud.CBusquedas;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utilitarios.CUtilitarios;

public class JfMisMaterias extends javax.swing.JFrame {

// Clase JfMisMaterias: gestiona la interfaz gráfica para mostrar las materias asignadas a un docente.
    private DefaultTableModel modelo; // Modelo de datos para la tabla JtableGrupo.
    private DefaultComboBoxModel listas; // Modelo de datos para los JComboBox.
    private TableRowSorter tr; // Objeto para ordenar y filtrar filas en la tabla.
    private CBusquedas cb = new CBusquedas(); // Objeto que gestiona las búsquedas de datos.
    private ArrayList<String[]> datosMaterias = new ArrayList<>(); // Lista para almacenar los datos de las materias.
    private static String[] datosDocente; // Datos del docente actual.

// Constructor: inicializa la interfaz gráfica y carga los datos iniciales.
    public JfMisMaterias(String[] datos) {
        initComponents(); // Inicializa los componentes gráficos.
        datosDocente = datos; // Almacena los datos del docente.

        // Configura la tabla para no permitir reordenar columnas.
        JtableGrupo.getTableHeader().setReorderingAllowed(false);

        // Carga los datos iniciales en los ComboBox correspondientes.
        cargaComboBox(JcmbxCiclo, 1);
        cargaComboBox(JcmbxCarrera, 2);
        cargaComboBox(JcmbxGrupo, 3);
        cargaComboBox(JcmbxAsignatura, 4);

        // Carga los datos iniciales en la tabla.
        cargarTabla();
    }

// **************** MÉTODOS ******************//
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
            datosMaterias = cb.buscaMateriasDocente(datosDocente[1]);

            // Limpia la tabla antes de cargar nuevos datos.
            limpiarTabla();

            // Agrega cada materia como una nueva fila en la tabla.
            for (String[] datosMateria : datosMaterias) {
                modelo.addRow(new Object[]{datosMateria[0], datosMateria[1], datosMateria[2], datosMateria[3]});
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
     * según el método de carga.
     * utilizará.
     */
    private void cargaComboBox(JComboBox<String> combo, int metodoCarga) {
        // Obtiene el modelo del JComboBox.
        listas = (DefaultComboBoxModel<String>) combo.getModel();

        try {
            // Obtiene los datos de las materias del docente.
            datosMaterias = cb.buscaMateriasDocente(datosDocente[1]);

            // Itera sobre los datos para agregar los valores al JComboBox.
            for (String[] datosVersion : datosMaterias) {
                String elemento = ""; // Variable para almacenar el dato seleccionado.

                // Selecciona el dato según el método de carga.
                switch (metodoCarga) {
                    case 1:
                        elemento = datosVersion[0];
                        break; // Primer campo (por ejemplo, ciclo).
                    case 2:
                        elemento = datosVersion[1];
                        break; // Segundo campo (por ejemplo, carrera).
                    case 3:
                        elemento = datosVersion[2];
                        break; // Tercer campo (por ejemplo, grupo).
                    case 4:
                        elemento = datosVersion[3];
                        break; // Cuarto campo (por ejemplo, asignatura).
                    default:
                        // Muestra un mensaje de error si el método de carga no es válido.
                        CUtilitarios.msg_error("Método de carga inválido", "Carga ComboBox");
                        return;
                }

                // Verifica si el elemento ya existe en el ComboBox.
                boolean existe = false;
                for (int i = 0; i < listas.getSize(); i++) {
                    if (listas.getElementAt(i).equals(elemento)) {
                        existe = true;
                        break;
                    }
                }

                // Agrega el elemento solo si no existe.
                if (!existe) {
                    listas.addElement(elemento);
                }
            }
        } catch (SQLException e) {
            // Muestra un mensaje de error si ocurre un problema al cargar los datos.
            CUtilitarios.msg_error("Error al cargar datos en el ComboBox", "Carga ComboBox");
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
        if (JcmbxCarrera.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxCarrera.getSelectedItem().toString(), 1));
        }
        if (JcmbxGrupo.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxGrupo.getSelectedItem().toString(), 2));
        }
        if (JcmbxAsignatura.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxAsignatura.getSelectedItem().toString(), 3));
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
        JlblAsignatura = new javax.swing.JLabel();
        JcmbxAsignatura = new javax.swing.JComboBox<>();
        JlblCarrera = new javax.swing.JLabel();
        JcmbxCarrera = new javax.swing.JComboBox<>();

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
                "Ciclo", "Carrera", "Grupo", "Asignatura"
            }
        ));
        JSPTablaGrupo.setViewportView(JtableGrupo);
        if (JtableGrupo.getColumnModel().getColumnCount() > 0) {
            JtableGrupo.getColumnModel().getColumn(1).setHeaderValue("Carrera");
        }

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

        JlblAsignatura.setText("Asignatura");

        JcmbxAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxAsignatura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmbxAsignaturaItemStateChanged(evt);
            }
        });

        JlblCarrera.setText("Carrera");

        JcmbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxCarrera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcmbxCarreraItemStateChanged(evt);
            }
        });

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
                            .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblCarrera))
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblAsignatura)
                            .addComponent(JcmbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 222, Short.MAX_VALUE)))
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
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JlblGrupo)
                            .addComponent(JlblCarrera)
                            .addComponent(JlblAsignatura))
                        .addGap(16, 16, 16)
                        .addComponent(JcmbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JcmbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuDocente md = new JfMenuDocente(datosDocente);
        CUtilitarios.creaFrame(md, datosDocente[2]);
    }//GEN-LAST:event_formWindowClosed

    private void JcmbxCicloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxCicloItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxCicloItemStateChanged

    private void JcmbxGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxGrupoItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxGrupoItemStateChanged

    private void JcmbxAsignaturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxAsignaturaItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxAsignaturaItemStateChanged

    private void JcmbxCarreraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxCarreraItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxCarreraItemStateChanged
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
            java.util.logging.Logger.getLogger(JfMisMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfMisMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfMisMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfMisMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfMisMaterias(datosDocente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaGrupo;
    private javax.swing.JComboBox<String> JcmbxAsignatura;
    private javax.swing.JComboBox<String> JcmbxCarrera;
    private javax.swing.JComboBox<String> JcmbxCiclo;
    private javax.swing.JComboBox<String> JcmbxGrupo;
    private javax.swing.JLabel JlblAsignatura;
    private javax.swing.JLabel JlblCarrera;
    private javax.swing.JLabel JlblCiclo;
    private javax.swing.JLabel JlblGrupo;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableGrupo;
    // End of variables declaration//GEN-END:variables
}
