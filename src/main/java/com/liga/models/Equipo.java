package com.liga.models;

public class Equipo {
    String nombreEquipo;
    int PJ;
    int PG;
    int PP;
    int PE;
    int GF;
    int GC;
    int TP;
    int puntos;
    public Equipo(){
    }

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.PJ = 0;
        this.PG = 0;
        this.PP = 0;
        this.PE = 0;
        this.GF = 0;
        this.GC = 0;
        this.TP = 0;
        this.puntos = 0;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
    public int getPJ() {
        return PJ;
    }
    public void setPJ(int pJ) {
        this.PJ = pJ;
    }
    public int getPG() {
        return PG;
    }
    public void setPG(int pG) {
        this.PG = pG;
    }
    public int getPP() {
        return PP;
    }
    public void setPP(int pP) {
        this.PP = pP;
    }
    public int getPE() {
        return PE;
    }
    public void setPE(int pE) {
        this.PE = pE;
    }
    public int getGF() {
        return GF;
    }
    public void setGF(int gF) {
        this.GF = gF;
    }
    public int getGC() {
        return GC;
    }
    public void setGC(int gC) {
        this.GC = gC;
    }
    public int getTP() {
        return TP;
    }
    public void setTP(int tP) {
        this.TP = tP;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
}
