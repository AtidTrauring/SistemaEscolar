package ventanas.alumnos;

import crud.CBusquedas;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utilitarios.CUtilitarios;

public class JfHistorialAcademico extends javax.swing.JFrame {

    //**************   ATRIBUTOS  *******************/
    // Variable para manipular el modelo de la tabla
    private DefaultTableModel modelo;
    // Instanci de la clase que permite hacer la consulta
    private CBusquedas cb = new CBusquedas();
    // Creacion de lista, para la obtencion de valores de la tabla
    private ArrayList<String[]> datosVersiones = new ArrayList<>();
    // Variable para obtener datos del Estudiante
    private static String[] datosAlumno;

    public JfHistorialAcademico(String[] datos) {
        initComponents();
        JtableKardex.getTableHeader().setReorderingAllowed(false);
        datosAlumno = datos;
        cargarTabla();
    }

    // Metodo para limpiar la tabla
    private void limpiarTabla() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        modelo.setRowCount(0);
    }

    // Metodo que permite ingresar los valores necesarios a la tabla
    private void cargarTabla() {
        // Obtenemos el modelo para poder manipularlo
        modelo = (DefaultTableModel) JtableKardex.getModel();
        try {
            // Leer los datos
            datosVersiones = cb.buscaHistorialEstudiante(datosAlumno[1]);
            // Limpiamos la tabla
            limpiarTabla();
            // Asignamos los valores obtenidos en la tabla
            for (String[] datosVersion : datosVersiones) {
                modelo.addRow(new Object[]{datosVersion[0], datosVersion[1], datosVersion[2], datosVersion[3]});
            }
        } catch (SQLException e) {
            CUtilitarios.msg_error("No se pudo cargar la informacion en la tabla", "Cargando Tabla");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JSPTablaKardex = new javax.swing.JScrollPane();
        JtableKardex = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial academico");
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
                "Asignatura", "Creditos", "Calificacion", "Periodo"
            }
        ));
        JSPTablaKardex.setViewportView(JtableKardex);

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSPTablaKardex, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSPTablaKardex, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        JfMenuAlumnos ma = new JfMenuAlumnos(datosAlumno);
        CUtilitarios.creaFrame(ma, datosAlumno[2]);
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
            java.util.logging.Logger.getLogger(JfHistorialAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfHistorialAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfHistorialAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfHistorialAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfHistorialAcademico(datosAlumno).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaKardex;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableKardex;
    // End of variables declaration//GEN-END:variables
}
