
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa1_presentacion.util.HelpersFecha;
import bancosoft.capa3_dominio.contactos.IPrestamoDAO;
import bancosoft.capa3_dominio.entidades.Cliente;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Prestamo;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author estal
 */
public class PrestamoDAOPostgre implements IPrestamoDAO {

    GestorJDBC gestorJDBC;

    public PrestamoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Prestamo prestamo) throws SQLException {
        int registros_afectados;
        try {
            String sentenciaSQL = "insert into prestamo (idcliente, monto, interes, numerocuotas, fechainicio, estado, nota)"
                    + "values ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sentecia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentecia.setInt(1, prestamo.getCliente().getClienteid());
            sentecia.setDouble(2, prestamo.getMonto());
            sentecia.setDouble(3, prestamo.getInteres());
            sentecia.setInt(4, prestamo.getNumeroCuotas());
            sentecia.setDate(5, prestamo.getFechaInicio());
            sentecia.setString(6, prestamo.getEstado());
            sentecia.setString(7, prestamo.getNota());
            registros_afectados = sentecia.executeUpdate();
            if (registros_afectados != 1) {
                throw new SQLException("No se pudo registrar el Prestamo.\n"
                        + "Intente de nuevo o consulte con el Administrador.");
            }
            String sentenciaSQL_ultimoregistro = "select max(idprestamo)as id from prestamo";
            ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL_ultimoregistro);

            int prestamoid = 0;
            while (resultado.next()) {
                prestamoid = resultado.getInt("id");
            }
            resultado.close();

            String sentenciaSQL_Cuotas = "insert into cuota( idprestamo, interes, capital, montocuota, fechapago, estado, seguro)"
                    + "values ( ?, ?, ?, ?, ?, ?, ?)";
            for (Cuota cuota : prestamo.getListCuotas()) {
                PreparedStatement sentencia_Cuota = gestorJDBC.prepararSentencia(sentenciaSQL_Cuotas);
                sentencia_Cuota.setInt(1, prestamoid);
                sentencia_Cuota.setDouble(2, cuota.getInteres_cuota());
                sentencia_Cuota.setDouble(3, cuota.getCapital_cuota());
                sentencia_Cuota.setDouble(4, cuota.getMontoCuota());
                sentencia_Cuota.setDate(5, HelpersFecha.convertDate(cuota.getFechaPago()));
                sentencia_Cuota.setString(6, "PENDIENTE");
                sentencia_Cuota.setDouble(7, cuota.getSeguro());
                sentencia_Cuota.executeUpdate();
            }
            return 1;
        } catch (Exception e) {
            throw new SQLException("No se pudo registrar el Prestamo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }

    }

    @Override
    public List<Prestamo> buscarPorEstado(String estado) throws SQLException {
        List<Prestamo> prestamos = new ArrayList<>();
        Prestamo prestamo;
        String sentenciaSQL = "select idprestamo,monto, interes, numerocuotas, fechainicio, estado "
                + " from prestamo where estado like '%" + estado + "%'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            prestamo = new Prestamo();
            prestamo.setPrestamoid(resultado.getInt("idprestamo"));
            prestamo.setMonto(resultado.getDouble("monto"));
            prestamo.setInteres(resultado.getDouble("interes"));
            prestamo.setNumeroCuotas(resultado.getInt("numerocuotas"));
            prestamo.setFechaInicio(resultado.getDate("fechainicio"));
            prestamo.setEstado(resultado.getString("estado"));
            prestamos.add(prestamo);
        }
        resultado.close();
        return prestamos;
    }

    @Override
    public List<Prestamo> buscarPrestamoCliente(String dni) throws SQLException {
        List<Prestamo> prestamos = new ArrayList<>();
        Prestamo prestamo;
        String sentenciaSQL = "select p.idprestamo, p.numerocuotas, p.interes, p.fechainicio, P.monto "
                + " from prestamo as p "
                + "join cliente as c on p.idcliente=c.idcliente "
                + "where dni='" + dni + "' and estado='VIGENTE' ";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            prestamo = new Prestamo();
            prestamo.setPrestamoid(resultado.getInt("idprestamo"));
            prestamo.setNumeroCuotas(resultado.getInt("numerocuotas"));
            prestamo.setInteres(resultado.getDouble("interes"));
            prestamo.setFechaInicio(resultado.getDate("fechainicio"));
            prestamo.setMonto(resultado.getDouble("monto"));
            prestamos.add(prestamo);
        }
        resultado.close();
        return prestamos;
    }

    @Override
    public int modificar(int idprestamo) throws SQLException {
        /*update prestamo set estado='CANCELADO'
         where idprestamo=49*/
        int registros_afectados;
        String sentenciaSQL = "update prestamo set estado = ? where idprestamo = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, "CANCELADO");
        sentencia.setInt(2, idprestamo);
        registros_afectados=sentencia.executeUpdate();
        return registros_afectados;
    }

}
