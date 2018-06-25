/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.contactos;

import bancosoft.capa3_dominio.entidades.Prestamo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author estal
 */
public interface IPrestamoDAO {

    public int ingresar(Prestamo prestamo) throws SQLException;

    public List<Prestamo> buscarPorEstado(String estado, int idanalista) throws SQLException;

     public int modificar(int idprestamo) throws SQLException;

    public List<Prestamo> buscarPrestamoCliente(String dni) throws SQLException;
}
