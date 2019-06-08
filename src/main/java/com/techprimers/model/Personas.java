/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techprimers.model;

/**
 *
 * @author LucasRoman
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




/**
 * Personas generated by hbm2java
 */
@Entity
@Table(name = "personas")
public class Personas  implements java.io.Serializable {

     @Id 
     @GeneratedValue
     private Long id;
          
     private String nombre;
     
     private String apellido;
     
     @Column(name="dni", unique=true)
     private int dni;
     
     private int telFijo;
     
     private int telCel;
     
     private String mail;
     
     private String descripcion;

    public Personas() {
    }

    public Personas(String nombre, String apellido, int dni, int telFijo, int telCel, String mail, String descripcion) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.dni = dni;
       this.telFijo = telFijo;
       this.telCel = telCel;
       this.mail = mail;
       this.descripcion = descripcion;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getDni() {
        return this.dni;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    public int getTelFijo() {
        return this.telFijo;
    }
    
    public void setTelFijo(int telFijo) {
        this.telFijo = telFijo;
    }
    public int getTelCel() {
        return this.telCel;
    }
    
    public void setTelCel(int telCel) {
        this.telCel = telCel;
    }
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}   

