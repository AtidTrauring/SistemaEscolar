package ventanas.jefeDivision;

import utilitarios.CUtilitarios;
import ventanas.JfInicionSesion;

public class JfMenuJefe extends javax.swing.JFrame {

    private static String[] datosJefe;

    public JfMenuJefe(String[] datos) {
        initComponents();
        datosJefe = datos;
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
        JmiAsignaDocenteAsignatura = new javax.swing.JMenuItem();
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
        JmiAgregaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaAlumnoActionPerformed(evt);
            }
        });
        JmnAlumno.add(JmiAgregaAlumno);

        JmiBuscaKardex.setText("Kardex del alumno");
        JmiBuscaKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiBuscaKardexActionPerformed(evt);
            }
        });
        JmnAlumno.add(JmiBuscaKardex);

        JmiBuscaAlumno.setText("Buscar alumnos");
        JmiBuscaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiBuscaAlumnoActionPerformed(evt);
            }
        });
        JmnAlumno.add(JmiBuscaAlumno);

        JmiReprobado.setText("Alumnos reprobados");
        JmiReprobado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiReprobadoActionPerformed(evt);
            }
        });
        JmnAlumno.add(JmiReprobado);

        JmiAlumnoInscrito.setText("Alumnos inscritos");
        JmiAlumnoInscrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAlumnoInscritoActionPerformed(evt);
            }
        });
        JmnAlumno.add(JmiAlumnoInscrito);

        JmiAlumnoPromedio.setText("Alumnos por promedio");
        JmiAlumnoPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAlumnoPromedioActionPerformed(evt);
            }
        });
        JmnAlumno.add(JmiAlumnoPromedio);

        JmbListaOpciones.add(JmnAlumno);

        JmnGrupo.setText("Grupos");

        JmiCreaGrupo.setText("Crear grupo");
        JmiCreaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiCreaGrupoActionPerformed(evt);
            }
        });
        JmnGrupo.add(JmiCreaGrupo);

        JmiBuscaGrupo.setText("Buscar grupo");
        JmiBuscaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiBuscaGrupoActionPerformed(evt);
            }
        });
        JmnGrupo.add(JmiBuscaGrupo);

        JmiAsignaAlumno.setText("Asignar alumnos");
        JmiAsignaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAsignaAlumnoActionPerformed(evt);
            }
        });
        JmnGrupo.add(JmiAsignaAlumno);

        JmiAsignaDocenteAsignatura.setText("Asignar cursos");
        JmiAsignaDocenteAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAsignaDocenteAsignaturaActionPerformed(evt);
            }
        });
        JmnGrupo.add(JmiAsignaDocenteAsignatura);

        JmbListaOpciones.add(JmnGrupo);

        JmnAsignatura.setText("Asignaturas");

        JmiAgregaAsignatura.setText("Agregar asignatura");
        JmiAgregaAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaAsignaturaActionPerformed(evt);
            }
        });
        JmnAsignatura.add(JmiAgregaAsignatura);

        JmnTemario.setText("Temarios");

        JmiAgregaUnidad.setText("Agregar unidad");
        JmiAgregaUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaUnidadActionPerformed(evt);
            }
        });
        JmnTemario.add(JmiAgregaUnidad);

        JmiAgregaSubtema.setText("Agregar subtema");
        JmiAgregaSubtema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaSubtemaActionPerformed(evt);
            }
        });
        JmnTemario.add(JmiAgregaSubtema);

        JmiBuscaTemario.setText("Consultar temarios");
        JmiBuscaTemario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiBuscaTemarioActionPerformed(evt);
            }
        });
        JmnTemario.add(JmiBuscaTemario);

        JmnAsignatura.add(JmnTemario);

        JmiBuscaAsignatura.setText("Buscar asignatura");
        JmiBuscaAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiBuscaAsignaturaActionPerformed(evt);
            }
        });
        JmnAsignatura.add(JmiBuscaAsignatura);

        JmiIndeReprobada.setText("Indice de reprobadas");
        JmiIndeReprobada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiIndeReprobadaActionPerformed(evt);
            }
        });
        JmnAsignatura.add(JmiIndeReprobada);

        JmbListaOpciones.add(JmnAsignatura);

        JmnDocentes.setText("Docentes");

        JmiAgregaDocente.setText("Agregar docente");
        JmiAgregaDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaDocenteActionPerformed(evt);
            }
        });
        JmnDocentes.add(JmiAgregaDocente);

        JmiBuscaDocente.setText("Buscar docente");
        JmiBuscaDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiBuscaDocenteActionPerformed(evt);
            }
        });
        JmnDocentes.add(JmiBuscaDocente);

        JmiGrupoDocente.setText("Grupos atendidos por docentes");
        JmiGrupoDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiGrupoDocenteActionPerformed(evt);
            }
        });
        JmnDocentes.add(JmiGrupoDocente);

        JmbListaOpciones.add(JmnDocentes);

        JmnAgregar.setText("Agregar docente/alumno");

        JmiAgregaDireccion.setText("Agregar dirección");
        JmiAgregaDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaDireccionActionPerformed(evt);
            }
        });
        JmnAgregar.add(JmiAgregaDireccion);

        JmiAgregaTelefono.setText("Agregar telefono");
        JmiAgregaTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaTelefonoActionPerformed(evt);
            }
        });
        JmnAgregar.add(JmiAgregaTelefono);

        JmiAgregaCorreo.setText("Agregar correo");
        JmiAgregaCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaCorreoActionPerformed(evt);
            }
        });
        JmnAgregar.add(JmiAgregaCorreo);

        JmiAgregaPersona.setText("Agregar persona");
        JmiAgregaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmiAgregaPersonaActionPerformed(evt);
            }
        });
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
        CUtilitarios.creaFrame(is, "Inicio de sesion");
    }//GEN-LAST:event_formWindowClosing

    private void JmiAgregaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaAlumnoActionPerformed
        JfAPersona ap = new JfAPersona(datosJefe, "Alumno", "Enviar");
        CUtilitarios.creaFrame(ap, "Agregar estudiante");
        this.hide();
    }//GEN-LAST:event_JmiAgregaAlumnoActionPerformed

    private void JmiAgregaDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaDocenteActionPerformed
        JfAPersona ap = new JfAPersona(datosJefe, "Docente", "Enviar");
        CUtilitarios.creaFrame(ap, "Agregar docente");
        this.hide();
    }//GEN-LAST:event_JmiAgregaDocenteActionPerformed

    private void JmiBuscaKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiBuscaKardexActionPerformed
        JfBuscaKardex bk = new JfBuscaKardex(datosJefe);
        CUtilitarios.creaFrame(bk, "Buscar kardex");
        this.hide();
    }//GEN-LAST:event_JmiBuscaKardexActionPerformed

    private void JmiBuscaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiBuscaAlumnoActionPerformed
        JfBuscaAlumno ba = new JfBuscaAlumno(datosJefe);
        CUtilitarios.creaFrame(ba, "Busca alumno");
        this.hide();
    }//GEN-LAST:event_JmiBuscaAlumnoActionPerformed

    private void JmiReprobadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiReprobadoActionPerformed
        JfReprobado r = new JfReprobado(datosJefe);
        CUtilitarios.creaFrame(r, "Alumnos reprobados");
        this.hide();
    }//GEN-LAST:event_JmiReprobadoActionPerformed

    private void JmiAlumnoInscritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAlumnoInscritoActionPerformed
        JfPromedioGrupo pg = new JfPromedioGrupo(datosJefe);
        CUtilitarios.creaFrame(pg, "Alumnos inscritos");
        this.hide();
    }//GEN-LAST:event_JmiAlumnoInscritoActionPerformed

    private void JmiAlumnoPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAlumnoPromedioActionPerformed
        JfAlumnoPromedio ap = new JfAlumnoPromedio(datosJefe);
        CUtilitarios.creaFrame(ap, "Alumno por pormedio");
        this.hide();
    }//GEN-LAST:event_JmiAlumnoPromedioActionPerformed

    private void JmiCreaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiCreaGrupoActionPerformed
        JfAGrupo ag = new JfAGrupo(datosJefe);
        CUtilitarios.creaFrame(ag, "Crear grupo");
        this.hide();
    }//GEN-LAST:event_JmiCreaGrupoActionPerformed

    private void JmiBuscaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiBuscaGrupoActionPerformed
        JfBuscaGrupo bg = new JfBuscaGrupo(datosJefe);
        CUtilitarios.creaFrame(bg, "Buscar grupo");
        this.hide();
    }//GEN-LAST:event_JmiBuscaGrupoActionPerformed

    private void JmiAsignaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAsignaAlumnoActionPerformed
        JfAsignaAlumno aa = new JfAsignaAlumno(datosJefe);
        CUtilitarios.creaFrame(aa, "Asigna alumnos");
        this.hide();
    }//GEN-LAST:event_JmiAsignaAlumnoActionPerformed

    private void JmiAsignaDocenteAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAsignaDocenteAsignaturaActionPerformed
        JfAsignaCurso ac = new JfAsignaCurso(datosJefe);
        CUtilitarios.creaFrame(ac, "Asigna cursos");
        this.hide();
    }//GEN-LAST:event_JmiAsignaDocenteAsignaturaActionPerformed

    private void JmiBuscaDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiBuscaDocenteActionPerformed
        JfBuscaDocente bd = new JfBuscaDocente(datosJefe);
        CUtilitarios.creaFrame(bd, "Buscar docentes");
        this.hide();
    }//GEN-LAST:event_JmiBuscaDocenteActionPerformed

    private void JmiGrupoDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiGrupoDocenteActionPerformed
        JfDocenteGrupo dc = new JfDocenteGrupo(datosJefe);
        CUtilitarios.creaFrame(dc, "Grupos atendidos por docentes");
        this.hide();
    }//GEN-LAST:event_JmiGrupoDocenteActionPerformed

    private void JmiAgregaDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaDireccionActionPerformed
        JfADireccion ad = new JfADireccion(datosJefe, null, "Enviar");
        CUtilitarios.creaFrame(ad, "Agrega direccion");
        this.hide();
    }//GEN-LAST:event_JmiAgregaDireccionActionPerformed

    private void JmiAgregaTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaTelefonoActionPerformed
        JfATelefono at = new JfATelefono(datosJefe, null, "Enviar");
        CUtilitarios.creaFrame(at, "Enviar");
        this.hide();
    }//GEN-LAST:event_JmiAgregaTelefonoActionPerformed

    private void JmiAgregaCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaCorreoActionPerformed
        JfACorreo ac = new JfACorreo(datosJefe, null, "Enviar");
        CUtilitarios.creaFrame(ac, "Agregar correo");
        this.hide();
    }//GEN-LAST:event_JmiAgregaCorreoActionPerformed

    private void JmiAgregaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaPersonaActionPerformed
        JfAPersona ap = new JfAPersona(datosJefe, null, "Enivar");
        CUtilitarios.creaFrame(ap, "Enviar");
        this.hide();
    }//GEN-LAST:event_JmiAgregaPersonaActionPerformed

    private void JmiAgregaAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaAsignaturaActionPerformed
        JfAAsignatura aa = new JfAAsignatura(datosJefe, null, "Enviar");
        CUtilitarios.creaFrame(aa, "Agregar asignatura");
        this.hide();
    }//GEN-LAST:event_JmiAgregaAsignaturaActionPerformed

    private void JmiAgregaUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaUnidadActionPerformed
        JfAUnidad au = new JfAUnidad(datosJefe, null, "Enviar");
        CUtilitarios.creaFrame(au, "Agregar unidad");
        this.hide();
    }//GEN-LAST:event_JmiAgregaUnidadActionPerformed

    private void JmiAgregaSubtemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiAgregaSubtemaActionPerformed
        JfASubtema as = new JfASubtema(datosJefe, null, "Enviar");
        CUtilitarios.creaFrame(as, "Agregar subtema");
        this.hide();
    }//GEN-LAST:event_JmiAgregaSubtemaActionPerformed

    private void JmiBuscaTemarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiBuscaTemarioActionPerformed
        JfBuscaTemario bt = new JfBuscaTemario(datosJefe);
        CUtilitarios.creaFrame(bt, "Buscar temario");
        this.hide();
    }//GEN-LAST:event_JmiBuscaTemarioActionPerformed

    private void JmiBuscaAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiBuscaAsignaturaActionPerformed
        JfBuscaAsignatura ba = new JfBuscaAsignatura(datosJefe);
        CUtilitarios.creaFrame(ba, "Buscar asignatura");
        this.hide();
    }//GEN-LAST:event_JmiBuscaAsignaturaActionPerformed

    private void JmiIndeReprobadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmiIndeReprobadaActionPerformed
        JfReprobadosAsignatura ra = new JfReprobadosAsignatura(datosJefe);
        CUtilitarios.creaFrame(ra, "Indice de reprobados");
        this.hide();
    }//GEN-LAST:event_JmiIndeReprobadaActionPerformed
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
    private javax.swing.JMenuItem JmiAsignaDocenteAsignatura;
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
