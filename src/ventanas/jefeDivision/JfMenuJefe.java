package ventanas.jefeDivision;

import javax.swing.JFrame;
import ventanas.JfInicionSesion;

public class JfMenuJefe extends javax.swing.JFrame {

    private static String[] datosJefe;

    public JfMenuJefe(String[] datos) {
        initComponents();
        datosJefe = datos;
    }

    public void creaFrame(JFrame frm, String titulo) {
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setTitle(titulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblFondoJefe = new javax.swing.JLabel();
        JmbListaOpciones = new javax.swing.JMenuBar();
        JmnAlumno = new javax.swing.JMenu();
        JmiAgregaAlumno = new javax.swing.JMenuItem();
        JmiBuscaKardex = new javax.swing.JMenuItem();
        JmiBuscaAlumno = new javax.swing.JMenuItem();
        JmiReprobado = new javax.swing.JMenuItem();
        JmiAlumnoInscrito = new javax.swing.JMenuItem();
        JmiAlumnoPromedio = new javax.swing.JMenuItem();
        JmnGrupo = new javax.swing.JMenu();
        JmiCreaGrupo = new javax.swing.JMenuItem();
        JmiBuscaGrupo = new javax.swing.JMenuItem();
        JmiAsignaAlumno = new javax.swing.JMenuItem();
        JmiAsignaAsignatura = new javax.swing.JMenuItem();
        JmnAsignatura = new javax.swing.JMenu();
        JmiAgregaAsignatura = new javax.swing.JMenuItem();
        JmnTemario = new javax.swing.JMenu();
        JmiAgregaUnidad = new javax.swing.JMenuItem();
        JmiAgregaSubtema = new javax.swing.JMenuItem();
        JmiBuscaTemario = new javax.swing.JMenuItem();
        JmiBuscaAsignatura = new javax.swing.JMenuItem();
        JmiIndeReprobada = new javax.swing.JMenuItem();
        JmnDocentes = new javax.swing.JMenu();
        JmiAgregaDocente = new javax.swing.JMenuItem();
        JmiBuscaDocente = new javax.swing.JMenuItem();
        JmiGrupoDocente = new javax.swing.JMenuItem();
        JmnAgregar = new javax.swing.JMenu();
        JmiAgregaDireccion = new javax.swing.JMenuItem();
        JmiAgregaTelefono = new javax.swing.JMenuItem();
        JmiAgregaCorreo = new javax.swing.JMenuItem();
        JmiAgregaPersona = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jefe de Division");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JpnlLienzo.setBackground(new java.awt.Color(255, 255, 255));

        JlblFondoJefe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoJefe.png"))); // NOI18N

        javax.swing.GroupLayout JpnlLienzoLayout = new javax.swing.GroupLayout(JpnlLienzo);
        JpnlLienzo.setLayout(JpnlLienzoLayout);
        JpnlLienzoLayout.setHorizontalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlblFondoJefe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JpnlLienzoLayout.setVerticalGroup(
            JpnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnlLienzoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JlblFondoJefe, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        JmnAlumno.setText("Alumnos");

        JmiAgregaAlumno.setText("Agregar alumno");
        JmnAlumno.add(JmiAgregaAlumno);

        JmiBuscaKardex.setText("Kardex del alumno");
        JmnAlumno.add(JmiBuscaKardex);

        JmiBuscaAlumno.setText("Buscar alumnos");
        JmnAlumno.add(JmiBuscaAlumno);

        JmiReprobado.setText("Alumnos reprobados");
        JmnAlumno.add(JmiReprobado);

        JmiAlumnoInscrito.setText("Alumnos inscritos");
        JmnAlumno.add(JmiAlumnoInscrito);

        JmiAlumnoPromedio.setText("Alumnos por promedio");
        JmnAlumno.add(JmiAlumnoPromedio);

        JmbListaOpciones.add(JmnAlumno);

        JmnGrupo.setText("Grupos");

        JmiCreaGrupo.setText("Crear grupo");
        JmnGrupo.add(JmiCreaGrupo);

        JmiBuscaGrupo.setText("Buscar grupo");
        JmnGrupo.add(JmiBuscaGrupo);

        JmiAsignaAlumno.setText("Asignar alumnos");
        JmnGrupo.add(JmiAsignaAlumno);

        JmiAsignaAsignatura.setText("Asignar asignaturas");
        JmnGrupo.add(JmiAsignaAsignatura);

        JmbListaOpciones.add(JmnGrupo);

        JmnAsignatura.setText("Asignaturas");

        JmiAgregaAsignatura.setText("Agregar asignatura");
        JmnAsignatura.add(JmiAgregaAsignatura);

        JmnTemario.setText("Temarios");

        JmiAgregaUnidad.setText("Agregar unidad");
        JmnTemario.add(JmiAgregaUnidad);

        JmiAgregaSubtema.setText("Agregar subtema");
        JmnTemario.add(JmiAgregaSubtema);

        JmiBuscaTemario.setText("Consultar temarios");
        JmnTemario.add(JmiBuscaTemario);

        JmnAsignatura.add(JmnTemario);

        JmiBuscaAsignatura.setText("Buscar asignatura");
        JmnAsignatura.add(JmiBuscaAsignatura);

        JmiIndeReprobada.setText("Indice de reprobadas");
        JmnAsignatura.add(JmiIndeReprobada);

        JmbListaOpciones.add(JmnAsignatura);

        JmnDocentes.setText("Docentes");

        JmiAgregaDocente.setText("Agregar docente");
        JmnDocentes.add(JmiAgregaDocente);

        JmiBuscaDocente.setText("Buscar docente");
        JmnDocentes.add(JmiBuscaDocente);

        JmiGrupoDocente.setText("Grupos atendidos por docentes");
        JmnDocentes.add(JmiGrupoDocente);

        JmbListaOpciones.add(JmnDocentes);

        JmnAgregar.setText("Agregar docente/alumno");

        JmiAgregaDireccion.setText("Agregar dirección");
        JmnAgregar.add(JmiAgregaDireccion);

        JmiAgregaTelefono.setText("Agregar telefono");
        JmnAgregar.add(JmiAgregaTelefono);

        JmiAgregaCorreo.setText("Agregar correo");
        JmnAgregar.add(JmiAgregaCorreo);

        JmiAgregaPersona.setText("Agregar persona");
        JmnAgregar.add(JmiAgregaPersona);

        JmbListaOpciones.add(JmnAgregar);

        setJMenuBar(JmbListaOpciones);

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
        this.setTitle(datosJefe[2]);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JfInicionSesion is = new JfInicionSesion();
        creaFrame(is, "Inicio de sesion");
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(JfMenuJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfMenuJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfMenuJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfMenuJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfMenuJefe(datosJefe).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlblFondoJefe;
    private javax.swing.JMenuBar JmbListaOpciones;
    private javax.swing.JMenuItem JmiAgregaAlumno;
    private javax.swing.JMenuItem JmiAgregaAsignatura;
    private javax.swing.JMenuItem JmiAgregaCorreo;
    private javax.swing.JMenuItem JmiAgregaDireccion;
    private javax.swing.JMenuItem JmiAgregaDocente;
    private javax.swing.JMenuItem JmiAgregaPersona;
    private javax.swing.JMenuItem JmiAgregaSubtema;
    private javax.swing.JMenuItem JmiAgregaTelefono;
    private javax.swing.JMenuItem JmiAgregaUnidad;
    private javax.swing.JMenuItem JmiAlumnoInscrito;
    private javax.swing.JMenuItem JmiAlumnoPromedio;
    private javax.swing.JMenuItem JmiAsignaAlumno;
    private javax.swing.JMenuItem JmiAsignaAsignatura;
    private javax.swing.JMenuItem JmiBuscaAlumno;
    private javax.swing.JMenuItem JmiBuscaAsignatura;
    private javax.swing.JMenuItem JmiBuscaDocente;
    private javax.swing.JMenuItem JmiBuscaGrupo;
    private javax.swing.JMenuItem JmiBuscaKardex;
    private javax.swing.JMenuItem JmiBuscaTemario;
    private javax.swing.JMenuItem JmiCreaGrupo;
    private javax.swing.JMenuItem JmiGrupoDocente;
    private javax.swing.JMenuItem JmiIndeReprobada;
    private javax.swing.JMenuItem JmiReprobado;
    private javax.swing.JMenu JmnAgregar;
    private javax.swing.JMenu JmnAlumno;
    private javax.swing.JMenu JmnAsignatura;
    private javax.swing.JMenu JmnDocentes;
    private javax.swing.JMenu JmnGrupo;
    private javax.swing.JMenu JmnTemario;
    private javax.swing.JPanel JpnlLienzo;
    // End of variables declaration//GEN-END:variables
}
