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

public class JfBuscaAlumno extends javax.swing.JFrame {

    private static String[] datosJefe;
    private DefaultTableModel modelo;
    private TableRowSorter tr;
    private CBusquedas cb = new CBusquedas();
    private DefaultComboBoxModel listas;
    private final CCargaCombos queryCarga = new CCargaCombos();
    private ArrayList<String> datosListas = new ArrayList<>();
    private ArrayList<String[]> datosKardex = new ArrayList<>();
    private ArrayList<String[]> datosAlumnos = new ArrayList<>();

    public JfBuscaAlumno(String[] datos) {
        initComponents();
        datosJefe = datos;
        cargarTabla();
        cargaComboBox(JcmbxCiclo, 1);
        cargaComboBox(JcmbxGrupo, 2);
        cargaComboBox(JcmbxMunicipio, 3);
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        modelo.setRowCount(0);
    }

    public void limpiarFiltro() {
        if (tr != null) {
            tr.setRowFilter(null);
        }
    }

    public void cargarTabla() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        try {
            datosKardex = cb.buscarAlumno();
            limpiarTabla();

            for (String[] datoKardex : datosKardex) {
                modelo.addRow(new Object[]{datoKardex[0], datoKardex[1], datoKardex[2], datoKardex[3], datoKardex[4],
                    datoKardex[5], datoKardex[6]});
            }
        } catch (SQLException ex) {
            CUtilitarios.msg_error("No se pudo cargar la informacion en la tabla", "Cargando Tabla");
        }
    }

    public void cargaComboBox(JComboBox combo, int metodoCarga) {
        listas = (DefaultComboBoxModel) combo.getModel();
        try {
            switch (metodoCarga) {
                case 1:
                    datosListas = queryCarga.cargaComboCiclo();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 2:
                    datosListas = queryCarga.cargaComboGrupo();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 3:
                    datosListas = queryCarga.cargaComboMunicipio();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
            }
        } catch (SQLException e) {
        }
    }

    public void aplicaFiltros() {
        modelo = (DefaultTableModel) JtableKardex.getModel();
        tr = new TableRowSorter<>(modelo);
        JtableKardex.setRowSorter(tr);
        ArrayList<RowFilter<Object, Object>> filtros = new ArrayList<>();
        if (JcmbxCiclo.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxCiclo.getSelectedItem().toString(), 5));
        }
        if (JcmbxGrupo.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxGrupo.getSelectedItem().toString(), 3));
        }
         if (JcmbxCiclo.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxMunicipio.getSelectedItem().toString(), 6));
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
        JlblMunicipio = new javax.swing.JLabel();
        JcmbxMunicipio = new javax.swing.JComboBox<>();
        JlblCiclo = new javax.swing.JLabel();
        JcmbxCiclo = new javax.swing.JComboBox<>();
        JlblGrupo = new javax.swing.JLabel();
        JcmbxGrupo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar alumno");
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
                "Matricula", "Nombre Completo", "Correo Institucional", "Grupo", "Carrera", "Ciclo", "Municipio"
            }
        ));
        JSPTablaKardex.setViewportView(JtableKardex);

        JlblMunicipio.setText("Municipio");

        JcmbxMunicipio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxMunicipioActionPerformed(evt);
            }
        });

        JlblCiclo.setText("Ciclo");

        JcmbxCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxCicloActionPerformed(evt);
            }
        });

        JlblGrupo.setText("Grupo");

        JcmbxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JlblMunicipio)
                    .addComponent(JcmbxMunicipio, 0, 235, Short.MAX_VALUE)
                    .addComponent(JcmbxCiclo, 0, 235, Short.MAX_VALUE)
                    .addComponent(JlblCiclo)
                    .addComponent(JcmbxGrupo, 0, 235, Short.MAX_VALUE)
                    .addComponent(JlblGrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPTablaKardex, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblMunicipio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JcmbxMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlblCiclo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JcmbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlblGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JcmbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void JcmbxMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxMunicipioActionPerformed
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxMunicipioActionPerformed

    private void JcmbxCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxCicloActionPerformed
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxCicloActionPerformed

    private void JcmbxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxGrupoActionPerformed
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxGrupoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuJefe mj = new JfMenuJefe(datosJefe);
        CUtilitarios.creaFrame(mj, datosJefe[2]);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(JfBuscaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfBuscaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfBuscaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfBuscaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfBuscaAlumno(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaKardex;
    private javax.swing.JComboBox<String> JcmbxCiclo;
    private javax.swing.JComboBox<String> JcmbxGrupo;
    private javax.swing.JComboBox<String> JcmbxMunicipio;
    private javax.swing.JLabel JlblCiclo;
    private javax.swing.JLabel JlblGrupo;
    private javax.swing.JLabel JlblMunicipio;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableKardex;
    // End of variables declaration//GEN-END:variables
}
