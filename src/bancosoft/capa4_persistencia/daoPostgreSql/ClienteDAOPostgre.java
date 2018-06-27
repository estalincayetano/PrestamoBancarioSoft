package bancosoft.capa4_persistencia.daoPostgreSql;

import bancosoft.capa3_dominio.contactos.IClienteDAO;
import bancosoft.capa3_dominio.entidades.Analista;
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

        String sentenciaSQL = "insert into cliente(dni, nombre, apellidos, direccion, edad, celular, idanalista) "
                + " values(?, ?, ?, ?, ?, ?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(sentenciaSQL);
        sentencia.setString(1, cliente.getDni());
        sentencia.setString(2, cliente.getNombre());
        sentencia.setString(3, cliente.getApellido());
        sentencia.setString(4, cliente.getDireccion());
        sentencia.setInt(5, cliente.getEdad());
        sentencia.setString(6, cliente.getCelular());
        sentencia.setInt(7, cliente.getAnalista().getIdanalista());
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
        String sentenciaSQL = "SELECT idcliente, dni, nombre, apellidos, direccion, edad, celular, idanalista "
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
            int idanalista = resultado.getInt("idanalista");
            Analista analista= new Analista();
            analista.setIdanalista(idanalista);
            cliente.setAnalista(analista);

        }
        resultado.close();
        return cliente;
    }

    @Override
    public int contarPrestamo(String dni) throws SQLException {
        int prestamos = 0;
        String sentenciaSQL = "select count(p.idprestamo) "
                + "from prestamo as p "
                + "join cliente as c on p.idcliente=c.idcliente "
                + "where c.dni='" + dni + "' and p.estado='VIGENTE'";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        while (resultado.next()) {
            prestamos = resultado.getInt("count");
        }
        resultado.close();
        return prestamos;
    }

    @Override
    public Cliente buscarPrestamoCliente(int idprestamo) throws SQLException {
        Cliente cliente = null;
        String sentenciaSQL = "select c.dni, c.nombre, c.apellidos from cliente as c "
                + "join prestamo as p on p.idcliente=c.idcliente "
                + "where p.idprestamo= " + idprestamo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(sentenciaSQL);
        if (resultado.next()) {
            cliente = new Cliente();
            cliente.setDni(resultado.getString("dni"));
            cliente.setNombre(resultado.getString("nombre"));
            cliente.setApellido(resultado.getString("apellidos"));
        }
        resultado.close();
        return cliente;
    }

}
