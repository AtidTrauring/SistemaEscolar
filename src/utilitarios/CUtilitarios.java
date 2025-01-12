package utilitarios;

import javax.swing.JFrame;

public class CUtilitarios {

    /*  Metodo que permite crear JFrame, recibiendo un objeto de tipo frame
        , el titulo que tendra y las medidas de este*/
    public void creaFrame(JFrame frm, String titulo, int ancho, int alto) {
        //Hacemos visible al nuevo frame
        frm.setVisible(true);
        // Centramos el frame
        frm.setLocationRelativeTo(null);
        // Asignamos las medidas
        frm.setSize(ancho, alto);
        // No permitimos que cambien las medidas
        frm.setResizable(false);
        // Agregamos un titulo
        frm.setTitle(titulo);
    }
}
