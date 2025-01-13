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
    private String calle, colonia, codigoPostal, num_Int, num_Ext, municipio, estado;
    private String regexNombre = "^[a-zA-Z]{1,80}$";
    private String regexCodigoPostal = "^[0-9]{5}$";
    private String regexEstado = "^[a-zA-Z]{1,19}$";
    private String regexMunicipio = "^[a-zA-Z]{1,80}$";
    private String regexCalle = "^[a-zA-Z]{1,80}$";
    private String regexNumero = "^[0-9]{1,5}$";
    private String regexColonia = "^[a-zA-Z]{1,80}$";
    private DefaultComboBoxModel listas;
    private ArrayList<String> datosListas = new ArrayList<>();
    private String nombreEstado;

    public JfADireccion(String[] datosJ, String[] datosP, String nombreBoton) {
        initComponents();
        JbtnEnviar.setText(nombreBoton);
    }

    public JfADireccion() {
        initComponents();
        cargaComboBox(JcmbxEstado, 1);
    }

    public void cargaComboBox(JComboBox combo, int metodoCarga) {
        listas = (DefaultComboBoxModel) combo.getModel();
        try {
            switch (metodoCarga) {
                case 1:
                    datosListas = queryCarga.cargaComboEstados();
                    for (int i = 1; i < datosListas.size(); i++) {
                        listas.addElement(datosListas.get(i));
                    }
                    datosListas.clear();
                    break;
            }
        } catch (SQLException e) {
        }
    }

    public void asignaValores() {
        calle = JtxtCalle.getText();
        colonia = JtxtBarrio.getText();
        codigoPostal = JtxtCP.getText();
        num_Int = JtxtNumeroInt.getText();
        num_Ext = JtxtNumeroExt.getText();
        municipio = JtxtMunicipio.getText();
        estado = (String) JcmbxEstado.getSelectedItem();
    }

    public void limpiaValores() {
        calle = null;
        colonia = null;
        codigoPostal = null;
        num_Int = null;
        num_Ext = null;
        municipio = null;
        estado = null;
    }

    public boolean validaCampos() {
        return CUtilitarios.validaCampo(calle, JtxtCalle, regexCalle, "Ingrese la calle", "Calle invalida")
                && CUtilitarios.validaCampo(colonia, JtxtBarrio, regexColonia, "Ingrese la colonia", "Colonia invalida")
                && CUtilitarios.validaCampo(codigoPostal, JtxtCP, regexCodigoPostal, "Ingrese el Codigo postal", "Codigo postal invalido")
                && CUtilitarios.validaCampo(num_Int, JtxtNumeroInt, regexNumero, "Ingrese el numero", "Numero Interior invalido")
                && CUtilitarios.validaCampo(num_Ext, JtxtNumeroExt, regexNumero, "Ingrese el numero", "Numero Exterior invalido")
                && CUtilitarios.validaCampo(municipio, JtxtMunicipio, regexMunicipio, "Ingrese el municipio", "Municipio invalido")
                && CUtilitarios.validaComboBox(nombreEstado, JcmbxEstado, "Seleccione un estado");

    }

    public void BuscaCamposColonia(String colonia) throws SQLException {
        try {
            String resultado = queryBusca1.buscarIdColonia(colonia);
            String IdCol = queryBusca2.obtenIdFinalColoniaa();
            int clave_colonia = Integer.parseInt(IdCol);
            if (resultado == null) {
                queryInserta1.insertaColonia(clave_colonia + 1, colonia);
                System.out.println("Se inserto colonia:" + colonia);
            } else {
                CUtilitarios.msg_advertencia("La colonia ya esta registrada", "Registro colonia");
                System.out.println("Encontrado");
            }

        } catch (Exception e) {
        }
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
        JlblEstado = new javax.swing.JLabel();
        JcmbxEstado = new javax.swing.JComboBox<>();
        JlblFondo = new javax.swing.JLabel();
        JbtnEnviar = new javax.swing.JButton();
        JlblMunicipio = new javax.swing.JLabel();
        JtxtMunicipio = new javax.swing.JTextField();
        JspMunicipio = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agrega direccion");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
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

        JlblEstado.setText("Estado");

        JcmbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        JlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoADireccoin.png"))); // NOI18N

        JbtnEnviar.setBackground(new java.awt.Color(153, 204, 255));
        JbtnEnviar.setText("Enviar");
        JbtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnEnviarActionPerformed(evt);
            }
        });

        JlblMunicipio.setText("Municipio");

        JtxtMunicipio.setToolTipText("Ingrese la ciudad usando puras letras mayusculas o minusculas");
        JtxtMunicipio.setBorder(null);
        JtxtMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtxtMunicipioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblNumeroExt)
                            .addComponent(JtxtNumeroExt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JspNumeroInt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblNumeroInt)
                            .addComponent(JtxtNumeroInt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtxtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JspCP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(JlblFondo)
                        .addGap(47, 47, 47))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JspNumerpExt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtxtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JspCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblCalle)
                            .addComponent(JlblBarrio)
                            .addComponent(JlblCP)
                            .addComponent(JtxtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JspBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblMunicipio)
                            .addComponent(JtxtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JspMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblEstado))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JcmbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbtnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlblCalle)
                .addGap(2, 2, 2)
                .addComponent(JtxtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JspCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JlblBarrio)
                .addGap(2, 2, 2)
                .addComponent(JtxtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JspBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JlblCP)
                .addGap(2, 2, 2)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JtxtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JlblNumeroInt)
                        .addGap(2, 2, 2)
                        .addComponent(JtxtNumeroInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspNumeroInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(JlblNumeroExt)
                        .addGap(2, 2, 2)
                        .addComponent(JtxtNumeroExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JlblFondo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JspNumerpExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JlblMunicipio)
                .addGap(2, 2, 2)
                .addComponent(JtxtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JspMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlblEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcmbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        JfAPersona rb = new JfAPersona(datosJefe, "Datos de la persona", "Actualizar");
        CUtilitarios.creaFrame(rb, "Actualiza direccion");
    }//GEN-LAST:event_JbtnEnviarActionPerformed

    private void JtxtMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtxtMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtxtMunicipioActionPerformed

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
    private javax.swing.JLabel JlblNumeroExt;
    private javax.swing.JLabel JlblNumeroInt;
    private javax.swing.JPanel JpnlLienzo;
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
    private javax.swing.JTextField JtxtNumeroExt;
    private javax.swing.JTextField JtxtNumeroInt;
    // End of variables declaration//GEN-END:variables
}
