/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.IClienteDAO;
import bancosoft.capa3_dominio.entidades.Cliente;
import bancosoft.capa4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estal
 */
public class ClienteDAOPostgre implements IClienteDAO {

    GestorJDBC gestorJDBC;

    public ClienteDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int ingresar(Cliente cliente) throws SQLException {

        String sentenciaSQL = "insert into cliente(dni, nombre, apellidos, direccion, edad, celular) "
                + " values(?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, cliente.getDni());
        sentencia.setString(2, cliente.getNombre());
        sentencia.setString(3, cliente.getApellido());
        sentencia.setString(4, cliente.getDireccion());
        sentencia.setInt(5, cliente.getEdad());
        sentencia.setString(6, cliente.getCelular());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Cliente cliente) throws SQLException {
        String sentenciaSQL = "update cliente set dni=?, nombre=?, apellidos=?, direccion=?, edad=?, celular=? "
                + " values(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, cliente.getDni());
        sentencia.setString(2, cliente.getNombre());
        sentencia.setString(3, cliente.getApellido());
        sentencia.setString(4, cliente.getDireccion());
        sentencia.setInt(6, cliente.getEdad());
        sentencia.setString(8, cliente.getCelular());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(Cliente cliente) throws SQLException {
        String sentenciaSQL = "delete from cliente where idcliente= ? ";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setInt(1, cliente.getClienteid());
        return sentencia.executeUpdate();
    }

    @Override
    public Cliente buscar(int clienteid) throws SQLException {
        Cliente cliente = null;
        String sentenciaSQL = "SELECT idcliente, dni, nombre, apellidos, direccion, edad, celular "
                + "FROM cliente where idcliente='" + clienteid + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            cliente = new Cliente();
            cliente.setClienteid(resultado.getInt("clienteid"));
            cliente.setDni(resultado.getString("dni"));
            cliente.setNombre(resultado.getString("nombre"));
            cliente.setApellido(resultado.getString("apellidos"));
            cliente.setDireccion(resultado.getString("direccion"));
            cliente.setEdad(resultado.getInt("edad"));
            cliente.setCelular(resultado.getString("celular"));
        }
        resultado.close();
        return cliente;
    }

    @Override
    public Cliente buscarPorDNI(String dni) throws SQLException {
        Cliente cliente = null;
        String sentenciaSQL = "SELECT idcliente, dni, nombre, apellidos, direccion, edad, celular "
                + "FROM cliente where dni='" + dni + "'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            cliente = new Cliente();
            cliente.setClienteid(resultado.getInt("idcliente"));
            cliente.setDni(resultado.getString("dni"));
            cliente.setNombre(resultado.getString("nombre"));
            cliente.setApellido(resultado.getString("apellidos"));
            cliente.setDireccion(resultado.getString("direccion"));
            cliente.setEdad(resultado.getInt("edad"));
            cliente.setCelular(resultado.getString("celular"));

        }
        resultado.close();
        return cliente;
    }

 
   
}
