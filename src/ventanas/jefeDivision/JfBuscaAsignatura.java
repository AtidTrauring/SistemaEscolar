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

public class JfBuscaAsignatura extends javax.swing.JFrame {

    private static String[] datosJefe;
    private DefaultTableModel modelo;
    private TableRowSorter tr;
    private final CBusquedas cb = new CBusquedas();
    private ArrayList<String[]> datosAsignatura = new ArrayList<>();
    private final CCargaCombos queryCarga = new CCargaCombos();
    private DefaultComboBoxModel listas;
    private ArrayList<String> datosListas = new ArrayList<>();

    public JfBuscaAsignatura(String[] datos) {
        initComponents();
        datosJefe = datos;
        cargarTabla();
        cargaComboBox(JcmbxCarrera, 1);
        cargaComboBox(JcmbxTA, 2);
        cargaComboBox(JcmbxHT, 3);
        cargaComboBox(JcmbxHP, 4);
        cargaComboBox(JcmbxNumCreditos, 5);
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) JtableAsignatura.getModel();
        modelo.setRowCount(0);
    }

    public void limpiarFiltro() {
        if (tr != null) {
            tr.setRowFilter(null);
        }
    }

    public void cargarTabla() {
        modelo = (DefaultTableModel) JtableAsignatura.getModel();
        try {
            datosAsignatura = cb.buscaRAsignatura2();
            limpiarTabla();
            for (String[] datoAsignatura : datosAsignatura) {
                modelo.addRow(new Object[]{datoAsignatura[0], datoAsignatura[1], datoAsignatura[2], datoAsignatura[3],
                    datoAsignatura[4], datoAsignatura[5]});
            }
            tr = new TableRowSorter<>(modelo);
            JtableAsignatura.setRowSorter(tr);
        } catch (SQLException e) {
            CUtilitarios.msg_error("No se pudo cargar la informacion en la tabla", "Cargando Tabla");
        }
    }

    public void cargaComboBox(JComboBox combo, int metodoCarga) {
        listas = (DefaultComboBoxModel) combo.getModel();
        try {
            switch (metodoCarga) {
                case 1:
                    datosListas = queryCarga.cargaComboCarrera();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 2:
                    datosListas = queryCarga.cargaComboTIpoAsig();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 3:
                    datosListas = queryCarga.cargaComboAsigHT();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 4:
                    datosListas = queryCarga.cargaComboAsigHP();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 5:
                    datosListas = queryCarga.cargaComboAsigCred();
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
        modelo = (DefaultTableModel) JtableAsignatura.getModel();
        tr = new TableRowSorter<>(modelo);
        JtableAsignatura.setRowSorter(tr);
        ArrayList<RowFilter<Object, Object>> filtros = new ArrayList<>();
        if (JcmbxCarrera.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxCarrera.getSelectedItem().toString(), 0));
        }
        if (JcmbxTA.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxTA.getSelectedItem().toString(), 1));
        }
        if (JcmbxHT.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxHT.getSelectedItem().toString(), 3));
        }
        if (JcmbxHP.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxHP.getSelectedItem().toString(), 4));
        }
        if (JcmbxNumCreditos.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxNumCreditos.getSelectedItem().toString(), 5));
        }
        RowFilter<Object, Object> rf = RowFilter.andFilter(filtros);
        tr.setRowFilter(rf);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblCarrera = new javax.swing.JLabel();
        JcmbxCarrera = new javax.swing.JComboBox<>();
        JlblTA = new javax.swing.JLabel();
        JcmbxTA = new javax.swing.JComboBox<>();
        JlblHT = new javax.swing.JLabel();
        JcmbxHT = new javax.swing.JComboBox<>();
        JlblHP = new javax.swing.JLabel();
        JcmbxHP = new javax.swing.JComboBox<>();
        JlblNumCreditos = new javax.swing.JLabel();
        JcmbxNumCreditos = new javax.swing.JComboBox<>();
        JSPTablaAsignatura = new javax.swing.JScrollPane();
        JtableAsignatura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca asignatura");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JlblCarrera.setText("Carrera");

        JcmbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxCarreraActionPerformed(evt);
            }
        });

        JlblTA.setText("Tipo de asignatura");

        JcmbxTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxTAActionPerformed(evt);
            }
        });

        JlblHT.setText("Horas teoricas");

        JcmbxHT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxHTActionPerformed(evt);
            }
        });

        JlblHP.setText("Horas practicas");

        JcmbxHP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxHPActionPerformed(evt);
            }
        });

        JlblNumCreditos.setText("Creditos");

        JcmbxNumCreditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxNumCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxNumCreditosActionPerformed(evt);
            }
        });

        JtableAsignatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carrera", "Tipo de Asignatura", "Asignatura", "Horas practicas", "Horas teoricas", "Creditos"
            }
        ));
        JSPTablaAsignatura.setViewportView(JtableAsignatura);

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSPTablaAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblCarrera)
                            .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblTA)
                            .addComponent(JcmbxTA, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addComponent(JlblHT)
                                .addGap(87, 87, 87)
                                .addComponent(JlblHP))
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(JcmbxHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JcmbxHP, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblNumCreditos)
                            .addComponent(JcmbxNumCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlblTA)
                    .addComponent(JlblCarrera)
                    .addComponent(JlblHT)
                    .addComponent(JlblHP)
                    .addComponent(JlblNumCreditos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcmbxTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcmbxHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcmbxHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcmbxNumCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JSPTablaAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpnlLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void JcmbxCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxCarreraActionPerformed
        // TODO add your handling code here:
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxCarreraActionPerformed

    private void JcmbxTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxTAActionPerformed
        // TODO add your handling code here:
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxTAActionPerformed

    private void JcmbxHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxHTActionPerformed
        // TODO add your handling code here:
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxHTActionPerformed

    private void JcmbxHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxHPActionPerformed
        // TODO add your handling code here:
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxHPActionPerformed

    private void JcmbxNumCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxNumCreditosActionPerformed
        // TODO add your handling code here:
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxNumCreditosActionPerformed
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
            java.util.logging.Logger.getLogger(JfBuscaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfBuscaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfBuscaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfBuscaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfBuscaAsignatura(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaAsignatura;
    private javax.swing.JComboBox<String> JcmbxCarrera;
    private javax.swing.JComboBox<String> JcmbxHP;
    private javax.swing.JComboBox<String> JcmbxHT;
    private javax.swing.JComboBox<String> JcmbxNumCreditos;
    private javax.swing.JComboBox<String> JcmbxTA;
    private javax.swing.JLabel JlblCarrera;
    private javax.swing.JLabel JlblHP;
    private javax.swing.JLabel JlblHT;
    private javax.swing.JLabel JlblNumCreditos;
    private javax.swing.JLabel JlblTA;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableAsignatura;
    // End of variables declaration//GEN-END:variables
}
