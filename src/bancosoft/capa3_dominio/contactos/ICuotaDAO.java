/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.contactos;

import bancosoft.capa3_dominio.entidades.Cuota;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author estal
 */
public interface ICuotaDAO {

    public List<Cuota> buscar(String dni, int idprestamo, String estado) throws SQLException;
}
