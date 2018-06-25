/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.IAnalistaDAO;
import bancosoft.capa3_dominio.entidades.Analista;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author estal
 */
public class AnalistaDAOPostgre implements IAnalistaDAO {

    GestorJDBC gestorJDBC;

    public AnalistaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Analista analista) throws SQLException {
        int registros_afectados;
        String sentenciaSQL = "insert into analista(idanalista, dni, nombres) "
                + "values (?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, analista.getIdanalista());
        sentencia.setString(2, analista.getDni());
        sentencia.setString(3, analista.getNombres());
        registros_afectados = sentencia.executeUpdate();
        return registros_afectados;
    }

    @Override
    public Analista buscar(String dni) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Analista> buscarAnalistas() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
