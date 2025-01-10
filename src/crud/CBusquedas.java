package crud;

import java.util.ArrayList;
import java.sql.SQLException;

public class CBusquedas {

    private final CConsultas cnslt = new CConsultas();
    private String consulta;

    // Metodos Compra
    //--------------------------------------------------------------------------
    
    // Inicio de Sesion
    
   public String buscaPersona(String nombre, String apPat, String apMat) throws SQLException {
        consulta = "SELECT `Id_persona` FROM `persona` WHERE nombre = '" + nombre + "' AND ApPat = '" + apPat + "' AND ApMat = '" + apMat + "'";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaTelefono(String telefono, int idPersona) throws SQLException {
        consulta = "SELECT `Id_telefonoPersona` FROM `telefono_persona` WHERE telefono = '" + telefono + "' AND Id_persona = '" + idPersona + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaPasajero(int idPersona) throws SQLException {
        consulta = "SELECT `Id_pasajero` FROM `pasajero` WHERE Id_persona = '" + idPersona + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaCliente(int idPersona) throws SQLException {
        consulta = "SELECT `Id_cliente` FROM `cliente` WHERE `Id_persona` = " + idPersona + "";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaFecha(int dia, int idMes, int idAnio) throws SQLException {
        consulta = "SELECT `Id_fecha` FROM `fecha` WHERE fecha.dia = '" + dia + "' AND fecha.Id_mes = '" + idMes + "' AND fecha.Id_anio = '" + idAnio + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaAnio(int anio) throws SQLException {
        consulta = "SELECT `Id_anio` FROM `anio` WHERE anio.anio = '" + anio + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaMes(int mes) throws SQLException {
        consulta = "SELECT `Id_mes` FROM `mes` WHERE mes.Id_mes = '" + mes + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaMetodoPago(int idFecha) throws SQLException {
        consulta = "SELECT `Id_metodo` FROM `metodo_pago` WHERE metodo_pago.Id_fecha = '" + idFecha + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaTarjeta(String numCuenta, int cvv) throws SQLException {
//        consulta = "SELECT `Id_tarjeta` FROM `tarjeta` WHERE tarjeta.numeroCuenta = '" + numCuenta + "';";
        consulta = "SELECT `Id_tarjeta` FROM `tarjeta` WHERE tarjeta.numeroCuenta = '" + numCuenta + "' AND tarjeta.CVV = '" + cvv + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaBoleto(int idMetodo, int idRuta, int idFecha, int idAsiento, int idPasajero, String tipoBoleto, float precioDescuento) throws SQLException {
        consulta = "SELECT `Id_boleto` FROM `boleto` WHERE boleto.Id_metodo = '" + idMetodo + "'"
                + " AND boleto.Id_ruta = '" + idRuta + "' AND boleto.Id_fecha = '" + idFecha + "'"
                + " AND boleto.Id_asiento = '" + idAsiento + "' AND boleto.Id_pasajero = '" + idPasajero + "'"
                + " AND boleto.tipo_boleto = '" + tipoBoleto + "' AND boleto.precioDescuento = '" + precioDescuento + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaCompra(int idBoleto, int idCliente, float total) throws SQLException {
        consulta = "SELECT `Id_BolClie` FROM `boletocliente` WHERE"
                + " boletocliente.Id_boleto = '" + idBoleto + "' AND"
                + " boletocliente.Id_cliente = '" + idCliente + "' AND"
                + " boletocliente.total = '" + total + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaReembolso(int idBoleto, int idFecha, float cantidad) throws SQLException {
        consulta = "SELECT `Id_reembolso` FROM `reembolso` WHERE"
                + " reembolso.Id_boleto = '" + idBoleto + "' AND"
                + " reembolso.Id_fecha = '" + idFecha + "' AND"
                + " reembolso.cantidad = '" + cantidad + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaPrecioRuta(int idRuta) throws SQLException {
        consulta = "SELECT `precio` FROM `ruta` WHERE ruta.Id_ruta = '" + idRuta + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }

    public String buscaFechaRuta(int idRuta) throws SQLException {
        consulta = "SELECT `Id_fecha` FROM `rutaautobus` WHERE rutaautobus.Id_ruta = '" + idRuta + "';";
        return cnslt.buscarValorSinMensaje(consulta);
    }
    public String buscarReembolsoBoleto(int id) throws SQLException {
        String idReembolsoBoleto = "SELECT reembolso.Id_boleto FROM `reembolso` WHERE reembolso.Id_reembolso = " + id;
        return cnslt.buscarValor(consulta);
    }

    public String buscarReembolsoFecha(String idReembolso) throws SQLException {
        String idReembolsoFecha = "SELECT reembolso.Id_fecha FROM `reembolso` WHERE reembolso.Id_reembolso =" + idReembolso;
        return cnslt.buscarValor(consulta);
    }

    public String buscarIdFechaMesRe(String idFecha) throws SQLException {
        String idFechaMesRe = "SELECT fecha.Id_mes FROM `fecha` WHERE fecha.Id_fecha =" + idFecha;
        return cnslt.buscarValor(consulta);
    }

    public String buscarIdFechaAnioRe(String idFecha) throws SQLException {
        String idFechaAnioRe = "SELECT fecha.Id_Id_anio FROM `fecha` WHERE fecha.Id_fecha =" + idFecha;
        return cnslt.buscarValor(consulta);
    }

    public String buscarIdBoletoPasajero(String idBoleto) throws SQLException {
        String idBoletoPersona = "SELECT boleto.Id_pasajero FROM `boleto` WHERE boleto.Id_boleto ='" + idBoleto + "'";
        return cnslt.buscarValor(consulta);
    }

    //--------------------------------------------------------------------------
    public int obtenIdBuscaAño(int año) throws SQLException {
        consulta = "SELECT\n"
                + "anio.Id_anio\n"
                + "FROM\n"
                + "anio\n"
                + "WHERE\n"
                + "anio.anio = " + año + ";";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaNunEconomico(String numero) throws SQLException {
        consulta = "SELECT\n"
                + "autobus.Id_autobus\n"
                + "FROM\n"
                + "autobus\n"
                + "WHERE\n"
                + "autobus.num_economico = '" + numero + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaMarca(String marca) throws SQLException {
        consulta = "SELECT\n"
                + "marca.Id_marca\n"
                + "FROM\n"
                + "marca\n"
                + "WHERE\n"
                + "marca.nombre = '" + marca + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaModelo(String modelo) throws SQLException {
        consulta = "SELECT\n"
                + "modelo.Id_modelo\n"
                + "FROM\n"
                + "modelo\n"
                + "WHERE\n"
                + "modelo.nombre = '" + modelo + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaPlaca(String placa) throws SQLException {
        consulta = "SELECT\n"
                + "autobus.Id_autobus\n"
                + "FROM\n"
                + "autobus\n"
                + "WHERE\n"
                + "autobus.placa = '" + placa + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public String buscarRutaAutobus(int id) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "rutaautobus.Id_RutAut\n"
                + "FROM\n"
                + "rutaautobus\n"
                + "WHERE\n"
                + "rutaautobus.Id_RutAut = " + id + ";");
        return idConductor;
    }

    public String buscarIdAutobusRuAuto(String id) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "rutaautobus.Id_autobus\n"
                + "FROM\n"
                + "rutaautobus\n"
                + "WHERE\n"
                + "rutaautobus.Id_RutAut = " + id + ";");
        return idConductor;
    }

    public String buscarIdAutobus(int id) throws SQLException {
        return cnslt.buscarValor("SELECT Id_autobus FROM autobus WHERE Id_autobus = " + id + ";");
    }

    public String buscarIdFechaAuto(String idAutobus) throws SQLException {
        return cnslt.buscarValor("SELECT Id_fecha FROM autobus WHERE Id_autobus = " + idAutobus + ";");
    }

    public String buscarBoleto(int idBoleto) throws SQLException {
        return cnslt.buscarValor("SELECT Id_boleto FROM boleto WHERE Id_boleto = " + idBoleto);
    }

    public String buscarAsiento(String idAsiento) throws SQLException {
        return cnslt.buscarValor("SELECT Id_boleto FROM boleto WHERE Id_asiento = '" + idAsiento + "'");
    }

    public String buscarIdTerminal(String idBoleto, String tipo) throws SQLException {
        return cnslt.buscarValor("SELECT Id_terminal FROM boleto WHERE Id_boleto = " + idBoleto);
    }

    public String buscarIdFechaPorBoleto(String idBoleto) throws SQLException {
        return cnslt.buscarValor("SELECT Id_fecha FROM boleto WHERE Id_boleto = " + idBoleto);
    }

    public String buscarIdMesPorFecha(String idFecha) throws SQLException {
        return cnslt.buscarValor("SELECT Id_mes FROM fecha WHERE Id_fecha = " + idFecha);
    }

    public String buscarIdAnioPorFecha(String idFecha) throws SQLException {
        return cnslt.buscarValor("SELECT Id_anio FROM fecha WHERE Id_fecha = " + idFecha);
    }

    public String buscarIdModeloAuto(String idAutobus) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "autobus.Id_modelo\n"
                + "FROM\n"
                + "autobus\n"
                + "WHERE\n"
                + "autobus.Id_autobus =" + idAutobus + ";");
        return idConductor;
    }

    public String buscarIdMarcaModelo(String idModelo) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "modelo.Id_marca\n"
                + "FROM\n"
                + "modelo\n"
                + "WHERE\n"
                + "modelo.Id_modelo = " + idModelo + ";");
        return idConductor;
    }

    public String buscarIdFechaRuAut(String idViaje) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "rutaautobus.Id_fecha\n"
                + "FROM\n"
                + "rutaautobus\n"
                + "WHERE\n"
                + "rutaautobus.Id_RutAut = " + idViaje + ";");
        return idConductor;
    }

    public String buscarIdMesFecha(String idFecha) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "fecha.Id_mes\n"
                + "FROM\n"
                + "fecha\n"
                + "WHERE\n"
                + "fecha.Id_fecha = " + idFecha + ";");
        return idConductor;
    }

    public String buscarIdAnoFecha(String idFecha) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "fecha.Id_anio\n"
                + "FROM\n"
                + "fecha\n"
                + "WHERE\n"
                + "fecha.Id_fecha = " + idFecha + ";");
        return idConductor;
    }

    public String buscarIdRutaRutAut(String idViaje) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "rutaautobus.Id_ruta\n"
                + "FROM\n"
                + "rutaautobus\n"
                + "WHERE\n"
                + "rutaautobus.Id_RutAut = " + idViaje + ";");
        return idConductor;
    }

    public String buscarIdOrigenRuta(String idRuta) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "ruta.Id_origen\n"
                + "FROM\n"
                + "ruta\n"
                + "WHERE\n"
                + "ruta.Id_ruta = " + idRuta + ";");
        return idConductor;
    }

    public String buscarIdTerminalOrigen(String idOrigen) throws SQLException {
        return cnslt.buscarValor("SELECT o.Id_terminal FROM origen o WHERE o.Id_origen = '" + idOrigen + "'");
    }

    public String buscarIdDestinoRuta(String idRuta) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "ruta.Id_destino\n"
                + "FROM\n"
                + "ruta\n"
                + "WHERE\n"
                + "ruta.Id_ruta = " + idRuta + ";");
        return idConductor;
    }

    public String buscarIdTerminalDestino(String idDestino) throws SQLException {
        return cnslt.buscarValor("SELECT d.Id_terminal FROM destino d WHERE d.Id_destino = '" + idDestino + "'");
    }

    public ArrayList<String[]> buscarReembolsoCompleto() throws SQLException {
        consulta = "SELECT r.Id_reembolso, p.nombre,  p.ApPat,  p.ApMat, r.cantidad AS cantidad_reembolso, f.dia, m.mes,  a.anio FROM reembolso r JOIN boleto b ON r.Id_boleto = b.Id_boleto JOIN pasajero pas ON b.Id_pasajero = pas.Id_pasajero "
                + "JOIN persona p ON pas.Id_persona = p.Id_persona JOIN fecha f ON r.Id_fecha = f.Id_fecha JOIN mes m ON f.Id_mes = m.Id_mes JOIN anio a ON f.Id_anio = a.Id_anio;";
        return cnslt.buscarValores(consulta, 8);
    }

    public String buscarReembolso(int id) throws SQLException {
        String idReembolso = cnslt.buscarValor("SELECT reembolso.Id_reembolso FROM flecha_amarilla.reembolso WHERE reembolso.Id_reembolso = " + id);
        return idReembolso;
    }

    public ArrayList<String[]> buscaViajeCompleta() throws SQLException {
        consulta = "SELECT ra.Id_RutAut, t_origen.nombre AS origen, t_destino.nombre AS destino, a.placa, m.nombre AS modelo, ma.nombre AS marca, f.dia, me.mes FROM ruta r "
                + "JOIN terminal t_origen ON r.Id_origen = t_origen.Id_terminal JOIN terminal t_destino ON r.Id_destino = t_destino.Id_terminal JOIN rutaAutobus ra ON r.Id_ruta = ra.Id_ruta "
                + "JOIN autobus a ON ra.Id_autobus = a.Id_autobus JOIN modelo m ON a.Id_modelo = m.Id_modelo JOIN marca ma ON m.Id_marca = ma.Id_marca JOIN fecha f ON ra.Id_fecha = f.Id_fecha JOIN mes me ON f.Id_mes = me.Id_mes;";
//        return cnslt.buscarCon7(consulta);
        return cnslt.buscarValores(consulta, 8);
    }

    public String buscarViaje(int id) throws SQLException {
        String idViaje = cnslt.buscarValor("SELECT rutaautobus.Id_RutAut FROM flecha_amarilla.rutaautobus WHERE rutaautobus.Id_RutAut = " + id);
        return idViaje;
    }

    public String buscaConduce(int id) throws SQLException {
        String idConduce = cnslt.buscarValor("SELECT autobusconductor.Id_AutCon FROM flecha_amarilla.autobusconductor WHERE autobusconductor.Id_AutCon = " + id);
        return idConduce;
    }

    public ArrayList<String[]> buscaConduceCompletos() throws SQLException {
        consulta = "SELECT autobusconductor.Id_AutCon, persona.nombre, persona.ApPat, persona.ApMat, autobus.placa, marca.nombre AS nombre_marca, modelo.nombre AS nombre_modelo FROM flecha_amarilla.autobus INNER JOIN autobusconductor ON autobus.Id_autobus = autobusconductor.Id_autobus "
                + " INNER JOIN conductor ON autobusconductor.Id_conductor = conductor.Id_conductor INNER JOIN modelo ON autobus.Id_modelo = modelo.Id_modelo INNER JOIN marca ON modelo.Id_marca = marca.Id_marca INNER JOIN persona ON conductor.Id_persona = persona.Id_persona ";
        return cnslt.buscarValores(consulta, 7);
    }

    public ArrayList<String[]> buscarPrueba(int camposRecibidos) throws SQLException {
        consulta = "SELECT persona.nombre, persona.ApPat, persona.ApMat, cliente.correo  FROM cliente INNER JOIN persona ON persona.Id_persona = cliente.Id_persona;";
        return cnslt.buscarValores(consulta, camposRecibidos);
    }

    public ArrayList<String[]> buscarClientesCompletos() throws SQLException {
        consulta = "SELECT persona.Id_persona, persona.nombre, persona.ApPat, persona.ApMat, cliente.correo FROM cliente INNER JOIN persona ON cliente.Id_persona = persona.Id_persona";
//        return cnslt.buscarCon5(consulta);
        return cnslt.buscarValores(consulta, 5);
    }

    public String buscarClientes(int id) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT cliente.Id_cliente FROM flecha_amarilla.cliente WHERE cliente.Id_persona = " + id);
        return idConductor;
    }

    public ArrayList<String[]> buscarPasajerosCompletos() throws SQLException {
        consulta = "SELECT  p.Id_pasajero, pe.nombre, pe.ApPat,  pe.ApMat,  p.tipoPasajero,  p.descuento FROM flecha_amarilla.pasajero AS p INNER JOIN  flecha_amarilla.persona AS pe ON  p.Id_persona = pe.Id_persona;";
        return cnslt.buscarValores(consulta, 6);
    }

    public ArrayList<String[]> buscarConductores() throws SQLException {
        consulta = "SELECT persona.nombre, persona.ApPat, persona.ApMat, telefono_persona.telefono FROM conductor INNER JOIN persona ON conductor.Id_persona = persona.Id_persona INNER JOIN telefono_persona ON telefono_persona.Id_persona = persona.Id_persona";
//        return cnslt.buscarCon4(consulta);
        return cnslt.buscarValores(consulta, 4);
    }

    public String buscarConductor(int id) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT conductor.Id_conductor FROM flecha_amarilla.conductor WHERE conductor.Id_persona = " + id);
        return idConductor;
    }

    public ArrayList<String[]> buscarConductoresCompletos() throws SQLException {
        consulta = "SELECT conductor.id_conductor, persona.nombre, persona.ApPat, persona.ApMat, telefono_persona.telefono FROM conductor INNER JOIN persona ON conductor.Id_persona = persona.Id_persona INNER JOIN telefono_persona ON telefono_persona.Id_persona = persona.Id_persona";
//        return cnslt.buscarCon5(consulta);
        return cnslt.buscarValores(consulta, 5);
    }

    public ArrayList<String[]> buscaUsuarios() throws SQLException {
        consulta = "SELECT persona.nombre, persona.ApPat, persona.ApMat FROM persona";
//        return cnslt.buscarCon3(consulta);
        return cnslt.buscarValores(consulta, 3);
    }

    public ArrayList<String[]> buscaAutobusesCompletos() throws SQLException {
        consulta = "SELECT autobus.Id_autobus, marca.nombre AS nombre_marca, modelo.nombre AS nombre_modelo, autobus.capacidad, fecha.dia AS dia_servicio, mes.mes AS mes_servicio, anio.anio AS anio_servicio "
                + "FROM autobus JOIN modelo ON autobus.Id_modelo = modelo.Id_modelo JOIN marca ON modelo.Id_marca = marca.Id_marca JOIN fecha ON autobus.Id_fecha = fecha.Id_fecha\n"
                + "JOIN mes ON fecha.Id_mes = mes.Id_mes JOIN anio ON fecha.Id_anio = anio.Id_anio;";
        return cnslt.buscarValores(consulta, 7);
    }

    public String buscarAutobus(int id) throws SQLException {
        String idAutobus = cnslt.buscarValor("SELECT autobus.Id_autobus FROM flecha_amarilla.autobus WHERE autobus.Id_autobus = " + id);
        return idAutobus;
    }

    public ArrayList<String[]> buscaAutobusesActivos() throws SQLException {
        consulta = "SELECT marca.nombre, modelo.nombre, autobus.capacidad, "
                + "CONCAT(fecha.dia, ' - ', mes.mes, ' - ', anio.anio) FROM "
                + "autobus JOIN fecha ON autobus.Id_fecha = fecha.Id_fecha JOIN "
                + "mes ON fecha.Id_mes = mes.Id_mes JOIN anio ON fecha.Id_anio = "
                + "anio.Id_anio JOIN modelo ON autobus.Id_modelo = modelo.Id_modelo JOIN "
                + "marca ON modelo.Id_marca = marca.Id_marca LEFT JOIN baja ON "
                + "autobus.Id_autobus = baja.Id_autobus WHERE baja.Id_autobus IS NULL";
        return cnslt.buscarValores(consulta, 4);
    }

    public ArrayList<String[]> buscaAutobusesInactivos() throws SQLException {
        consulta = "SELECT marca.nombre, modelo.nombre, autobus.capacidad, "
                + "CONCAT( fecha.dia, ' - ', mes.mes, ' - ', anio.anio ) FROM "
                + "autobus JOIN fecha ON autobus.Id_fecha = fecha.Id_fecha JOIN "
                + "mes ON fecha.Id_mes = mes.Id_mes JOIN anio ON fecha.Id_anio = "
                + "anio.Id_anio JOIN modelo ON autobus.Id_modelo = modelo.Id_modelo "
                + "JOIN marca ON modelo.Id_marca = marca.Id_marca JOIN baja ON "
                + "autobus.Id_autobus = baja.Id_autobus;";
        return cnslt.buscarValores(consulta, 4);
    }

    public ArrayList<String[]> buscaParadasCompletas() throws SQLException {
        consulta = " SELECT rutaterminal.Id_RutTer, ruta.nombre, terminal.nombre FROM rutaterminal "
                + " INNER JOIN ruta ON ruta.Id_ruta = rutaterminal.Id_ruta "
                + " INNER JOIN terminal ON terminal.Id_terminal = rutaterminal.Id_terminal ";
//        return cnslt.buscarCon2(consulta);
        return cnslt.buscarValores(consulta, 3);
    }

    public String buscarParadas(int id) throws SQLException {
        String idParada = cnslt.buscarValor("SELECT rutaterminal.Id_RutTer FROM flecha_amarilla.rutaterminal WHERE rutaterminal.Id_RutTer = " + id);
        return idParada;
    }

    public String buscarBoletos(int id) throws SQLException {
        String idBoleto = cnslt.buscarValor("SELECT boleto.Id_boleto FROM flecha_amarilla.boleto WHERE boleto.Id_boleto = " + id);
        return idBoleto;
    }

    public ArrayList<String[]> buscaBoletosCompletos() throws SQLException {
        consulta = "SELECT boleto.Id_boleto, asiento.asiento, terminal_origen.nombre AS Origen, terminal_destino.nombre AS Destino, fecha.dia, mes.mes, anio.anio, boleto.tipo_boleto, boleto.precioDescuento FROM boleto "
                + "JOIN asiento ON boleto.Id_asiento = asiento.Id_asiento JOIN ruta ON boleto.Id_ruta = ruta.Id_ruta JOIN origen ON ruta.Id_origen = origen.Id_origen JOIN destino ON ruta.Id_destino = destino.Id_destino "
                + "JOIN terminal AS terminal_origen ON origen.Id_terminal = terminal_origen.Id_terminal JOIN terminal AS terminal_destino ON destino.Id_terminal = terminal_destino.Id_terminal JOIN fecha ON boleto.Id_fecha = fecha.Id_fecha "
                + "JOIN mes ON fecha.Id_mes = mes.Id_mes JOIN anio ON fecha.Id_anio = anio.Id_anio;";
        return cnslt.buscarValores(consulta, 9);
    }

    public ArrayList<String[]> buscaTerminalesCompletas() throws SQLException {
        consulta = "SELECT terminal.Id_terminal, terminal.nombre, estado.nombre, ciudad.nombre, direccion.nombre_calle, direccion.numero, colonia.colonia, codigo_postal.codigo_postal, telefonoterminal.telefono "
                + "FROM terminal INNER JOIN direccion ON direccion.Id_direccion = terminal.Id_direccion INNER JOIN ciudad ON ciudad.Id_ciudad = direccion.Id_ciudad INNER JOIN estado ON estado.Id_estado = ciudad.Id_estado "
                + "INNER JOIN colonia ON colonia.Id_colonia = direccion.Id_colonia INNER JOIN codigo_postal ON codigo_postal.Id_CP = direccion.Id_CP INNER JOIN telefonoterminal ON terminal.Id_terminal = telefonoterminal.Id_terminal ";
//        return cnslt.buscarCon8(consulta);
        return cnslt.buscarValores(consulta, 9);
    }

    public String buscarTerminales(int id) throws SQLException {
        String idTerminal = cnslt.buscarValor("SELECT terminal.Id_terminal FROM flecha_amarilla.terminal WHERE terminal.Id_terminal = " + id);
        return idTerminal;
    }

    public ArrayList<String[]> buscaRutasCompletas() throws SQLException {
        consulta = "SELECT DISTINCT ruta.Id_ruta, ruta.nombre AS NombreRuta,terminal_origen.nombre AS Origen, terminal_destino.nombre AS Destino, ruta.distancia, ruta.hora_salida,"
                + " ruta.hora_llegada,ruta.duracion_ruta,ruta.precio FROM ruta  JOIN origen ON ruta.Id_origen = origen.Id_origen JOIN destino ON ruta.Id_destino = destino.Id_destino"
                + " JOIN terminal AS terminal_origen ON origen.Id_terminal = terminal_origen.Id_terminal JOIN terminal AS terminal_destino ON destino.Id_terminal = terminal_destino.Id_terminal";
        return cnslt.buscarValores(consulta, 9);
    }

    public String buscarRutas(int id) throws SQLException {
        String idRuta = cnslt.buscarValor("SELECT ruta.Id_ruta FROM flecha_amarilla.ruta WHERE ruta.Id_ruta = " + id);
        return idRuta;
    }

    public int obtenIdFinalPersona() throws SQLException {
        consulta = "SELECT MAX(Id_persona) FROM flecha_amarilla.persona;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalTelefono() throws SQLException {
        consulta = "SELECT MAX(Id_telefonoPersona) FROM flecha_amarilla.telefono_persona;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalCliente() throws SQLException {
        consulta = "SELECT MAX(Id_cliente) FROM flecha_amarilla.cliente;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalConductor() throws SQLException {
        consulta = "SELECT MAX(Id_conductor) FROM flecha_amarilla.conductor;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalPasajero() throws SQLException {
        consulta = "SELECT MAX(Id_pasajero) FROM flecha_amarilla.pasajero;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalFecha() throws SQLException {
        consulta = "SELECT MAX(fecha.Id_fecha) FROM flecha_amarilla.fecha;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalAnio() throws SQLException {
        consulta = "SELECT MAX(anio.Id_anio) FROM flecha_amarilla.anio;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalTarjeta() throws SQLException {
        consulta = "SELECT MAX(tarjeta.Id_tarjeta) FROM flecha_amarilla.tarjeta;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalMetodoPago() throws SQLException {
        consulta = "SELECT MAX(metodo_pago.Id_metodo) FROM flecha_amarilla.metodo_pago;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalEfectivo() throws SQLException {
        consulta = "SELECT MAX(efectivo.Id_efectivo) FROM flecha_amarilla.efectivo;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalBoleto() throws SQLException {
        consulta = "SELECT MAX(boleto.Id_boleto) FROM flecha_amarilla.boleto;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalCompra() throws SQLException {
        consulta = "SELECT MAX(boletocliente.Id_BolClie) FROM flecha_amarilla.boletocliente";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalReembolso() throws SQLException {
        consulta = "SELECT MAX(reembolso.Id_reembolso) FROM flecha_amarilla.reembolso;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public ArrayList<String[]> consulta8() throws SQLException {
        consulta = "SELECT CONCAT(p.nombre, ' ', p.ApPat, ' ', p.ApMat) AS Nombre_Pasajero,"
                + " CONCAT(pCon.nombre, ' ', pCon.ApPat, ' ', pCon.ApMat) AS Nombre_Conductor,"
                + " ruta.nombre AS Nombre_Ruta, CONCAT(fecha.dia,' ', mes.mes,' ',anio.anio)"
                + " AS Fecha FROM boleto b, pasajero pa, persona p, ruta, rutaAutobus ra,"
                + " autobusConductor ac, conductor co, persona pCon, fecha, mes, anio"
                + " WHERE b.Id_pasajero = pa.Id_pasajero AND pa.Id_persona = p.Id_persona"
                + " AND b.Id_ruta = ruta.Id_ruta AND ruta.Id_ruta = ra.Id_ruta AND ra.Id_autobus"
                + " = ac.Id_autobus AND ac.Id_conductor = co.Id_conductor AND co.Id_persona"
                + " = pCon.Id_persona AND b.Id_fecha = fecha.Id_fecha AND fecha.Id_mes = mes.Id_mes"
                + " AND fecha.Id_anio = anio.Id_anio AND fecha.dia = 16 AND mes.mes = 'Junio' AND"
                + " anio.anio = 2024;";
        return cnslt.buscarValores(consulta, 4);
    }

    public ArrayList<String[]> consulta9() throws SQLException {
//        consulta = "SELECT DISTINCT ruta.Id_ruta, ruta.nombre, ruta.duracion_ruta,"
//                + " ruta.hora_salida, ruta.hora_llegada, ruta.precio, ruta.distancia,"
//                + " ruta.Id_origen, origen.nombre, ruta.Id_destino, destino.nombre FROM"
//                + " ruta INNER JOIN boleto ON ruta.Id_ruta = boleto.Id_ruta INNER JOIN"
//                + " metodo_pago ON boleto.Id_metodo = metodo_pago.Id_metodo INNER JOIN"
//                + " terminal AS origen ON origen.Id_terminal = ruta.Id_origen INNER JOIN"
//                + " terminal AS destino ON destino.Id_terminal = ruta.Id_destino WHERE"
//                + " metodo_pago.Id_metodo = 1;";
        consulta = "SELECT DISTINCT ruta.nombre, ruta.duracion_ruta, ruta.hora_salida,"
                + " ruta.hora_llegada, ruta.precio, ruta.distancia, origen.nombre,"
                + " destino.nombre FROM ruta INNER JOIN boleto ON ruta.Id_ruta = boleto.Id_ruta"
                + " INNER JOIN metodo_pago ON boleto.Id_metodo = metodo_pago.Id_metodo"
                + " INNER JOIN terminal AS origen ON origen.Id_terminal = ruta.Id_origen"
                + " INNER JOIN terminal AS destino ON destino.Id_terminal = ruta.Id_destino"
                + " WHERE metodo_pago.Id_metodo = 1;";
        return cnslt.buscarValores(consulta, 8);
    }

    public ArrayList<String[]> consulta12() throws SQLException {
        consulta = "SELECT DISTINCT CONCAT( p.nombre, ' ', p.ApPat, ' ', p.ApMat ) AS Nombre_Chofer,"
                + " r.nombre AS Nombre_Ruta, cor.nombre AS Ciudad_Origen, cde.nombre AS Ciudad_Destino,"
                + " ter.nombre AS Terminal_Parada, CONCAT( per.nombre, ' ', per.ApPat, ' ', per.ApMat )"
                + " AS Nombre_cliente FROM ruta r, rutaConductor rc, conductor c, persona p, origen o,"
                + " destino d, terminal tor, direccion dor, ciudad cor, terminal tde, direccion dde,"
                + " ciudad cde, rutaTerminal rt, terminal ter, direccion dir_parada, boleto b, pasajero pas,"
                + " persona per WHERE r.Id_ruta = rc.Id_ruta AND rc.Id_conductor = c.Id_conductor AND"
                + " c.Id_persona = p.Id_persona AND r.Id_origen = o.Id_origen AND r.Id_destino = d.Id_destino"
                + " AND o.Id_terminal = tor.Id_terminal AND tor.Id_direccion = dor.Id_direccion AND"
                + " dor.Id_ciudad = cor.Id_ciudad AND d.Id_terminal = tde.Id_terminal AND tde.Id_direccion"
                + " = dde.Id_direccion AND dde.Id_ciudad = cde.Id_ciudad AND r.Id_ruta = rt.Id_ruta AND"
                + " rt.Id_terminal = ter.Id_terminal AND ter.Id_direccion = dir_parada.Id_direccion AND"
                + " r.Id_ruta = b.Id_ruta AND b.Id_pasajero = pas.Id_pasajero AND pas.Id_persona"
                + " = per.Id_persona AND cor.nombre = 'Ciudad de México' AND cde.nombre = 'Cancún';";
        return cnslt.buscarValores(consulta, 6);
    }

    public ArrayList<String[]> consulta13() throws SQLException {
        consulta = "SELECT co.nombre AS Ciudad_Origen, cd.nombre AS Ciudad_Destino FROM ruta r JOIN"
                + " origen o ON r.Id_origen = o.Id_origen JOIN destino d ON r.Id_destino = d.Id_destino JOIN"
                + " terminal torigen ON o.Id_terminal = torigen.Id_terminal JOIN direccion dorigen ON"
                + " torigen.Id_direccion = dorigen.Id_direccion JOIN ciudad co ON dorigen.Id_ciudad = co.Id_ciudad JOIN"
                + " terminal tdestino ON d.Id_terminal = tdestino.Id_terminal JOIN direccion ddestino ON"
                + " tdestino.Id_direccion = ddestino.Id_direccion JOIN ciudad cd ON ddestino.Id_ciudad = cd.Id_ciudad JOIN"
                + " rutaConductor rc ON r.Id_ruta = rc.Id_ruta GROUP BY r.Id_ruta, co.nombre, cd.nombre"
                + " HAVING COUNT(DISTINCT rc.Id_conductor) = 3;";
        return cnslt.buscarValores(consulta, 2);
    }

    public ArrayList<String[]> consulta14() throws SQLException {
        consulta = "SELECT asiento.asiento AS 'Nombre Asiento', marca.nombre AS 'Marca', modelo.nombre AS 'Modelo' FROM"
                + " autobus JOIN rutaAutobus ON autobus.Id_autobus = rutaAutobus.Id_autobus JOIN"
                + " ruta ON rutaAutobus.Id_ruta = ruta.Id_ruta JOIN asiento ON"
                + " autobus.Id_autobus = asiento.Id_autobus LEFT JOIN boleto ON"
                + " asiento.Id_asiento = boleto.Id_asiento JOIN fecha ON"
                + " rutaAutobus.Id_fecha = fecha.Id_fecha JOIN origen ON"
                + " ruta.Id_origen = origen.Id_origen JOIN destino ON"
                + " ruta.Id_destino = destino.Id_destino JOIN ciudad AS"
                + " ciudad_origen ON origen.Id_terminal = ciudad_origen.Id_ciudad JOIN"
                + " ciudad AS ciudad_destino ON destino.Id_terminal = ciudad_destino.Id_ciudad JOIN"
                + " mes ON fecha.Id_mes = mes.Id_mes JOIN anio ON fecha.Id_anio = anio.Id_anio JOIN"
                + " modelo ON autobus.Id_modelo = modelo.Id_modelo JOIN marca ON"
                + " modelo.Id_marca = marca.Id_marca WHERE ciudad_origen.nombre = 'Ciudad de Mexico' AND"
                + " ciudad_destino.nombre = 'Morelia' AND fecha.dia = 20 AND mes.mes = 'Junio' AND"
                + " anio.anio = 2024 AND boleto.Id_boleto IS NULL;";
        return cnslt.buscarValores(consulta, 3);
    }

//    public ArrayList<String[]> buscaAsientos(String destino, String origen, String mes, String dia, String anio) throws SQLException {
//        consulta = "SELECT asiento.id_asiento, asiento.asiento\n"
//                + "FROM autobus\n"
//                + "JOIN rutaAutobus ON autobus.Id_autobus = rutaAutobus.Id_autobus\n"
//                + "JOIN ruta ON rutaAutobus.Id_ruta = ruta.Id_ruta\n"
//                + "JOIN asiento ON autobus.Id_autobus = asiento.Id_autobus\n"
//                + "LEFT JOIN boleto ON asiento.Id_asiento = boleto.Id_asiento\n"
//                + "JOIN fecha ON rutaAutobus.Id_fecha = fecha.Id_fecha\n"
//                + "JOIN origen ON ruta.Id_origen = origen.Id_origen\n"
//                + "JOIN destino ON ruta.Id_destino = destino.Id_destino\n"
//                + "JOIN ciudad AS ciudad_origen ON origen.Id_terminal = ciudad_origen.Id_ciudad\n"
//                + "JOIN ciudad AS ciudad_destino ON destino.Id_terminal = ciudad_destino.Id_ciudad\n"
//                + "JOIN mes ON fecha.Id_mes = mes.Id_mes\n"
//                + "JOIN anio ON fecha.Id_anio = anio.Id_anio\n"
//                + "JOIN modelo ON autobus.Id_modelo = modelo.Id_modelo\n"
//                + "JOIN marca ON modelo.Id_marca = marca.Id_marca\n"
//                + "WHERE ciudad_origen.nombre = '" + origen + "'\n"
//                + "  AND ciudad_destino.nombre = '" + destino + "'\n"
//                + "  AND fecha.dia = " + dia + "\n"
//                + "  AND mes.mes = '" + mes + "'\n"
//                + "  AND anio.anio = " + anio + "\n"
//                + "  AND boleto.Id_boleto IS NULL;";
//        return cnslt.buscarValores(consulta, 2);
//    }
    public ArrayList<String[]> buscaAsientosRuta(String destino, String origen, String mes, String dia, String anio) throws SQLException {
        consulta = "SELECT asiento.id_asiento, asiento.asiento, ruta.Id_ruta, ruta.precio "
                + "FROM autobus "
                + "JOIN rutaAutobus ON autobus.Id_autobus = rutaAutobus.Id_autobus "
                + "JOIN ruta ON rutaAutobus.Id_ruta = ruta.Id_ruta "
                + "JOIN asiento ON autobus.Id_autobus = asiento.Id_autobus "
                + "LEFT JOIN boleto ON asiento.Id_asiento = boleto.Id_asiento "
                + "JOIN fecha ON rutaAutobus.Id_fecha = fecha.Id_fecha "
                + "JOIN origen ON ruta.Id_origen = origen.Id_origen "
                + "JOIN destino ON ruta.Id_destino = destino.Id_destino "
                + "JOIN terminal AS terminal_origen ON origen.Id_terminal = terminal_origen.Id_terminal "
                + "JOIN terminal AS terminal_destino ON destino.Id_terminal = terminal_destino.Id_terminal "
                + "JOIN mes ON fecha.Id_mes = mes.Id_mes "
                + "JOIN anio ON fecha.Id_anio = anio.Id_anio "
                + "JOIN modelo ON autobus.Id_modelo = modelo.Id_modelo "
                + "JOIN marca ON modelo.Id_marca = marca.Id_marca "
                + "WHERE terminal_origen.nombre = '" + origen + "' "
                + "AND terminal_destino.nombre = '" + destino + "' "
                + "AND fecha.dia = " + dia + " "
                + "AND mes.mes = '" + mes + "' "
                + "AND anio.anio = " + anio + " "
                + "AND boleto.Id_boleto IS NULL;";
        return cnslt.buscarValores(consulta, 4);
    }

    public int obtenIdFinalRuta() throws SQLException {
        consulta = "SELECT MAX(Id_ruta) FROM flecha_amarilla.ruta;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdRuta(String ruta) throws SQLException {
        consulta = "SELECT\n"
                + "ruta.Id_ruta\n"
                + "FROM\n"
                + "ruta\n"
                + "WHERE\n"
                + "ruta.nombre = '" + ruta + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFecha(int dia, String mes, int anio) throws SQLException {
        consulta = "SELECT\n"
                + "fecha.Id_fecha\n"
                + "FROM\n"
                + "fecha\n"
                + "INNER JOIN anio ON anio.Id_anio = fecha.Id_anio\n"
                + "INNER JOIN mes ON mes.Id_mes = fecha.Id_mes\n"
                + "WHERE\n"
                + "fecha.dia =" + dia + " AND\n"
                + "mes.mes = '" + mes + "' AND\n"
                + "anio.anio = " + 2024 + ";";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdtTerminal(String terminal) throws SQLException {
        consulta = "SELECT\n"
                + "terminal.Id_terminal\n"
                + "FROM\n"
                + "terminal\n"
                + "WHERE\n"
                + "terminal.nombre = '" + terminal + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalParada() throws SQLException {
        consulta = "SELECT MAX(Id_RutTer) FROM flecha_amarilla.rutaterminal;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalAutobusConductor() throws SQLException {
        consulta = "SELECT MAX(Id_AutCon) FROM flecha_amarilla.autobusconductor;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalRutaAutobus() throws SQLException {
        consulta = "SELECT MAX(Id_RutAut) FROM flecha_amarilla.rutaautobus;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalRutaConductor() throws SQLException {
        consulta = "SELECT MAX(Id_RutCon) FROM flecha_amarilla.rutaconductor;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdOrigenSeleccionado(String origen) throws SQLException {
        consulta = "SELECT\n"
                + "origen.Id_origen\n"
                + "FROM\n"
                + "origen\n"
                + "INNER JOIN terminal ON terminal.Id_terminal = origen.Id_terminal\n"
                + "WHERE\n"
                + "terminal.nombre ='" + origen + "'";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdDestinoSeleccionado(String destino) throws SQLException {
        consulta = "SELECT\n"
                + "origen.Id_origen\n"
                + "FROM\n"
                + "origen\n"
                + "INNER JOIN terminal ON terminal.Id_terminal = origen.Id_terminal\n"
                + "WHERE\n"
                + "terminal.nombre ='" + destino + "'";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaConductor(String conductor) throws SQLException {
        consulta = "SELECT\n"
                + "conductor.Id_conductor\n"
                + "FROM\n"
                + "persona\n"
                + "INNER JOIN conductor ON persona.Id_persona = conductor.Id_persona\n"
                + "WHERE\n"
                + "persona.nombre = '" + conductor + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaAutobus(String numAutobus) throws SQLException {
        consulta = "SELECT\n"
                + "autobus.Id_autobus\n"
                + "FROM\n"
                + "autobus\n"
                + "WHERE\n"
                + "autobus.num_economico = '" + numAutobus + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaAnio(int anio) throws SQLException {
        consulta = "SELECT\n"
                + "anio.Id_anio\n"
                + "FROM\n"
                + "anio\n"
                + "WHERE\n"
                + "anio.anio = " + anio + ";";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaFecha(int dia, String mes, int año) throws SQLException {
        consulta = "SELECT\n"
                + "fecha.Id_fecha\n"
                + "FROM\n"
                + "anio\n"
                + "INNER JOIN fecha ON anio.Id_anio = fecha.Id_anio\n"
                + "INNER JOIN mes ON mes.Id_mes = fecha.Id_mes\n"
                + "WHERE\n"
                + "anio.anio = " + año + " AND\n"
                + "mes.mes = '" + mes + "' AND\n"
                + "fecha.dia = " + dia + ";";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalAño() throws SQLException {
        consulta = "SELECT MAX(Id_anio) FROM flecha_amarilla.anio;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalMarca() throws SQLException {
        consulta = "SELECT MAX(Id_marca) FROM flecha_amarilla.marca;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalModelo() throws SQLException {
        consulta = "SELECT MAX(Id_modelo) FROM flecha_amarilla.modelo;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalAutobus() throws SQLException {
        consulta = "SELECT MAX(Id_autobus) FROM flecha_amarilla.autobus;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalCodigoPostal() throws SQLException {
        consulta = "SELECT MAX(Id_CP) FROM flecha_amarilla.codigo_postal;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public String obtenIdFinalCodigoPostall() throws SQLException {
        consulta = "SELECT MAX(Id_CP) FROM flecha_amarilla.codigo_postal;";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdFinalColoniaa() throws SQLException {
        consulta = "SELECT MAX(Id_colonia) FROM flecha_amarilla.colonia;";
        return cnslt.buscarValor(consulta);
    }

    public int obtenIdFinalColonia() throws SQLException {
        consulta = "SELECT MAX(Id_colonia) FROM flecha_amarilla.colonia;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalDireciion() throws SQLException {
        consulta = "SELECT MAX(Id_direccion) FROM flecha_amarilla.direccion;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalTerminal() throws SQLException {
        consulta = "SELECT MAX(Id_terminal) FROM flecha_amarilla.terminal;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalEstado() throws SQLException {
        consulta = "SELECT MAX(Id_estado) FROM flecha_amarilla.estado;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdFinalCiudad() throws SQLException {
        consulta = "SELECT MAX(Id_ciudad) FROM flecha_amarilla.ciudad;";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaEstado(String estado) throws SQLException {
        consulta = "SELECT\n"
                + "estado.Id_estado\n"
                + "FROM\n"
                + "estado\n"
                + "WHERE\n"
                + "estado.nombre = '" + estado + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdtEstado(String estado) throws SQLException {
        consulta = "SELECT\n"
                + "estado.Id_estado\n"
                + "FROM\n"
                + "estado\n"
                + "WHERE\n"
                + "estado.nombre = '" + estado + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdCodigoPostal(int codigoPostal) throws SQLException {
        consulta = "SELECT\n"
                + "codigo_postal.Id_CP\n"
                + "FROM\n"
                + "codigo_postal\n"
                + "WHERE\n"
                + "codigo_postal.codigo_postal = " + codigoPostal + ";";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdtCiudad(String Ciudad) throws SQLException {
        consulta = "SELECT\n"
                + "ciudad.Id_ciudad\n"
                + "FROM\n"
                + "ciudad\n"
                + "WHERE\n"
                + "ciudad.nombre = '" + Ciudad + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdtColonia(String colonia) throws SQLException {
        consulta = "SELECT\n"
                + "colonia.Id_colonia\n"
                + "FROM\n"
                + "colonia\n"
                + "WHERE\n"
                + "colonia.colonia = '" + colonia + "';";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int obtenIdBuscaDireccion(String calle, int numero) throws SQLException {
        consulta = "SELECT\n"
                + "direccion.Id_direccion\n"
                + "FROM\n"
                + "direccion\n"
                + "INNER JOIN ciudad ON ciudad.Id_ciudad = direccion.Id_ciudad\n"
                + "INNER JOIN colonia ON colonia.Id_colonia = direccion.Id_colonia\n"
                + "INNER JOIN codigo_postal ON codigo_postal.Id_CP = direccion.Id_CP\n"
                + "INNER JOIN estado ON estado.Id_estado = ciudad.Id_estado\n"
                + "WHERE\n"
                + "direccion.nombre_calle = '" + calle + "' AND\n"
                + "direccion.numero = " + numero + ";";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public String buscarIdNumeroHabitacional(String numero) throws SQLException {
        String idTerminal = cnslt.buscarValor("SELECT\n"
                + "direccion.Id_direccion\n"
                + "FROM\n"
                + "direccion\n"
                + "WHERE\n"
                + "direccion.numero = '" + numero + "';");
        return idTerminal;
    }

    public int buscarIdConductorRutaConductor(int idRutaConductor) throws SQLException {
        consulta = "SELECT Id_conductor FROM rutaConductor WHERE Id_rutaConductor = " + idRutaConductor + ";";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public int buscarIdPersonaConductor(int idConductor) throws SQLException {
        consulta = "SELECT Id_persona FROM conductor WHERE Id_conductor = " + idConductor + ";";
        return Integer.parseInt(cnslt.buscarValor(consulta));
    }

    public String buscarIdNombreTerminal(String nombreTerminal) throws SQLException {
        String idTerminal = cnslt.buscarValor("SELECT terminal.Id_terminal\n"
                + "FROM\n"
                + "terminal\n"
                + "WHERE\n"
                + "terminal.nombre = '" + nombreTerminal + "';");
        return idTerminal;
    }

    public String buscarIdCiudad(String ciudad) throws SQLException {
        String idTerminal = cnslt.buscarValor("SELECT\n"
                + "ciudad.Id_ciudad\n"
                + "FROM\n"
                + "ciudad\n"
                + "WHERE\n"
                + "ciudad.nombre = '" + ciudad + "';");
        return idTerminal;
    }

    public String buscarIdColonia(String colonia) throws SQLException {
        String idTerminal = cnslt.buscarValor("SELECT\n"
                + "colonia.Id_colonia\n"
                + "FROM\n"
                + "colonia\n"
                + "WHERE\n"
                + "colonia.colonia = '" + colonia + "';");
        return idTerminal;
    }

    public String buscarIdCodigoPostal(String codigoPostal) throws SQLException {
        String idTerminal = cnslt.buscarValor("SELECT\n"
                + "codigo_postal.Id_CP\n"
                + "FROM\n"
                + "codigo_postal\n"
                + "WHERE\n"
                + "codigo_postal.codigo_postal = '" + codigoPostal + "';");
        return idTerminal;
    }

    public String buscarIdDireccion(String calle, String numero, String idCiudad, String idColonia, String idCodigoPostal) throws SQLException {
        String idDireccion = cnslt.buscarValor("SELECT\n"
                + "direccion.Id_direccion\n"
                + "FROM\n"
                + "direccion\n"
                + "WHERE\n"
                + "direccion.nombre_calle = '" + calle + "' AND\n"
                + "direccion.numero = " + numero + " AND\n"
                + "direccion.Id_ciudad = " + idCiudad + " AND\n"
                + "direccion.Id_colonia = " + idColonia + " AND\n"
                + "direccion.Id_CP = " + idCodigoPostal + ";");
        return idDireccion;
    }

    public String buscarIdEstado(String estado) throws SQLException {
        String idTerminal = cnslt.buscarValor("SELECT\n"
                + "estado.Id_estado\n"
                + "FROM\n"
                + "estado\n"
                + "WHERE\n"
                + "estado.nombre = '" + estado + "';");
        return idTerminal;
    }

    public String obtenIdFinalEstadoo() throws SQLException {
        consulta = "SELECT MAX(Id_estado) FROM flecha_amarilla.estado;";
        //return Integer.parseInt(cnslt.buscarValor(consulta));
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdFinalAñoo() throws SQLException {
        consulta = "SELECT MAX(Id_anio) FROM flecha_amarilla.anio;";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdBuscaAñoo(String año) throws SQLException {
        consulta = "SELECT\n"
                + "anio.Id_anio\n"
                + "FROM\n"
                + "anio\n"
                + "WHERE\n"
                + "anio.anio = " + año + ";";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdBuscaMarcaa(String marca) throws SQLException {
        consulta = "SELECT\n"
                + "marca.Id_marca\n"
                + "FROM\n"
                + "marca\n"
                + "WHERE\n"
                + "marca.nombre = '" + marca + "';";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdFinalMarcaa() throws SQLException {
        consulta = "SELECT MAX(Id_marca) FROM flecha_amarilla.marca;";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdBuscaModeloo(String modelo) throws SQLException {
        consulta = "SELECT\n"
                + "modelo.Id_modelo\n"
                + "FROM\n"
                + "modelo\n"
                + "WHERE\n"
                + "modelo.nombre = '" + modelo + "';";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdFinalModeloo() throws SQLException {
        consulta = "SELECT MAX(Id_modelo) FROM flecha_amarilla.modelo;";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdFinalFechaa() throws SQLException {
        consulta = "SELECT MAX(fecha.Id_fecha) FROM flecha_amarilla.fecha;";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdBuscaMes(String mes) throws SQLException {
        consulta = "SELECT\n"
                + "mes.Id_mes\n"
                + "FROM\n"
                + "mes\n"
                + "WHERE\n"
                + "mes.mes = '" + mes + "';";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdBuscaPlacaa(String placa) throws SQLException {
        consulta = "SELECT\n"
                + "autobus.Id_autobus\n"
                + "FROM\n"
                + "autobus\n"
                + "WHERE\n"
                + "autobus.placa = '" + placa + "';";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdBuscaNunEconomicoo(String numero) throws SQLException {
        consulta = "SELECT\n"
                + "autobus.Id_autobus\n"
                + "FROM\n"
                + "autobus\n"
                + "WHERE\n"
                + "autobus.num_economico = '" + numero + "';";
        return cnslt.buscarValor(consulta);
    }

    public String obtenIdFinalAutobuss() throws SQLException {
        consulta = "SELECT MAX(Id_autobus) FROM flecha_amarilla.autobus;";
        return cnslt.buscarValor(consulta);
    }

    public String buscarIdMes(String mes) throws SQLException {
        String idConductor = cnslt.buscarValor("SELECT\n"
                + "mes.Id_mes\n"
                + "FROM\n"
                + "mes\n"
                + "WHERE\n"
                + "mes.mes = '" + mes + "';");
        return idConductor;
    }

    public String buscaAnioo(String anio) throws SQLException {
        consulta = "SELECT `Id_anio` FROM `anio` WHERE anio.anio = '" + anio + "';";
        return cnslt.buscarValor(consulta);
    }

    public String buscaFechaa(String dia, String idMes, String idAnio) throws SQLException {
        consulta = "SELECT `Id_fecha` FROM `fecha` WHERE fecha.dia = '" + dia + "' AND fecha.Id_mes = '" + idMes + "' AND fecha.Id_anio = '" + idAnio + "';";
        return cnslt.buscarValor(consulta);
    }

//Boletos********************
    public String buscarIdBoletoFecha(String id) throws SQLException {
        String idFecha = cnslt.buscarValor("SELECT boleto.Id_fecha FROM boleto WHERE boleto.Id_boleto = " + id + ";");
        return idFecha;
    }

    public String buscarIdBoletoAsiento(String id) throws SQLException {
        String idAsiento = cnslt.buscarValor("SELECT boleto.Id_asiento FROM boleto WHERE boleto.Id_boleto = " + id + ";");
        return idAsiento;
    }

    public String buscarIdBoletoRuta(String id) throws SQLException {
        String idRuta = cnslt.buscarValor("SELECT boleto.Id_ruta FROM boleto WHERE boleto.Id_boleto = " + id + ";");
        return idRuta;
    }

    public String buscarIdFechaanio(String idFecha) throws SQLException {
        String idBoleto = cnslt.buscarValor("SELECT fecha.Id_anio FROM fecha WHERE fecha.Id_fecha = " + idFecha + ";");
        return idBoleto;
    }

    public String buscarIdFechaMes(String idFecha) throws SQLException {
        String idBoleto = cnslt.buscarValor("SELECT fecha.Id_mes FROM fecha WHERE fecha.Id_fecha = " + idFecha + ";");
        return idBoleto;
    }

    public String buscarIdRutaOrigen(String idRuta) throws SQLException {
        String idBoleto = cnslt.buscarValor("SELECT ruta.Id_origen FROM ruta WHERE ruta.Id_ruta = " + idRuta + ";");
        return idBoleto;
    }
}
