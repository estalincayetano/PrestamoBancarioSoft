package bancosoft.capa4_persistencia.daoPostgreSql;

import java.sql.DriverManager;
import bancosoft.capa4_persistencia.GestorJDBC;

public class GestorJDBCPostgre extends GestorJDBC {    

    @Override
    public void abrirConexion() throws Exception{        
        Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/SistemaBancarioBD";
        conexion = DriverManager.getConnection(url,"postgres", "12345678");   
    }
    
}
