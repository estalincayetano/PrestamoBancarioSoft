
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.FabricaAbstractaDAO;
import bancosoft.capa3_dominio.contactos.IClienteDAO;
import bancosoft.capa3_dominio.contactos.ICuotaDAO;
import bancosoft.capa3_dominio.contactos.IPagoDAO;
import bancosoft.capa3_dominio.contactos.IPrestamoDAO;
import bancosoft.capa3_dominio.contactos.IUsuarioDAO;
import bancosoft.capa4_persistencia.GestorJDBC;

/**
 *
 * @author estal
 */
public class FabricaDAOPostgre extends FabricaAbstractaDAO {

    @Override
    public GestorJDBC crearGestorJDBC() {
        return new GestorJDBCPostgre();
    }

    @Override
    public IClienteDAO crearClienteDAO(GestorJDBC gestorJDBC) {
        return new ClienteDAOPostgre(gestorJDBC);
    }

    @Override
    public IPrestamoDAO crearPrestamoDAO(GestorJDBC gestorJDBC) {
        return new PrestamoDAOPostgre(gestorJDBC);
    }

    @Override
    public ICuotaDAO crearCuotaDAO(GestorJDBC gestorJDBC) {
        return new CuotaDAOPostgre(gestorJDBC);
    }

    @Override
    public IPagoDAO crearPagoDAO(GestorJDBC gestorJDBC) {
        return new PagoDaoPostgre(gestorJDBC);
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC) {
       return new UsuarioDAOPostgre(gestorJDBC);
    }

}
