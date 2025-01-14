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

public class JfPromedioGrupo extends javax.swing.JFrame {

    // Variable para manipular el modelo de la tabla
    private DefaultTableModel modelo;
    // Variable para poder manipular el modelo de las listas
    private DefaultComboBoxModel listas;
    // Variable para poder agregar filtros
    private TableRowSorter tr;
    private CBusquedas cb = new CBusquedas();
    private CCargaCombos cc = new CCargaCombos();
    private static String[] datosJefe;
    // Creacion de lista, para la obtencion de valores de la tabla
    private ArrayList<String[]> datosGrupo = new ArrayList<>();
    // Creacion de lista, para la obtencion de valores de las listas
    private ArrayList<String> datosListas = new ArrayList<>();

    public JfPromedioGrupo(String[] datos) {
        initComponents();
        datosJefe = datos;
        // Linea para impedir que sea posible mover los encabezados de cada tabla
        JtableGrupo.getTableHeader().setReorderingAllowed(false);
        // Cargar los valores de JComboBox
        cargaComboBox(JcmbxCiclo, 1);
        cargaComboBox(JcmbxGrupo, 2);
        // Cargas los valores de la tabla
        cargarTabla();
    }

    // Metodo para limpiar la tabla
    private void limpiarTabla() {
        modelo = (DefaultTableModel) JtableGrupo.getModel();
        modelo.setRowCount(0);
    }

    public void limpiarFiltro() {
        // Si el objeto 'tr' tiene algun filtro
        if (tr != null) {
            // Elimina el filtro 
            tr.setRowFilter(null);
        }
    }

    // Metodo que permite ingresar los valores necesarios a la tabla
    public void cargarTabla() {
        // Obtenemos el modelo para poder manipularlo
        modelo = (DefaultTableModel) JtableGrupo.getModel();
        try {
            // Leer los datos
            datosGrupo = cb.buscaNoAlumnos();
            // Limpiamos la tabla
            limpiarTabla();
            // Asignamos los valores obtenidos en la tabla
            for (String[] datosGroup : datosGrupo) {
                modelo.addRow(new Object[]{datosGroup[0], datosGroup[1], datosGroup[2]});
            }
            // Crea un TableRowSorter para permitir la ordenación de las filas de la tabla.
            tr = new TableRowSorter<>(modelo);

            // Establece el TableRowSorter en la tabla 'JtableConductores'.
            JtableGrupo.setRowSorter(tr);
        } catch (SQLException e) {
            CUtilitarios.msg_error("No se pudo cargar la informacion en la tabla", "Cargando Tabla");
        }
    }

    /* Metodo que permite cargar las opciones en las listas
     Recibe por parametro el JComboBox al que se agregaran items */
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

    /*Metodo que permite crear una lista de filtros que se puedan aplicar de
    manera simultanea*/
    public void aplicaFiltros() {
        // Obtenemos el modelo de la tabla y lo guardamos en la variable 'modelo'
        modelo = (DefaultTableModel) JtableGrupo.getModel();
        // Creamos un TableRowSorter para el modelo de la tabla y lo guardamos en la variable 'tr'
        tr = new TableRowSorter<>(modelo);
        // Asignamos el TableRowSorter a la tabla para que se pueda ordenar y filtrar
        JtableGrupo.setRowSorter(tr);
        // Creamos una lista para almacenar los filtros que se van a aplicar
        ArrayList<RowFilter<Object, Object>> filtros = new ArrayList<>();
        // Si se selecciona una marca (índice diferente de 0), agregamos un filtro para esa marca
        if (JcmbxCiclo.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxCiclo.getSelectedItem().toString(), 0));
        }
        // Si se selecciona un modelo (índice diferente de 0), agregamos un filtro para ese modelo
        if (JcmbxGrupo.getSelectedIndex() != 0) {
            filtros.add(RowFilter.regexFilter(JcmbxGrupo.getSelectedItem().toString(), 1));
        }
        // Creamos un filtro combinando todos los filtros de la lista
        RowFilter<Object, Object> rf = RowFilter.andFilter(filtros);

        // Aplicamos el filtro combinado al TableRowSorter
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
        JlblPromedioAlumnos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alumnos inscritos");
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

        JtableGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ciclo", "Grupo", "No. de alumnos"
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

        JlblPromedioAlumnos.setBorder(javax.swing.BorderFactory.createTitledBorder("Promedio de alumnos inscritos por grupo"));

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JSPTablaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblCiclo)
                            .addComponent(JcmbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JlblGrupo)
                            .addComponent(JcmbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JlblPromedioAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblCiclo)
                        .addGap(16, 16, 16)
                        .addComponent(JcmbxCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblGrupo)
                        .addGap(16, 16, 16)
                        .addComponent(JcmbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JlblPromedioAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuJefe mj = new JfMenuJefe(datosJefe);
        CUtilitarios.creaFrame(mj, datosJefe[2]);
    }//GEN-LAST:event_formWindowClosed

    private void JcmbxCicloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxCicloItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxCicloItemStateChanged

    private void JcmbxGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcmbxGrupoItemStateChanged
        aplicaFiltros();
    }//GEN-LAST:event_JcmbxGrupoItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        double suma = 0.0;
        int contador = 0;

        // Iteramos sobre el ArrayList
        for (String[] grupo : datosGrupo) {
            // Convertir el valor numérico en la posición [2] de String[] a double
            double valor = Double.parseDouble(grupo[2]);
            suma += valor;  // Sumar el valor al total
            contador++;  // Contamos cuántos valores numéricos hay
        }

        // Si tenemos al menos un valor, calculamos el promedio
        if (contador > 0) {
            double promedio = suma / contador;
            double promedioP;
            promedioP = Math.round(promedio);
            // Redondear el promedio a dos decimales
//            Math.round(promedio * 100.0) / 100.0
            JlblPromedioAlumnos.setText(String.valueOf(promedioP));
        }
    }//GEN-LAST:event_formWindowOpened
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
            java.util.logging.Logger.getLogger(JfPromedioGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfPromedioGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfPromedioGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfPromedioGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfPromedioGrupo(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSPTablaGrupo;
    private javax.swing.JComboBox<String> JcmbxCiclo;
    private javax.swing.JComboBox<String> JcmbxGrupo;
    private javax.swing.JLabel JlblCiclo;
    private javax.swing.JLabel JlblGrupo;
    private javax.swing.JLabel JlblPromedioAlumnos;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTable JtableGrupo;
    // End of variables declaration//GEN-END:variables
}
