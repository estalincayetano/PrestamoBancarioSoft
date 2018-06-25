package bancosoft.capa3_dominio.contactos;

import bancosoft.capa4_persistencia.GestorJDBC;
import bancosoft.capa5_infraestructura.parametros.LectorDeParametros;

public abstract class FabricaAbstractaDAO {

    public static FabricaAbstractaDAO getInstancia() {
        String nombreClaseFabricaDAO;
        FabricaAbstractaDAO FabricaDAO;
        try {
            LectorDeParametros lectorDeParametros = new LectorDeParametros();
            nombreClaseFabricaDAO = lectorDeParametros.getValorParametro("claseFabricaDAO");
            FabricaDAO = (FabricaAbstractaDAO) Class.forName(nombreClaseFabricaDAO).newInstance();
            return FabricaDAO;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public abstract GestorJDBC crearGestorJDBC();

    public abstract IClienteDAO crearClienteDAO(GestorJDBC gestorJDBC);

    public abstract IPrestamoDAO crearPrestamoDAO(GestorJDBC gestorJDBC);

    public abstract ICuotaDAO crearCuotaDAO(GestorJDBC gestorJDBC);

    public abstract IPagoDAO crearPagoDAO(GestorJDBC gestorJDBC);

    public abstract IUsuarioDAO crearUsuarioDAO(GestorJDBC gestorJDBC);

    public abstract IAnalistaDAO crearAnalistaDAO(GestorJDBC gestorJDBC);

    public abstract ICajeroDAO crearCajeroDAO(GestorJDBC gestorJDBC);
}
