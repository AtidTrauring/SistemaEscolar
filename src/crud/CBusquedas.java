package crud;

import java.util.ArrayList;
import java.sql.SQLException;

public class CBusquedas {

    private final CConsultas cnslt = new CConsultas();
    private String consulta;

    // --------------------- Busquedas JfInicioSesion ---------------------
    public String[] buscaUsuario(String user, String pass) throws SQLException {
        consulta = "SELECT p.clave_persona, p.usuario, c.contrasenia, "
                + "CONCAT(p.nombre, ' ', p.ap_Paterno, ' ', p.ap_Materno) FROM "
                + "persona p JOIN contrasenia c ON c.clave_contrasenia = p.clave_contrasenia "
                + "WHERE p.usuario = '" + user + "' AND c.contrasenia = '" + pass + "'";
        return cnslt.buscarValoresLista(consulta, 4);
    }

    public String usuarioEnDocente(String idPersona) throws SQLException {
        consulta = "SELECT d.clave_docente FROM docente d JOIN "
                + "persona p ON p.clave_persona = d.clave_persona WHERE d.clave_persona = " + idPersona + ";";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String[] datosDocente(String idPersona) throws SQLException {
        consulta = "SELECT p.clave_persona, d.clave_docente, "
                + "CONCAT(p.nombre, ' ',p.ap_Paterno, ' ',p.ap_Materno) "
                + "FROM persona p JOIN docente d ON d.clave_persona = p.clave_persona "
                + "WHERE p.clave_persona = " + idPersona + ";";
        return cnslt.buscarValoresLista(consulta, 3);
    }

    public String usuarioEnEstudiante(String idPersona) throws SQLException {
        consulta = "SELECT e.clave_estudiante FROM estudiante e JOIN "
                + "persona p ON p.clave_persona = e.clave_persona WHERE e.clave_persona = " + idPersona + ";";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String[] datosEstudiante(String idPersona) throws SQLException {
        consulta = "SELECT p.clave_persona, e.clave_estudiante, "
                + "CONCAT(p.nombre, ' ',p.ap_Paterno, ' ',p.ap_Materno) "
                + "FROM persona p JOIN estudiante e ON e.clave_persona = p.clave_persona "
                + "WHERE p.clave_persona = " + idPersona + ";";
        return cnslt.buscarValoresLista(consulta, 3);
    }

    public String usuarioEnJefe(String idPersona) throws SQLException {
        consulta = "SELECT j.clave_jefe FROM jefecarrera j JOIN "
                + "persona p ON p.clave_persona = j.clave_persona WHERE j.clave_persona = " + idPersona + ";";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String[] datosJefe(String idPersona) throws SQLException {
        consulta = "SELECT p.clave_persona, j.clave_jefe, "
                + "CONCAT(p.nombre, ' ',p.ap_Paterno, ' ',p.ap_Materno) "
                + "FROM persona p JOIN jefecarrera j ON j.clave_persona = p.clave_persona "
                + "WHERE p.clave_persona = " + idPersona + ";";
        return cnslt.buscarValoresLista(consulta, 3);
    }

    // --------------------- Busquedas JfMenuAlumnos ---------------------
    public ArrayList<String[]> buscaHistorialEstudiante(String idEstudiante) throws SQLException {
        consulta = "SELECT a.nombre_asignatura, a.creditos, "
                + "ev.calificacion, c.ciclo "
                + "FROM estudiante_version ev "
                + "JOIN version v ON ev.clave_version = v.clave_version "
                + "JOIN asignatura a ON v.clave_asignatura = a.clave_asignatura "
                + "JOIN ciclo c ON v.clave_ciclo = c.clave_ciclo "
                + "WHERE ev.clave_estudiante = " + idEstudiante + " "
                + "ORDER BY c.ciclo;";
        return cnslt.buscarValores(consulta, 4);

    }

    public ArrayList<String[]> buscaMateriasDocente(String idDocente) throws SQLException {
        consulta = "SELECT c.ciclo, car.nombre_carrera, g.grupo, "
                + "a.nombre_asignatura  FROM docente d "
                + "JOIN docente_version dv ON d.clave_docente = dv.clave_docente "
                + "JOIN version v ON dv.clave_version = v.clave_version "
                + "JOIN asignatura a ON v.clave_asignatura = a.clave_asignatura "
                + "JOIN carrera_asignatura ca ON a.clave_asignatura = ca.clave_asignatura "
                + "JOIN carrera car ON ca.clave_carrera = car.clave_carrera "
                + "JOIN grupo g ON v.clave_ciclo = g.clave_ciclo "
                + "JOIN ciclo c ON v.clave_ciclo = c.clave_ciclo "
                + "WHERE d.clave_docente = " + idDocente + ";";
        return cnslt.buscarValores(consulta, 4);

    }

}
