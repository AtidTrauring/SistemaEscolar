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

public class JfAAsignatura extends javax.swing.JFrame {

    private static String[] datosJefe;
    private static String[] datosAsignatura;
    private String regexNombre = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9 ]+$";
    private String regexClave = "^[a-zA-Z0-9-]{1,8}$";
    private String regexHP = "^[0-9]+$";
    private String regexHT = "^[0-9]+$";
    private String regexCreditos = "^[0-9]+$";
    private String regexUnidades = "^[0-9]+$";
    private String claveAsig, asignatura, HT, HP, numUnid, creditos, tipoAsig, carrera;
    private final CBusquedas queryBusca = new CBusquedas();
    private final CInserciones queryInserta = new CInserciones();
    private ArrayList<String> datosListas = new ArrayList<>();
    DefaultComboBoxModel<String> listas;
    private final CCargaCombos queryCarga = new CCargaCombos();

    public JfAAsignatura(String[] datosJ, String[] datosA, String nombreBoton) {
        initComponents();
        datosJefe = datosJ;
        datosAsignatura = datosA;
        JbtnEnviar.setText(nombreBoton);
        cargaComboBox(JcmbxCarrera, 1);
    }

    public void asignaValores() {
        // Obtener los valores de los campos de texto
        claveAsig = JtxtClave.getText().trim();
        asignatura = JtxtNombre.getText();
        HT = JtxtHT.getText();
        HP = JtxtHP.getText();
        numUnid = JtxtNumeroUnidades.getText();
        creditos = JtxtCreditos.getText();
        tipoAsig = (String) JcmbxTA.getSelectedItem();
        carrera = (String) JcmbxCarrera.getSelectedItem();
    }

    public void limpiaValores() {
        claveAsig = null;
        asignatura = null;
        HT = null;
        HP = null;
        numUnid = null;
        creditos = null;
        tipoAsig = null;
        carrera = null;
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
            }
        } catch (SQLException e) {
        }
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
        cadena = campo.getText().trim(); // Elimina espacios al inicio y al final
        if (cadena.isEmpty()) {
            return null;
        } else if (cadena.matches(regex)) {
            return cadena;
        } else {
            return "NoValido";
        }
    }

    public String devuelveCadenaHP(JTextField campo, String regex) {
        String cadena = null;
        try {
            cadena = campo.getText();
            if (cadena.isEmpty()) {
                cadena = null;
            } else if (cadena.matches(regexHP)) {
                return cadena;
            } else {
                cadena = "NoValido";
                throw new IllegalArgumentException("No se permiten letras, solo números.");
            }
        } catch (IllegalArgumentException e) {
            CUtilitarios.msg_advertencia(e.getMessage(), "Advertencia");
            cadena = null;
        }
        return cadena;
    }

    public String devuelveCadenaHT(JTextField campo, String regex) {
        String cadena = null;
        try {
            cadena = campo.getText();
            if (cadena.isEmpty()) {
                cadena = null;
            } else if (cadena.matches(regexHT)) {
                return cadena;
            } else {
                cadena = "NoValido";
                throw new IllegalArgumentException("No se permiten letras, solo números.");
            }
        } catch (IllegalArgumentException e) {
            CUtilitarios.msg_advertencia(e.getMessage(), "Advertencia");
            cadena = null;
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
        campoTexto = devuelveCadenaClave(campo, regex);
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
        try {
            campoTexto = (String) comboBox.getSelectedItem();
            if (campoTexto.equals("Selecciona una opcion")) {
                throw new IllegalArgumentException(mensajeVacio);
            }
        } catch (IllegalArgumentException e) {
            CUtilitarios.msg_advertencia(e.getMessage(), "Advertencia");
            valida = false;
        }
        return valida;
    }

    public boolean validaCampoCarrera(String campoTexto, JComboBox<String> comboBox, String mensajeVacio) {
        boolean valida = true;
        try {
            campoTexto = (String) comboBox.getSelectedItem();
            if (campoTexto.equals("Selecciona una opcion")) {
                throw new IllegalArgumentException(mensajeVacio);
            }
        } catch (IllegalArgumentException e) {
            CUtilitarios.msg_advertencia(e.getMessage(), "Advertencia");
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
                && (validaCampoTA(tipoAsig, JcmbxTA, "Ingrese el tipo de asignatura"))
                && (validaCampoCarrera(carrera, JcmbxCarrera, "Ingrese la carrera"));
    }

    public void enviarDatos() {
        String clave_asignatura, clave_tipo_asignatura;
        if (validaCampos()) {
            asignaValores();
            try {
                clave_asignatura = JtxtClave.getText();
                clave_tipo_asignatura = queryBusca.obtenClaveTASeleccionado(tipoAsig);
                if (carrera == null || carrera.isEmpty()) {
                    CUtilitarios.msg_error("Debe seleccionar una carrera antes de continuar.", "Falta Información");
                    return;
                }

                int clave_carrera = queryBusca.obtenClaveCarreraSeleccionado(carrera);

                // Imprimir valores para depuración
                System.out.println("ClaveAsignatura:" + claveAsig + "\nNombreAsignatura:" + asignatura + "\nHorasTeoricas: " + HT + "\nHorasPracticas: " + HP);
                System.out.println("CAsignatura: " + clave_asignatura);
                System.out.println("NumerosUnidades: " + numUnid + "\nCreditos: " + creditos);
                System.out.println("TipoAsignatura: " + tipoAsig);
                System.out.println("claveTA: " + clave_tipo_asignatura);
                System.out.println("ClaveCarrera: " + clave_carrera);

                // Llamar al método de inserción de asignatura
                boolean insercionAsignatura = queryInserta.insertaAsignatura(claveAsig, asignatura, HT, HP, numUnid, creditos, clave_tipo_asignatura);

                if (insercionAsignatura) {
                    // Insertar relación en carrera_asignatura
                    boolean insercionCarreraAsignatura = queryInserta.insertaCarrera_asignatura(clave_carrera, claveAsig);

                    if (insercionCarreraAsignatura) {
                        // Mostrar mensaje de éxito y limpiar valores
                        CUtilitarios.msg("Asignatura y relación con carrera registradas correctamente", "Registro Asignatura");
                        limpiaValores();
                        this.dispose();
                    } else {
                        CUtilitarios.msg_error("Hubo un error al registrar la relación carrera-asignatura.", "Error en el Registro");
                    }
                } else {
                    CUtilitarios.msg_error("Hubo un error al registrar la asignatura.", "Error en el Registro");
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
        JcmbxCarrera = new javax.swing.JComboBox<>();
        JlblTA1 = new javax.swing.JLabel();

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

        JcmbxCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));
        JcmbxCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcmbxCarreraActionPerformed(evt);
            }
        });

        JlblTA1.setText("Carrera");

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlblFondo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
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
                    .addComponent(JtxtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JspCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlblCreditos)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JspHP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JtxtHP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JlblNumeroUnidades)
                        .addComponent(JtxtNumeroUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JlblHP)
                        .addComponent(JspNumeroUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addComponent(JlblTA)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JpnlLienzoLayout.createSequentialGroup()
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblTA1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpnlLienzoLayout.createSequentialGroup()
                                .addGap(0, 5, Short.MAX_VALUE)
                                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JbtnEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JcmbxCarrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JcmbxTA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
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
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addComponent(JlblHP)
                                .addGap(2, 2, 2)
                                .addComponent(JtxtHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(JspHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(JlblNumeroUnidades)
                                .addGap(2, 2, 2)
                                .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JtxtNumeroUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JlblTA1)))
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(JlblTA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JcmbxTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addComponent(JspNumeroUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JlblCreditos))
                            .addComponent(JcmbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addComponent(JtxtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(JspCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(JbtnEnviar)))))
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

    private void JcmbxCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcmbxCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcmbxCarreraActionPerformed
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
    private javax.swing.JComboBox<String> JcmbxCarrera;
    private javax.swing.JComboBox<String> JcmbxTA;
    private javax.swing.JLabel JlblClave;
    private javax.swing.JLabel JlblCreditos;
    private javax.swing.JLabel JlblFondo;
    private javax.swing.JLabel JlblHP;
    private javax.swing.JLabel JlblHT;
    private javax.swing.JLabel JlblNombre;
    private javax.swing.JLabel JlblNumeroUnidades;
    private javax.swing.JLabel JlblTA;
    private javax.swing.JLabel JlblTA1;
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
