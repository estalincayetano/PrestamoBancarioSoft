
package bancosoft.capa2_aplicacion;

import bancosoft.capa3_dominio.contactos.FabricaAbstractaDAO;
import bancosoft.capa3_dominio.contactos.IClienteDAO;
import bancosoft.capa3_dominio.entidades.Cliente;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.util.List;

/**
 *
 * @author estal
 */
public class GestionarClienteServicio {

    private GestorJDBC gestorJDBC;
    private IClienteDAO clienteDAO;

    public GestionarClienteServicio() {
        FabricaAbstractaDAO fabricaAbstracta = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstracta.crearGestorJDBC();
        clienteDAO = fabricaAbstracta.crearClienteDAO(gestorJDBC);
    }

    public int crearCliente(Cliente cliente) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = clienteDAO.ingresar(cliente);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int modificarCliente(Cliente cliente) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = clienteDAO.modificar(cliente);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public int eliminarCliente(Cliente cliente) throws Exception {
        gestorJDBC.abrirConexion();
        int registros_afectados = clienteDAO.eliminar(cliente);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }

    public Cliente buscarCliente(int clienteid) throws Exception {
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAO.buscar(clienteid);
        gestorJDBC.cerrarConexion();
        return cliente;
    }

    public Cliente buscarDNI(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAO.buscarPorDNI(dni);
        gestorJDBC.cerrarConexion();
        return cliente;
    }

}
