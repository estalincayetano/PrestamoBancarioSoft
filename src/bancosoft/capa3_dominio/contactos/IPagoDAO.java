/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.contactos;

import bancosoft.capa3_dominio.entidades.Pago;
import java.sql.SQLException;

/**
 *
 * @author estal
 */
public interface IPagoDAO {
      public int Ingresar(Pago pago) throws SQLException;
}
