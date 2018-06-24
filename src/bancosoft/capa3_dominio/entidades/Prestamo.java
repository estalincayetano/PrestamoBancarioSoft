
package bancosoft.capa3_dominio.entidades;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.text.DecimalFormat;

/**
 *
 * @author estal
 */
public class Prestamo {

    private Cliente cliente;
    private int prestamoid;
    private double monto;
    private double interes;
    private int numeroCuotas;
    private Date fechaInicio;
    private String estado;
    private String nota;
    private List<Cuota> listCuotas;

    public static final int LONGITUD_MONTO = 6;
    public static final int LONGITUD_INTERES = 5;
    public static final int LONGITUD_CUOTA = 2;

    public Prestamo() {
        fechaInicio = Date.valueOf(String.format("%1$tY-%1$tm-%1$te", new java.util.Date()));
        estado = "VIGENTE";
        listCuotas = new ArrayList<Cuota>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Cuota> getListCuotas() {
        return listCuotas;
    }

    public void setListCuotas(List<Cuota> listCuotas) {
        this.listCuotas = listCuotas;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getPrestamoid() {
        return prestamoid;
    }

    public void setPrestamoid(int prestamoid) {
        this.prestamoid = prestamoid;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
        return fechaInicio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }


    /*Implementacion de metodos para calcular el capital de la cuota, el interes de la cuota,
     el importe de cuota, el seguro de desgraven  
    
     */
    /*Metodo para validar datos de entrada*/
    public boolean validarMonto() {
        if (monto >= 1000) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarInteres() {
        if (interes >= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarCuotas() {
        if (numeroCuotas >= 6) {
            return true;
        } else {
            return false;
        }
    }
    /*Elimiar porcentaje*/
    /*METODO PARA AGREGAR LAS CUOTAS DEL PRESTAMO*/

    public void agregarCuota(Cuota cuota) {
        listCuotas.add(cuota);
    }
    /*Metodo para calcular la taza de interes diaria de la cuota*/

    public double calcularTazaDiaria() {
        double inte = interes / 100;
        float diasf = 1 / 360f;
        return (Math.pow((1 + inte), diasf) - 1) * 100;

    }
    /*Metodo para calcular la taza de interes mensuales que se aplicara a cada cuota*/

    public double calcularTazaMensual() {
        return (Math.pow((1 + (calcularTazaDiaria() / 100)), 30) - 1) * 100;
    }
    /*Metodo para calcular el interes mensual de la cuota del prestamo*/

    public double calcularInteresMensual() {
        double interesCuota = 0.0;
        interesCuota = monto * ((calcularTazaMensual() / 100)) + 10;
        return interesCuota;
    }
    /*Metodo para calcular el seguro de desgraven*/

    public double calcularDesgraven() {
        return monto * ((0.00075) * 1);
    }


    /*Metodo para calcular el Capital del importe de la cuota mensual en este 
     caso la regla de negocio dice cuota fija*/
    public double calcularCapital() {
        return monto / numeroCuotas;
    }
    /*Metodo para calcular el importe Referencial mensual de cada cuota*/

    public double calcularImporteCuotaReferencial() {
        return calcularCapital() + calcularInteresMensual();
    }
    /*Metodo para calcular el importe Neto de cada cuota Mensual*/

    public double calcularImporteDeCuota() {
        return calcularImporteCuotaReferencial() + calcularDesgraven();
    }

}
