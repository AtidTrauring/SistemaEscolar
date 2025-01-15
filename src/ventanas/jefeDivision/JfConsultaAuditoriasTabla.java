package ventanas.jefeDivision;

import crud.CBuscaAuditorias;
import utilitarios.CUtilitarios;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class JfConsultaAuditoriasTabla extends javax.swing.JFrame {

    //**************   ATRIBUTOS  *******************/
    private final CBuscaAuditorias queryBusca = new CBuscaAuditorias();
    private DefaultTableModel modelo;
    private ArrayList<String[]> datosConsultas;
    private static int opcionEscogida;

    public JfConsultaAuditoriasTabla(int opcionAuditoria) {
        initComponents();
        opcionEscogida = opcionAuditoria;
    }

    //**************** METODOS ******************/
    private void limpiarTabla() {
        modelo = (DefaultTableModel) JtableConsultas.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
    }

    public void cargarTabla(String[] columnas, int numColumnas, int opcionConsulta) {
        modelo = (DefaultTableModel) JtableConsultas.getModel();
        try {
            limpiarTabla();
            switch (opcionConsulta) {
                case 1:
                    datosConsultas = queryBusca.consulta1();
                    break;
                case 2:
                    datosConsultas = queryBusca.consulta2();
                    break;
                case 3:
                    datosConsultas = queryBusca.consulta3();
                    break;
                case 4:
                    datosConsultas = queryBusca.consulta4();
                    break;
                case 5:
                    datosConsultas = queryBusca.consulta5();
                    break;
                case 6:
                    datosConsultas = queryBusca.consulta6();
                    break;
                case 7:
                    datosConsultas = queryBusca.consulta7();
                    break;
                case 8:
                    datosConsultas = queryBusca.consulta8();
                    break;
                case 9:
                    datosConsultas = queryBusca.consulta9();
                    break;
                case 10:
                    datosConsultas = queryBusca.consulta10();
                    break;
                case 11:
                    datosConsultas = queryBusca.consulta11();
                    break;
                case 12:
                    datosConsultas = queryBusca.consulta12();
                    break;
                case 13:
                    datosConsultas = queryBusca.consulta13();
                    break;
                case 14:
                    datosConsultas = queryBusca.consulta14();
                    break;
                case 15:
                    datosConsultas = queryBusca.consulta15();
                    break;
                case 16:
                    datosConsultas = queryBusca.consulta16();
                    break;
                case 17:
                    datosConsultas = queryBusca.consulta17();
                    break;
                case 18:
                    datosConsultas = queryBusca.consulta18();
                    break;
                case 19:
                    datosConsultas = queryBusca.consulta19();
                    break;
                case 20:
                    datosConsultas = queryBusca.consulta20();
                    break;
                case 21:
                    datosConsultas = queryBusca.consulta21();
                    break;
                case 22:
                    datosConsultas = queryBusca.consulta22();
                    break;
                case 23:
                    datosConsultas = queryBusca.consulta23();
                    break;
                case 24:
                    datosConsultas = queryBusca.consulta24();
                    break;
                case 25:
                    datosConsultas = queryBusca.consulta25();
                    break;
                case 26:
                    datosConsultas = queryBusca.consulta26();
                    break;
                case 27:
                    datosConsultas = queryBusca.consulta27();
                    break;
                case 28:
                    datosConsultas = queryBusca.consulta28();
                    break;
                case 29:
                    datosConsultas = queryBusca.consulta29();
                    break;
                case 30:
                    datosConsultas = queryBusca.consulta30();
                    break;
                case 31:
                    datosConsultas = queryBusca.consulta31();
                    break;
            }

            for (int i = 0; i < numColumnas; i++) {
                modelo.addColumn(columnas[i]);
            }
            for (String[] datos : datosConsultas) {
                modelo.addRow(datos);
            }
            JtableConsultas.getTableHeader().setReorderingAllowed(false);
        } catch (SQLException e) {
            CUtilitarios.msg_error("No se pudo cargar la informacion en la tabla", "Cargando Tabla");
        }
    }

    public void eleccionCarga(int opcionAuditoria) {
        switch (opcionAuditoria) {
            case 1:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_asignatura", "nuevo_nombre_asignatura", "nuevo_horas_T", "nuevo_horas_P", "nuevo_numero_unidades", "nuevo_creditos", "nuevo_clave_tasignatura", "viejo_clave_asignatura", "viejo_nombre_asignatura", "viejo_horas_T", "viejo_horas_P", "viejo_numero_unidades", "viejo_creditos", "viejo_clave_tasignatura", "actualizado_clave_asignatura", "actualizado_nombre_asignatura", "actualizado_horas_T", "actualizado_horas_P", "actualizado_numero_unidades", "actualizado_creditos", "actualizado_clave_tasignatura"}, 25, 1);
                break;
            case 2:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_asignatura", "nuevo_clave_semestre", "viejo_clave_asignatura", "viejo_clave_semestre", "actualizado_clave_asignatura", "actualizado_clave_semestre"}, 10, 2);
                break;
            case 3:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_asignatura", "nuevo_clave_unidad", "viejo_clave_asignatura", "viejo_clave_unidad", "actualizado_clave_asignatura", "actualizado_clave_unidad"}, 10, 3);
                break;
            case 4:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_carrera", "nuevo_nombre_carrera", "viejo_clave_producto", "viejo_nombre_carrera", "actualizado_clave_carrera", "actualizado_nombre_carrera"}, 10, 4);
                break;
            case 5:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_asignatura", "nuevo_clave_carrera", "viejo_clave_asignatura", "viejo_clave_carrera", "actualizado_clave_asignatura", "actualizado_clave_carrera"}, 10, 5);
                break;
            case 6:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_ciclo", "nuevo_ciclo", "nuevo_fecha_inicio", "nuevo_fecha_fin", "viejo_clave_ciclo", "viejo_ciclo", "viejo_fecha_inicio", "viejo_fecha_fin", "actualizado_clave_ciclo", "actualizado_ciclo", "actualizado_fecha_inicio", "actualizado_fecha_fin"}, 16, 6);
                break;
            case 7:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_cp", "nuevo_cp", "viejo_clave_origen", "viejo_cp", "actualizado_clave_origen", "actualizado_cp"}, 10, 7);
                break;
            case 8:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_colonia", "nuevo_colonia", "viejo_clave_colonia", "viejo_colonia", "actualizado_clave_colonia", "actualizado_colonia"}, 10, 8);
                break;
            case 9:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_contrasenia", "nuevo_contrasenia", "viejo_clave_contrasenia", "viejo_contrasenia", "actualizado_clave_contrasenia", "actualizado_contrasenia"}, 10, 9);
                break;
            case 10:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_correo", "nuevo_correo", "nuevo_clave_persona", "viejo_clave_correo", "viejo_correo", "viejo_clave_persona", "actualizado_clave_correo", "actualizado_correo", "actualizado_clave_persona"}, 13, 10);
                break;
            case 11:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_dir", "nuevo_calle", "nuevo_num_Inter", "nuevo_num_Exter", "nuevo_clave_colonia", "nuevo_clave_cp", "nuevo_clave_mun", "viejo_clave_dir", "viejo_calle", "viejo_num_Inter", "viejo_num_Exter", "viejo_clave_colonia", "viejo_clave_cp", "viejo_clave_mun", "actualizado_clave_dir", "actualizado_calle", "actualizado_num_Inter", "actualizado_num_Exter", "actualizado_clave_colonia", "actualizado_clave_cp", "actualizado_clave_mun"}, 25, 11);
                break;
            case 12:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_docente", "nuevo_clave_persona", "viejo_clave_docente", "viejo_clave_persona", "actualizado_clave_docente", "actualizado_clave_persona"}, 10, 12);
                break;
            case 13:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_carrera", "nuevo_clave_docente", "viejo_clave_carrera", "viejo_clave_docente", "actualizado_clave_carrera", "actualizado_clave_docente"}, 10, 13);
                break;
            case 14:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_docente", "nuevo_clave_grupo", "viejo_clave_docente", "viejo_clave_grupo", "actualizado_clave_docente", "actualizado_clave_grupo"}, 10, 14);
                break;
            case 15:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_docente", "nuevo_clave_version", "viejo_clave_docente", "viejo_clave_version", "actualizado_clave_docente", "actualizado_clave_version"}, 10, 15);
                break;
            case 16:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_estado", "nuevo_estado", "viejo_clave_estado", "viejo_estado", "actualizado_clave_estado", "actualizado_estado"}, 10, 16);
                break;
            case 17:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_estudiante", "nuevo_clave_persona", "viejo_clave_estudiante", "viejo_clave_persona", "actualizado_clave_estudiante", "actualizado_clave_persona"}, 10, 17);
                break;
            case 18:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_estudiante", "nuevo_clave_carrera", "viejo_clave_estudiante", "viejo_clave_carrera", "actualizado_clave_estudiante", "actualizado_clave_carrera"}, 10, 18);
                break;
            case 19:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_grupo", "nuevo_clave_estudiante", "viejo_clave_grupo", "viejo_clave_estudiante", "actualizado_clave_grupo", "actualizado_clave_estudiante"}, 10, 19);
                break;
            case 20:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_estudiante", "nuevo_clave_version", "nuevo_calificacion", "viejo_clave_estudiante", "viejo_clave_version", "viejo_calificacion", "actualizado_clave_estudiante", "actualizado_clave_version", "actualizado_calificacion"}, 13, 20);
                break;
            case 21:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_grupo", "nuevo_grupo", "nuevo_clave_ciclo", "viejo_clave_grupo", "viejo_grupo", "viejo_clave_ciclo", "actualizado_clave_grupo", "actualizado_grupo", "actualizado_clave_ciclo"}, 13, 21);
                break;
            case 22:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_jefe", "nuevo_clave_persona", "nuevo_clave_carrera", "viejo_clave_jefe", "viejo_clave_persona", "viejo_clave_carrera", "actualizado_clave_jefe", "actualizado_clave_persona", "actualizado_clave_carrera"}, 13, 22);
                break;
            case 23:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_mun", "nuevo_municipio", "nuevo_clave_estado", "viejo_clave_mun", "viejo_municipio", "viejo_clave_estado", "actualizado_clave_mun", "actualizado_municipio", "actualizado_clave_estado"}, 13, 23);
                break;
            case 24:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_origen", "nuevo_origen", "viejo_clave_origen", "viejo_origen", "actualizado_clave_origen", "actualizado_origen"}, 10, 24);
                break;
            case 25:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_persona", "nuevo_ap_paterno", "nuevo_ap_materno", "nuevo_nombre", "nuevo_usuario", "nuevo_clave_contrasenia", "nuevo_clave_dir", "viejo_clave_persona", "viejo_ap_paterno", "viejo_ap_materno", "viejo_nombre", "viejo_usuario", "viejo_clave_contrasenia", "viejo_clave_dir", "actualizado_clave_persona", "actualizado_ap_paterno", "actualizado_ap_materno", "actualizado_nombre", "actualizado_usuario", "actualizado_clave_contrasenia", "actualizado_clave_dir"}, 25, 25);
                break;
            case 26:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_semestre", "nuevo_semestre", "viejo_clave_semestre", "viejo_semestre", "actualizado_clave_semestre", "actualizado_semestre"}, 10, 26);
                break;
            case 27:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_subtema", "nuevo_subtema", "nuevo_clave_unidad", "viejo_clave_subtema", "viejo_subtema", "viejo_clave_unidad", "actualizado_clave_subtema", "actualizado_subtema", "actualizado_clave_unidad"}, 13, 27);
                break;
            case 28:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_telefono", "nuevo_telefono", "nuevo_clave_persona", "viejo_clave_telefono", "viejo_telefono", "viejo_clave_persona", "actualizado_clave_telefono", "actualizado_telefono", "actualizado_clave_persona"}, 13, 28);
                break;
            case 29:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_tasignatura", "nuevo_tipo_asignatura", "viejo_clave_tasignatura", "viejo_tipo_asignatura", "actualizado_clave_tasignatura", "actualizado_tipo_asignatura"}, 10, 29);
                break;
            case 30:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_id_unidad", "nuevo_unidad", "viejo_id_unidad", "viejo_unidad", "actualizado_id_unidad", "actualizado_unidad"}, 10, 30);
                break;
            case 31:
                cargarTabla(new String[]{"id_audita", "accion", "usuario", "fecha", "nuevo_clave_version", "nuevo_clave_asignatura", "nuevo_clave_ciclo", "nuevo_horas_clase", "nuevo_clave_origen", "viejo_clave_version", "viejo_clave_asignatura", "viejo_clave_ciclo", "viejo_horas_clase", "viejo_clave_origen", "actualizado_clave_version", "actualizado_clave_asignatura", "actualizado_clave_ciclo", "actualizado_horas_clase", "actualizado_clave_origen"}, 19, 31);
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JSPTablaConsultas = new javax.swing.JScrollPane();
        JtableConsultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccion de auditorias");
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

        JtableConsultas.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JtableConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JSPTablaConsultas.setViewportView(JtableConsultas);

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSPTablaConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JSPTablaConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        eleccionCarga(opcionEscogida);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfConsultaAuditorias ca = new JfConsultaAuditorias();
        CUtilitarios.creaFrame(ca, "Seleccion de auditorias.");
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
            java.util.logging.Logger.getLogger(JfConsultaAuditoriasTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfConsultaAuditoriasTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfConsultaAuditoriasTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfConsultaAuditoriasTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfConsultaAuditoriasTabla(opcionEscogida).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaConsultas;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableConsultas;
    // End of variables declaration//GEN-END:variables
}
