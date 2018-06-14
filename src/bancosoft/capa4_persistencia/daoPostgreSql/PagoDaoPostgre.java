/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.IPagoDAO;
import bancosoft.capa3_dominio.entidades.Pago;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author estal
 */
public class PagoDaoPostgre implements IPagoDAO {

    GestorJDBC gestorJDBC;

    public PagoDaoPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int Ingresar(Pago pago) throws SQLException {
        int registros_afectados;
        try {
            /*insert into pagoTotal(fecha, idcuota, monto)
             values( ?, ?, ?);*/
            String sentenciaSQL_pago = "insert into pago(fecha, idcuota, monto) values( ?, ?, ?)";
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL_pago);
            sentencia.setDate(1, pago.getFecha());
            sentencia.setInt(2, pago.getCuota().getCuotaid());
            sentencia.setDouble(3, pago.pagoTotal());
            registros_afectados = sentencia.executeUpdate();
            if (registros_afectados == 1) {
                CuotaDAOPostgre cuotaDAOPostgre = new CuotaDAOPostgre(gestorJDBC);
                cuotaDAOPostgre.modificar(pago.getCuota());
            }
            return 1;
        } catch (Exception e) {
            throw new SQLException("No se pudo registrar el pago.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
    }

}
