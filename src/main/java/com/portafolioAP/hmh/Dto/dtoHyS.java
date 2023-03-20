package com.portafolioAP.hmh.Dto;

import javax.validation.constraints.NotBlank;



public class dtoHyS {
    @NotBlank
    private String nombreH;
    @NotBlank
    private int porcentajeH;
    
    //constructor

    public dtoHyS() {
    }

    public dtoHyS(String nombreH, int porcentajeH) {
        this.nombreH = nombreH;
        this.porcentajeH = porcentajeH;
    }
    
    //getter setter

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public int getPorcentajeH() {
        return porcentajeH;
    }

    public void setPorcentaje(int porcentajeH) {
        this.porcentajeH = porcentajeH;
    }
}
