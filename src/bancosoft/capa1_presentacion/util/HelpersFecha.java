/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa1_presentacion.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author estal
 */
public class HelpersFecha {

    public static Date addDay(Date fecha, int dias) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(fecha);
        gregorianCalendar.add(Calendar.DATE, dias);
        fecha = gregorianCalendar.getTime();
        return fecha;
    }

    public static java.sql.Date convertDate(Date fecha) {
        java.sql.Date fecha_sql = java.sql.Date.valueOf(String.format("%1$tY-%1$tm-%1$te", fecha));
        return fecha_sql;
    }
}
