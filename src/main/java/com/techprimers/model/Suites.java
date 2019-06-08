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
@Table(name = "suite")
public class Suites  implements java.io.Serializable {

     @Id 
     @GeneratedValue
     private Integer idSuite;
          
     private String nombre;
     
     private int cantPersonas;
     
     private int ambientes;
     
     private int costoPorDia;

    public Suites() {
    }

    public int getIdSuite() {
        return idSuite;
    }

    public void setIdSuite(int idSuite) {
        this.idSuite = idSuite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public int getCostoPorDia() {
        return costoPorDia;
    }

    public void setCostoPorDia(int costoPorDia) {
        this.costoPorDia = costoPorDia;
    }
       
}   