/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa2_aplicacion;

import bancosoft.capa3_dominio.contactos.FabricaAbstractaDAO;
import bancosoft.capa3_dominio.contactos.IPagoDAO;
import bancosoft.capa3_dominio.contactos.ICuotaDAO;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Pago;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.util.List;

/**
 *
 * @author estal
 */
public class RegistrarPagoServicio {

    private GestorJDBC gestorJDBC;
    private IPagoDAO pagoDAO;
    private ICuotaDAO cuotaDAO;

    public RegistrarPagoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        pagoDAO = fabricaAbstractaDAO.crearPagoDAO(gestorJDBC);
        cuotaDAO = fabricaAbstractaDAO.crearCuotaDAO(gestorJDBC);
    }

    public List<Cuota> buscarCuotas(String dni, int id, String estado) throws Exception {
        gestorJDBC.abrirConexion();
        List<Cuota> cuota = cuotaDAO.buscar(dni, id, estado);
        gestorJDBC.cerrarConexion();
        return cuota;
    }
}
