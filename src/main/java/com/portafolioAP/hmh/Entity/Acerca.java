package com.portafolioAP.hmh.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acerca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreA;
    private String apellidoA;
    private String profesionA;
    private String sobreTiA;
    
    
    //constructor

    public Acerca() {
    }

    public Acerca(String nombreA, String apellidoA, String profesionA, String sobreTiA) {
        this.nombreA = nombreA;
        this.apellidoA = apellidoA;
        this.profesionA = profesionA;
        this.sobreTiA = sobreTiA;
    }
    
    //getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getApellidoA() {
        return apellidoA;
    }

    public void setApellidoA(String apellidoA) {
        this.apellidoA = apellidoA;
    }

    public String getProfesionA() {
        return profesionA;
    }

    public void setProfesionA(String profesionA) {
        this.profesionA = profesionA;
    }

    public String getSobreTiA() {
        return sobreTiA;
    }

    public void setSobreTiA(String sobreTiA) {
        this.sobreTiA = sobreTiA;
    }
}
