/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.contactos;

import bancosoft.capa3_dominio.entidades.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author estal
 */
public interface IClienteDAO {

    public int ingresar(Cliente cliente) throws SQLException;

    public int modificar(Cliente cliente) throws SQLException;

    public int eliminar(Cliente cliente) throws SQLException;

    public Cliente buscar(int clienteid) throws SQLException;

    public Cliente buscarPorDNI(String dni) throws SQLException;

    public int contarPrestamo(String dni) throws SQLException;

}
