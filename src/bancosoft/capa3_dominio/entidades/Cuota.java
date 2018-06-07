/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.entidades;

import java.util.Date;

/**
 *
 * @author estal
 */
public class Cuota {

    private int cuotaid;
    private double capital_cuota;
    private double interes_cuota;
    private double montoCuota;
    private Date fechaPago;
    private String estado;
    private double seguro;
    

    public double getSeguro() {
        return seguro;
    }

    public void setSeguro(double seguro) {
        this.seguro = seguro;
    }
    

    public Cuota() {
        estado = "PENDIENTE";
    }

    public int getCuotaid() {
        return cuotaid;
    }

    public void setCuotaid(int cuotaid) {
        this.cuotaid = cuotaid;
    }

    public double getCapital_cuota() {
        return capital_cuota;
    }

    public void setCapital_cuota(double capital_cuota) {
        this.capital_cuota = capital_cuota;
    }

    public double getInteres_cuota() {
        return interes_cuota;
    }

    public void setInteres_cuota(double interes_cuota) {
        this.interes_cuota = interes_cuota;
    }

    public double getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(double montoCuota) {
        this.montoCuota = montoCuota;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
