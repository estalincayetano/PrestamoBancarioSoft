/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.entidades;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estal
 */
public class PagoTest {
    
    public PagoTest() {
    }
    
   
    /**
     * Test of ValidarFechaPago method, of class Pago.
     */
    @Test
    public void testValidarFechaPago() {
        System.out.println("ValidarFechaPago");
        Cuota cuota= new Cuota();
        cuota.setFechaPago(new java.sql.Date(2018-06-25));
        Pago instance = new Pago();
        instance.setCuota(cuota);
        instance.setFecha(new java.sql.Date(2018-04-25));
        Boolean expResult = true;
        Boolean result = instance.ValidarFechaPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
    public void testValidarFechaPago1() {
        System.out.println("ValidarFechaPago");
        Cuota cuota= new Cuota();
        cuota.setFechaPago(new java.sql.Date(2018-06-23));
        Pago instance = new Pago();
        instance.setCuota(cuota);
        instance.setFecha(new java.sql.Date(2018-06-29));
        Boolean expResult = false;
        Boolean result = instance.ValidarFechaPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularMora method, of class Pago.
     */
 @Test
    public void testCalcularMora() {
        System.out.println("calcularMora");
        Cuota cuota= new Cuota();
        cuota.setMontoCuota(300);
        cuota.setFechaPago(new java.sql.Date(2018-06-30));
        Pago instance = new Pago();
        instance.setCuota(cuota);
        instance.setFecha(new java.sql.Date(2018-07-01));
        double expResult = 9;
        double result = instance.calcularMora();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of pagoTotal method, of class Pago.
     */
 @Test
    public void testPagoTotal() {
        System.out.println("pagoTotal");
         Cuota cuota= new Cuota();
        cuota.setMontoCuota(300);
        cuota.setFechaPago(new java.sql.Date(2018-06-30));
        Pago instance = new Pago();
        instance.setCuota(cuota);
        instance.setFecha(new java.sql.Date(2018-07-01));
        double expResult = 309.0;
        double result = instance.pagoTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

}
