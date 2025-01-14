package ventanas.jefeDivision;

import crud.CBusquedas;
import utilitarios.CUtilitarios;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class JfBuscaKardex extends javax.swing.JFrame {

    //**************   ATRIBUTOS  *******************/
    private DefaultTableModel modelo;
    private TableRowSorter tr;
    private CBusquedas cb = new CBusquedas();
    private ArrayList<String[]> datosKardex = new ArrayList<>();
    private ArrayList<String[]> datosAlumno = new ArrayList<>();
    private static String[] datosJefe;

    public JfBuscaKardex(String[] datos) {
        initComponents();
        JtableKardex.getTableHeader().setReorderingAllowed(false);
        datosJefe = datos;
        cargarTabla();
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        modelo.setRowCount(0);
    }

    private void limpiarBuscadores() {
        // Limpia los cuadro de texto
        JtxtNombreAlumno.setText(null);
        JtxtMatriculaAlumno.setText(null);
    }

    public void limpiarFiltro() {
        // Si el objeto 'tr' tiene algun filtro
        if (tr != null) {
            // Elimina el filtro 
            tr.setRowFilter(null);
        }
    }

    public void cargarTabla() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        try {
            datosKardex = cb.buscarAlumnosCompletos();
            limpiarTabla();

            for (String[] datoKardex : datosKardex) {
                modelo.addRow(new Object[]{datoKardex[0], datoKardex[1], datoKardex[2], datoKardex[3], datoKardex[4], datoKardex[5],
                    datoKardex[6],datoKardex[7]});
            }
        } catch (SQLException ex) {
            CUtilitarios.msg_error("No se pudo cargar la informacion en la tabla", "Cargando Tabla");
        }
    }

    public void aplicaFiltros() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        tr = new TableRowSorter<>(modelo);
        JtableKardex.setRowSorter(tr);
        ArrayList<RowFilter<Object, Object>> filtros = new ArrayList<>();
        if (!JtxtNombreAlumno.getText().trim().isEmpty()) {
            filtros.add(RowFilter.regexFilter("^" + JtxtNombreAlumno.getText().trim() + "$", 0));
        }
        if (!JtxtMatriculaAlumno.getText().trim().isEmpty()) {
            filtros.add(RowFilter.regexFilter("^" + JtxtMatriculaAlumno.getText().trim() + "$", 1));
        }
        RowFilter<Object, Object> rf = RowFilter.andFilter(filtros);
        tr.setRowFilter(rf);
    }
    
    private String[] obtenerValoresFilaTabla() {
        String[] valores = new String[4];
        int filaSeleccionada = JtableKardex.getSelectedRow();
        if (filaSeleccionada != -1) {
            for (int i = 0; i < JtableKardex.getColumnCount(); i++) {
                valores[i] = (String) JtableKardex.getValueAt(filaSeleccionada, i);
            }
        } else {
            CUtilitarios.msg_error("No hay fila seleccionada", "Obteniendo datos fila");
            return null;
        }
        return valores;
    }
    
   



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JSPTablaKardex = new javax.swing.JScrollPane();
        JtableKardex = new javax.swing.JTable();
        JlblNombreAlumno = new javax.swing.JLabel();
        JtxtNombreAlumno = new javax.swing.JTextField();
        JlblMatriculaAlumno = new javax.swing.JLabel();
        JtxtMatriculaAlumno = new javax.swing.JTextField();
        JbtnActualizaDato = new javax.swing.JButton();
        JbtnEliminaAlumno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Kardex");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JtableKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alumno", "Matricula", "Clave Asignatura", "Asignatura", "Docente", "Periodo", "Origen", "Calificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JSPTablaKardex.setViewportView(JtableKardex);

        JlblNombreAlumno.setText("Nombre del alumno");

        JtxtNombreAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JtxtNombreAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtxtNombreAlumnoKeyReleased(evt);
            }
        });

        JlblMatriculaAlumno.setText("Matricula");

        JtxtMatriculaAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JtxtMatriculaAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtxtMatriculaAlumnoKeyReleased(evt);
            }
        });

        JbtnActualizaDato.setText("Actualizar datos");

        JbtnEliminaAlumno.setText("Eliminar alumno");

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JlblNombreAlumno)
                    .addComponent(JtxtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlblMatriculaAlumno)
                    .addComponent(JtxtMatriculaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JbtnEliminaAlumno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbtnActualizaDato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPTablaKardex, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblNombreAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtxtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlblMatriculaAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JtxtMatriculaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbtnActualizaDato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbtnEliminaAlumno))
                    .addComponent(JSPTablaKardex, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void JtxtNombreAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtNombreAlumnoKeyReleased
        aplicaFiltros();
    }//GEN-LAST:event_JtxtNombreAlumnoKeyReleased

    private void JtxtMatriculaAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtxtMatriculaAlumnoKeyReleased
        aplicaFiltros();
    }//GEN-LAST:event_JtxtMatriculaAlumnoKeyReleased

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
            java.util.logging.Logger.getLogger(JfBuscaKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfBuscaKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfBuscaKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfBuscaKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfBuscaKardex(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaKardex;
    private javax.swing.JButton JbtnActualizaDato;
    private javax.swing.JButton JbtnEliminaAlumno;
    private javax.swing.JLabel JlblMatriculaAlumno;
    private javax.swing.JLabel JlblNombreAlumno;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableKardex;
    private javax.swing.JTextField JtxtMatriculaAlumno;
    private javax.swing.JTextField JtxtNombreAlumno;
    // End of variables declaration//GEN-END:variables
}
