package crud;

import java.sql.SQLException;
import java.util.ArrayList;

public class CCargaCombos {

    private final CConsultas cnslt = new CConsultas();
    private String consulta;

    //---------------------- Direccion ----------------------
    public ArrayList<String> cargaComboEstados() throws SQLException {
        consulta = "SELECT estado from estado";
        return cnslt.buscarValoresCombos(consulta);
    }
}
