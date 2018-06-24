/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.IUsuarioDAO;
import bancosoft.capa3_dominio.entidades.Usuario;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author estal
 */
public class UsuarioDAOPostgre implements IUsuarioDAO {

    GestorJDBC gestorJDBC;

    public UsuarioDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Usuario usuario) throws SQLException {
        String sentenciaSQL = "insert into usuario(dni,nombre,password,tipo)values(?,?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, usuario.getDni());
        sentencia.setString(2, usuario.getNombre());
        sentencia.setString(3, usuario.getPassword());
        sentencia.setString(4, usuario.getTipo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Usuario usuario) throws SQLException {
        String sentenciaSQL = "update usuario set tipo = ? "
                + " where idusuario = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, usuario.getTipo());
        sentencia.setInt(2, usuario.getUsuarioid());
        return sentencia.executeUpdate();
    }

    @Override
    public Usuario buscarUsuario(String dni) throws SQLException {
        Usuario usuario = null;
        String sentenciaSQL = "select idusuario, nombre, password, tipo from usuario "
                + " where dni = '" +dni+"'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setNombre(resultado.getString("nombre"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setTipo(resultado.getString("tipo"));
            usuario.setUsuarioid(resultado.getInt("idusuario"));
        }
        return usuario;
    }

    @Override
    public Usuario ingresoSistema(String nombre, String contrasenia) throws SQLException {
        Usuario usuario = null;
        String sentenciaSQL = "select nombre,password,tipo from usuario "
                + " where nombre = '" + nombre + "' and password = '" + contrasenia + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setNombre(resultado.getString("nombre"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setTipo(resultado.getString("tipo"));
        }
        return usuario;
    }

}
