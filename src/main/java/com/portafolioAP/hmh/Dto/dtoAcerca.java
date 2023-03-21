package com.portafolioAP.hmh.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAcerca {
    
    @NotBlank
    private String nombreA;
    @NotBlank
    private String apellidoA;
    @NotBlank
    private String profesionA;
    @NotBlank
    private String sobreTiA;
    
    //constructor

    public dtoAcerca() {
    }

    public dtoAcerca(String nombreA, String apellidoA, String profesionA, String sobreTiA) {
        this.nombreA = nombreA;
        this.apellidoA = apellidoA;
        this.profesionA = profesionA;
        this.sobreTiA = sobreTiA;
    }
    
    //getter setter

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
