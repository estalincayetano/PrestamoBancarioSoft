package bancosoft.capa2_aplicacion;

import bancosoft.capa3_dominio.contactos.FabricaAbstractaDAO;
import bancosoft.capa3_dominio.contactos.IClienteDAO;
import bancosoft.capa3_dominio.contactos.ICuotaDAO;
import bancosoft.capa3_dominio.contactos.IPrestamoDAO;
import bancosoft.capa3_dominio.entidades.Cliente;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Prestamo;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.util.List;

/**
 *
 * @author estal
 */
public class RegistrarPrestamoServicio {

    private GestorJDBC gestorJDBC;
    private IPrestamoDAO prestamoDAO;
    private IClienteDAO clienteDAO;
    private ICuotaDAO cuotaDAO;

    public RegistrarPrestamoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        prestamoDAO = fabricaAbstractaDAO.crearPrestamoDAO(gestorJDBC);
        clienteDAO = fabricaAbstractaDAO.crearClienteDAO(gestorJDBC);
        cuotaDAO = fabricaAbstractaDAO.crearCuotaDAO(gestorJDBC);
    }

    public int crearPrestamo(Prestamo prestamo) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            int registros_afectados = prestamoDAO.ingresar(prestamo);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }

    }

    public List<Prestamo> buscarPrestamos(String estado, int idanalista) throws Exception {
        gestorJDBC.abrirConexion();
        List<Prestamo> prestamos = prestamoDAO.buscarPorEstado(estado, idanalista);
        gestorJDBC.cerrarConexion();
        return prestamos;
    }

    public List<Cuota> buscarCuotas(int idprestamo) throws Exception {
        gestorJDBC.abrirConexion();
        List<Cuota> cuotas = cuotaDAO.listCuotas(idprestamo);
        gestorJDBC.cerrarConexion();
        return cuotas;
    }

    public Cliente buscarCliente(int idprestamo) throws Exception {
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAO.buscarPrestamoCliente(idprestamo);
        gestorJDBC.cerrarConexion();
        return cliente;
    }

    public int numeroDePrestamos(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        int prestamos = clienteDAO.contarPrestamo(dni);
        gestorJDBC.cerrarConexion();
        return prestamos;
    }
}
