/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.contactos;

import bancosoft.capa3_dominio.entidades.Analista;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author estal
 */
public interface IAnalistaDAO {

    public int ingresar(Analista analista) throws SQLException;

    public Analista buscar(String dni) throws SQLException;

    public List<Analista> buscarAnalistas() throws SQLException;
}
