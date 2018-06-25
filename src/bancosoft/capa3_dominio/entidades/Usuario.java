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
public class Usuario {

    private int usuarioid;
    private String dni;
    private String nombre;
    private String user ;
    private String password;
    private String tipo;
    public static final int LONGITUD_DNI = 8;

    public Usuario() {
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void validarPassword(String password, String nuevoPassword) throws Exception {
        if (!password.equals(nuevoPassword)) {
            throw new Exception("Contraseña INVALIDA!.");
        }
    }
}
