/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa5_infraestructura.parametros;

//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Lain
 */
public class LectorDeParametros {
    
    public String getValorParametro(String parametro){
        String valorParametro;
        InputStream canalDeEntrada;
        Properties propiedades = new Properties();
        try {
            canalDeEntrada = Thread.currentThread().getContextClassLoader().getResourceAsStream("bancosoft/capa5_infraestructura/parametros/Parametros.properties");
            propiedades.load(canalDeEntrada);            
            valorParametro = propiedades.getProperty(parametro);
            return valorParametro;
        } catch (IOException e) {
            return null;
        }
    }
    
}
