package crud;

import java.sql.SQLException;

public class CInserciones {

    private final CConsultas cnslt = new CConsultas();
    private String consulta;

    public boolean insertaCalificacion(String idEstudiante, String idVersion, Double calificacion) throws SQLException {
        String consulta = "CALL sp_agrega_estudiante_version (" + idEstudiante + ", '" + idVersion + "', " + calificacion + ");";
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

    public boolean insertaCarrera_asignatura(int carrera, String clave) throws SQLException {
        String consulta = "CALL sp_agrega_carrera_asignatura ('" + clave + "'," + carrera + ");";
        return cnslt.inserta(consulta);

    }

//    public boolean insertaGrupo(int carrera, String clave, String ciclo, String grupo, int semestre) throws SQLException {
//        String consulta = "CALL sp_agrega_grupo ('" + clave + "','" + grupo + "','" + ciclo + "'," + semestre + "," + carrera + ");";
//        return cnslt.inserta(consulta);
//
//    }
    public boolean insertaGrupo(int clave, String grupo, String ciclo, int semestre, int carrera) throws SQLException {
        String consulta = "CALL sp_agrega_grupo (" + clave + ",'" + grupo + "','" + ciclo + "'," + semestre + "," + carrera + ");";
        return cnslt.inserta(consulta);

    }
}
