package crud;

import java.sql.SQLException;

public class CActualizaciones {

    private final CConsultas cnslt = new CConsultas();
    private String consulta;

    public boolean actualizarAnio(int anio, String id) throws SQLException {
        consulta = "UPDATE flecha_amarilla.anio SET `anio`='" + anio + "' WHERE Id_anio = '" + id + "';";
        return cnslt.actualiza(consulta);
    }

}
