package ventanas.jefeDivision;

import crud.CBusquedas;
import crud.CCargaCombos;
import crud.CInserciones;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import utilitarios.CUtilitarios;

public class JfAUnidad extends javax.swing.JFrame {

    private static String[] datosJefe;
    private static String[] datosUnidad;
    private String regexUnidad = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 \\-\\_\\(\\)\\[\\]\\+]+$";
    private String unidad, asignatura, carrera;
    private final CBusquedas queryBusca = new CBusquedas();
    private final CInserciones queryInserta = new CInserciones();
    private ArrayList<String> datosListas = new ArrayList<>();
    DefaultComboBoxModel<String> listas;
    private final CCargaCombos queryCarga = new CCargaCombos();

    public JfAUnidad(String[] datosJ, String[] datosU, String nombreBoton) {
        initComponents();
        datosJefe = datosJ;
        datosUnidad = datosU;
        JbtnEnviar.setText(nombreBoton);
        cargaComboBox(JcmbxAsignatura, 1);
        cargaComboBox(JcmbxCarrera, 2);
    }

    public void asignaValores() {
        // Obtener los valores de los campos de texto
        unidad = JtxtUnidad.getText().trim();
        asignatura = (String) JcmbxAsignatura.getSelectedItem();
        carrera = (String) JcmbxCarrera.getSelectedItem();
    }

    public void limpiaValores() {
        // Obtener los valores de los campos de texto
        unidad = null;
        asignatura = null;
        carrera = null;
    }

    public void cargaComboBox(JComboBox combo, int metodoCarga) {
        listas = (DefaultComboBoxModel) combo.getModel();
        try {
            switch (metodoCarga) {
                case 1:
                    datosListas = queryCarga.cargaComboAsignatura();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
                case 2:
                    datosListas = queryCarga.cargaComboCarrera();
                    for (int i = 0; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
            }
        } catch (SQLException e) {
        }
    }

    public String devuelveCadena(JTextField campo, String regex) {
        String cadena = null;
        cadena = campo.getText();
        if (cadena.isEmpty()) {
            cadena = null;
        } else if (cadena.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 \\-\\_\\(\\)\\[\\]\\+]+$")) {
            return cadena;
        } else {
            cadena = "NoValido";
        }
        return cadena;
    }

    public boolean validaCampoComb(String campoTexto, JComboBox<String> comboBox, String mensajeVacio) {
        boolean valida = true;

        campoTexto = (String) comboBox.getSelectedItem(); // Obtener el texto seleccionado del JComboBox

        if (campoTexto == null || campoTexto.equals("Selecciona una opcion")) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Unidad");
            valida = false;
        }

        return valida;
    }

    public boolean validaCampoUnidad(String campoTexto, JTextField campo, String regex, String mensajeVacio, String mensajeInvalido) {
        boolean valida = true;
        campoTexto = devuelveCadena(campo, regex);
        if (campoTexto == null) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Unidad");
            valida = false;
        } else if ("NoValido".equals(campoTexto)) {
            CUtilitarios.msg_error(mensajeInvalido, "Registro Unidad");
            valida = false;
        }
        return valida;
    }

    public boolean validaCampos() {
        return validaCampoUnidad(unidad, JtxtUnidad, regexUnidad, "Ingrese el nombre de la unidad", "Valores invalidos para la unidad")
                && validaCampoComb(asignatura, JcmbxAsignatura, "Seleccione una asignatura")
                && validaCampoComb(carrera, JcmbxCarrera, "Selecciones una carrera");
    }

    public void enviarDatos() {
        int clave_unidad, clave_carrera;
        String nomUnidad, clave_asignatura;
        if (validaCampos()) {
            asignaValores();
            try {
                clave_unidad = queryBusca.obtenClaveUnidadFinal();
                nomUnidad = JtxtUnidad.getText();
                clave_asignatura = queryBusca.obtenClaveAsignatura(asignatura);
                clave_carrera = queryBusca.obtenClaveCarreraSeleccionado(carrera);
                int clave_carreras = queryBusca.obtenClaveCarreraSeleccionado(carrera);

                // Imprimir valores para depuración
                System.out.println("NombreUnidad:" + unidad + "\nNombreAsignatura:" + asignatura + "\nNombreCarrera: " + carrera);
                System.out.println("CUnidad: " + clave_unidad + " CAsignatut:" + clave_asignatura + " CCarrera:" + clave_carrera);

                // Llamar al método de inserción de asignatura
                boolean insercionUnidad = queryInserta.insertaUnidad((clave_unidad + 1), unidad);

                if (insercionUnidad) {
                    // Insertar relación en carrera_asignatura
                    boolean insercionAsignaturaUnidad = queryInserta.insertaAsignatura_Unidad(clave_asignatura, clave_unidad);

                    if (insercionAsignaturaUnidad) {
                        // Mostrar mensaje de éxito y limpiar valores
                        CUtilitarios.msg("La unidad a sido resgitrada", "Registro Unidad");
                        limpiaValores();
                        this.dispose();
                    } else {
                        CUtilitarios.msg_error("Hubo un error al registrar la relación asignatura_unidad", "Error en el Registro");
                    }
                }
            } catch (SQLException ex) {
                CUtilitarios.msg_error("Error en la base de datos: " + ex.getMessage(), "Error de SQL");
            }
        } else {
        }
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
        JtxtUnidad = new javax.swing.JTextField();
        JlblFondo = new javax.swing.JLabel();
        JbtnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agrega unidad");
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

        JlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoUnidad.png"))); // NOI18N

        JbtnEnviar.setBackground(new java.awt.Color(153, 204, 255));
        JbtnEnviar.setText("Enviar");
        JbtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JlblCarrera)
                    .addComponent(JlblAsignatura)
                    .addComponent(JlblUnidad)
                    .addComponent(JtxtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JcmbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JbtnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblFondo)
                        .addGap(30, 30, 30))))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblCarrera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlblAsignatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JcmbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlblUnidad))
                    .addComponent(JlblFondo))
                .addGap(9, 9, 9)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtxtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnEnviar))
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

    private void JbtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnEnviarActionPerformed
        enviarDatos();
    }//GEN-LAST:event_JbtnEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(JfAUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfAUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfAUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfAUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfAUnidad(datosJefe, datosUnidad, new String()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnEnviar;
    private javax.swing.JComboBox<String> JcmbxAsignatura;
    private javax.swing.JComboBox<String> JcmbxCarrera;
    private javax.swing.JLabel JlblAsignatura;
    private javax.swing.JLabel JlblCarrera;
    private javax.swing.JLabel JlblFondo;
    private javax.swing.JLabel JlblUnidad;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JTextField JtxtUnidad;
    // End of variables declaration//GEN-END:variables
}
