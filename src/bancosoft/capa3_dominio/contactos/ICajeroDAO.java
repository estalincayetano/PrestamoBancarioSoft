/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.contactos;

import bancosoft.capa3_dominio.entidades.Cajero;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author estal
 */
public interface ICajeroDAO {

    public int ingresar(Cajero cajero) throws SQLException;

    public Cajero buscar(String dni) throws SQLException;

    public List<Cajero> buscarCajeros() throws SQLException;
}
