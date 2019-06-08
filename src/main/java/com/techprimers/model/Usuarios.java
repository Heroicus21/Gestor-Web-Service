package com.techprimers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuarios {

    private int id;
    private String usuario;
    private String psw;
    private int permiso;

    public Usuarios(int id, String usuario, String psw, int permiso) {
        this.id = id;
        this.usuario = usuario;
        this.psw = psw;
        this.permiso = permiso;
    }

    public Usuarios() {
    }

    
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }
}
