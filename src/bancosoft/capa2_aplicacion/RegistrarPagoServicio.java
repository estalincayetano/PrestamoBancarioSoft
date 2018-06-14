/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa2_aplicacion;

import bancosoft.capa3_dominio.contactos.FabricaAbstractaDAO;
import bancosoft.capa3_dominio.contactos.IPagoDAO;
import bancosoft.capa3_dominio.contactos.ICuotaDAO;
import bancosoft.capa3_dominio.contactos.IPrestamoDAO;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Pago;
import bancosoft.capa3_dominio.entidades.Prestamo;
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
    private IPrestamoDAO prestamoDAO;

    public RegistrarPagoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        pagoDAO = fabricaAbstractaDAO.crearPagoDAO(gestorJDBC);
        cuotaDAO = fabricaAbstractaDAO.crearCuotaDAO(gestorJDBC);
        prestamoDAO = fabricaAbstractaDAO.crearPrestamoDAO(gestorJDBC);
    }

    public List<Prestamo> buscarPrestamos(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        List<Prestamo> prestamos = prestamoDAO.buscarPrestamoCliente(dni);
        gestorJDBC.cerrarConexion();
        return prestamos;
    }

    public List<Cuota> buscarCuotas(int id, String estado) throws Exception {
        gestorJDBC.abrirConexion();
        List<Cuota> cuota = cuotaDAO.buscar(id, estado);
        gestorJDBC.cerrarConexion();
        return cuota;
    }


    public int registrarPago(Pago pago) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            gestorJDBC.iniciarTransaccion();
            int registros_afectados = pagoDAO.Ingresar(pago);
            gestorJDBC.terminarTransaccion();
            return registros_afectados;
        } catch (Exception e) {
            gestorJDBC.cancelarTransaccion();
            throw e;
        }
    }
}
