/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.contactos;

import bancosoft.capa3_dominio.entidades.Usuario;
import java.sql.SQLException;

/**
 *
 * @author estal
 */
public interface IUsuarioDAO {

    public int ingresar(Usuario usuario) throws SQLException;

    public int modificar(Usuario usuario) throws SQLException;

    public Usuario buscarUsuario(String dni) throws SQLException;

    public Usuario buscarUser(String user) throws SQLException;

    public Usuario ingresoSistema(String user, String contrasenia) throws SQLException;
}
