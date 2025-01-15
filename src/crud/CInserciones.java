package crud;

import java.sql.SQLException;

public class CInserciones {

    private final CConsultas cnslt = new CConsultas();
    private String consulta;

    public boolean insertaCalificacion(String idEstudiante, String idVersion, Double calificacion) throws SQLException {
        String consulta = "CALL sp_agrega_estudiante_version (" + idEstudiante + "," + idVersion + "," + calificacion + ");";
        System.out.println(consulta);
        return cnslt.inserta(consulta);
    }

    // ---------------------------Inserciones Direccion-----------------------------------------
    public boolean insertaColonia(int clave_colonia, String colonia) throws SQLException {
        consulta = "INSERT INTO `colonia`(`clave_colonia`, `colonia`) VALUES (" + clave_colonia + ",'" + colonia + "')";
        return cnslt.inserta(consulta);
    }

    public boolean insertaAsignatura(String clave, String nombre, String HT, String HP, String numUni, String creditos, String clave_tasignatura) throws SQLException {
        String consulta = "CALL sp_agrega_asignatura ('" + clave + "','" + nombre + "'," + HT + "," + HP + "," + numUni + "," + creditos + ",'" + clave_tasignatura + "');";
        return cnslt.inserta(consulta);

    }

//    public boolean insertaAsignatura(String clave, String nombre, String HT, String HP, String numUni, String creditos, String clave_tasignatura) throws SQLException {
//        String consulta = "CALL sp_agrega_asignatura (" + clave + "," + nombre + "," + HT + "," + HP + "," + numUni + "," + creditos + "," + clave_tasignatura + ");";
//        return cnslt.inserta(consulta);
//    }
//    public boolean insertaAsignatura(String clave, String nombre, String HT, String HP, String numUni, String creditos, String TA) throws SQLException {
//        consulta = "INSERT INTO `asignatura`(`clave_asignatura`, `nombre_asignatura`, `horas_T`, `horas_P`, `numero_unidades`, `creditos`, `clave_tasignatura`) "
//                + "VALUES (" + clave + ",'" + nombre + "','" + HT+ "','" + HP + "','" + numUni + "'," + creditos + ",'" + TA + "')";
//        return cnslt.inserta(consulta);
//    }
}
