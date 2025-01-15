package ventanas.jefeDivision;

import crud.CBusquedas;
import crud.CInserciones;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import utilitarios.CUtilitarios;

public class JfAAsignatura extends javax.swing.JFrame {

    private static String[] datosJefe;
    private static String[] datosAsignatura;
    private String regexNombre = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$";
    private String regexClave = "^[a-zA-Z0-9-]{1,8}$";
    private String regexHP = "^[0-9]+$";
    private String regexHT = "^[0-9]+$";
    private String regexCreditos = "^[0-9]+$";
    private String regexUnidades = "^[0-9]+$";
    private String claveAsig, asignatura, HT, HP, numUnid, creditos, tipoAsig;
    private final CBusquedas queryBusca = new CBusquedas();
    private final CInserciones queryInserta = new CInserciones();

    public JfAAsignatura(String[] datosJ, String[] datosA, String nombreBoton) {
        initComponents();
        datosJefe = datosJ;
        datosAsignatura = datosA;
        JbtnEnviar.setText(nombreBoton);
    }

    public void asignaValores() {
        // Obtener los valores de los campos de texto
        claveAsig = JtxtClave.getText();
        asignatura = JtxtNombre.getText();
        HT = JtxtHT.getText();
        HP = JtxtHP.getText();
        numUnid = JtxtNumeroUnidades.getText();
        creditos = JtxtCreditos.getText();
        tipoAsig = (String) JcmbxTA.getSelectedItem();
    }

    public void limpiaValores() {
        claveAsig = null;
        asignatura = null;
        HT = null;
        HP = null;
        numUnid = null;
        creditos = null;
        tipoAsig = null;
    }

    public String devuelveCadena(JTextField campo, String regex) {
        String cadena = null;
        cadena = campo.getText();
        if (cadena.isEmpty()) {
            cadena = null;
        } else if (cadena.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$")) {
            return cadena;
        } else {
            cadena = "NoValido";
        }
        return cadena;
    }

    public String devuelveCadenaClave(JTextField campo, String regex) {
        String cadena = null;
        cadena = campo.getText();
        if (cadena.isEmpty()) {
            cadena = null;
        } else if (cadena.matches(regexClave)) {
            return cadena;
        } else {
            cadena = "NoValido";
        }
        return cadena;
    }

    public String devuelveCadenaHP(JTextField campo, String regex) {
        String cadena = null;
        cadena = campo.getText();
        if (cadena.isEmpty()) {
            cadena = null;
        } else if (cadena.matches(regexHP)) {
            return cadena;
        } else {
            cadena = "NoValido";
        }
        return cadena;
    }

    public String devuelveCadenaHT(JTextField campo, String regex) {
        String cadena = null;
        cadena = campo.getText();
        if (cadena.isEmpty()) {
            cadena = null;
        } else if (cadena.matches(regexHT)) {
            return cadena;
        } else {
            cadena = "NoValido";
        }
        return cadena;
    }

    public String devuelveCadenaCreditos(JTextField campo, String regex) {
        String cadena = null;
        cadena = campo.getText();
        if (cadena.isEmpty()) {
            cadena = null;
        } else if (cadena.matches(regexCreditos)) {
            return cadena;
        } else {
            cadena = "NoValido";
        }
        return cadena;
    }

    public String devuelveCadenaUnidades(JTextField campo, String regex) {
        String cadena = null;
        cadena = campo.getText();
        if (cadena.isEmpty()) {
            cadena = null;
        } else if (cadena.matches(regexUnidades)) {
            return cadena;
        } else {
            cadena = "NoValido";
        }
        return cadena;
    }

