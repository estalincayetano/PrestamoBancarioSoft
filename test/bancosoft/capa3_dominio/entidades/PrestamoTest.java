/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.entidades;

import java.util.Date;
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
        instance.setInteres(10);
        double expResult = 0.026478555537545745;
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
        instance.setInteres(10);
        double expResult =0.7974140622760251 ;
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
        instance.setMonto(1000);
        instance.setInteres(10);
        double expResult = 17.974140622760252;
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
        instance.setMonto(20000);
        double expResult = 15;
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
        instance.setMonto(20000);
        instance.setNumeroCuotas(24);
        double expResult = 833.33333333333334;
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
        instance.setMonto(1000);
        instance.setInteres(10);
        instance.setNumeroCuotas(12);
        double expResult = 101.30747395609359;
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
        instance.setMonto(1000);
        instance.setNumeroCuotas(12);
        instance.setInteres(10);
        double expResult = 102.05747395609359;
        double result = instance.calcularImporteDeCuota();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getFechaInicio method, of class Prestamo.
     */

}
