package ventanas.jefeDivision;

public class JfMenuJefe extends javax.swing.JFrame {

    public JfMenuJefe() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnlLienzo = new javax.swing.JPanel();
        JlblFondoJefe = new javax.swing.JLabel();
        JmbListaOpciones = new javax.swing.JMenuBar();
        JmnAlumno = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        JmiBuscaKardex = new javax.swing.JMenuItem();
        JmiBuscaAlumno = new javax.swing.JMenuItem();
        JmiReprobado = new javax.swing.JMenuItem();
        JmnGrupo = new javax.swing.JMenu();
        JmiCreaGrupo = new javax.swing.JMenuItem();
        JmiAsignaAlumno = new javax.swing.JMenuItem();
        JmiAsignaAsignatura = new javax.swing.JMenuItem();
        JmiAsignaDocente = new javax.swing.JMenuItem();
        JmiBuscaGrupo = new javax.swing.JMenuItem();
        JmnAsignatura = new javax.swing.JMenu();
        JmiAgregaAsignatura = new javax.swing.JMenuItem();
        JmiAsignaUnidad = new javax.swing.JMenuItem();
        JmiAsignaSubtema = new javax.swing.JMenuItem();
        JmnTemario = new javax.swing.JMenu();
        JmnUnidades = new javax.swing.JMenu();
        JmiAgregaUnidad = new javax.swing.JMenuItem();
        JmiBuscaUnidad = new javax.swing.JMenuItem();
        JmnSubtemas = new javax.swing.JMenu();
        JmiAgregaSubtema = new javax.swing.JMenuItem();
        JmiBuscaSubtema = new javax.swing.JMenuItem();
        JmnDocentes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jefe de Division");
        setResizable(false);

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
                .addComponent(JlblFondoJefe, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        JmnAlumno.setText("Alumnos");

        jMenu1.setText("Agregar datos de alumnos");

        jMenuItem3.setText("Agregar dirección");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Agregar telefono");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Agregar correo");
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Registrar alumno");
        jMenu1.add(jMenuItem6);

        JmnAlumno.add(jMenu1);

        JmiBuscaKardex.setText("Buscar kardex");
        JmnAlumno.add(JmiBuscaKardex);

        JmiBuscaAlumno.setText("Buscar alumnos");
        JmnAlumno.add(JmiBuscaAlumno);

        JmiReprobado.setText("Reprobados");
        JmnAlumno.add(JmiReprobado);

        JmbListaOpciones.add(JmnAlumno);

        JmnGrupo.setText("Grupos");

        JmiCreaGrupo.setText("Crear grupo");
        JmnGrupo.add(JmiCreaGrupo);

        JmiAsignaAlumno.setText("Asignar alumnos");
        JmnGrupo.add(JmiAsignaAlumno);

        JmiAsignaAsignatura.setText("Asignar asignaturas");
        JmnGrupo.add(JmiAsignaAsignatura);

        JmiAsignaDocente.setText("Asignar docentes");
        JmnGrupo.add(JmiAsignaDocente);

        JmiBuscaGrupo.setText("Buscar grupo");
        JmnGrupo.add(JmiBuscaGrupo);

        JmbListaOpciones.add(JmnGrupo);

        JmnAsignatura.setText("Asignaturas");

        JmiAgregaAsignatura.setText("Agregar asignatura");
        JmnAsignatura.add(JmiAgregaAsignatura);

        JmiAsignaUnidad.setText("Asignar unidad");
        JmnAsignatura.add(JmiAsignaUnidad);

        JmiAsignaSubtema.setText("Asignar subtema");
        JmnAsignatura.add(JmiAsignaSubtema);

        JmbListaOpciones.add(JmnAsignatura);

        JmnTemario.setText("Temarios");

        JmnUnidades.setText("Unidades");

        JmiAgregaUnidad.setText("Agregar unidad");
        JmnUnidades.add(JmiAgregaUnidad);

        JmiBuscaUnidad.setText("Buscar unidad");
        JmnUnidades.add(JmiBuscaUnidad);

        JmnTemario.add(JmnUnidades);

        JmnSubtemas.setText("Subtemas");

        JmiAgregaSubtema.setText("Agregar subtema");
        JmnSubtemas.add(JmiAgregaSubtema);

        JmiBuscaSubtema.setText("Buscar subtema");
        JmnSubtemas.add(JmiBuscaSubtema);

        JmnTemario.add(JmnSubtemas);

        JmbListaOpciones.add(JmnTemario);

        JmnDocentes.setText("Docentes");

        jMenuItem1.setText("Agregar docente");
        JmnDocentes.add(jMenuItem1);

        jMenuItem2.setText("Buscar docente");
        JmnDocentes.add(jMenuItem2);

        JmbListaOpciones.add(JmnDocentes);

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
                new JfMenuJefe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlblFondoJefe;
    private javax.swing.JMenuBar JmbListaOpciones;
    private javax.swing.JMenuItem JmiAgregaAsignatura;
    private javax.swing.JMenuItem JmiAgregaSubtema;
    private javax.swing.JMenuItem JmiAgregaUnidad;
    private javax.swing.JMenuItem JmiAsignaAlumno;
    private javax.swing.JMenuItem JmiAsignaAsignatura;
    private javax.swing.JMenuItem JmiAsignaDocente;
    private javax.swing.JMenuItem JmiAsignaSubtema;
    private javax.swing.JMenuItem JmiAsignaUnidad;
    private javax.swing.JMenuItem JmiBuscaAlumno;
    private javax.swing.JMenuItem JmiBuscaGrupo;
    private javax.swing.JMenuItem JmiBuscaKardex;
    private javax.swing.JMenuItem JmiBuscaSubtema;
    private javax.swing.JMenuItem JmiBuscaUnidad;
    private javax.swing.JMenuItem JmiCreaGrupo;
    private javax.swing.JMenuItem JmiReprobado;
    private javax.swing.JMenu JmnAlumno;
    private javax.swing.JMenu JmnAsignatura;
    private javax.swing.JMenu JmnDocentes;
    private javax.swing.JMenu JmnGrupo;
    private javax.swing.JMenu JmnSubtemas;
    private javax.swing.JMenu JmnTemario;
    private javax.swing.JMenu JmnUnidades;
    private javax.swing.JPanel JpnlLienzo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