    public boolean validaCampoClave(String campoTexto, JTextField campo, String regex, String mensajeVacio, String mensajeInvalido) {
        boolean valida = true;
        campoTexto = devuelveCadena(campo, regex);

        if (campoTexto == null) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Asignatura");
            valida = false;
        } else if ("NoValido".equals(campoTexto)) {
            CUtilitarios.msg_error(mensajeInvalido, "Registro Asignatura");
            valida = false;
        }
        return valida;
    }

    public boolean validaCampoAsignatura(String campoTexto, JTextField campo, String regex, String mensajeVacio, String mensajeInvalido) {
        boolean valida = true;
        campoTexto = devuelveCadena(campo, regex);
        if (campoTexto == null) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Asignatura");
            valida = false;
        } else if (campoTexto.equals("NoValido")) {
            CUtilitarios.msg_error(mensajeInvalido, "Registro Asignatura");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    public boolean validaCampoHT(String campoTexto, JTextField campo, String regex, String mensajeVacio, String mensajeInvalido) {
        boolean valida = true;
        campoTexto = devuelveCadena(campo, regex);
        if (campoTexto == null) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Asignatura");
            valida = false;
        } else if (campoTexto.equals("NoValido")) {
            CUtilitarios.msg_error(mensajeInvalido, "Registro Asignatura");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    public boolean validaCampoHP(String campoTexto, JTextField campo, String regex, String mensajeVacio, String mensajeInvalido) {
        boolean valida = true;
        campoTexto = devuelveCadena(campo, regex);
        if (campoTexto == null) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Asignatura");
            valida = false;
        } else if (campoTexto.equals("NoValido")) {
            CUtilitarios.msg_error(mensajeInvalido, "Registro Asignatura");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    public boolean validaCampoCreditos(String campoTexto, JTextField campo, String regex, String mensajeVacio, String mensajeInvalido) {
        boolean valida = true;
        campoTexto = devuelveCadena(campo, regex);
        if (campoTexto == null) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Asignatura");
            valida = false;
        } else if (campoTexto.equals("NoValido")) {
            CUtilitarios.msg_error(mensajeInvalido, "Registro Asignatura");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    public boolean validaCampoUnidades(String campoTexto, JTextField campo, String regex, String mensajeVacio, String mensajeInvalido) {
        boolean valida = true;
        campoTexto = devuelveCadena(campo, regex);
        if (campoTexto == null) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Asignatura");
            valida = false;
        } else if (campoTexto.equals("NoValido")) {
            CUtilitarios.msg_error(mensajeInvalido, "Registro Asignatura");
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    public boolean validaCampoTA(String campoTexto, JComboBox<String> comboBox, String mensajeVacio) {
        boolean valida = true;

        campoTexto = (String) comboBox.getSelectedItem(); // Obtener el texto seleccionado del JComboBox

        if (campoTexto.equals("Selecciona una opcion")) {
            CUtilitarios.msg_advertencia(mensajeVacio, "Registro Asignatura");
            valida = false;
        }
        return valida;
    }

    public boolean validaCampos() {
        return (validaCampoClave(claveAsig, JtxtClave, regexClave, "Ingrese la clave.", "Valores invalidos para la clave"))
                && (validaCampoAsignatura(asignatura, JtxtNombre, regexNombre, "Ingrese el nombre de la asignatura", "Valores invalidos para el nombre de la asignatura"))
                && (validaCampoHT(HT, JtxtHT, regexHT, "Ingrerse las horas teoricas", "Valores invalidos para las horas teoricas"))
                && (validaCampoHP(HP, JtxtHP, regexHP, "Ingrese las horas practicas.", "Valores invalidos para las horas practicas"))
                && (validaCampoUnidades(numUnid, JtxtNumeroUnidades, regexUnidades, "Ingrese el numero de unidades", "Valores invalidos para el numero de unidades"))
                && (validaCampoCreditos(creditos, JtxtCreditos, regexCreditos, "Ingrese los creditos", "Valores invalidos para los creditos"))
                && (validaCampoTA(tipoAsig, JcmbxTA, "Ingrese el tipo de asignatura"));
    }

    public void enviarDatos() {
    String clave_asignatura, clave_tipo_asignatura;
    if (validaCampos()) {
        asignaValores();
        try {
            // Obtener las claves
            clave_asignatura = queryBusca.obtenClaveFinalAsignatura(claveAsig);
            clave_tipo_asignatura = queryBusca.obtenClaveTASeleccionado(tipoAsig);

            // Imprimir valores para depuración
            System.out.println("ClaveAsignatura:" + claveAsig + "\nNombreAsignatura:" + asignatura + "\nHorasTeoricas: " + HT + "\nHorasPracticas: " + HP);
            System.out.println("CAsignatura" + clave_asignatura);
            System.out.println("NumerosUnidades: " + numUnid + "\nCreditos:" + creditos);
            System.out.println("TipoAsignatura: " + tipoAsig);
            System.out.println("claveTA: " + clave_tipo_asignatura);

            // Llamar al método de inserción
            boolean insercion = queryInserta.insertaAsignatura(clave_asignatura, asignatura, HT, HP, numUnid, creditos, clave_tipo_asignatura);

            if (insercion) {
                // Si la inserción fue exitosa, muestra mensaje de éxito
                CUtilitarios.msg("Asignatura Registrada", "Registro Asignatura");
            } else {
                // Si la inserción falló, muestra mensaje de error
                CUtilitarios.msg_error("Hubo un error al registrar la asignatura.", "Error en el Registro");
            }

        } catch (SQLException ex) {
            CUtilitarios.msg_error("Error en la base de datos: " + ex.getMessage(), "Error de SQL");
        } finally {
            limpiaValores();
        }
        this.dispose();
    }
}
//    public void enviarDatos() {
//        String clave_asignatura, clave_tipo_asignatura;
//        if (validaCampos()) {
//            asignaValores();
//            try {
//                boolean claveTAExistente = queryBusca.obtenClaveTASeleccionado(tipoAsig);
//                if (!claveTAExistente) {
//                    CUtilitarios.msg_error("El tipo de asignatura no existe. Por favor seleccione un tipo válido.", "Error en el Registro");
//                    return; // Detener la ejecución si la clave de tipo asignatura no existe
//                }
//                boolean claveExistente = queryBusca.obtenClaveFinalAsignatura(claveAsig);
//                if (claveExistente) {
//                    CUtilitarios.msg_error("La clave de la asignatura ya existe. Por favor ingrese una clave diferente.", "Error en el Registro");
//                    return;
//                }
//                clave_asignatura = claveAsig;
//                clave_tipo_asignatura = tipoAsig;
//                System.out.println("ClaveAsignatura:" + claveAsig + "\nNombreAsignatura:" + asignatura + "\nHorasTeoricas: " + HT + "\nHorasPracticas: " + HP);
//                System.out.println("NumerosUnidades: " + numUnid + "\nCreditos:" + creditos);
//                System.out.println("TipoAsignatura: " + tipoAsig);
//                System.out.println("claveTA: " + clave_tipo_asignatura);
//                boolean insercion = queryInserta.insertaAsignatura(clave_asignatura, asignatura, HT, HP, numUnid, creditos, clave_tipo_asignatura);
//
//                if (insercion) {
//                    CUtilitarios.msg("Asignatura Registrada", "Registro Asignatura");
//                } else {
//                    CUtilitarios.msg_error("Hubo un error al registrar la asignatura.", "Error en el Registro");
//                }
//
//            } catch (SQLException ex) {
//                CUtilitarios.msg_error("Error en la base de datos: " + ex.getMessage(), "Error de SQL");
//            } finally {
//                limpiaValores();
//            }
//            this.dispose();
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblClave = new javax.swing.JLabel();
        JtxtClave = new javax.swing.JTextField();
        JspClave = new javax.swing.JSeparator();
        JlblNombre = new javax.swing.JLabel();
        JtxtNombre = new javax.swing.JTextField();
        JspNombre = new javax.swing.JSeparator();
        JlblHT = new javax.swing.JLabel();
        JtxtHT = new javax.swing.JTextField();
        JspHT = new javax.swing.JSeparator();
        JlblHP = new javax.swing.JLabel();
        JtxtHP = new javax.swing.JTextField();
        JspHP = new javax.swing.JSeparator();
        JlblNumeroUnidades = new javax.swing.JLabel();
        JtxtNumeroUnidades = new javax.swing.JTextField();
        JspNumeroUnidades = new javax.swing.JSeparator();
        JlblCreditos = new javax.swing.JLabel();
        JtxtCreditos = new javax.swing.JTextField();
        JspCreditos = new javax.swing.JSeparator();
        JlblTA = new javax.swing.JLabel();
        JcmbxTA = new javax.swing.JComboBox<>();
        JlblFondo = new javax.swing.JLabel();
        JbtnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agrega asignatura");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JlblClave.setText("Clave de la asignatura");

        JtxtClave.setToolTipText("Ingrese la vialidad usando puras letras mayusculas o minusculas");
        JtxtClave.setBorder(null);

        JlblNombre.setText("Asignatura");

        JtxtNombre.setToolTipText("Ingrese la colonia usando puras letras mayusculas o minusculas");
        JtxtNombre.setBorder(null);

        JlblHT.setText("Horas teoricas");

        JtxtHT.setToolTipText("Ingrese el codigo postal usando solo 5 numeros en total");
        JtxtHT.setBorder(null);

        JlblHP.setText("Horas practicas");

        JtxtHP.setToolTipText("Ingrese el numero habitacional usando puros numeros que puede ir del 1 a 5 como maximo");
        JtxtHP.setBorder(null);

        JlblNumeroUnidades.setText("Numero de unidades");

        JtxtNumeroUnidades.setToolTipText("Ingrese el numero habitacional usando puros numeros que puede ir del 1 a 5 como maximo");
        JtxtNumeroUnidades.setBorder(null);

        JlblCreditos.setText("Creditos");

        JtxtCreditos.setToolTipText("Ingrese la ciudad usando puras letras mayusculas o minusculas");
        JtxtCreditos.setBorder(null);

        JlblTA.setText("Tipo asignatura");

        JcmbxTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion", "Curricular", "Cocurricular" }));
        JcmbxTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxTAActionPerformed(evt);
            }
        });

        JlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoAsignatura.png"))); // NOI18N

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlblFondo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JtxtHT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JspHT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JspClave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlblClave)
                    .addComponent(JlblNombre)
                    .addComponent(JlblHT)
                    .addComponent(JtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JspNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtxtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JspCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblCreditos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbtnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JspHP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JtxtHP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblNumeroUnidades)
                            .addComponent(JtxtNumeroUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JlblHP)
                            .addComponent(JspNumeroUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblTA)
                            .addComponent(JcmbxTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addComponent(JlblClave)
                                .addGap(2, 2, 2)
                                .addComponent(JtxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(JspClave, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(JlblNombre)
                                .addGap(2, 2, 2)
                                .addComponent(JtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(JspNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JlblHT)
                                .addGap(2, 2, 2)
                                .addComponent(JtxtHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JlblFondo))
                        .addGap(2, 2, 2)
                        .addComponent(JspHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JlblHP)
                            .addComponent(JlblTA))
                        .addGap(2, 2, 2)
                        .addComponent(JtxtHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(JlblNumeroUnidades)
                        .addGap(2, 2, 2)
                        .addComponent(JtxtNumeroUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JspNumeroUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlblCreditos)
                        .addGap(2, 2, 2)
                        .addComponent(JtxtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JspCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(JcmbxTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbtnEnviar)))
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

    private void JcmbxTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcmbxTAActionPerformed
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
            java.util.logging.Logger.getLogger(JfAAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfAAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfAAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfAAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfAAsignatura(datosJefe, datosAsignatura, new String()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtnEnviar;
    private javax.swing.JComboBox<String> JcmbxTA;
    private javax.swing.JLabel JlblClave;
    private javax.swing.JLabel JlblCreditos;
    private javax.swing.JLabel JlblFondo;
    private javax.swing.JLabel JlblHP;
    private javax.swing.JLabel JlblHT;
    private javax.swing.JLabel JlblNombre;
    private javax.swing.JLabel JlblNumeroUnidades;
    private javax.swing.JLabel JlblTA;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JSeparator JspClave;
    private javax.swing.JSeparator JspCreditos;
    private javax.swing.JSeparator JspHP;
    private javax.swing.JSeparator JspHT;
    private javax.swing.JSeparator JspNombre;
    private javax.swing.JSeparator JspNumeroUnidades;
    private javax.swing.JTextField JtxtClave;
    private javax.swing.JTextField JtxtCreditos;
    private javax.swing.JTextField JtxtHP;
    private javax.swing.JTextField JtxtHT;
    private javax.swing.JTextField JtxtNombre;
    private javax.swing.JTextField JtxtNumeroUnidades;
    // End of variables declaration//GEN-END:variables
}
