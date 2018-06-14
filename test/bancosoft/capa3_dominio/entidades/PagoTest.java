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
        Pago instance = new Pago();
        Boolean expResult = null;
        Boolean result = instance.ValidarFechaPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularMora method, of class Pago.
     */
    @Test
    public void testCalcularMora() {
        System.out.println("calcularMora");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.calcularMora();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pagoTotal method, of class Pago.
     */
    @Test
    public void testPagoTotal() {
        System.out.println("pago");
        Pago instance = new Pago();
        double expResult = 0.0;
        double result = instance.pagoTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
