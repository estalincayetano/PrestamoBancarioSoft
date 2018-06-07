/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public List<Cuota> buscar(String dni, int idprestamo, String estado) throws SQLException {
        List<Cuota> cuotas = new ArrayList<>();
        Cuota cuota;
        /*select cu.* from cliente as c
         join prestamo as p on c.idcliente = p.idcliente
         join cuota as cu on cu.idprestamo = p.idprestamo
         WHERE cu.estado = 'PENDIENTE' AND c.dni = '70804619' and p.idprestamo=10'*/
        String sentenciaSQL = "select cu.capital, cu.interes, cu.seguro, cu.montocuota, cu.fechapago, cu.estado"
                + "from cliente as c"
                + "join prestamo as p on c.idcliente = p.idcliente"
                + "join cuota as cu on cu.idprestamo = p.idprestamo"
                + "where cu.estado = '"+estado+"' AND c.dni = '"+dni+"' and p.idprestamo="+idprestamo+"";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            cuota = new Cuota();
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

}
