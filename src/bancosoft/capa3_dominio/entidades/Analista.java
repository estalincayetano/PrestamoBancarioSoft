/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa3_dominio.entidades;

/**
 *
 * @author estal
 */
public class Analista {

    public int idanalista;
    public String dni;
    public String nombres;

    public Analista() {

    }

    public int getIdanalista() {
        return idanalista;
    }

    public void setIdanalista(int idanalista) {
        this.idanalista = idanalista;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
