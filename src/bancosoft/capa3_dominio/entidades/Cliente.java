package bancosoft.capa3_dominio.entidades;

import java.util.ArrayList;

/**
 *
 * @author estal
 */
public class Cliente {

    private Analista analista;
    private int clienteid;
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private String celular;

    public static final int LONGITUD_DNI = 8;
    public static final int LONGITUD_NOMBRE = 40;
    public static final int LONGITUD_APELLIDO = 40;
    public static final int LONGITUD_EDAD = 2;
    public static final int LONGITUD_DIRECCION = 50;
    public static final int LONGITUD_CELULAR = 12;

    public Cliente() {
    }

    public int getClienteid() {
        return clienteid;
    }

    public Analista getAnalista() {
        return analista;
    }

    public void setAnalista(Analista analista) {
        this.analista = analista;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni != null) {
            this.dni = dni.trim().isEmpty() ? null : dni.trim();
        } else {
            this.dni = null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre.trim().isEmpty() ? null : nombre.trim();
        } else {
            this.nombre = null;
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null) {
            this.apellido = apellido.trim().isEmpty() ? null : apellido.trim();
        } else {
            this.apellido = null;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
