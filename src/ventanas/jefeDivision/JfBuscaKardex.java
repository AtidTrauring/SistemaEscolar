package ventanas.jefeDivision;

import crud.CBusquedas;
import crud.CMensajes;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class JfBuscaKardex extends javax.swing.JFrame {

    //**************   ATRIBUTOS  *******************/
    private DefaultTableModel modelo;
    private TableRowSorter tr;
    private final CBusquedas queryBusca = new CBusquedas();
    private ArrayList<String[]> datosKardex = new ArrayList<>();

    public JfBuscaKardex() {
        initComponents();
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        modelo.setRowCount(0);
    }

    public void cargarTabla() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        try {
            datosKardex = queryBusca.buscaTerminalesCompletas();
            limpiarTabla();
            for (String[] datosTerminal : datosKardex) {
                modelo.addRow(new Object[]{datosTerminal[1], datosTerminal[2], datosTerminal[3], datosTerminal[4], datosTerminal[5], datosTerminal[6],
                    datosTerminal[7], datosTerminal[8]});
            }
            tr = new TableRowSorter<>(modelo);
            JtableKardex.setRowSorter(tr);
        } catch (SQLException ex) {
            CMensajes.msg_error("No se pudo cargar la informacion en la tabla", "Cargando Tabla");
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
            filtros.add(RowFilter.regexFilter("^" + JtxtMatriculaAlumno.getText().trim() + "$", 0));
        }
        RowFilter<Object, Object> rf = RowFilter.andFilter(filtros);
        tr.setRowFilter(rf);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Kardex");
        setResizable(false);

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JtableKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave Asignatura", "Asignatura", "Docente", "Inicio", "Termino", "Origen", "Calificación"
            }
        ));
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
                    .addComponent(JtxtMatriculaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPTablaKardex, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(JtxtMatriculaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            java.util.logging.Logger.getLogger(JfBuscaKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfBuscaKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfBuscaKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfBuscaKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfBuscaKardex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaKardex;
    private javax.swing.JLabel JlblMatriculaAlumno;
    private javax.swing.JLabel JlblNombreAlumno;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableKardex;
    private javax.swing.JTextField JtxtMatriculaAlumno;
    private javax.swing.JTextField JtxtNombreAlumno;
    // End of variables declaration//GEN-END:variables
}
