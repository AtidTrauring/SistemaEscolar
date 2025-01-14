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

    public ArrayList<String> cargaComboCiclo() throws SQLException {
        consulta = "SELECT ciclo.ciclo FROM ciclo;";
        return cnslt.buscarValoresCombos(consulta);
    }

    public ArrayList<String> cargaComboGrupo() throws SQLException {
        consulta = "SELECT grupo.grupo FROM grupo;";
        return cnslt.buscarValoresCombos(consulta);
    }

    public ArrayList<String> cargaComboMunicipio() throws SQLException {
        consulta = "SELECT municipio.municipio FROM municipio;";
        return cnslt.buscarValoresCombos(consulta);
    }

    public ArrayList<String> cargaComboUnidad(String claveAsignatura) throws SQLException {
        consulta = "SELECT u.unidad FROM asignatura_unidad au "
                + "JOIN unidad u ON au.clave_unidad = u.clave_unidad "
                + "WHERE au.clave_asignatura = '" + claveAsignatura + "';";
        return cnslt.buscarValoresCombos(consulta);
    }

    public ArrayList<String> cargaComboSubtema(String nombreUnidad) throws SQLException {
        consulta = "SELECT s.subtema FROM subtema s "
                + "JOIN unidad u ON s.clave_unidad = u.clave_unidad "
                + "WHERE u.unidad = '" + nombreUnidad + "';";
        return cnslt.buscarValoresCombos(consulta);
    }

    public ArrayList<String> cargaComboAsignatura(String nombreUnidad) throws SQLException {
        consulta = "SELECT asignatura.nombre_asignatura FROM asignatura;";
        return cnslt.buscarValoresCombos(consulta);
    }

}
