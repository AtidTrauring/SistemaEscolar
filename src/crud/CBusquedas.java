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

    // --------------------- Busquedas JfMenuDocente ---------------------
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

    public ArrayList<String[]> buscaAlumnosGrupo(String grupo, String ciclo, String asignatura) throws SQLException {
        consulta = "SELECT e.clave_estudiante, "
                + "CONCAT(p.ap_Paterno, ' ', p.ap_Materno, ' ', p.nombre) AS Nombre_Completo "
                + "FROM estudiante_grupo eg JOIN grupo g ON eg.clave_grupo = g.clave_grupo "
                + "JOIN ciclo c ON g.clave_ciclo = c.clave_ciclo "
                + "JOIN estudiante e ON eg.clave_estudiante = e.clave_estudiante "
                + "JOIN persona p ON e.clave_persona = p.clave_persona "
                + "JOIN estudiante_version ev ON e.clave_estudiante = ev.clave_estudiante "
                + "JOIN version v ON ev.clave_version = v.clave_version "
                + "JOIN carrera_asignatura ca ON v.clave_asignatura = ca.clave_asignatura "
                + "JOIN asignatura a ON ca.clave_asignatura = a.clave_asignatura "
                + "WHERE g.grupo = '" + grupo + "' AND c.ciclo = '" + ciclo + "' "
                + "AND a.nombre_asignatura = '" + asignatura + "' "
                + "ORDER BY p.ap_Paterno, p.ap_Materno, p.nombre;";
        return cnslt.buscarValores(consulta, 2);
    }

    public String buscaMateriaDocente(String ciclo, String asignatura, String grupo, String idDocente) throws SQLException {
        consulta = "SELECT v.clave_version FROM version v "
                + "JOIN ciclo c ON v.clave_ciclo = c.clave_ciclo "
                + "JOIN asignatura a ON v.clave_asignatura = a.clave_asignatura "
                + "JOIN docente_version dv ON v.clave_version = dv.clave_version "
                + "JOIN docente d ON dv.clave_docente = d.clave_docente "
                + "JOIN grupo g ON v.clave_ciclo = g.clave_ciclo "
                + "WHERE c.ciclo = '" + ciclo + "' AND a.nombre_asignatura = '" + asignatura + "' "
                + "AND g.grupo = '" + grupo + "' AND d.clave_docente = " + idDocente + ";";
        return cnslt.buscarValor(consulta);
    }

    // --------------------- Busquedas JfMenuJefeDivision ---------------------
    public ArrayList<String[]> buscarAlumnosCompletos() throws SQLException {
        consulta = "SELECT pe.nombre AS nombre_estudiante, a.clave_asignatura, \n"
                + "    a.nombre_asignatura, p.nombre AS nombre_docente, \n"
                + "    c.ciclo, o.origen,  ev.calificacion\n"
                + "FROM asignatura a\n"
                + "JOIN version v ON a.clave_asignatura = v.clave_asignatura\n"
                + "JOIN ciclo c ON v.clave_ciclo = c.clave_ciclo\n"
                + "JOIN origen o ON v.clave_origen = o.clave_origen\n"
                + "JOIN docente_version dv ON v.clave_version = dv.clave_version\n"
                + "JOIN docente d ON dv.clave_docente = d.clave_docente\n"
                + "JOIN persona p ON d.clave_persona = p.clave_persona\n"
                + "JOIN estudiante_version ev ON v.clave_version = ev.clave_version\n"
                + "JOIN estudiante e ON ev.clave_estudiante = e.clave_estudiante\n"
                + "JOIN persona pe ON e.clave_persona = pe.clave_persona;";
        return cnslt.buscarValores(consulta, 7);
    }

    public String buscarIdCodigoPostal(String codigoPostal) throws SQLException {
        String claveDireccion = cnslt.buscarValor("SELECT\n"
                + "codigo_postal.clave_cp\n"
                + "FROM\n"
                + "codigo_postal\n"
                + "WHERE\n"
                + "codigo_postal.cp = '" + codigoPostal + "';");
        return claveDireccion;
    }

    public String buscarIdColonia(String colonia) throws SQLException {
        String claveDireccion = cnslt.buscarValor("SELECT\n"
                + "colonia.clave_colonia\n"
                + "FROM\n"
                + "colonia\n"
                + "WHERE\n"
                + "colonia.colonia = '" + colonia + "';");
        return claveDireccion;
    }

    public String obtenIdFinalColoniaa() throws SQLException {
        consulta = "SELECT MAX(clave_colonia) FROM carreras_teschi.colonia;";
        return cnslt.buscarValor(consulta);
    }

}
