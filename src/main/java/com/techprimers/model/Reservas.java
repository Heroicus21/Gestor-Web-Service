/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techprimers.model;

import java.io.Serializable;
import static java.util.Calendar.DATE;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author LucasRoman
 */
@Entity
@Table(name = "tb_reservas")
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer idReserva;
    
    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = true, updatable = true)
    private Personas idPersona;
      
    @ManyToOne
    @JoinColumn(name = "id_suite", insertable = true, updatable = true)
    private Suites idCabania;
    
    private Date fechaEntrada;
    
    private Date fechaSalida;
    
    private int monto;
    
    private boolean pago;

    public Reservas() {
        this.pago=false;
    }

    public Reservas(Integer iDreserva) {
        this.idReserva = iDreserva;
    }

    public Reservas(Integer iDreserva, Personas iDpersona, Usuarios idUsuario, Date fechaEntrada, Date fechaSalida) {
        this.idReserva = iDreserva;
        this.idPersona = iDpersona;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }
    
    public Personas getIdPersona() {
        return idPersona;
    }
    
    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public Suites getIdCabania() {
        return idCabania;
    }

    public void setIdCabania(Suites idCabania) {
        this.idCabania = idCabania;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
}
