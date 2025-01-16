package ventanas.jefeDivision;

import crud.CBusquedas;
import crud.CCargaCombos;
import crud.CInserciones;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import utilitarios.CUtilitarios;
import javax.swing.JTextField;

public class JfADireccion extends javax.swing.JFrame {

    private final CBusquedas queryBusca1 = new CBusquedas();
    private final CBusquedas queryBusca2 = new CBusquedas();
    private final CInserciones queryInserta1 = new CInserciones();
    private final CCargaCombos queryCarga = new CCargaCombos();

    private static String[] datosJefe;
    private static String[] datosPersona;
    private String calle, colonia, codigoPostal, num_Int, num_Ext, municipio, nombreEstado;
    private String regexNombre = "^[a-zA-Z]{1,80}$";
    private String regexCodigoPostal = "^[0-9]{5}$";
    private String regexEstado = "^[a-zA-Z]{1,19}$";
    private String regexMunicipio = "^[a-zA-Z]{1,80}$";
    private String regexCalle = "^[a-zA-Z]{1,80}$";
    private String regexNumero = "^[0-9]{1,5}$";
    private String regexColonia = "^[a-zA-Z]{1,80}$";
    private DefaultComboBoxModel listas;
    private ArrayList<String> datosListas = new ArrayList<>();
    private String titulos = this.getTitle();

    public JfADireccion(String[] datosJ, String[] datosP, String nombreBoton) {
        initComponents();
        JbtnEnviar.setText(nombreBoton);
        cargaComboBox(JcmbxEstado);
    }

    public void cargaComboBox(JComboBox combo) {
        listas = (DefaultComboBoxModel) combo.getModel();
        try {
            datosListas = queryCarga.cargaComboEstados();
            for (int i = 1; i < datosListas.size(); i++) {
                listas.addElement(datosListas.get(i));
            }
            datosListas.clear();
        } catch (SQLException e) {
            CUtilitarios.msg_advertencia("No se pudieron cargar los estados", "Agrega direccion");
        }
    }

    public boolean validaCampos() {
        return CUtilitarios.validaCampo(calle, JtxtCalle, regexCalle, "Ingrese la calle", "Calle invalida", titulos)
                && CUtilitarios.validaCampo(colonia, JtxtBarrio, regexColonia, "Ingrese la colonia", "Colonia invalida", titulos)
                && CUtilitarios.validaCampo(codigoPostal, JtxtCP, regexCodigoPostal, "Ingrese el Codigo postal", "Codigo postal invalido", titulos)
                && CUtilitarios.validaCampo(num_Int, JtxtNumeroInt, regexNumero, "Ingrese el numero", "Numero Interior invalido", titulos)
                && CUtilitarios.validaCampo(num_Ext, JtxtNumeroExt, regexNumero, "Ingrese el numero", "Numero Exterior invalido", titulos)
                && CUtilitarios.validaCampo(municipio, JtxtMunicipio, regexMunicipio, "Ingrese el municipio", "Municipio invalido", titulos)
                && CUtilitarios.validaComboBox(nombreEstado, JcmbxEstado, "Seleccione un estado", titulos);

    }

