package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.ICuotaDAO;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Prestamo;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estal
 */
public class CuotaDAOPostgre implements ICuotaDAO {

    GestorJDBC gestorJDBC;

    public CuotaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public List<Cuota> buscar(int idprestamo, String estado) throws SQLException {
        List<Cuota> cuotas = new ArrayList<>();
        Cuota cuota;
        String sentenciaSQL = "select cu.idcuota, cu.capital, cu.interes, cu.seguro, cu.montocuota, cu.fechapago, cu.estado "
                + "from cliente as c "
                + "join prestamo as p on c.idcliente = p.idcliente "
                + "join cuota as cu on cu.idprestamo = p.idprestamo "
                + "where cu.estado = '" + estado + "' and p.idprestamo= " + idprestamo + " order by idcuota";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            cuota = new Cuota();
            cuota.setCuotaid(resultado.getInt("idcuota"));
            cuota.setCapital_cuota(resultado.getDouble("capital"));
            cuota.setInteres_cuota(resultado.getDouble("interes"));
            cuota.setSeguro(resultado.getDouble("seguro"));
            cuota.setMontoCuota(resultado.getDouble("montocuota"));
            cuota.setFechaPago(resultado.getDate("fechapago"));
            cuota.setEstado(resultado.getString("estado"));
            cuotas.add(cuota);
        }
        resultado.close();
        return cuotas;
    }

    @Override
    public int modificar(Cuota cuota) throws SQLException {
        String sentenciaSQL = "update cuota set estado = ? where idcuota = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, "CANCELADA");
        sentencia.setInt(2, cuota.getCuotaid());
        return sentencia.executeUpdate();
    }

    @Override
    public int cuotaMax(int idprestamo) throws SQLException {
        String sentencia_ultima_cuota = "select max(c.idcuota) as maxi from cuota as c "
                + "join prestamo as p on c.idprestamo=p.idprestamo "
                + "where p.idprestamo=" + idprestamo;
        ResultSet resultado_ultimo = gestorJDBC.ejecutarConsulta(sentencia_ultima_cuota);

        int cuotaid_ultimo = 0;
        while (resultado_ultimo.next()) {
            cuotaid_ultimo = resultado_ultimo.getInt("maxi");
        }
        resultado_ultimo.close();
        return cuotaid_ultimo;
    }

    @Override
    public List<Cuota> listCuotas(int idprestamo) throws SQLException {
        List<Cuota> cuotas = new ArrayList<>();
        Cuota cuota;
        String sentenciaSQL = "select c.idcuota, c.montocuota, c.fechapago, c.estado from cuota as c "
                + "where idprestamo= " + idprestamo+" order by idcuota";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            cuota = new Cuota();
            cuota.setCuotaid(resultado.getInt("idcuota"));
            cuota.setMontoCuota(resultado.getDouble("montocuota"));
            cuota.setFechaPago(resultado.getDate("fechapago"));
            cuota.setEstado(resultado.getString("estado"));
            cuotas.add(cuota);
        }
        resultado.close();

        return cuotas;
    }

}
