package com.portafolioAP.hmh.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class HyS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreH;
    private int porcentajeH;
    
    //constructor

    public HyS() {
    }

    public HyS(String nombreH, int porcentajeH) {
        this.nombreH = nombreH;
        this.porcentajeH = porcentajeH;
    }
    
    //getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public int getPorcentajeH() {
        return porcentajeH;
    }

    public void setPorcentajeH(int porcentajeH) {
        this.porcentajeH = porcentajeH;
    }
    
}
