/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa2_aplicacion;

import bancosoft.capa3_dominio.contactos.FabricaAbstractaDAO;
import bancosoft.capa3_dominio.contactos.IPrestamoDAO;
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

    public RegistrarPrestamoServicio() {
        FabricaAbstractaDAO fabricaAbstractaDAO = FabricaAbstractaDAO.getInstancia();
        gestorJDBC = fabricaAbstractaDAO.crearGestorJDBC();
        prestamoDAO = fabricaAbstractaDAO.crearPrestamoDAO(gestorJDBC);

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

    public List<Prestamo> buscarProductos(String estado) throws Exception {
        gestorJDBC.abrirConexion();
        List<Prestamo> productos = prestamoDAO.buscarPorEstado(estado);
        gestorJDBC.cerrarConexion();
        return productos;
    }
}
