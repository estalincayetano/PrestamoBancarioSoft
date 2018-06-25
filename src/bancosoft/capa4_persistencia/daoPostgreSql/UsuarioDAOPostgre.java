/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.IUsuarioDAO;
import bancosoft.capa3_dominio.entidades.Analista;
import bancosoft.capa3_dominio.entidades.Cajero;
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
        int registros_afectados;
        try {
            String sentenciaSQL = "insert into usuario(dni,nombres,usuario,password,tipo) values(?,?,?,?,?)";
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
            sentencia.setString(1, usuario.getDni());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getUser());
            sentencia.setString(4, usuario.getPassword());
            sentencia.setString(5, usuario.getTipo());
            registros_afectados = sentencia.executeUpdate();
            if (registros_afectados != 1) {
                throw new SQLException("No se pudo registrar el El usuario.\n"
                        + "Intente de nuevo o consulte con el Administrador.");
            } else {
                String id_usuario = "select max(idusuario) as id from usuario";
                ResultSet resultado = gestorJDBC.ejecutarConsulta(id_usuario);
                int id = 0;
                while (resultado.next()) {
                    id = resultado.getInt("id");
                }
                resultado.close();

                if (usuario.getTipo().equals("Analista")) {
                    Analista analista = new Analista();
                    analista.setIdanalista(id);
                    analista.setDni(usuario.getDni());
                    analista.setNombres(usuario.getNombre());
                    AnalistaDAOPostgre analistaDAOPostgre = new AnalistaDAOPostgre(gestorJDBC);
                    int reg_analista = analistaDAOPostgre.ingresar(analista);
                    if (reg_analista != 1) {
                        throw new SQLException("No se pudo registrar el el Analista.\n"
                                + "Intente de nuevo o consulte con el Administrador.");
                    } else {
                        return 1;

                    }
                } else if (usuario.getTipo().equals("Cajero(a)")) {
                    Cajero cajero = new Cajero();
                    cajero.setIdcajero(id);
                    cajero.setDni(usuario.getDni());
                    cajero.setNombres(usuario.getNombre());
                    CajeroDAOPostgre cajeroDAOPostgre = new CajeroDAOPostgre(gestorJDBC);
                    int reg_cajero = cajeroDAOPostgre.ingresar(cajero);
                    if (reg_cajero != 1) {
                        throw new SQLException("No se pudo registrar el el Cajero.\n"
                                + "Intente de nuevo o consulte con el Administrador.");
                    } else {
                        return 1;
                    }
                } else if (usuario.getTipo().equals("Administrador(a)")) {
                    Analista analista = new Analista();
                    analista.setIdanalista(id);
                    analista.setDni(usuario.getDni());
                    analista.setNombres(usuario.getNombre());
                    Cajero cajero = new Cajero();
                    cajero.setIdcajero(id);
                    cajero.setDni(usuario.getDni());
                    cajero.setNombres(usuario.getNombre());
                    AnalistaDAOPostgre analistaDAOPostgre = new AnalistaDAOPostgre(gestorJDBC);
                    int reg_analista = analistaDAOPostgre.ingresar(analista);
                    CajeroDAOPostgre cajeroDAOPostgre = new CajeroDAOPostgre(gestorJDBC);
                    int reg_cajero = cajeroDAOPostgre.ingresar(cajero);
                    if (reg_analista != 1 || reg_cajero != 1) {
                        throw new SQLException("No se pudo Completar el registro.\n"
                                + "Intente de nuevo o consulte con el Administrador.");
                    } else {

                        return 1;
                    }
                }
                return 1;
            }
        } catch (Exception e) {
            throw new SQLException("No se pudo registrar la Operacion.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }

    }

    @Override
    public int modificar(Usuario usuario) throws SQLException {
        String sentenciaSQL = "update usuario set usuario = ? "
                + " where idusuario = ?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, usuario.getUser());
        sentencia.setInt(2, usuario.getUsuarioid());
        return sentencia.executeUpdate();
    }

    @Override
    public Usuario buscarUsuario(String dni) throws SQLException {
        Usuario usuario = null;
        String sentenciaSQL = "select idusuario, nombres, usuario, password, tipo from usuario "
                + " where dni = '" + dni + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setNombre(resultado.getString("nombres"));
            usuario.setUser(resultado.getString("usuario"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setTipo(resultado.getString("tipo"));
            usuario.setUsuarioid(resultado.getInt("idusuario"));
        }
        return usuario;
    }

    @Override
    public Usuario ingresoSistema(String user, String contrasenia) throws SQLException {
        Usuario usuario = null;
        String sentenciaSQL = "select idusuario,usuario,password,nombres, tipo, dni from usuario "
                + " where usuario = '" + user + "' and password = '" + contrasenia + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            usuario = new Usuario();
            usuario.setUsuarioid(resultado.getInt("idusuario"));
            usuario.setUser(resultado.getString("usuario"));
            usuario.setPassword(resultado.getString("password"));
            usuario.setNombre(resultado.getString("nombres"));
            usuario.setTipo(resultado.getString("tipo"));
            usuario.setDni(resultado.getString("dni"));
        }
        return usuario;
    }

}
