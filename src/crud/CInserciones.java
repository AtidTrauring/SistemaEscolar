package crud;

import java.sql.SQLException;

public class CInserciones {

    private final CConsultas cnslt = new CConsultas();
    private String consulta;

    public boolean insertaCalificacion(String idVersion, String idEstudiante, Double calificacion) throws SQLException {
        String consulta = "CALL sp_agrega_estudiante_version (" + idEstudiante + "," + idVersion + "," + calificacion + ");";
        return cnslt.inserta(consulta);
    }
}
