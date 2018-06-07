/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.IPagoDAO;
import bancosoft.capa3_dominio.entidades.Pago;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.sql.SQLException;

/**
 *
 * @author estal
 */
public class PagoDaoPostgre implements IPagoDAO{

    GestorJDBC gestorJDBC;

    public PagoDaoPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int Ingresar(Pago pago) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
