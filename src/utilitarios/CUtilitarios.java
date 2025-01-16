package utilitarios;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CUtilitarios {

    /*  Metodo que permite crear JFrame, recibiendo un objeto de tipo frame
        , el titulo que tendra y las medidas de este*/
    public static void creaFrame(JFrame frm, String titulo) {
        //Hacemos visible al nuevo frame
        frm.setVisible(true);
        // Centramos el frame
        frm.setLocationRelativeTo(null);
        // No permitimos que cambien las medidas
        frm.setResizable(false);
        // Agregamos un titulo
        frm.setTitle(titulo);
    }

    public static void msg(String msg, String origen) {
        JOptionPane.showMessageDialog(null, msg, origen, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void msg_error(String msg, String origen) {
        JOptionPane.showMessageDialog(null, msg, origen, JOptionPane.ERROR_MESSAGE);
    }

    public static void msg_advertencia(String msg, String origen) {
        JOptionPane.showMessageDialog(null, msg, origen, JOptionPane.WARNING_MESSAGE);
    }

    public static double validaCalificaion(String valor) {
        String regex = "^(100|\\d{1,2}(\\.\\d{1,2})?)$";
        if (valor.matches(regex)) {
            double numero = Double.parseDouble(valor);
            if (numero >= 0 && numero <= 100) {
                return numero;
            } else {
                msg_advertencia("El valor debe estar entre 0 y 100.", "Asignar calificacion");
                return -1;
            }
        } else {
            msg_error("Ingrese numeros entre 0 y 100.", "Asignar calificacion");
            return -1;
        }
    }

    public static boolean validaComboBox(String campoTexto, JComboBox<String> comboBox, String mensajeVacio, String tituloMensaje) {
        boolean valida = true;
        campoTexto = (String) comboBox.getSelectedItem(); // Obtener el texto seleccionado del JComboBox
        if (campoTexto.equals("Selecciona una opcion")) {
            CUtilitarios.msg_advertencia(mensajeVacio, tituloMensaje);
            valida = false;
        }
        return valida;
    }

    public static String devuelveCadena(JTextField campo, String regex) {
        String cadena = null;
        cadena = campo.getText();
        if (cadena.isEmpty()) {
            cadena = null;
        } else if (cadena.matches(regex)) {
            return cadena;
        } else {
            cadena = "NoValido";
        }
        return cadena;
    }

    public static boolean validaCampo(String campoTexto, JTextField campo, String regex, String mensajeVacio, String mensajeInvalido, String tituloMensaje) {
        boolean valida = true;
        campoTexto = devuelveCadena(campo, regex);
        if (campoTexto == null) {
            CUtilitarios.msg_advertencia(mensajeVacio, tituloMensaje);
            valida = false;
        } else if (campoTexto.equals("NoValido")) {
            CUtilitarios.msg_error(mensajeInvalido, tituloMensaje);
            valida = false;
        } else {
            valida = true;
        }
        return valida;
    }

    // Método para validar números de teléfono
    public static String validarTelefono(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            CUtilitarios.msg_error("El número de teléfono no puede estar vacío.", "Error");
            return null;
        }

        // Expresión regular para números de teléfono de exactamente 10 dígitos
        String regex = "^\\d{10}$";
        if (!texto.matches(regex)) {
            CUtilitarios.msg_error("El número de teléfono debe contener exactamente 10 dígitos.", "Error");
            return null;
        }

        return texto.trim(); // Retorna el valor validado sin espacios adicionales
    }

    public static String validarCorreo(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            CUtilitarios.msg_error("El correo electrónico no puede estar vacío.", "Error");
            return null;
        }

        // Expresión regular para validar correos electrónicos
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (!texto.matches(regex)) {
            CUtilitarios.msg_error("El correo electrónico no es válido.", "Error");
            return null;
        }

        return texto.trim(); // Retorna el valor validado sin espacios adicionales
    }

    public static String[] agregarElemento(String[] arreglo, String nuevoElemento) {
        // Crear un nuevo arreglo con un tamaño mayor en 1
        String[] nuevoArreglo = new String[arreglo.length + 1];

        // Copiar los elementos existentes al nuevo arreglo
        System.arraycopy(arreglo, 0, nuevoArreglo, 0, arreglo.length);

        // Agregar el nuevo elemento al final del nuevo arreglo
        nuevoArreglo[nuevoArreglo.length - 1] = nuevoElemento;

        return nuevoArreglo; // Retornar el nuevo arreglo con el elemento agregado
    }

}