        private String obtenValorCombo() {
        String estado = (String) JcmbxEstado.getSelectedItem();
        if (estado == null || estado.equals("Seleccione una opcion")) {
            CUtilitarios.msg_advertencia("Por favor, seleccione una ocupacion", "Advertencia");
            estado = null;
        }
        return estado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblCalle = new javax.swing.JLabel();
        JtxtCalle = new javax.swing.JTextField();
        JspCalle = new javax.swing.JSeparator();
        JlblBarrio = new javax.swing.JLabel();
        JtxtBarrio = new javax.swing.JTextField();
        JspBarrio = new javax.swing.JSeparator();
        JlblCP = new javax.swing.JLabel();
        JtxtCP = new javax.swing.JTextField();
        JspCP = new javax.swing.JSeparator();
        JlblNumeroInt = new javax.swing.JLabel();
        JtxtNumeroInt = new javax.swing.JTextField();
        JspNumeroInt = new javax.swing.JSeparator();
        JlblNumeroExt = new javax.swing.JLabel();
        JtxtNumeroExt = new javax.swing.JTextField();
        JspNumerpExt = new javax.swing.JSeparator();
        JlblMunicipio = new javax.swing.JLabel();
        JtxtMunicipio = new javax.swing.JTextField();
        JspMunicipio = new javax.swing.JSeparator();
        JlblEstado = new javax.swing.JLabel();
        JcmbxEstado = new javax.swing.JComboBox<>();
        JlblNombre = new javax.swing.JLabel();
        JtxtNombre = new javax.swing.JTextField();
        JsNombre = new javax.swing.JSeparator();
        JbtnEnviar = new javax.swing.JButton();
        JlblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agrega direccion");
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

        JlblCalle.setText("Nombre de la vialidad");

        JtxtCalle.setToolTipText("Ingrese la vialidad usando puras letras mayusculas o minusculas");
        JtxtCalle.setBorder(null);

        JlblBarrio.setText("Colonia/Barrio");

        JtxtBarrio.setToolTipText("Ingrese la colonia usando puras letras mayusculas o minusculas");
        JtxtBarrio.setBorder(null);

        JlblCP.setText("Codigo Postal");

        JtxtCP.setToolTipText("Ingrese el codigo postal usando solo 5 numeros en total");
        JtxtCP.setBorder(null);

        JlblNumeroInt.setText("Numero Interior");

        JtxtNumeroInt.setToolTipText("Ingrese el numero habitacional usando puros numeros que puede ir del 1 a 5 como maximo");
        JtxtNumeroInt.setBorder(null);

        JlblNumeroExt.setText("Numero Exterior");

        JtxtNumeroExt.setToolTipText("Ingrese el numero habitacional usando puros numeros que puede ir del 1 a 5 como maximo");
        JtxtNumeroExt.setBorder(null);

        JlblMunicipio.setText("Municipio");

        JtxtMunicipio.setToolTipText("Ingrese la ciudad usando puras letras mayusculas o minusculas");
        JtxtMunicipio.setBorder(null);

        JlblEstado.setText("Estado");

        JcmbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblNombre.setText("Ingresa nombre de la persona");

        JtxtNombre.setBorder(null);

        JbtnEnviar.setBackground(new java.awt.Color(153, 204, 255));
        JbtnEnviar.setText("Enviar");
        JbtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnEnviarActionPerformed(evt);
            }
        });

        JlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoADireccoin.png"))); // NOI18N

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JtxtCalle, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(JspCalle)
                        .addComponent(JlblCalle)
                        .addComponent(JlblBarrio)
                        .addComponent(JtxtBarrio)
                        .addComponent(JspBarrio)
                        .addComponent(JlblCP)
                        .addComponent(JtxtCP))
                    .addComponent(JlblNombre)
                    .addComponent(JtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JspCP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlblEstado)
                    .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JcmbxEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE)
                        .addComponent(JsNombre, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblNumeroExt)
                            .addComponent(JspNumeroInt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblNumeroInt)
                            .addComponent(JlblMunicipio)
                            .addComponent(JtxtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JspMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtxtNumeroExt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JspNumerpExt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addComponent(JtxtNumeroInt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JbtnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblFondo)
                        .addGap(44, 44, 44))))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblNombre)
                        .addGap(12, 12, 12)
                        .addComponent(JtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JcmbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(JlblCalle)
                        .addGap(2, 2, 2)
                        .addComponent(JtxtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlblBarrio)
                        .addGap(2, 2, 2)
                        .addComponent(JtxtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JlblCP)
                        .addGap(2, 2, 2)
                        .addComponent(JtxtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblFondo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlblNumeroInt)
                        .addGap(2, 2, 2)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtxtNumeroInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbtnEnviar))
                        .addGap(2, 2, 2)
                        .addComponent(JspNumeroInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(JlblNumeroExt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JtxtNumeroExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JspNumerpExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlblMunicipio)
                        .addGap(2, 2, 2)
                        .addComponent(JtxtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        // Enviar String[5]
        /*
        datosPersona
        [0] -> Nombre
        [1] -> Paterno
        [2] -> Materno
        [3] -> Ocupacion
        [4] -> idCarrera
        [5] -> telefono
        [6] -> correo
         */
 /*
        datosDireccion
        [0] -> IdDireccion
        [1] -> Calle
        [2] -> Numero Interior
        [3] -> Numero Exterior
        [4] -> Clave colonia
        [5] -> Clave codigo postal
        [6] -> Clave municipio
         */
        if (validaCampos()) {
            String[] datosDireccion = new String[7];
            try {
//                datosDireccion[0] = ;
                datosDireccion[1] = JtxtCalle.getText();
                datosDireccion[2] = JtxtNumeroInt.getText();
                datosDireccion[3] = JtxtNumeroExt.getText();
//                datosDireccion[0] =;
//                datosDireccion[0] =;

            } catch (Exception e) {
            }
            System.out.println("Datos direccion");
            for (String string : datosDireccion) {
                System.out.println(string);
            }
            System.out.println("Datos Persona");
            for (String string : datosPersona) {
                System.out.println(string);
            }
            this.hide();
        }
    }//GEN-LAST:event_JbtnEnviarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JfMenuJefe mj = new JfMenuJefe(datosJefe);
        CUtilitarios.creaFrame(mj, datosJefe[2]);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (datosPersona != null && datosPersona.length > 0) {
            JtxtNombre.setText(datosPersona[0] + " " + datosPersona[1] + " " + datosPersona[2]);
            JtxtNombre.setEditable(false);
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
            java.util.logging.Logger.getLogger(JfADireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfADireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfADireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfADireccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfADireccion(datosJefe, datosPersona, new String()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnEnviar;
    private javax.swing.JComboBox<String> JcmbxEstado;
    private javax.swing.JLabel JlblBarrio;
    private javax.swing.JLabel JlblCP;
    private javax.swing.JLabel JlblCalle;
    private javax.swing.JLabel JlblEstado;
    private javax.swing.JLabel JlblFondo;
    private javax.swing.JLabel JlblMunicipio;
    private javax.swing.JLabel JlblNombre;
    private javax.swing.JLabel JlblNumeroExt;
    private javax.swing.JLabel JlblNumeroInt;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JSeparator JsNombre;
    private javax.swing.JSeparator JspBarrio;
    private javax.swing.JSeparator JspCP;
    private javax.swing.JSeparator JspCalle;
    private javax.swing.JSeparator JspMunicipio;
    private javax.swing.JSeparator JspNumeroInt;
    private javax.swing.JSeparator JspNumerpExt;
    private javax.swing.JTextField JtxtBarrio;
    private javax.swing.JTextField JtxtCP;
    private javax.swing.JTextField JtxtCalle;
    private javax.swing.JTextField JtxtMunicipio;
    private javax.swing.JTextField JtxtNombre;
    private javax.swing.JTextField JtxtNumeroExt;
    private javax.swing.JTextField JtxtNumeroInt;
    // End of variables declaration//GEN-END:variables
}
