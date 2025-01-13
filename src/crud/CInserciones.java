package crud;

import java.sql.SQLException;

public class CInserciones {

    private final CConsultas cnslt = new CConsultas();
    private String consulta;

    public boolean insertaCalificacion(String idVersion, String idEstudiante, Double calificacion) throws SQLException {
        String consulta = "CALL sp_agrega_estudiante_version (" + idEstudiante + "," + idVersion + "," + calificacion + ");";
        return cnslt.inserta(consulta);
    }
    
     // ---------------------------Inserciones Direccion-----------------------------------------
        public boolean insertaColonia(int clave_colonia, String colonia) throws SQLException {
        consulta = "INSERT INTO `colonia`(`clave_colonia`, `colonia`) VALUES (" + clave_colonia + ",'" + colonia + "')";
        return cnslt.inserta(consulta);
    }
}
