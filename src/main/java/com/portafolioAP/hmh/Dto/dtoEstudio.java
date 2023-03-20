package com.portafolioAP.hmh.Dto;

import javax.validation.constraints.NotBlank;



public class dtoEstudio {
    @NotBlank
    private String nombreS;
    @NotBlank
    private String descripcionS;
    
    //constructor
    public dtoEstudio() {
    }

    public dtoEstudio(String nombreS, String descripcionS) {
        this.nombreS = nombreS;
        this.descripcionS = descripcionS;
    }
    
    //getter setter

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getDescripcionS() {
        return descripcionS;
    }

    public void setDescripcionS(String descripcionS) {
        this.descripcionS = descripcionS;
    }
    
}
