package bancosoft.capa3_dominio.entidades;

import bancosoft.capa1_presentacion.util.RoundCalculos;
import java.sql.Date;

/**
 *
 * @author estal
 */
public class Pago {

    private int idpago;
    private Cajero cajero;
    private Cuota cuota;
    private Date fecha;
    private String estado;

    public Pago() {
        fecha = Date.valueOf(String.format("%1$tY-%1$tm-%1$te", new java.util.Date()));
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean ValidarFechaPago() {
        if (fecha.compareTo(cuota.getFechaPago())>= 1) {
            return true;
        } else {
            return false;
        }
    }

    public double calcularMora() {
        double mora = 0;
        if (ValidarFechaPago() == true) {
            mora = 0.03 * cuota.getMontoCuota();
        } else {
            mora = 0;
        }
        return RoundCalculos.redondearDecimales(mora, 2);
    }

    public double pagoTotal() {
        double pago = 0.0;
        pago = cuota.getMontoCuota() + calcularMora();
        return RoundCalculos.redondearDecimales(pago, 2);
    }
}
