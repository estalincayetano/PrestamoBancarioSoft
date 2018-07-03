/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.entidades;

import java.sql.Date;
import java.util.List;
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
public class PrestamoTest {
    
    public PrestamoTest() {
    }
    
  
    /**
     * Test of calcularTazaDiaria method, of class Prestamo.
     */
  @Test
    public void testCalcularTazaDiaria() {
        System.out.println("calcularTazaDiaria");
        Prestamo instance = new Prestamo();
        instance.setInteres(11.99);
        double expResult = 0.0315;
        double result = instance.calcularTazaDiaria();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularTazaMensual method, of class Prestamo.
     */
 @Test
    public void testCalcularTazaMensual() {
        System.out.println("calcularTazaMensual");
        Prestamo instance = new Prestamo();
        instance.setInteres(11.99);
        double expResult = 0.9493;
        double result = instance.calcularTazaMensual();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularInteresMensual method, of class Prestamo.
     */
 @Test
    public void testCalcularInteresMensual() {
        System.out.println("calcularInteresMensual");
        Prestamo instance = new Prestamo();
        instance.setMonto(30000);
        instance.setInteres(11.99);
        double expResult = 294.79;
        double result = instance.calcularInteresMensual();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularDesgraven method, of class Prestamo.
     */
  @Test
    public void testCalcularDesgraven() {
        System.out.println("calcularDesgraven");
        Prestamo instance = new Prestamo();
        instance.setMonto(3000);
        double expResult = 2.25;
        double result = instance.calcularDesgraven();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
 @Test
    public void testCalcularDesgraven1() {
        System.out.println("calcularDesgraven");
        Prestamo instance = new Prestamo();
        instance.setMonto(1499);
        double expResult = 0.0;
        double result = instance.calcularDesgraven();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularCapital method, of class Prestamo.
     */
    @Test
    public void testCalcularCapital() {
        System.out.println("calcularCapital");
        Prestamo instance = new Prestamo();
        instance.setMonto(30000);
        instance.setNumeroCuotas(12);
        double expResult = 2500;
        double result = instance.calcularCapital();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularImporteCuotaReferencial method, of class Prestamo.
     */
 @Test
    public void testCalcularImporteCuotaReferencial() {
        System.out.println("calcularImporteCuotaReferencial");
        Prestamo instance = new Prestamo();
        instance.setMonto(30000);
        instance.setInteres(11.99);
        instance.setNumeroCuotas(24);
        double expResult = 1544.79;
        double result = instance.calcularImporteCuotaReferencial();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calcularImporteDeCuota method, of class Prestamo.
     */
    @Test
    public void testCalcularImporteDeCuota() {
        System.out.println("calcularImporteDeCuota");
        Prestamo instance = new Prestamo();
        instance.setMonto(30000);
        instance.setNumeroCuotas(24);
        instance.setInteres(11.99);
        double expResult = 1567.29;
        double result = instance.calcularImporteDeCuota();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
