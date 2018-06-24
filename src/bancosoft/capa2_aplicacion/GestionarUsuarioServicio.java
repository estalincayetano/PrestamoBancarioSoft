
package bancosoft.capa2_aplicacion;

import bancosoft.capa3_dominio.contactos.FabricaAbstractaDAO;
import bancosoft.capa3_dominio.contactos.IUsuarioDAO;
import bancosoft.capa3_dominio.entidades.Usuario;
import bancosoft.capa4_persistencia.GestorJDBC;

/**
 *
 * @author estal
 */
public class GestionarUsuarioServicio {
 private GestorJDBC gestorJDBC;
    private IUsuarioDAO usuarioDAO;
    public GestionarUsuarioServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        usuarioDAO = fabricaAbstractaDAO.crearUsuarioDAO(gestorJDBC);
    }
   
    public int crearUsuario(Usuario usuario) throws Exception{
        gestorJDBC.abrirConexion();
        int registros_afectados = usuarioDAO.ingresar(usuario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
    
    public int modificarUsuario(Usuario usuario) throws Exception{
        gestorJDBC.abrirConexion();
        int registros_afectados = usuarioDAO.modificar(usuario);
        gestorJDBC.cerrarConexion();
        return registros_afectados;
    }
    
    public Usuario buscarUsuario(String dni) throws Exception{
        gestorJDBC.abrirConexion();
        Usuario usuario = usuarioDAO.buscarUsuario(dni);
        gestorJDBC.cerrarConexion();
        return usuario;
    }
    
    public Usuario buscaIngresoSistema(String nombre, String contrasenia) throws Exception{
        gestorJDBC.abrirConexion();
        Usuario usuario = usuarioDAO.ingresoSistema(nombre,contrasenia);
        gestorJDBC.cerrarConexion();
        return usuario;
    }   
}
