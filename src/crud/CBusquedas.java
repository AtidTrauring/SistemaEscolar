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
    public ArrayList<String[]> buscarDocente() throws SQLException {
        consulta = "SELECT \n"
                + "    d.clave_docente,\n"
                + "    CONCAT(p.nombre, ' ', p.ap_Paterno, ' ', p.ap_Materno) AS nombre_completo,\n"
                + "    t.telefono,c.correo\n"
                + "FROM docente d\n"
                + "JOIN persona p ON d.clave_persona = p.clave_persona\n"
                + "JOIN telefono t ON p.clave_persona = t.clave_persona\n"
                + "JOIN correo c ON p.clave_persona = c.clave_persona;";
        return cnslt.buscarValores(consulta, 4);
    }

    public ArrayList<String[]> buscarAlumnosCompletos() throws SQLException {
        consulta = "SELECT pe.nombre AS nombre_estudiante, e.clave_estudiante, a.clave_asignatura, "
                + "a.nombre_asignatura, p.nombre AS nombre_docente, "
                + "c.ciclo, o.origen, ev.calificacion "
                + "FROM asignatura a "
                + "JOIN version v ON a.clave_asignatura = v.clave_asignatura "
                + "JOIN ciclo c ON v.clave_ciclo = c.clave_ciclo "
                + "JOIN origen o ON v.clave_origen = o.clave_origen "
                + "JOIN docente_version dv ON v.clave_version = dv.clave_version "
                + "JOIN docente d ON dv.clave_docente = d.clave_docente "
                + "JOIN persona p ON d.clave_persona = p.clave_persona "
                + "JOIN estudiante_version ev ON v.clave_version = ev.clave_version "
                + "JOIN estudiante e ON ev.clave_estudiante = e.clave_estudiante "
                + "JOIN persona pe ON e.clave_persona = pe.clave_persona;";
        return cnslt.buscarValores(consulta, 8);
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

    public ArrayList<String[]> buscaPromedioAlumnos() throws SQLException {
        consulta = "SELECT DISTINCT c.ciclo, g_cursado.grupo, "
                + "CONCAT(p.ap_Paterno, ' ', p.ap_Materno, ' ', p.nombre), "
                + "ROUND(AVG(CAST(ev.calificacion AS DECIMAL(10, 2))), 2) "
                + "FROM estudiante e JOIN persona p ON e.clave_persona = p.clave_persona "
                + "JOIN estudiante_grupo eg ON e.clave_estudiante = eg.clave_estudiante "
                + "JOIN grupo g_actual ON eg.clave_grupo = g_actual.clave_grupo "
                + "LEFT JOIN estudiante_version ev ON e.clave_estudiante = ev.clave_estudiante "
                + "LEFT JOIN version v ON ev.clave_version = v.clave_version "
                + "LEFT JOIN grupo g_cursado ON v.clave_ciclo = g_cursado.clave_ciclo "
                + "LEFT JOIN ciclo c ON v.clave_ciclo = c.clave_ciclo "
                + "GROUP BY e.clave_estudiante, g_actual.grupo, g_cursado.grupo, c.ciclo "
                + "ORDER BY p.ap_Paterno, p.ap_Materno, p.nombre, c.ciclo;";
        return cnslt.buscarValores(consulta, 4);
    }

    public ArrayList<String[]> buscarAlumnosReprobados() throws SQLException {
        consulta = "SELECT \n"
                + "    e.clave_estudiante,\n"
                + "    CONCAT(pe.nombre, ' ', pe.ap_Paterno, ' ', pe.ap_Materno) AS nombre_completo,\n"
                + "    a.nombre_asignatura, \n"
                + "    g.grupo, \n"
                + "    c.ciclo\n"
                + "FROM estudiante e\n"
                + "JOIN persona pe ON e.clave_persona = pe.clave_persona\n"
                + "JOIN estudiante_version ev ON e.clave_estudiante = ev.clave_estudiante\n"
                + "JOIN version v ON ev.clave_version = v.clave_version\n"
                + "JOIN asignatura a ON v.clave_asignatura = a.clave_asignatura\n"
                + "JOIN estudiante_grupo eg ON e.clave_estudiante = eg.clave_estudiante\n"
                + "JOIN grupo g ON eg.clave_grupo = g.clave_grupo\n"
                + "JOIN ciclo c ON v.clave_ciclo = c.clave_ciclo\n"
                + "WHERE ev.calificacion < 70;";
        return cnslt.buscarValores(consulta, 5);
    }

    public ArrayList<String[]> buscaNoAlumnos() throws SQLException {
        consulta = "SELECT c.ciclo, g.grupo, "
                + "COUNT(eg.clave_estudiante) FROM grupo g, estudiante_grupo eg, ciclo c "
                + "WHERE g.clave_grupo = eg.clave_grupo "
                + "AND g.clave_ciclo = c.clave_ciclo "
                + "GROUP BY g.grupo, c.ciclo ORDER BY g.grupo;";
        return cnslt.buscarValores(consulta, 3);
    }

}
