/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.ICajeroDAO;
import bancosoft.capa3_dominio.entidades.Cajero;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author estal
 */
public class CajeroDAOPostgre implements ICajeroDAO {

    GestorJDBC gestorJDBC;

    public CajeroDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Cajero cajero) throws SQLException {
        int registros_afectados;
        String sentenciaSQL = "insert into cajero (idcajero,dni,nombres) values(?,?,?)";
        PreparedStatement sentecia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentecia.setInt(1, cajero.getIdcajero());
        sentecia.setString(2, cajero.getDni());
        sentecia.setString(3, cajero.getNombres());
        registros_afectados = sentecia.executeUpdate();
        return registros_afectados;
    }

    @Override
    public Cajero buscar(String dni) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cajero> buscarCajeros() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
